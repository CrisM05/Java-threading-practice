import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Random;

public class MultiThreadMain {
  private static final int threadCount = 8;
  private static final AtomicBoolean found = new AtomicBoolean(false);
  private static final String target = "sdbgi";
  private static final AtomicLong counter = new AtomicLong();
  private static final long start = System.currentTimeMillis();
  
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    for (int i = 0; i < threadCount; i++) {
      final int threadId = i;
      executor.submit(() -> guessString(threadId));
      // System.out.println(targetIncludeCapitals());
    }
    executor.shutdown();
    System.out.println("Threads submitted");
  }

  private static void guessString(int threadId) {
    while(!found.get()) {
      String guess = generateRandomString();
      if (target.equals(guess)) {
        long finish = System.currentTimeMillis();
        found.set(true);
        System.out.println(String.format("Thread %d guessed %s after %,d total guesses", threadId, target, counter.get()));
        System.out.println(String.format("Total time: %,d ms", finish-start));
      }
    }
    // for (int i = 0; i < 10; i++) {
    //   System.out.println(generateRandomString());
    // }
  }

  private static String generateRandomString () {
    counter.getAndIncrement();
    int stringLength = target.length();
    char[] str = new char[stringLength];
    boolean capitalize = targetIncludeCapitals();
    Random rnd = new Random();
    for (int i = 0; i < stringLength; i++) {
      boolean isUpperCase = !capitalize ? false : rnd.nextBoolean();
      char curr;
      if (isUpperCase) curr = (char) ('A' + rnd.nextInt(26));
      else curr = (char) ('a' + rnd.nextInt(26));
      str[i] = curr;
    }
    return new String(str);
  }

  private static boolean targetIncludeCapitals () {
    for (int i = 0; i < target.length(); i++) {
      if (target.charAt(i) == Character.toUpperCase(target.charAt(i))) return true;
    }
    return false;
  }
}
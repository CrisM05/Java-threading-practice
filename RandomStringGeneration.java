import java.util.Random;

public class RandomStringGeneration {
  private static final long start = System.currentTimeMillis();
  public static void main(String[] args) {
    String target = "Bazinga";
    int length = target.length();
    String word = getRandomWord(target.length());
    long count = 0;
    while (!word.equals(target)) {
      word = getRandomWord(length);
      count++;
      // if (count > 0 && count % 1000000 == 0) {
      //   System.out.println(String.format("%,d+ attempts...", count));
      //   System.out.println("Current word is " + word);
      // }
    }
    System.out.println(String.format("It took %,d attempts to guess %s", count, target));
    System.out.println(String.format("Total time: %,d ms", System.currentTimeMillis() - start));
  }

  public static String getRandomWord(int length) {
    char[] str = new char[length];
    Random rnd = new Random();
    for (int i = 0; i < length; i++) {
      boolean isUpperCase = rnd.nextBoolean();
      char curr;
      if (isUpperCase) {
        curr = (char) ('A' + rnd.nextInt(26));
      } else {
        curr = (char) ('a' + rnd.nextInt(26));
      }
      // curr = (char) ('a' + rnd.nextInt(26));
      str[i] = curr;
    }
    return new String(str);
  }
}
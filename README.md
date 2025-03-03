# Overview
There are 2 files here, named if threaded or not

## What I learned

Threading is hard. There are many things to keep synchronized.

I have used the java.util.concurrent package before with the google maps api but this was more of a dive

I like the idea of multiple threads working together in solving something very trivial

## Outcome

When it comes to smaller words the non multi threaded java ran quicker. I belive it was because while the ExecutorService was making threads the other program was just guessing.

However of course with longer words of 6 or more the multi threaded approach was better. Primarily because I was able to leverage the 8 cores of the M3. I do hope to look into making this more optimal. Not in guessing words, this was made just to guess randomly, but in threading optimization in how they run.
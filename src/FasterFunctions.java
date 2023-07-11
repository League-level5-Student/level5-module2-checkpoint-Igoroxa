
public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		// Your Code Here

		Thread first = new Thread(() -> SlowFunctions.slowSortLargeArray());
		Thread second = new Thread(() -> SlowFunctions.ackermann(0, 1));
		Thread third = new Thread(() -> SlowFunctions.millionsOfSqrts());

		first.start();
		second.start();
		third.start();
		
		try {
			first.join();
			second.join();
			third.join();
			System.out.println("works");
		} catch (InterruptedException e) {
			System.err.println("Could not join threads");
		}

		float endTime = (float) ((double) System.currentTimeMillis() - (double) startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}

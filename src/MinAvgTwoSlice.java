

public class MinAvgTwoSlice {

	public static void main(String[] args) {

		int sol = solution(new int[] { 4,2,2,5,1,5,8});

		System.out.print(sol);

	}

	/**
	 Explication:
	 C=(v+w+x+y+z)/5
	 A and B are the average of corresponding slices of size 2 and 3, respectively, i.e., A=(v+w)/2 and B=(x+y+z)/3. 
	 C = 0.4*A+0.6*B
	 
	 Cannot be that C < A and C < B at the same time. 
	 
	 Proof. Let say this is the case. Then we have 0.4*C < 0.4*A, and 0.6*C < 0.6*B. Summing these two, we get 0.4*C+0.6*C < 0.4*A+0.6*B, or equivalently C < C, which is obviously wrong.
Therefore, either A <= C or B <= C. But, the algorithm already returns the best of A and B, thus the algorithm is also handling slices of size 5.
For slices of bigger size, we can reason similarly.

	 */
	// (10 + 10 + 1 + 1 + 1) / 5 = 23/5 = 4.6
	//(20/2 + 3/3 ) / 5 = 0.4*10 + 0.6*1 = 4 + 0.6 = 4.6
	//10*0.2 + 10*0.2 + 1*0.2 + 1*0.2 + 1*0.2 = 2 + 2 + 0.2 + 0.2 + 0.2 = 4.6
	
	public static int solution(int[] A) {

		int minAvgPos = 0, currentSum = 0;
		
		double minAvg = Double.MAX_VALUE, currentAvg = 0.0;

		Double a = 3.0D;
		
			for (int i = 0; i < A.length - 1 ; i++) {

				currentSum = A[i] + A[i + 1];
				currentAvg = currentSum / (double) 2.0;
				if(currentAvg < minAvg) {
					minAvg = currentAvg;
					minAvgPos = i;
				}

				if(i < A.length - 2) {
					currentSum += A[i + 2];
					currentAvg = currentSum / 3.0;
					if(currentAvg < minAvg) {
						minAvg = currentAvg;
						minAvgPos = i;
					}	
				}
		}
		return minAvgPos;
	}
	
	public static int solutionWithouthMatchOptimization(int[] A) {

		int minAvgPos = 0, count = 0, currentSum = 0;

		double minAvg = Double.MAX_VALUE, currentAvg = 0.0;

		for (int currentInitPos = 0; currentInitPos < A.length; currentInitPos++) {

			count = 0;
			currentSum = 0;
			currentAvg = 0.0;
			for (int i = currentInitPos; i < A.length; i++) {

				currentSum += A[i];

				if (++count > 1) {
					currentAvg = currentSum / (double) count;

					if (minAvg > currentAvg) {
						minAvg = currentAvg;
						minAvgPos = currentInitPos;

					}
				}
			}
		}

		System.out.println(minAvg);
		return minAvgPos;
	}
}
/*
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 * 
 * 
 * A non-empty array A consisting of N integers is given. A pair of integers (P,
 * Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the
 * slice contains at least two elements). The average of a slice (P, Q) is the
 * sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be
 * precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * 
 * For example, array A such that: A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1
 * A[5] = 5 A[6] = 8
 * 
 * contains the following example slices:
 * 
 * slice (1, 2), whose average is (2 + 2) / 2 = 2; slice (3, 4), whose average
 * is (5 + 1) / 2 = 3; slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * 
 * The goal is to find the starting position of a slice whose average is
 * minimal.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the
 * starting position of the slice with the minimal average. If there is more
 * than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * 
 * For example, given array A such that: A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5
 * A[4] = 1 A[5] = 5 A[6] = 8
 * 
 * the function should return 1, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [2..100,000]; each element of array A is an
 * integer within the range [−10,000..10,000].
 * 
 * 
 * 
 */

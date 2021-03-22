
import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {

		int sol = solution(new int[] { 1, 3, 6, 4, 1, 2});

		System.out.print(sol);

	}

	public static int solution(int[] A) {

		Arrays.sort(A);

		int current = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= current)
				continue;

			if (A[i] > current + 1)
				return current + 1;
			
			current ++;

		}
		
		 
		return current + 1 ;
	}
}
/*
 * https://app.codility.com/programmers/lessons/4-counting_elements/
 * missing_integer/
 * 
 * 
 * 
 * This is a demo task.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 * 
 * 
 */

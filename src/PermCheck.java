import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

public class PermCheck {

	public static void main(String[] args) {

		int sol = solution(new int[] { 1, 2, 3, 5 });

		
			System.out.print(sol);
		
	}

	public static int solution(int[] A) {

		boolean[] checked = new boolean[A.length];

		for (int i = 0; i < checked.length; i++) {
			if (A[i] <= 0 || A[i] > checked.length || checked[A[i] - 1])
				return 0;
			checked[A[i] - 1] = true;
		}

		return 1;
	}
}
/*
 https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 
A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2

is a permutation, but array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3

is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2

the function should return 1.

Given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3

the function should return 0.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [1..1,000,000,000].


 */

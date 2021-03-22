import java.util.Arrays;
import java.util.Comparator;

public class NumberOfDiscIntersections {

	public static void main(String[] args) {

		int sol = solutionN2(new int[] { 1,5,2,1,4,0});
//1, 2147483647, 0 //Test it input
		System.out.print(sol);

	}

	public static int solution(int[] A) {

		class PointOnLine {
			public long point;
			public boolean isBegining;

			public PointOnLine(long point, boolean isBegining) {
				this.point = point;
				this.isBegining = isBegining;
			}
		}

		PointOnLine[] points = new PointOnLine[A.length * 2];

		for (int i = 0, j = 0; i < A.length; i++) {
			points[j++] = new PointOnLine(i - A[i], true);
			points[j++] = new PointOnLine(i + (long) A[i], false);
		}

		Arrays.sort(points, new Comparator<PointOnLine>() {
			@Override
			public int compare(PointOnLine p1, PointOnLine p2) {
				if (p1.point == p2.point) {
					// First we put the Opener and later the closer
					if (!p2.isBegining)
						return -1;
					if (!p1.isBegining)
						return 1;
					
					return 0;
				}
				return p1.point > p2.point ? 1 : -1;
			}
		});

		int countIntersection = 0, activesCircles = 0;

		for (int i = 0; i < points.length; i++) {
			PointOnLine current = points[i];

			if (current.isBegining) {
				countIntersection += activesCircles;
				activesCircles++;

				if (countIntersection > 10000000)
					return -1;
			} else {
				activesCircles--;
			}

		}

		return countIntersection;
	}

	/**
	 * This is the basic solution, the problem is the time because is a N2 complexity
	 * Correctness 100% Performance 50%
	 * 
	 * Quadratic solutions, perfect result but without optimization
	 */
	public static int solutionN2(int[] A) {

		class Pair {
			public int start;
			public int end;

			public Pair(int start, int end) {
				this.start = start;
				this.end = end;
			}
		}

		Pair[] pairs = new Pair[A.length];

		for (int i = 0; i < A.length; i++) {
			pairs[i] = new Pair(i - A[i], i + A[i]);
		}

		Arrays.sort(pairs, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.start - o2.start;
			}
		});

		int countIntersection = 0;

		for (int i = 0; i < A.length; i++) {
			Pair current = pairs[i];

			for (int j = i + 1; j < A.length; j++) {
				Pair p = pairs[j];
				if (current.end >= p.start) {
					countIntersection++;
				} else {
					break;
				}
			}

		}

		if (countIntersection > 10000000)
			return -1;

		return countIntersection;
	}
}
/*
 * https://app.codility.com/programmers/lessons/6-sorting/
 * number_of_disc_intersections/
 * 
 * 
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array
 * A of N non-negative integers, specifying the radiuses of the discs, is given.
 * The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * 
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and
 * K-th discs have at least one common point (assuming that the discs contain
 * their borders).
 * 
 * The figure below shows discs drawn for N = 6 and A as follows: A[0] = 1 A[1]
 * = 5 A[2] = 2 A[3] = 1 A[4] = 4 A[5] = 0
 * 
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * 
 * discs 1 and 4 intersect, and both intersect with all the other discs; disc 2
 * also intersects with discs 0 and 3.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A describing N discs as explained above, returns the
 * number of (unordered) pairs of intersecting discs. The function should return
 * −1 if the number of intersecting pairs exceeds 10,000,000.
 * 
 * Given array A shown above, the function should return 11, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [0..2,147,483,647].
 * 
 * 
 * 
 */

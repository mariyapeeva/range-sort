/**
 * Hybrid sort is a combination of Bubble sort and Selection sort.
 */
package uk.ac.gold;

import java.util.Arrays;

/**
 * @author mpeev001
 *
 */
public class HybridSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Normal case
		int[] A = {10, 5, 3, 9, 8, 7, 6};
		System.out.println("Original array: " + Arrays.toString(A));
		System.out.println();

		A = hybridSort(A);

		System.out.println("Array sorted: " + Arrays.toString(A));
		System.out.println();
		
		// Extreme cases
		
		int[] B = new int[0];
		int[] C = {100};
		int[] D = {2, 2, 2, 2, 2, 2, 2, 2};
		int[] E = {-100, 19, -10, -13, 40, 200, -200, 10000, 80, 34, 76, 12, 18, -90, 60};
		int[] F = {-100, -200, -40, -362, -4, -10, -7, -9, -800, -74, -22, -12, -10, -9, -1};
		
		System.out.println("Original array B: " + Arrays.toString(B));
		System.out.println();
		
		B = hybridSort(B);
		
		System.out.println("Array sorted B: " + Arrays.toString(B));
		
		System.out.println("Original array C: " + Arrays.toString(C));
		System.out.println();
		
		C = hybridSort(C);
		
		System.out.println("Array sorted C: " + Arrays.toString(C));
		
		System.out.println("Original array D: " + Arrays.toString(D));
		System.out.println();
		
		D = hybridSort(D);
		
		System.out.println("Array sorted D: " + Arrays.toString(D));
		
		System.out.println("Original array E: " + Arrays.toString(E));
		System.out.println();
		
		E = hybridSort(E);
		
		System.out.println("Array sorted E: " + Arrays.toString(E));
	}
	/**
	 * Hybrid sort
	 * @param A The unsorted array
	 * @return A The sorted array
	 */
	public static int[] hybridSort(int[] A) {
		// Bubble sort frame
		for(int i = 0; i < A.length; i++) {
			// Set min to the current element
			int min = i;
			for(int j = i + 1; j < A.length - i; j++) {
				if(A[j] < A[j - 1]) {
					swap(A, j, j - 1);
				}
				// Find min
				if(A[j - 1] < A[min]) {
					min = j - 1;
				}
			}
			// Swap current element with the min element 
			if (min != i) {
				swap(A, i, min);
			}	
		}
		return A;
	}
	/**
	 * Swap
	 * @param A The array
	 * @param i The index of the first element
	 * @param j The index of the second element
	 * @return void 
	 */
	static void swap(int[] A, int i, int j) {
		// swap
		int copy = A[i];
		A[i] = A[j];
		A[j] = copy;
	}
}

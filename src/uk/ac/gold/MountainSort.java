/**
 * Mountain Sort sorts an array with a time complexity of Q(N) using Range Sort.
 * The first half of the array is sorted in an ascending order and the second half is sorted in a descending order.
 */

package uk.ac.gold;

import java.util.Arrays;

/**
 * @author mpeev001
 *
 */
public class MountainSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Normal case
		
		int[] A= {34, 12, 7, 43, 55, 41, 97, 28, 2, 62};

		System.out.println("Original array: " + Arrays.toString(A));
		System.out.println();

		A = mountainSort(A);

		System.out.println();
		System.out.println("Array sorted: " + Arrays.toString(A));
		
		// Extreme cases
		int[] B = new int[0];
		int[] C = {100, 120};
		int[] D = {2, 2, 2, 2, 2, 2, 2};
		int[] E = {-100, 19, -10, -13, 40, 200, -200, 10000};
		int[] F = {-100, -200, -40, -362, -4, -10, -7, -9};
		
		System.out.println();
		
		System.out.println("Original array B: " + Arrays.toString(B));
		
		B = mountainSort(B);
		
		System.out.println("Array sorted B: " + Arrays.toString(B));
		
		System.out.println();
		
		System.out.println("Original array C: " + Arrays.toString(C));
				
		C = mountainSort(C);
				
		System.out.println("Array sorted C: " + Arrays.toString(C));
		
		System.out.println();
		
		System.out.println("Original array D: " + Arrays.toString(D));
				
		D = mountainSort(D);
				
		System.out.println("Array sorted D: " + Arrays.toString(D));
		
		System.out.println();
		
		System.out.println("Original array E: " + Arrays.toString(E));
				
		E = mountainSort(E);
				
		System.out.println("Array sorted E: " + Arrays.toString(E));
		
		System.out.println();
		
		System.out.println("Original array F: " + Arrays.toString(F));
				
		F = mountainSort(F);
				
		System.out.println("Array sorted F: " + Arrays.toString(F));
	}
	/** 
	 * Mountain sort
	 * @param A The unsorted array
	 * @return B The sorted array
	 * */
	public static int[] mountainSort(int[] A) {
		// if the length of A is less than or equal to 1, terminate
		if(A.length <= 1) {
			return A;
		}
		
		// Sort the array
		A = rangeSort(A);
		
		// Set length
		int n = A.length;
		
		// Create a new array B
		int[] B = new int[n];
		
		// Set first half
		int first = (int) Math.ceil((float)n/2);
		int second = (int) Math.floor((float)n/2);
		System.out.println(first);
		// Assign the first half of A to the first half of B in an ascending order and
		// the second half of A to the second half of B in a descending order
		for(int i = 0; i < first; i++) {
			B[i] = A[i];
			if (i < second) {
				B[n - 1 - i] = A[second + i]; 
			}
		}
		
		// return B
		return B;
	}
	
	/** 
	 * Range sort
	 * @param A The unsorted array
	 * @return B The sorted array
	 * */
	public static int[] rangeSort(int[] A) {
		// If the length of A is less than or equal to 1, terminate
		if(A.length <= 1) {
			return A;
		}
		// Set length
		int n = A.length;
		
		// Set the min and max values
		int min = A[0];
		int max = A[0];
		
		for(int i = 0; i < n; i++) {
			if(A[i] > max) {
				max = A[i];
			} else if(A[i] < min) {
				min = A[i];
			}
		}
		// Set the distance between the min and max values
		int dist = max - min; 
		
		// If the distance is 0, terminate 
		if(dist == 0) {
			return A;
		}
		
		// Set range to the mean distance between the values
		float range = (float) dist/(n - 1); 
		
		// Count the number of values within a mean distance from each other
		int[] count = new int[(int) (Math.floor(dist/range)) + 1];

		for(int i = 0; i < n; i++) {	
			count[(int) Math.floor((A[i]-min)/range)]++;	
		}
		
		// Calculate the index based on the cumulative count
		int[] index = new int[count.length + 1];

		index[1] = count[0];

		for(int i = 2; i < count.length + 1; i++) {
			index[i] += index[i - 1] + count[i - 1];
		}
		
		// B is a partial order
		int[] B = new int[n];

		for(int i = 0; i < n; i++) {
			int j = (int) Math.floor((A[i] - min)/range);
			B[index[j + 1] - --count[j] - 1] = A[i];
		}
		
		// Sort the unsorted elements of B recursively
		for(int i = 0; i < index.length - 1; i++) {
			int next = index[i + 1];
			int curr = index[i];
			
			if(next - curr > 1) {
				int[] multiple = new int[next - curr];
				
				for(int j = curr; j < next; j++) {
					multiple[j - curr] = B[j];
				}
				multiple = rangeSort(multiple);
				
				for(int j = curr; j < next; j++) {
					B[j] = multiple[j - curr];
				} 
			}
		}
		
		// Return the sorted array
		return B;
	}
}

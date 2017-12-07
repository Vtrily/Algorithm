package project;

import java.util.Arrays;

public class OptimizeInsertionSort {
	public static void main(String[] args) {
		int[] arr = {1, 4, 6, 3, 7, 8, 2, 9, 5};
		arr = sortByAsc(arr);
		System.out.println(Arrays.toString(arr));
		arr = sortByDesc(arr);
		System.out.println(Arrays.toString(arr));
	}
	//升序
	public static int[] sortByAsc(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int e = arr[i];
			int j;
			for(j = i;j > 0 && arr[j-1] > e; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = e;
		}
		return arr;
	}
	//降序
	public static int[] sortByDesc(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int e = arr[i];
			int j;
			for(j = i;j > 0 && arr[j-1] < e; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = e;
		}
		
		return arr;
	}
}

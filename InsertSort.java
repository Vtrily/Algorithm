package project;

import java.util.Arrays;

//插入排序
public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {1, 4, 6, 3, 7, 8, 2, 9, 5};
		sortByAsc(arr);
		System.out.println(Arrays.toString(arr));
		sortByDesc(arr);
		System.out.println(Arrays.toString(arr));
	}
	//升序
	public static void sortByAsc(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = i;j > 0 && arr[j] < arr[j-1]; j--) {
				SwapUtil.swap(arr, j - 1, j);
				//System.out.println(Arrays.toString(arr));
			}
		}
	}
	//降序
	public static void sortByDesc(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = i;j > 0 && arr[j] > arr[j-1]; j--) {
				SwapUtil.swap(arr, j, j-1);
			}
		}
	}
}

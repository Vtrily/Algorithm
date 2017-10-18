package project;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {1,8,7,4,5,3,3,2};
		sortByAsc(arr);
		System.out.println(Arrays.toString(arr));
		sortByDesc(arr);
		System.out.println(Arrays.toString(arr));
	}
	//升序排列
	public static void sortByAsc(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for(int j = i + 1; j < arr.length;j++) {
				if(arr[i] > arr[j]) 
				minIndex = j;
			}
			SwapUtil.swap(arr, i , minIndex);
		}
	}
	//降序排列
	public static void sortByDesc(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int maxIndex = i;
			for(int j = i + 1;j < arr.length; j++) {
				if(arr[j] > arr[maxIndex])
				maxIndex = j;
			}
			SwapUtil.swap(arr, i, maxIndex);
		}
	}
	
	
	
}

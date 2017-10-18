package project;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr= {1,5,3,7,9,4};
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0;j < arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					SwapUtil.swap(arr, j, j+1);
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}

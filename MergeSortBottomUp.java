package project;

import java.util.Arrays;

//自底向上的排序
public class MergeSortBottomUp {
	public static void main(String[] args) {
		int[] arr = {8,6,2,3,1,5,7,4,56,100,80};
		mergeSortBU(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	public static void mergeSortBU(int[] arr,int n) {
		for(int sz = 1;sz <= n;sz += sz)
			for(int i = 0; i + sz < n; i += sz + sz)
				MergeSort.__merge(arr, i, i+sz-1, min(i+sz+sz-1,n-1));
	}
	public static int min(int arg1,int arg2) {
		if(arg1 > arg2)
			return  arg2;
		else
			return  arg1;
	}
}

package project;

import java.util.Arrays;
import java.util.Random;

//快速排序优化之三路快速排序
//将数组分为大于v、等于v、小于v三部分
//然后对数组进行排序
public class QuickSort3 {
	public static void main(String[] args) {
		int[] arr = {8,6,2,3,1,5,7,4,56,100,80};
		quickSort(arr,arr.length);
		System.out.println(Arrays.toString(arr));
	}
	public static void quickSort(int[] arr, int n) {
		__quickSort(arr, 0, n-1);
	}
	public static void __quickSort(int[] arr,int l, int r) {
//		if(l >= r) {
//			return;
//		}
		//配合插入排序进行优化
		if(r -l <= 15){
			InsertSort.sortByAsc(arr);
			return;
		}
		Random random = new Random();
		SwapUtil.swap(arr, l, random.nextInt()%(r-l+1));
		int v = arr[l];
		
		//目的：将数组分为三部分
		//arr[l+1...lt] < v
		//arr[gt...r] > v  
		//arr[lt+1...i] == v
		
		int lt = l;
		int gt = r + 1;
		int i = l + 1;
		while(i < gt) {
			if(arr[i] < v) {
				SwapUtil.swap(arr, i, lt + 1);
				i++;
				lt++;
			}else if(arr[i] > v) {
				SwapUtil.swap(arr, i, gt-1);
				gt--;
			}else {
				i++;
			}
		}
		SwapUtil.swap(arr,l,lt);
		__quickSort(arr, l, lt-1);
		__quickSort(arr, gt, r);
	}
}

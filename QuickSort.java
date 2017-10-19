package project;

import java.util.Arrays;
import java.util.Random;

//快速排序
//原理：
//把整个数据分成两个部分，小于v,大于v
//Partition
//快速排序分出来的两个数组可能为一大一小，不均匀
//快速排序最差的情况，O(n^2)
//完全有序时，近乎只有一部分有数据
//标定元素的选择很重要
//优化：随机选择一个标定元素
public class QuickSort {
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
		int p = __partition(arr, l, r);
		__quickSort(arr, l, p-1);
		__quickSort(arr, p+1, r);
	}
	public static int __partition(int[] arr,int l, int r){
		//优化：随机选择
		Random random = new Random();
		SwapUtil.swap(arr, l, random.nextInt()%(r-l+1));
		int v = arr[l];
		int j = l;
		//arr[l+1...j] < v, arr[j+1...v] > v
		for(int i = l+1;i <= r;i++) {
			if(arr[i] < v) {
				SwapUtil.swap(arr, j+1, i);
				j++;
			}
		}
		SwapUtil.swap(arr, l, j);
		return j;
	}
}

package project;

import java.util.Arrays;
import java.util.Random;

//快速排序优化之 双路快速排序
//双路快速排序原理：
//为了防止出现分组不均匀的情况，将大于等于v、小于等于v的数值置于数组两端
//然后对数组进行排序
public class QuickSort2 {
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
		
		//arr[l+1...i) <= v; arr(j...r] >= v
		int i = l + 1,j = r;
		while(true) {
			while(i <= r && arr[i] < v) {
				i++;
			}
			while(j >= l + 1&& arr[j] > v) {
				j--;
			}
			if(i > j) {
				break;
			}
			SwapUtil.swap(arr, i, j);
			i++;
			j--;
		}
		SwapUtil.swap(arr, l, j);
		return j;
	}
}

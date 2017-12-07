package project;

import java.util.Arrays;

//归并排序
public class MergeSort {
	public static void main(String[] args) {
		//int[] arr = {2,3,6,8,1,4,5,7};
		int[] arr = {8,6,2,3,1,5,7,4,56,100,80};
		mergeSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int n) {
		 __mergeSort(arr, 0, n-1);
	}
	//归并排序的本质就是进行递归操作
	//递归进行归并排序
	public static void __mergeSort(int[] arr,int l, int r) {
//		if(l >= r) {
//			return;
//		}
		//小数组使用插入排序
		if(r - l <=15) {
			InsertSort.sortByAsc(arr);
			return;
		}
		//数据太大时可能发生溢出错误
		int mid = (l + r)/2;
		//对数组左半部分进行排序
		__mergeSort(arr, l, mid);
		//对数组右半部分进行排序
		__mergeSort(arr, mid + 1, r);
		//进行归并
		//优化
		if(arr[mid] > arr[mid + 1]) {
			__merge(arr, l, mid, r);
		}
	}
	public static void __merge(int[] arr, int l, int mid, int r) {
		//l为左边界
		//r为右边界
		//i左指针
		//j右指针
		
		//开辟临时空间
		int[] aux = new int[r - l + 1];
		for(int i = l; i <= r; i++)
			aux[i - l] = arr[i];
		int i = l,j = mid + 1;
		//k为下一个需要放的位置
		for(int k = l; k <= r; k++) {
			
			if(i > mid) {
				//边界溢出判断
				arr[k] = aux[j - l];
				j++;
			}else if(j > r) {
				//边界溢出判断
				arr[k] = aux[i - l];
				i++;
			}else if(aux[i - l] < aux[j - l]) {
				//数据比较赋值给新空间
				arr[k] = aux[i - l];
				i++;
			}else {
				//数据比较赋值给新空间
				arr[k] = aux[j-l];
				j++;
			}
		}
	}
}

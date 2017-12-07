package project;

public class SwapUtil {
	public static void swap(int[] arr,int i, int index) {
		int x = arr[index];
		arr[index] = arr[i];
		arr[i] = x;
		//return arr;
	}
}

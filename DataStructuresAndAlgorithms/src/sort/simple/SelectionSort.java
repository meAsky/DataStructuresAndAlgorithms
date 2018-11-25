package sort.simple;

import java.util.Arrays;

import sort.util.Utils;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {11,48,15,7};
		sort(arr);
		
	}
	public static void sort(int[] arr){
		//比较
		if(arr == null || arr.length<=1) {
			return ;
		}
		//定义选择排序需要的轮数。轮数等于数组的长度
		for (int  i= 0;  i< arr.length; i++) {
			int minindex = i;
			//每一轮选择排序需要的进行的数据比较
			for (int j = i; j < arr.length; j++) {
				if (arr[j]<arr[minindex]) {
					minindex=j;
				}
				Utils.swap(arr, minindex, i);
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}

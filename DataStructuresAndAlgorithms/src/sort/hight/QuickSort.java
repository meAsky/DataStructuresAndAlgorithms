package sort.hight;

import java.util.Arrays;

import sort.util.Utils;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {2,7,8,3,4,6,16,19};
		System.out.println(Arrays.toString(quickSort(arr, 0, arr.length-1)));
	}
	//快排
	public static int[] quickSort(int[] arr,int start,int end){
		int si = partition(arr, start, end); // 最终这个si的值，是第一次基准线的值
		if (si > start) {
			quickSort(arr, start, si-1);
		}
		if (si < end) {
			quickSort(arr, si+1, end);
		}
		return arr;
	} 
	
	//分区操作函数
	public static int partition(int[] arr,int start,int end){
		int pivot = (int) (start+Math.random()*(end-start+1));//确定基本关键词
		Utils.swap(arr, pivot, end);//将基准移到数组的最后
		int smallindex = start -1 ;//比基准数大的索引角标，用于换位置
		for (int i = start; i <= end; i++) {
			if (arr[i] <= arr[end]) { //将第i个元素与基准值进行了一个对比。
				smallindex++; //1
				if (i>smallindex) {//2>1
					Utils.swap(arr, i, smallindex);
				}
			}
		}
		return smallindex;
	}
}

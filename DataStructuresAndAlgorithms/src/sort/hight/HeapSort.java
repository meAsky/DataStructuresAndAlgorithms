package sort.hight;

import java.util.Arrays;

import sort.util.Utils;

public class HeapSort {
	static int len;
	public static void main(String[] args) {
		int[] arr = {11,48,15,7};
		System.out.println(Arrays.toString(heapSort(arr)));
	}
	
	public static int[] heapSort(int[] arr){
		len = arr.length;
		//1.构建大顶堆。（这个构建大顶堆中有调整的递归方法）
		buildMaxHeap(arr);
		//2. 将顶部的元素，与无序区的最后一个元素交换位置。
		while(len >0){
			Utils.swap(arr, 0, len-1);// 0表示大顶元素，len-1表示最后一个元素
			len--;// 无序区 的长度减少一位
			changeHeap(arr, 0);//继续调整
		}
		return arr;
	}
	
	//构建一个大顶堆
	public static void buildMaxHeap(int[] arr){
		for (int i =(len/2) ; i >=0; i--) {
			// 调整大顶堆
			changeHeap(arr,i);
		}
	}
	// 调整大顶堆
	private static void changeHeap(int[] arr, int i) {
		int maxindex = i;
		//如果有左子树。且左子树大于父节点，则将最大指针指向左子树
		if (i*2<len && arr[i*2]> arr[maxindex]) {
			maxindex = i*2;
		}
		//如果有右子树。且右子树大于父节点，则将最大指针指向左子树
		if (i*2+1<len && arr[i*2+1]> arr[maxindex]) {
			maxindex = i*2+1;
		}
		//如果父节点不是最大值，则将父节点与最大值交换，这样才能保证我们的父节点是最大的，构建成为一个大顶堆。
		if (maxindex != i) {
			Utils.swap(arr, maxindex, i);
			changeHeap(arr, maxindex);
		}
		
	}
}	

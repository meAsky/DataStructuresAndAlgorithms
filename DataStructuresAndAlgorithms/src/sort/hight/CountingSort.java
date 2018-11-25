package sort.hight;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int[] arr = {11,48,15,7};
		System.out.println(Arrays.toString(sort(arr)));
	}
	
	public static int[] sort(int[] arr){
		
		int min =arr[0],max=arr[0];
		for (int  i= 0; i < arr.length; i++) { //找到最大最小的值
			if (arr[i]>max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		// 1,2,3,5
		int[] bucket = new int[max-min+1];//定义额外的数组
		Arrays.fill(bucket, 0);
		for (int i = 0; i < arr.length; i++) {
			bucket[arr[i]-min]++;
		}
		int index = 0,i=0;
		while(index <arr.length){
			if (bucket[i] !=0) {
				arr[index] = i+min;
				bucket[i]--;
				index++;
			} else {
				i++;
			}
		}
		return arr;
	}
}
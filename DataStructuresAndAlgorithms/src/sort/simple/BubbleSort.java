package sort.simple;

import java.util.Arrays;

import sort.util.Utils;

/**
 * 冒泡排序
 * @author John
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {11,48,15,7};
		sort(arr);
		
	}

	public static void sort(int [] arr) {
		if(arr==null||arr.length<1) {
			return ;
		}
		//外层for循环是进行冒泡排序的轮数，轮数=数组的长度-1（最后一个元素是不需要进行操作的）
		for(int i=0;i<arr.length-1;i++) {
			//内层for循环，是指每一轮冒泡操作中的两两数据比较与数据交换
			for(int j=0;j<arr.length-1-i;j++) {
					if (arr[j]>arr[j+1]) {
						Utils.swap(arr, j, j+1);
					}
				}
			}
			System.out.println(Arrays.toString(arr));
		}
}

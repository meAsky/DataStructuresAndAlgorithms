package sort.simple;

import java.util.Arrays;
/**
 * 希尔排序
 * @author John
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {11,48,15,7};
		sort(arr);
		
	}
	
	public static void sort(int[] arr){
		int len = arr.length;
		int temp;
		int gap = len/2;//增量，或者说他是一个分组的数量
		while(gap>0){
			for (int i=gap;i<len;i++) {
				int preindex = i-gap; //此时为0
				temp = arr[i];//arr[5]
				while(preindex>=0 &&  arr[preindex]<temp){
					arr[preindex+gap] = arr[preindex];
					preindex-=gap;
				}//0 and 5之间的比较
				arr[preindex+gap] = temp;
			}
			gap/=2;
		} 
		System.out.println(Arrays.toString(arr));
	}
}

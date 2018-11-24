package sort.simple;

import java.util.Arrays;

/**
 * 插入排序
 * @author John
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {11,48,15,7};
		sort(arr);
		
	}
	public static void sort(int[] arr){
		//校验
		//设置当前的元素。
		int current; 
		for (int i = 0; i < arr.length-1; i++) {
			current = arr[i+1];
			int preindex = i;
			while (preindex >=0 && current < arr[preindex]) {
				//需要将上一元素进行下移操作
				arr[preindex+1]=arr[preindex];
				preindex--; //保证从后向前完全遍历比较
			}
			arr[preindex+1] = current;
		}
		System.out.println(Arrays.toString(arr));
	}
}

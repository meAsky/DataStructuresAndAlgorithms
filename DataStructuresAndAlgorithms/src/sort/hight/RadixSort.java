package sort.hight;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add(0);
		list.add(2);
		list.add(1);
		list.add(6);
		list.add(4);
		list.add(7);
		System.out.println(list);
		int[] arr = {22,11,44,35,6,734,224,1980,1};
		System.out.println(Arrays.toString(sort(arr)));
	}
	
	public static int[] sort(int[] arr){
		if (arr == null || arr.length<2) {
			return arr;
		}
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int maxDigit = 0; //确定最大的数字有几位
		while(max!=0){
			max/=10;
			maxDigit++;
		}
		int mod = 10;//每一位的倍数差距
		int div = 1; //定义一个除法的基准值
		ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>(); //定义一个桶
		for (int i = 0; i < 10 ;i++) {//看图说话，每一位的值都在0-9之间
			bucketList.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < maxDigit; i++,mod*=10,div*=10) {
			for (int j = 0; j < arr.length; j++) {
				int num = (arr[j] % mod)/div;//第一次循环，取出个位数字进行一个填充
				bucketList.get(num).add(arr[j]);
			}
			int index = 0;
			//回填的操作
			for (int j = 0; j < bucketList.size(); j++) {
				for (int k = 0; k < bucketList.get(j).size(); k++) {
					arr[index++] = bucketList.get(j).get(k);
				}
				bucketList.get(j).clear();
			}
		}
		return arr;
		
	}
}




package sort.hight;

import java.util.ArrayList;

public class BucketSort {
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(5);
		a.add(77);
		a.add(11);
		a.add(3);
		a.add(76);
		a.add(76);
		System.err.println(sort(a,3));
		
	}
	
	public static ArrayList<Integer> sort(ArrayList<Integer> arr,int bucketSize){
		if (arr == null || arr.size()<2) { //随着递归的深入，我们的桶可能出现空的list，我们在使用get（0）的时候，就会报错
			return arr;
		}
		int max = arr.get(0),min = arr.get(0);
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i)> max) {
				max = arr.get(i);
			}
			if (arr.get(i) < min) {
				min = arr.get(i);
			}
		}
		int bucketCount = (max-min)/bucketSize + 1;//避免bucketCount为0
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<ArrayList<Integer>>(bucketCount);
		ArrayList<Integer> resultArr = new ArrayList<Integer>(); //我们回填的list
		//初始化我们的桶
		for (int i = 0; i <bucketCount; i++) {
			//计数排序里边是数字，但是桶排序里边是一个list
			bucketArr.add(new ArrayList<Integer>());//内层存放值得list
		}
	// 循环原始的数据，将原始数据填充到应该填充的位置（我们内层list的位置。arr.get(i)-min）
		for (int i = 0; i < arr.size(); i++) {
			bucketArr.get((arr.get(i)-min)/bucketSize).add(arr.get(i));
		}
		//递归的将桶里的数据进行一个排序，并且回填到我们的原数组中
		for (int i = 0; i <bucketCount; i++) {
			if (bucketSize == 1) { //有重复数据出现的时候的一个判断,避免除以0的操作
				for (int j = 0; j < bucketArr.get(i).size(); j++) {
					resultArr.add(bucketArr.get(i).get(j));
				}
			} else {
				if (bucketCount == 1) {
					bucketSize--;//也是为了递归操做中数据少，size大，导致最终桶的数量为1，这样就不能再继续进行排序了，会造成死循环。
				}
				//递归试的进行桶排序
				ArrayList<Integer> temp = sort(bucketArr.get(i), bucketSize);//递归操作，bucketsize不能为0，因为0不能做被除数
				//将排序好的序列，回填到我们的结果list里边。
				for (int j = 0; j < temp.size(); j++) {
					resultArr.add(temp.get(j));
				}
			}
		}
		return resultArr;
	}
}
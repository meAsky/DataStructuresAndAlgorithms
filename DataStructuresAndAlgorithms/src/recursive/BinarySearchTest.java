package recursive;

/**
 * 
 * @author John
 *
 */
public class BinarySearchTest { 
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(binSearch(arr, 0, arr.length-1, 5));
	}
	
	public static int binSearch(int arr[],int low,int high,int keyvalue){
		if (low<=high) {
			int mid = (low+high)/2;
			if (keyvalue == arr[mid]) {
				return mid;
			}
			else if( keyvalue < arr[mid]){
				return binSearch(arr, low, mid-1, keyvalue);
			}
			else 
				return binSearch(arr, mid+1, high, keyvalue);
		}else {
			return -1;//没有查询到
		}
	}
}

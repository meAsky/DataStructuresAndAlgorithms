package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 变位字
 * @author John
 *
 */
public class changeTest { 
	static int size;//字母的长度
	static int count;
	static char[] ch = new char[100];
	public static void main(String[] args) throws IOException {
		System.out.println("请输入字母：");
		String s =getString();
		size = s.length();
		count = 0;
		for (int i = 0; i < size; i++) {
			ch[i] = s.charAt(i);
		}
		doChange(size);
		
	}
	
	public static void doChange(int n){
		//参数n代表的是字母的长度
		if (n==1) {//因为假设等0就退出的话，在rotate里面数组就超出了
			return;
		}
		for (int i = 0; i < n; i++) {//向前移动n-1次 ，循环n次
			doChange(n-1);
			if (n==2) {
				//打印
				display();
			}
			//移动的函数
			move(n);
		}
	}

	private static void display() {
		if (count < 99) {
			System.out.print(" ");
		}
		if (count<9) {
			System.out.print("  ");
		}
		System.out.print(++count +":");
		for (int i = 0; i < size; i++) {
			System.out.print(ch[i]);
		}
		System.out.print("  ");
		System.out.flush();
		if (count % 6 ==0) {
			System.out.println();
		}
	}

	private static void move(int n) {//把最后的字母向前移动n-1位
		int j;
		int position = size-n;
		char temp = ch[position];
		for (j = position+1; j < size; j++) {
			ch[j-1] = ch[j];
		}
		ch[j-1] = temp;
		
	}
	
	public static String getString() throws IOException{
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String string = br.readLine();
		return string;
	}
}

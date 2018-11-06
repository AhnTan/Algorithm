
/*
1���� ū �ڿ��� �߿���  1�� �ڱ� �ڽ��� ������ ����� ���� �ڿ����� �Ҽ���� �Ѵ�. 
���� ���, 5�� 1�� 5�� ������ ����� ���� ������ �Ҽ��̴�. 
������, 6�� 6 = 2 �� 3 �̱� ������ �Ҽ��� �ƴϴ�.

�������� ������ ������ �������� ���ذ� ������, 2���� ū ��� ¦���� �� �Ҽ��� ������ ��Ÿ�� �� �ִٴ� ���̴�. 
 ��, ¦���� �� �Ҽ��� ������ ��Ÿ���� ǥ���� �� ������ ������ ��Ƽ���̶�� �Ѵ�. 
 ���� ���, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7�̴�. 10000���� �۰ų� ���� ��� ¦�� n�� ���� ������ ��Ƽ���� �����Ѵ�.

2���� ū ¦�� n�� �־����� ��, n�� ������ ��Ƽ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
���� ������ n�� ������ ��Ƽ���� ���� ������ ��쿡�� �� �Ҽ��� ���̰� ���� ���� ���� ����Ѵ�.
*/

import java.io.*;
import java.util.*;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	int size = 1000000;
	int array[];
	int num1,num2,num,temp;
	int check=0;

	public static void main(String[] args) {

		new Main();

	}

	public Main() {
		
		init();
		try {
		int size_s = Integer.parseInt(reader.readLine());
			for(int k=0; k<size_s; k++) {
				calc();
				if(k<size_s-1){
					builder.append("\n");	
				}
			}
		}catch(Exception e) {}
		
		System.out.println(builder);
	}

	public void init() {
		array = new int[size];

		Arrays.fill(array, 0);

		for (int i = 2; i < size; i++)
			array[i] = i;

		for (int i = 2; i < size; i++) {
			if (array[i] != 0) {
				for (int j = i + i; j < size; j += i) {
					array[j] = 0;
				}
			}
		}
	}
	
	public void calc() {
		try {
			num = Integer.parseInt(reader.readLine());
			
			temp = num/2;
			
			for(int i=2; i<num; i++) {
				if(array[i]==temp) {
					num1 = array[i];
					num2 = array[i];
					builder.append(num1 + " " + num2);
					check=1;
				}
			}
			
			if(check==0) {
				calc2(temp);
			}
			
			check=0;
			
			
		}catch(Exception e) {}
	}

	public void calc2(int temp) {
		num1=0;
		num2=0;
		for(int i=temp; i<num; i++) {
			for(int j=temp; j>1; j--) {
				if( (array[i]+array[j])==num ) {
					num1 = array[j];
					num2 = array[i];
					break;
				}
			}
			if(num1!=0) {
				builder.append(num1 + " " + num2);
				break;
			}
		}
		
	}
}

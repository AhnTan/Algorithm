
/*
1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 
예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 
하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.

골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 
 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 숫자의 골드바흐 파티션이라고 한다. 
 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다. 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.

2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 
만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
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

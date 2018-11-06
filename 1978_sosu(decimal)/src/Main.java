import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	Scanner scanner;
	int num[];
	int value;
	int count=0;
	
	public static void main(String[] args) {
		new Main();

	}
	
	public Main() {
		
		init();
		System.out.println(calc());		
		
	}
	
	public void init() {
		scanner = new Scanner(System.in);
		value = 123456;
		
		num = new int[value];
		
		for(int m=0; m<value; m++) {
			num[m] = m;
		}
		
		for(int i=2; i<value; i++) {
			if(num[i] == 0) {
				continue;
			}
			
			// n의 배수를 삭제하는 것(여기서는 i)
			for(int j=i+i; j<value; j+=i) {
				num[j] = 0;
			}
		}
		
		
		for(int k=2; k<value; k++) {
			if(num[k] != 0) {
				//System.out.println(num[k]);
			}
		}
		
	}
	
	public int calc() {
		int num_size = scanner.nextInt();
		int input_num[] = new int[num_size];
	
		Arrays.fill(input_num, 0);
		
		for(int k=0; k<num_size; k++) {
			input_num[k] = scanner.nextInt();
			for(int m=0; m<value; m++) {
				if( ( input_num[k]==num[m] ) && (input_num[k]!=1)) {
					count++;
				}
			}
		}
		
		return count;
	}

}

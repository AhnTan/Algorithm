import java.util.Arrays;
import java.util.Scanner;

public class Main {

	int num_1,num_2;
	int sum,minmum=0;
	Scanner scanner;
	int array[];
	int size=123456;
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		init();
		calc();
	}

	public void init() {
		scanner = new Scanner(System.in);
		array = new int[size];

		Arrays.fill(array, 0);
		for (int i = 2; i < size; i++) {
			array[i] = i;
		}

		for (int i = 2; i < size; i++) {

			if (array[i] != 0) {
				for (int j = i + i; j < size; j += i) {
					array[j] = 0;
				}
			}
		}
	}

	public void calc() {
		num_1 = scanner.nextInt();
		num_2 = scanner.nextInt();
		
		for(int t=num_1; t<=num_2; t++) {
			
			if(array[t]!=0) {
				sum += array[t];
				if(minmum==0) {
					minmum = array[t];
				}
			}
		}
		if(sum==0) {
			sum = -1;
			System.out.println(sum);
		}else {
			System.out.println(sum);
			System.out.println(minmum);
		}
	}
	
}

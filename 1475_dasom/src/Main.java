import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	ArrayList<Integer> namergi;
	Scanner scanner;
	int num;
	
	int count=0;
	int temp_count;
	int check1=0; // 6,9 
	int check2=0; // 0,1,2,3,4,5,7,8
	
	int know[] = new int[10];
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
	
		init();
		System.out.println(calc());
		/*for(int p=0; p<1000000; p++) {
			init(p);
			System.out.println(" p : " + p);
			calc();
		}*/
		
	}
	
	public void init() {
		int m = 0;
		namergi = new ArrayList<Integer>();
		scanner = new Scanner(System.in);
		num = scanner.nextInt();
		
		Arrays.fill(know, 0);
		

		if ((num / 10) == 0) {
			namergi.add(num);
		} 
		else {
			while (num != 0) {

				if(num%10==6 || num%10==9) {
					check1++;
				}
				
				namergi.add(num % 10);

				num = num / 10;

				m++;
			}

			for (int i = namergi.size()-1; i >= 0; i--) {
				if( (namergi.get(i)==6) || (namergi.get(i)==9) ) {
					namergi.remove(i);
				}
			}
		}
	}
	
	public int calc() {
		
		while( check1 > 0 ) {
			
			check1 -= 2;
			
			count ++;
			
		}

		
		for(int i=namergi.size()-1; i>=0; i--) {
			for(int j=i; j>=i; j--) {
				if(namergi.get(i)==namergi.get(j)) {
					
					 know[namergi.get(i)] += 1;
					
				}
			}
		}
		
		temp_count = know[0];
		
		for(int m=1; m<10; m++) {
			if(temp_count < know[m]) {
				temp_count = know[m];
			
			}
		}
		

		
		if(count<=temp_count) {
			count=temp_count;
		}
		
		return count;
	}

	
}

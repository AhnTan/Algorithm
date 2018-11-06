import java.util.Arrays;
import java.util.Scanner;

public class Main {

	Scanner scanner;

	int input,m,n,x,y, max, minus, xy_cha, mn_cha;
	int array[];
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		
		scanner = new Scanner(System.in);
		
		input = scanner.nextInt();
		array = new int[input];
		Arrays.fill(array, 0);
		
		for(int i=0; i<input; i++) {
			array[i] = init();
		}
		
		for(int j=0; j<input; j++) {
			System.out.println(array[j]);
		}
		
	}
	
	public int init() {
		
		m = scanner.nextInt();
		n = scanner.nextInt();
		x = scanner.nextInt();
		y = scanner.nextInt();
		
		mn_cha = Math.abs(m-n);
		xy_cha = Math.abs(x-y);
		
		if( m > n ) {
			max = m;
			minus = n-m;
			calc(max, minus);
		}
		else if( m < n ) {
			max = m;
			minus = m;
			calc(max, minus);
		}
		//System.out.println(calc());
		return 0;
	}
	
	public int calc(int max, int minus) {
		
		int count_x=1;
		int count_y=1;
		int count=1;
		
		while(! (x==count_x && y==count_y) ) {
			
			if(minus == xy_cha) {
				
			}
			
			count_y += minus;
			count += max;
			
			
			
			minus -= (n-m);
			
			//System.out.println(count + "¹øÂ° : " + "<" + count_x + "," + count_y + ">");
			
		}
		
		
		return count;
	}
}

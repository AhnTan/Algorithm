import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	Scanner scanner;

	int input,m,n,x,y;
	int array[];
	

	public Main2() {
		
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
		
		//System.out.println(calc());
		return calc();
	}
	
	public int calc() {
		
		int count_x=1;
		int count_y=1;
		int count=1;
		
		while(! (x==count_x && y==count_y) ) {
			
			if(count_x==m) {
				count_x=1;
			}else {
				count_x++;
			}
			if(count_y==n) {
				count_y=1;
			}else {
				count_y++;
			}
			count+=1;
			
			
			
			if(count_x==m && count_y==n) {
				count=-1;
				break;
			}
		}
		
		
		return count;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	int array[] = new int[100];
	int sum1=1,sum2=1;
	
	public static void main(String[] args) {
		new Main();

	}
	
	public Main() {
		
		try {
			
			String[] s = reader.readLine().split(" ");
			
			int num  = Integer.parseInt(s[0]);
			int size = Integer.parseInt(s[1]);			
			
			calc(num, size);
			
		}catch(Exception e) {}
		
		
	}

	public void calc(int num, int size) {
	
		while(size!=0) {
			sum1 *= num; 
			sum2 *= size;
			num--;
			size--;
		}
		
		System.out.println(sum1 / sum2);
		
	}
}

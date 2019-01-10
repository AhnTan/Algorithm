import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	long num1 = 0;
	long num2 = 1;
	long num3 = 1;
	String a,b,c;
	String max = Integer.toString(Integer.MAX_VALUE);
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		init();
	}
	
	public void init() {
		try {
			
			int size = Integer.parseInt(reader.readLine());
			
			for(int i=0; i<size-1; i++) {
				num3 = num1 + num2;
				num1 = num2;
				num2 = num3;
			}
			
				System.out.println(num3);
		
			
		}catch(Exception e) {}
		
		
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	int array[];
	
	public static void main(String[] args) {
		
		new Main();
	}
	
	public Main() {
		// 최대 공약수를 찾아 각 수를 최대공약수로 나누기
		try {
			int size = Integer.parseInt(reader.readLine());
			array = new int[size];
			String s[] = reader.readLine().split(" ");
			array[0] = Integer.parseInt(s[0]);
			for(int i=1; i<size; i++) {
				array[i] = Integer.parseInt(s[i]);
				calc(array[0], array[i]);
			}
			System.out.println(builder);
			
		}catch(Exception e) {}
	}
	
	public void calc(int max, int min) {
		int temp = min;
		int r = max % min;
		
		while(true) {
			if(r==0) {
				builder.append(array[0]/min).append("/").append(temp/min).append("\n");
				break;
			}

			max = min;
			min = r;
			r = max % min;
		}
		
		
	}

}

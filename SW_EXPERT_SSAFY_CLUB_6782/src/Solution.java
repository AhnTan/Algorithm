import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int case_size, init_num, count;
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		init();
	}
	
	public void init() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			System.out.println(Math.pow(Math.sqrt(100), 2.0));
			for(int i=0; i<case_size; i++) {
				count = 0;
				init_num = Integer.parseInt(reader.readLine());
				writer.write("#" + (i+1) + " ");
				calc(init_num);
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {}
	}
	
	public void calc(double num) {
		try {
			
			double temp = Math.sqrt(num);
			
			if ((int) num == 2) {
				writer.write(count + "\n");
				return;
			} else if (Math.pow(temp, 2.0) == num) {
				System.out.println("!! : " + num);
				count++;
				calc(temp);
			} else {
				System.out.println(num);
				count++;
				calc(num + 1.0);
			}
		}catch(Exception e) {}
	}
	
}

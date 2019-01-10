import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int case_size, count;
	long init_num;
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		init();
	}
	
	public void init() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			
			for(int i=0; i<case_size; i++) {
				count = 0;
				init_num = Long.parseLong(reader.readLine());
				writer.write("#" + (i+1) + " ");
				calc(init_num);
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {}
	}
	
	public void calc(long num) {
		try {

			double temp = Math.sqrt(num);
			
			if ((long)num == 2) {
				writer.write(count + "\n");
				return;
			} else if ( (Math.pow((long)temp, 2.0) != num) || num==1) {
				
				// 제곱근을 정수로 변환시켜 1을 더해준다.
				// 그 더한 값을 제곱한것이 조건에 부합하는 가장 가까운 수(n)이므로 원래 값인(num)을 빼주면 한번에 그 값까지의 카운터가 된다.  
				Long n = (long)temp;
				n += 1;
				n = (long)Math.pow(n, 2.0);
				
				count += (n - num);
				calc(n);
				
				
			} else {
				count++;
				calc((long)temp);
			}
			
		}catch(Exception e) {}
	}
	
}

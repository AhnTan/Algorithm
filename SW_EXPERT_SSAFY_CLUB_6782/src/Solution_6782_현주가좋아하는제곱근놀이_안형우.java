import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_6782_현주가좋아하는제곱근놀이_안형우{

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int case_size, count;
	long init_num;
	
	public static void main(String[] args) {
		new Solution_6782_현주가좋아하는제곱근놀이_안형우();
	}
	
	public Solution_6782_현주가좋아하는제곱근놀이_안형우() {
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
				
				Long n = (long)temp;
				n += 1;
				n = (long)Math.pow(n, 2.0);
				
				count += (n - num);
				calc(n);
				//count++;
				//calc(num + 1);
				
			} else {
				count++;
				calc((long)temp);
			}
			
		}catch(Exception e) {}
	}
	
}

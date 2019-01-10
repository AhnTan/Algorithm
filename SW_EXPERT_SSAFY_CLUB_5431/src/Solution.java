import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int case_size, total_std, now_std;
	int array[];
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		init();

	}
	
	public void init(){
		try {
			case_size = Integer.parseInt(reader.readLine());
			
			for(int i=0; i<case_size; i++) {
				
				
				String s[] = reader.readLine().split(" ");
				total_std = Integer.parseInt(s[0]);
				now_std = Integer.parseInt(s[1]);
			
				array = new int[total_std];
				Arrays.fill(array, 0);
			
				writer.write("#" + (i+1));
			
				calc();
				
				writer.write("\n");
			}
			writer.flush();
			writer.close();
			
			
		}catch(Exception e) {}
	}
	
	public void calc() {
		try {
			String s[] = reader.readLine().split(" ");
			
			for (int i = 0; i < s.length; i++) {
				array[Integer.parseInt(s[i])-1]++;
			}
			
			for(int i=0; i<total_std; i++) {
				if(array[i]==0) {
					writer.write(" " + (i+1));
				}
			}
			
		}catch(Exception e) {}
	}
	
}

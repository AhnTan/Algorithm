import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int min, max, min_index, max_index;
	int case_size = 10;
	int dump_size;
	int array[];
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		
		try {
			for (int i = 0; i < case_size; i++) {
				writer.write("#" + (i + 1) + " " + init() + "\n");
			}
			writer.flush();
			writer.close();
		}catch(Exception e) {}
	}
	
	public int init() {
		try {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			array = new int[100];
			Arrays.fill(array, 0);
			
			dump_size = Integer.parseInt(reader.readLine());
			
			String s[] = reader.readLine().split(" ");
			
			for(int i=0; i<s.length; i++) {
				
				array[i]=Integer.parseInt(s[i]);				
			}
			
			for(int j=0; j<dump_size; j++) {
				calc();
			}
			
			Arrays.sort(array);
			
		}catch (Exception e) {}
		
		return ( array[array.length-1] - array[0] );
	}
	
	public void calc() {
		
		Arrays.sort(array);
		
		array[0]++;
		array[array.length-1]--;
		
		
	}
}

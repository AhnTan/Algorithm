import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	int array[][], width, cnt;
	int case_size = 10;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
			for (int i = 0; i < case_size; i++) {
				cnt = 0;
				init();
				writer.write("#" + (i + 1) + " " + cnt + "\n");
			}
			writer.flush();
			writer.close();
		}catch(Exception e) {}
	}
	
	public void init() {
		try {
			width = Integer.parseInt(reader.readLine());
			array = new int[width][255];
			
			for(int i=0; i<width; i++) {
				Arrays.fill(array[i], 0);
			}
			
			String s[] = reader.readLine().split(" ");
			
			for(int i=0; i<width; i++) {
				for(int j=0; j<Integer.parseInt(s[i]); j++) {
					array[i][j] = 1;
				}
			}
		
			// ÁÂ¿ì 2Ä­¾¿ Á¦¿ÜÇÏ°í
			for(int i=2; i<width-2; i++) {
				calc(s, i);
			}
		}catch(Exception e) {}
	}
	
	public void calc(String s[], int index) {
		
		for(int j=Integer.parseInt(s[index])-1; j>=0; j--) {
			if(array[index-2][j] == 0 && array[index+2][j] == 0 && array[index-1][j] == 0 && array[index+1][j] == 0) {
				cnt++;
			}	
		}
	}
	
}

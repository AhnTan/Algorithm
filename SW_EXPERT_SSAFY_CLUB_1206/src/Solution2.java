import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Solution2 {
	public static void main(String[] args) throws IOException{
		int width, cnt, case_size = 10;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < case_size; i++) {
			cnt = 0;
			width = Integer.parseInt(reader.readLine());
			String s[] = reader.readLine().split(" ");
			// ÁÂ¿ì 2Ä­¾¿ Á¦¿ÜÇÏ°í
			for(int k=2; k<width-2; k++) {
				int num1 = Integer.parseInt(s[k-2]);
				int num2 = Integer.parseInt(s[k-1]);
				int num3 = Integer.parseInt(s[k+2]);
				int num4 = Integer.parseInt(s[k+1]);
				int num = Integer.parseInt(s[k]);
				if( num > num1 && num > num2 && num > num3 && num > num4) {
					int max,max2,result;
					max = Math.max(num1, num2);
					max2 = Math.max(num3, num4);
					result = Math.max(max, max2);
					cnt += num-result;
				}
			}
			writer.write("#" + (i + 1) + " " + cnt + "\n");
		}
		writer.flush();
		writer.close();
	}
}

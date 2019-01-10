import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {
	
	int array[], index, count, test_case_size, size, max_cal, result=0;
	String temp,num;
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	ArrayList<Integer> list1;	
	ArrayList<Integer> list2;
	
	int now_score=0;
	int now_cal = 0;
	
	
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		init();
	}
	
	public void init() {
		try {
			test_case_size = Integer.parseInt(reader.readLine());
	
			for(int i=0; i<test_case_size; i++) {
				list1 = new ArrayList<Integer>();
				list2 = new ArrayList<Integer>();
				//hash = new HashMap<Integer, Integer>();
				input_init();
				writer.write("#" + (i+1) + " " + result + "\n");
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {}
	}
	
	public void input_init() {
		try {
			String s[] = reader.readLine().split(" ");
		
			size = Integer.parseInt(s[0]);
			max_cal = Integer.parseInt(s[1]);
			
			for(int i=0; i<size; i++) {
				String s2[] = reader.readLine().split(" ");
				list1.add(Integer.parseInt(s2[0]));
				list2.add(Integer.parseInt(s2[1]));
			}
			
			result = 0;
			for(int i=0; i<size; i++) {

				calc(i, 0, 0);
				
			}
			
		}catch(Exception e) {}
	}
	
	public void calc(int index, int nows_score, int nows_cal) throws IOException {
		
		if(index==size) {
			return;
		}
		
		nows_score += list1.get(index);
		nows_cal += list2.get(index);

		for(int j=index; j<size; j++) {

			if (nows_cal <= max_cal) {

				if (result <= nows_score) {
					result = nows_score;
				}

				calc(j+1, nows_score, nows_cal);
			} else if (nows_cal > max_cal && index < size) {
				
				// calc(index--, nows_score - list1.get(index), nows_cal - list2.get(index));
			}
		}
	}
}

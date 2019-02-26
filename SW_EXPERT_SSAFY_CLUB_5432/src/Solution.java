import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	Stack<String> stack = new Stack<String>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	int case_size, last_index, sum=0;
	int laser[] = new int [100000];
	int gidung[] = new int [100000];
	
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			
			for(int i=0; i<case_size; i++) {
				init();
				calc();
				writer.write("#" + (i+1) + " " + sum + "\n");
			}
			writer.flush();
			writer.close();
		}catch(Exception e) {}
		
	}
	
	public void calc() {
		int index = 0;
	
		for(int i=0; i<last_index; i++) {
			if(gidung[i]!=0) {
				index = 0;
				for(int j=i+1; j<gidung[i]; j++) {
					index += laser[j];
				}
				sum = sum + (index+1);
			}
		}
		
	}
	
	public void init() {

		try {
			String st[] = reader.readLine().split("");
			
			sum = 0;
			laser = new int [100000];
			gidung = new int [100000];
			
			for(int i=0; i<st.length; i++) {
				
				if(stack.isEmpty()) {
					stack.push(st[i]);
					stack2.push(i);
				}
				
				else {
					if (stack.peek().equals("(") == st[i].equals(")")) {
						stack.pop();
						// 레이저일때
						if( (i - stack2.peek()) == 1) {
							laser[i] = 1;
							stack2.pop();
						}
						// 기둥, 배열index는 기둥시작위치 , value는 기둥끝위치
						else {
							int temp = stack2.pop();
							gidung[temp] = i;
							last_index = i;
							
							
						}
					}
					else {
						stack.push(st[i]);
						stack2.push(i);
					}
				}
			}
		}catch(Exception e) {}
	}
}


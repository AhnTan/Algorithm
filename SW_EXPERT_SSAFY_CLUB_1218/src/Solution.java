import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	Stack<String> stack = new Stack<String>();
	
	int case_size = 10;
	
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
			for(int i=0; i<case_size; i++) {
				writer.write("#" + (i+1) + " " + init() + "\n");
			}
			writer.flush();
			writer.close();
		}catch(Exception e) {}
		
	}

	public int init() {
		try {
			int trash = Integer.parseInt(reader.readLine());
			String st[] = reader.readLine().split("");
			
			for(int i=0; i<st.length; i++) {
				
				if(stack.isEmpty()) {
					stack.push(st[i]);
				}
				
				else {
					String temp = st[i];

					switch (temp) {
					case ")":
						if (!(stack.pop().equals("("))) {
							return 0;
						}
						break;
					case "}":
						if (!(stack.pop().equals("{"))) {
							return 0;
						}
						break;
					case ">":
						if (!(stack.pop().equals("<"))) {
							return 0;
						}
						break;
					case "]":
						if (!(stack.pop().equals("["))) {
							return 0;
						}
						break;
					default:
						stack.push(st[i]);
						break;
					}
				}
			}
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
}

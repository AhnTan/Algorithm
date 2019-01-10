import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int max_size;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Object> list = new Stack<>();
		
		max_size = Integer.parseInt(reader.readLine());
		
		for(int i=0; i<max_size; i++) {
			String s[] = reader.readLine().split(" ");
			
			switch(s[0]) {
			case "push":
				list.push(s[1]);
				break;
			case "top":
				if(list.size()==0) {
					writer.write("-1\n");
				}else
					writer.write(list.peek().toString()+"\n");
				break;
			case "pop":
				if(list.size()==0) {
					writer.write("-1\n");
				}else
					writer.write(list.pop().toString()+"\n");
				break;
			case "empty":
				if(list.empty()==true)
					writer.write("1\n");
				else
					writer.write("0\n");
				break;
			case "size":
				writer.write(list.size()+"\n");
				default:
					break;
			}
		}
		writer.flush();
		writer.close();
	}
}

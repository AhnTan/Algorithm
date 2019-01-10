import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	int array[];
	public static void main(String[] args) {
		new Main();

	}
	
	public Main() {
		try {
			
			int size = Integer.parseInt(reader.readLine());
			array = new int[size];
			for(int i=0; i<size; i++) {
				array[i] = Integer.parseInt(reader.readLine());
			}
			
			Arrays.sort(array);
			
			for(int i=0; i<size; i++) {
				builder.append(array[i]).append("\n");
			}
			
		}catch(Exception e) {}
		
		System.out.println(builder);
		
	}

}

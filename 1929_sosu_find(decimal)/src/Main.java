import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	int size=1000001;
	int num_1,num_2,arrays[];
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		init();
		calc();
		System.out.println(builder);
	}

	public void init() {
		arrays = new int[size];
		Arrays.fill(arrays, 0);
		for(int i=2; i<size; i++) {
			arrays[i] = i;
		}
		
		for(int i=2; i<size; i++) {
			if(arrays[i]!=0) {
				for(int j=i+i; j<size; j+=i) {
					arrays[j] = 0;
				}
			}
		}
	}
	
	public void calc() {
		try {
			String[] arr = reader.readLine().split(" ");
			num_1 = Integer.parseInt(arr[0]);
			num_2 = Integer.parseInt(arr[1]);
		} catch (IOException e) {}
	
		for(int k=num_1; k<=num_2; k++) {
			if(arrays[k]!=0)
				builder.append(arrays[k]).append("\n");
		}
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	int case_size;

	int min_array[];
	int max_array[];
	int temp_array[];

	int result = 0;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		try {
			case_size = Integer.parseInt(reader.readLine());

			min_array = new int[case_size];
			max_array = new int[case_size];
			temp_array = new int[case_size];

			for (int i = 0; i < case_size; i++) {
				String s[] = reader.readLine().split(" ");
				min_array[i] = Integer.parseInt(s[0]);
				max_array[i] = Integer.parseInt(s[1]);
			}

			sort();
			init();
			
			System.out.println(result);
			
		} catch (Exception e) {
		}
	}

	public void init() {
		for (int i = 0; i < case_size; i++) {
			boolean check = false;
			
			if (temp_array[i] != 1) {
				for (int j = 0; j < case_size; j++) {
					if (temp_array[j] != 1 && ( min_array[j] <= max_array[i])) {
						temp_array[j] = 1;
						check = true;
					}
				}
		

			if (check == true) {
				result++;
			}
			
			}
		}
	}
	
	public void sort() {
		int min_temp = 0;
		int max_temp = 0;
		
		for (int i = 0; i < case_size; i++) {
			for (int j = i + 1; j < case_size; j++) {
				if (max_array[j] < max_array[i]) {
					min_temp = min_array[i];
					max_temp = max_array[i];
					min_array[i] = min_array[j];
					max_array[i] = max_array[j];
					min_array[j] = min_temp;
					max_array[j] = max_temp;
				}
			}
		}
	}

}

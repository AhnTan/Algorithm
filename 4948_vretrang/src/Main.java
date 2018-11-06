import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	int size = 1000000;
	int array[];

	public static void main(String[] args) {
		new Main();
	}

	public Main() {

		init();
		calc();
	}

	public void init() {

		array = new int[size];

		for (int i = 0; i < size; i++) {
			array[i] = i;
		}

		for (int i = 2; i < size; i++) {

			if (array[i] != 0) {
				for (int j = i + i; j < size; j += i) {
					array[j] = 0;
				}
			}
		}

	}

	public void calc() {
		try {
			while (true) {

				int count = 0;
				int num = Integer.parseInt(reader.readLine());
				if (num == 0) {
					break;
				}
				for (int i = num + 1; i <= num*2; i++) {
					if(array[i]!=0) {
						count++;
					}
				}
				builder.append(count).append("\n");
			}

		} catch (Exception e) {
		}
		
		System.out.println(builder);
	}

}

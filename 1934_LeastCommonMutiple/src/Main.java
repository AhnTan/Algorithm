import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	long min, max, a, b;
	long col, temp;
	String s[];

	public static void main(String[] args) {

		new Main();

	}

	public Main() {

		try {
			int size = Integer.parseInt(reader.readLine());

			for (int k = 0; k < size; k++)
				init();

			System.out.println(builder);

		} catch (Exception e) {
		}

	}

	public void init() {
		try {
			s = reader.readLine().split(" ");

			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);

			min = a;
			max = b;
			temp = 1;

			if (a > b) {
				min = b;
				max = a;
			}

			if (max % min == 0) {
				temp *= min;
			} 
			else {
				for (int i = 2; i < min; i++) {
					// °ø¾à¼ö
					if ((a % i) == 0 && (b % i) == 0) {
						temp = i;
					
					}
				}
			}

			builder.append((a*b) / temp).append("\n");

		} catch (Exception e) {
		}
	}

}

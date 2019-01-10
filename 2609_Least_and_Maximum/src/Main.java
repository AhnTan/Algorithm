import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 최대공약,최소공배수 찾기
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

		init();
		System.out.println(builder);

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
					// 최대공약수 찾기
					if ((a % i) == 0 && (b % i) == 0) {
						temp = i;
					
					}
				}
			}

			builder.append(temp).append("\n");
			builder.append((a*b) / temp);
			
			

		} catch (Exception e) {
		}
	}

}

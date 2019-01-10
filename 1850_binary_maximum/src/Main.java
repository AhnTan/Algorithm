import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder builder = new StringBuilder();

			String s[] = reader.readLine().split(" ");
			long a = Long.parseLong(s[0]);
			long b = Long.parseLong(s[1]);
			long max, min;
			max = b;
			min = a;
			if (a > b) {
				max = a;
				min = b;
			}
			long r = max % min;

			while (true) {
				if (r == 0) {

					for (int i = 0; i < min; i++) {
						builder.append("1");
					}
					System.out.println(builder);
					break;
				}

				max = min;
				min = r;
				r = max % min;
			}

		} catch (Exception e) {
		}
	}
}
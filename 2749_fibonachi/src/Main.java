import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	int mod = 1000000;
	int p = mod/10*15;
	long[] array = new long[p];
	
	String a,b,c;
	String max = Integer.toString(Integer.MAX_VALUE);
	
	
	// 피사노 주기법
	// 주기를 찾아 계산함 -> 주기의길이가 p일때 n번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M으로 나눈 나머지와 같다
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		init();
	}
	
	public void init() {
		try {
			
			long size = Long.parseLong(reader.readLine());

			//System.out.println(num3%1000000);
		
			array[0] = 0;
			array[1] = 1;
			calc(size);
			
		}catch(Exception e) {}
	}
	
	public void calc(long n) {

		//System.out.println("aaa");
		for(int i=2; i<p; i++) {
			array[i] = array[i-1] + array[i-2];
			//System.out.println("array[" + i + "] : " + array[i]);
			array[i] %= mod;
		}
		//System.out.println("bbb");
		System.out.println(array[(int)(n%p)]);
	}
}

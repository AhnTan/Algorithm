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
		init();
	}
	
	public void init() {
		try {
			array = new int[10];
			
			int num = Integer.parseInt(reader.readLine());
			int temp=num;
			int temp2=0;
			int count=0;
			while(temp != 0) {
				array[count++] = temp%10;
				temp = temp/10;
			}
	
			Arrays.sort(array);

			for(int i=9; i>=10-count; i--) {
				if(array[i]!=0) {
					temp2 = temp2*10 + array[i];
				}else if(array[i]==0) {
					temp2 = temp2*10;
				}
			}
			System.out.print(temp2);
		}catch(Exception e) {}
	}
}

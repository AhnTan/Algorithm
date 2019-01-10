import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	int num;
	int array[] = new int[41];
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		
		try {
			int size = Integer.parseInt(reader.readLine());
			Arrays.fill(array, 0);
			
			for(int i=0; i<size; i++) {
				
				int num = Integer.parseInt(reader.readLine());

				if( num == 0 ) {
					System.out.println("1 0");
				}
				else {
					System.out.println(init(num-1) + " " + init(num));	
				}
			}
		}catch(Exception e) {}
		
	}
	
	// �迭�� �̿��� ���� �����س��� �ٽ� ��ߵ�
	public int init(int n) {
		if(array[n] > 0) {
			return array[n];
		}
		if(n==0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		return array[n] = init(n-1) + init(n-2);
	}

}

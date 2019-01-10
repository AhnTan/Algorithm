import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


class Main {

	int array[], index, count;
	String temp,num;
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		new Main();
	}
	
	public Main() {
		init();
	}
	
	public void init() {
		try {
			
			int case_size = Integer.parseInt(reader.readLine());
			
			for(int i=0; i<case_size; i++) {
				temp = "";
				index = Integer.MAX_VALUE;
				count = 0;
				calc();
				writer.write("#" + (i+1) + " " + count + "\n");
			}
			
			writer.flush();
			writer.close();
			reader.close();
			
		}catch(Exception e) {}
	}
	
	
	public void calc() {
		
		try {
			num = reader.readLine();
			
			array = new int[num.length()];
			
			for(int i=0; i<num.length(); i++) {
				array[i] = num.charAt(i)-48;
				
				if(array[i]==1 && index>=i) {
					index = i;
				}
			}
			
			Arrays.fill(array, 0);
			fuc_check(index);

		}catch(Exception e) {}
	}
	
	public void fuc_check(int index) {

		while(true) {
			String s = String.valueOf(num.charAt(index) - 48);
			String temp = "";

			if (array[index] == Integer.parseInt(s)) {

			} else {
				for (int k = index; k < array.length; k++) {
					array[k] = Integer.valueOf(s);
					temp += String.valueOf(array[k]);
				}
				count++;
			}

			index++;

			if (temp.equals(num))
				break;
		}
	}
}

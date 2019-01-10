import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	int array[],array_yang[],array_um[];
	int size,max=0 ;
	int check=0;
	

	public static void main(String[] args) {
		new Main();

	}

	public Main() {
		init();
		calc1();
		calc2();
		calc3();
		calc4();
		System.out.print(builder);
	}

	public void init() {
		try {

			size = Integer.parseInt(reader.readLine());
			array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = Integer.parseInt(reader.readLine());
			}

			Arrays.sort(array);
			
			
			array_yang = new int[4001];
		
			array_um = new int[4001];
		
			
			Arrays.fill(array_yang, 0);

			Arrays.fill(array_um, 0);
		
		
			
		} catch (Exception e) {
		}

	}

	public void calc1() {
		double sum=0;
		for(int i=0; i<size; i++) {
			sum += array[i];
			if(array[i]>=0) {
				array_yang[array[i]]++;
				if(max<array_yang[array[i]]) {
					max = array_yang[array[i]];
				}
			}
			else if(array[i]<0) {
				array_um[ Math.abs(array[i]) ]++;
				if( max< array_um[ Math.abs(array[i]) ]) {
					max = array_um[ Math.abs(array[i]) ];
				}
			}
		}
		builder.append( Math.round(sum/size) ).append("\n");
	}

	public void calc2() {
		builder.append(array[array.length/2]).append("\n");
	}

	// ÃÖºó°ª
	public void calc3() {
		int temp=0,temp_count=max;
		
		for(int i=array_um.length-1; i>0; i--) {

			if(array_um[i]!=0) {
				
				if(temp_count == array_um[i] && check<2) {
					temp = 0 - i;
					check++;
					if(check==2)
						break;
				}
				
				else if (temp_count < array_um[i]) {
					temp = 0 - i;
					temp_count = array_um[i];
				}
			}
		}
		
		for(int i=0; i<array_yang.length; i++) {
			if(array_yang[i]!=0) {
				
				if(temp_count == array_yang[i] && check<2) {
					temp = i;
					check++;
						if(check==2)
								break;
				}
				
				else if (temp_count < array_yang[i]) {
					temp = i;
					temp_count = array_yang[i];
				}
			}
		}
		
		builder.append(temp).append("\n");

	}

	public void calc4() {
		builder.append(array[array.length-1] - array[0]);
	}	
}

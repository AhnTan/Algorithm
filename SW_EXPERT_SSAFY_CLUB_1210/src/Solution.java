import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int start, index_y;
	int case_size = 10;
	int array[][];
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
		for(int i=0; i<case_size; i++) {
			
			
			init();
			calc();
			writer.write("#" + (i+1) + " " + start + "\n");
		}
		writer.flush();
		writer.close();
		}catch(Exception e) {}
	}
	
	public void init() {
		try {
			int trash = Integer.parseInt(reader.readLine());
			array = new int[100][100];
			
			for(int i=0; i<array.length; i++) {
				String s[] = reader.readLine().split(" ");
				for(int j=0; j<array[i].length; j++) {
					array[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			start();
			index_y = array.length-1;
			
		}catch(Exception e) {}
	}
	
	public void start() {
	
		
		for(int i=0; i<array.length; i++) {
			if(array[99][i] == 2) {
				start = i;
				//System.out.println("스타트점은 : " + start);
			}
		}
		
	}

	
	public void calc() {
		
	
		
		while (index_y > 0) {

			index_y--;

			if(start+1 > 99) {
				if ((array[index_y][start - 1] == 1)) {
					//System.out.println("y줄(-1) -> " + index_y + "     " + "현재 start 위치 : " + start);
					start = calc_real(start, -1);
				}
			}else if(start-1<0) {
				if ((array[index_y][start + 1] == 1)) {
					//System.out.println("y줄(1) -> " + index_y + "     " + "현재 start 위치 : " + start);
					start = calc_real(start, 1);

				}
			}
			else {
				// 오른쪽 체크
				if ((array[index_y][start + 1] == 1)) {
					//System.out.println("y줄(1) -> " + index_y + "     " + "현재 start 위치 : " + start);
					start = calc_real(start, 1);

				}
				// 왼쪽 체크
				else if ((array[index_y][start - 1] == 1)) {
					//System.out.println("y줄(-1) -> " + index_y + "     " + "현재 start 위치 : " + start);
					start = calc_real(start, -1);
				}

				//System.out.println("y줄 -> " + index_y + "     " + "현재 start 위치 : " + start);
			}

		}
		//System.out.println("정답 : " + start + " " + index_y);
	}
	
	public int calc_real(int start, int v) {
		int start_s = start;
		while( ! ((start_s + v)==-1 || (start_s + v)==100) ) {

			if(array[index_y][start_s + v] == 0) {
				return start_s;
			}
			
			start_s = start_s + v;
		}
		return start_s;
	}
	
	public void view() {
		for(int i=0; i<array.length; i++) {
		
			for(int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}

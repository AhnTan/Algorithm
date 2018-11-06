import java.util.Scanner;

public class Main {

	Scanner scanner;
	
	int height=0;
	int width=0;
	int temp_width[];
	int string[];
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		
		scanner = new Scanner(System.in);
		int circles = scanner.nextInt();
		string = new int[circles];
		
		for(int k=0; k<circles; k++) {
			string[k] = circle();
		}
		for(int k=0; k<circles; k++) {
			System.out.println(string[k]);
		}
	}
	
	public int circle() {
	
		int sum=0;
	
		height = scanner.nextInt();
		width = scanner.nextInt();
		
		temp_width = new int[width];
		
		init();
		
		if(height == 0) {
			sum = temp_width[temp_width.length-1];
		}
		else {
			sum = calc();
		}
		return sum;
	}
	
	public int calc() {
		int i=0;
		int check_height=0;

		while(height!=check_height) {
			for(i=1; i<width; i++) {
				temp_width[i] = temp_width[i-1] + temp_width[i];
			}
			check_height++;
		}
		return temp_width[i-1];
	}
	
	public void init() {
		for (int i = 0; i < width; i++) {
			temp_width[i] = i+1;
		}
	}

}

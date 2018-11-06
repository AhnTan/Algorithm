import java.util.Scanner;

public class Main {
	Scanner scanner;
	int num[] ;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Main();
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초"); //실행 시간 계산 및 출력
	}

	public Main() {
		scanner = new Scanner(System.in);
		int circles = scanner.nextInt();
		num = new int[circles];
		for(int k=0; k<circles; k++) {
			num[k] = calc();
		}
		for(int k=0; k<circles; k++) {
			System.out.println(num[k]);
		}
	}
	
	public int calc() {
		
		int count,start,end,length;
		int i=1;
		
		start = scanner.nextInt();
		end = scanner.nextInt();
		length = end - start;
		while(true) {
			if((i*i)<=length && ((i+1)*(i+1)>length)) {		
				break;
			}
			i++;
		}
		count = (i*2)-1;
		if(length == i*i) {}
		else if(length <= ((i*i)+(i-1))) {count++;}
		else {count+=2;}
		return count;
	}
}

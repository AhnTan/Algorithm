import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	int calculator[];
	Scanner s_1 = new Scanner(System.in);
	
	public Main() {
		
		int s = s_1.nextInt();
		
		calculator = new int[s];
		
		for(int k=0; k<s; k++) {
			calculator[k] = calc();
		}
		for(int k=0; k<s; k++) {
			System.out.println(calculator[k]);
		}
	}
	
	public int calc() {
		int temp,s1,s2,s3;
		int i=1;
		int count = 0;
		
		s1 = s_1.nextInt();
		s2 = s_1.nextInt();
		s3 = s2-s1;
		do{
			count+=2;
			i++;
		}while(((i*(i+1))/2 <= s3/2));
		temp = (i-1)*i ;
		if(s3==temp) {}
		else if(s3 == temp+i || (i>(s3-temp) && i!=0)) {
			count++;
		}
		else if(i<(s3-temp)) {
			count+=2;
		}
		return count;
	}
}


/*public class Main {



	public static void main(String[] args) {



		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt();

		int[] result = new int[num];



		for (int i = 0; i < num; i++) {

			int x = scan.nextInt();

			int y = scan.nextInt();

			int dist = y - x;

		

			int n = (int)Math.ceil(Math.sqrt(dist));

			int maxDist =(int)Math.pow(Math.ceil(Math.sqrt(dist)),2);

			int maxNum = n*2 -1 ;

			int numberOfTimes = maxNum ;

			

			if(dist <= maxDist-n) {

				numberOfTimes = maxNum-1;

			}

			result[i] = numberOfTimes;

		}


		for(int res : result) {

			System.out.println(res);

		}

		scan.close();
	}

}*/
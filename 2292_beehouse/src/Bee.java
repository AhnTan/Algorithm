
import java.util.Scanner;

class Bee {

	int count;
	
	int number = 0;
	int edit_number;
	
	int check_minus_num = 1;
	
	Scanner s = new Scanner(System.in);
	
	public Bee() {
		
		count = 0;
		
		while(!(number>=1 && number<=1000000000)) {
			
			System.out.print("숫자 입력 : ");
			number = s.nextInt();				// 숫자 입력
		
		}
		

		count++;							// 기본 카운트 1
		
		int result_count = check(number);
		
		System.out.println("결과 : " + result_count);
	}
	
	
	public int check(int number) {
		
		// 1일때는 그냥 1번이므로 return
		if(number == 1) {
			return count;
		}
		
		// 2이상일때 체크
		else {
			
			edit_number = number - 1;			// -1 빼기
		
			
			// 먼저 나머지 값이 있는지 확인 나머지값이 있다면 count 증가
			if((edit_number % 6)>0) {
				count ++;
				
				edit_number = edit_number/6;
				muk_zero(edit_number);
			}
			
			else {
				// 몫만 남김
				edit_number = edit_number/6 ;
				muk_non_zero(edit_number);
			}
			
			
		}
	
		return count;
	}
	
	public void muk_zero(int edit_number) {
		if(edit_number!=0) {
			// 1씩 증가시키며 빼기
			do {
		
				edit_number = edit_number - check_minus_num;
				
				if(edit_number>=0) {
					count++;
				}
				
				check_minus_num++;
				
			
			}while(edit_number>0);
		}
	}
	
	public void muk_non_zero(int edit_number) {
		if(edit_number!=0) {
			// 1씩 증가시키며 빼기
			do {
		
				edit_number = edit_number - check_minus_num;
				
				count++;
					
				check_minus_num++;
				
			
			}while(edit_number>0);
		}
	}
}

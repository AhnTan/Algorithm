
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
			
			System.out.print("���� �Է� : ");
			number = s.nextInt();				// ���� �Է�
		
		}
		

		count++;							// �⺻ ī��Ʈ 1
		
		int result_count = check(number);
		
		System.out.println("��� : " + result_count);
	}
	
	
	public int check(int number) {
		
		// 1�϶��� �׳� 1���̹Ƿ� return
		if(number == 1) {
			return count;
		}
		
		// 2�̻��϶� üũ
		else {
			
			edit_number = number - 1;			// -1 ����
		
			
			// ���� ������ ���� �ִ��� Ȯ�� ���������� �ִٸ� count ����
			if((edit_number % 6)>0) {
				count ++;
				
				edit_number = edit_number/6;
				muk_zero(edit_number);
			}
			
			else {
				// �� ����
				edit_number = edit_number/6 ;
				muk_non_zero(edit_number);
			}
			
			
		}
	
		return count;
	}
	
	public void muk_zero(int edit_number) {
		if(edit_number!=0) {
			// 1�� ������Ű�� ����
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
			// 1�� ������Ű�� ����
			do {
		
				edit_number = edit_number - check_minus_num;
				
				count++;
					
				check_minus_num++;
				
			
			}while(edit_number>0);
		}
	}
}

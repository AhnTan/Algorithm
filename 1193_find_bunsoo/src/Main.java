import java.util.Scanner;

class Main {

	int bun_ja, bun_mo, temp, temp2, temp3, num=1;

	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		Scanner s = new Scanner(System.in);
		num = s.nextInt();
		while(temp/num == 0) {
			temp2++;
			temp += temp2;
		}
		temp3 = temp2;
			if(temp2%2 != 0) {
				temp2 = temp % num ;
				temp2 += 1;	
				bun_ja = temp2;
				bun_mo = (temp3+1) - bun_ja;
			}
			else if(temp2%2 == 0) {
				temp2 = temp % num ;
				temp2 += 1;	
				bun_mo = temp2;
				bun_ja = (temp3+1) - bun_mo;
			}	
		System.out.println(bun_ja + "/" + bun_mo);
	}
}







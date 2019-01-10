import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder builder = new StringBuilder();
	int num;
	ArrayList<String> list = new ArrayList<String> ();
	public static void main(String[] args) {
		new Main();

	}
	
	public Main() {
		init();
		sort();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
	
	public void init() {
		try {
		
			num = Integer.parseInt(reader.readLine());
			
			for(int i=0; i<num; i++) {
				int count=0;
				list.add(reader.readLine());
				int temp_length = list.get(i).length();
				String temp = list.get(i);
				for(int j=i-1; j>=0; j--) {
					if(temp_length < list.get(j).length()){
						list.set(list.size()-1 - count, list.get(j));
						count++;
					}
				}
				if(count != 0) {
					list.set(list.size()-1-count, temp);
				}
			}
			
			for(int j=list.size()-1; j>0; j--) {
				String temp=list.get(j);
				for(int k=j-1; k>=0; k--) {
					if(temp.equals(list.get(k))) {
						list.remove(k);
					}
				}
			}	
		}catch(Exception e) {}
	}
	
	public void sort() {
		for(int i=list.size()-1; i>0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(list.get(i).length() == list.get(j).length() && (list.get(i).compareTo(list.get(j)) < 0)){
					String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
}

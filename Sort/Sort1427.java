import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort1427 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();   
		int[] arr = new int[10]; // 수의 범위 : 0 ~ 9
 
		for (int i = 0; i < s.length(); i++) {	
            arr[(s.charAt(i) - '0')]++;
        }

        br.close();
 
        StringBuilder sb = new StringBuilder();

		for(int i = 9; i >= 0; i--) {
			
			while(arr[i]-- > 0) {	// arr 값이 0보타 클 경우 
				sb.append(i);
			}
		}
        System.out.println(sb);
    }
}

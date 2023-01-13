import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort10989 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());   
		int[] arr = new int[10001]; // 수의 범위 : 0 ~ 100
 
		for (int i = 0; i <length; i++) {	// 수열의 크기 : 50 
			arr[Integer.valueOf(br.readLine())]++;	// 0 ~ 100
		}
        br.close();
 
        StringBuilder sb = new StringBuilder();
		for(int i = 1; i < 10001; i++) {
			
			while(arr[i]-- > 0) {	// arr 값이 0보타 클 경우 
				sb.append(i).append('\n');
			}
		}
        System.out.println(sb);
    }
    
}

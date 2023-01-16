import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Sort10814 {
    /* 나이 순으로 정렬을 하되 나이가 같다면 그 이후에는 이름으로 정렬하는 알고리즘 
     * 추가적인 공부 blog --> https://velog.io/@dkwktm45/Java-%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Comparator%EC%97%90-%EB%8C%80%ED%95%B4
    */
    public static void main(String[] args) throws NumberFormatException, IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());   

        String[][] arr = new String[length][2];

        for(int i = 0; i<length; i++){
            String[] list = br.readLine().split(" ");
            arr[i][0] = list[0];
            arr[i][1] = list[1];

        }
		Arrays.sort(arr, new Comparator<String[]>() {
			// 나이순으로 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		
		for(int i = 0; i < length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
        
    }

}

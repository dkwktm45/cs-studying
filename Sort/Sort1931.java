
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sort1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.valueOf(br.readLine());   
    
        int[][] arr = new int[length][2];
        StringTokenizer st;
        for(int i = 0; i < length; i++){
            st = new StringTokenizer(br.readLine(), " ");   
            arr[i][0] = Integer.valueOf(st.nextToken());
            arr[i][1] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {		
            @Override
            public int compare(int[] e1, int[] e2) {
                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.  
				if(e1[1] == e2[1]) {
					return e1[0] - e2[0];
				}

                return e1[1] - e2[1];
            }
        });
        int result = 0;
        int endTime = 0;
        for (int i = 0; i < length; i++) {
            if(arr[i][0] >= endTime){
                endTime = arr[i][1];
                result++;
            }
        }
        System.out.println(result);
    }
}

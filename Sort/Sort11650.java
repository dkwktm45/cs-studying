
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Sort11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.valueOf(br.readLine());   

        int[][] arr = new int[length][2];

        for(int i = 0; i < length; i++){
            String[] nums = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(nums[0]);
            arr[i][1] = Integer.valueOf(nums[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {		
            @Override
            public int compare(int[] e1, int[] e2) {
                if(e1[0] == e2[0]) {		// 첫번째 원소가 같다면 두 번째 원소끼리 비교
                    return e1[1] - e2[1];
                }
                else {
                    return e1[0] - e2[0];
                }
            }
        });

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}

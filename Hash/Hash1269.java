import java.util.HashMap;
import java.util.Scanner;

public class Hash1269{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        
        HashMap<Integer , Boolean> A = new HashMap<>();

        int AL = sc.nextInt();
        int BL = sc.nextInt();
        int cnt = AL;

        while(cnt != 0){
            A.put(sc.nextInt(),true);
            cnt--;
        }
        int result = 0;

        // B의 차집합
        for(int i=0; i<BL;i++){
            if(A.containsKey(sc.nextInt())){
                result++;
            }
        }
        System.out.println((BL-result) + (AL-result));
        
    }
}
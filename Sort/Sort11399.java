import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort11399{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int[] solution = new int[length];
        String[] list = br.readLine().split(" ");

        for(int i = 0; i< length; i++){    
            solution[i] = Integer.parseInt(list[i]);
        }

        Arrays.sort(solution);
        int num = 0; 
        for(int i = 0; i < length; i++){
            int cntNum = 0;
            for(int j = 0; j <= i;j++){
                cntNum += solution[j];
            }
            num +=cntNum;
        }
        System.out.println(num);
        
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sort2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());   
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("----------------------------------");
        for(int i = 0; i< length - 1; i++){
            for(int j = i + 1; j<length; j++){
                if(arr[i] > arr[j]){ // arr의 i 값 보다 i + 1(j) 이 작다면!!
                    // i + 1(j) 의 위치의 값을 i 의 값 위치로 바꿔줘야 한다.
                    int temp = arr[j]; 
					arr[j] = arr[i];
					arr[i] = temp;
                }
            }
        }

        for(int num : arr){
            System.out.println(num);
        }
    }
}

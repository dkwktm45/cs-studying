import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort10817{
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split(" ");
        int[] result = new int[list.length];
        for(int i = 0; i<list.length; i++){
            result[i] = Integer.valueOf(list[i]);
        }
        Arrays.sort(result);
        System.out.println(result[1]);
        
    }
}
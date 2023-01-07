import java.util.Arrays;
import java.util.Vector;

public class Stack12096 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1}; 
        Vector<Integer> result = new Vector<Integer>(); 
        
        int index = 0;
        
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            if(result.size() == 0){
                result.add(num);
            }else if(result.get(index) != num){
                index++;
                result.add(num);
            }
        }
    }
}

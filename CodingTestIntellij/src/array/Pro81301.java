package array;

public class Pro81301 {
  public static void main(String[] args) {
    String s = "23four5six7";
    String[] intList = {"zero", "one", "two" , "three", "four", "five", "siz", "seven", "eight", "nine"};
    String sum= "";

    char[] cArray = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      cArray[i] = s.charAt(i);
    }
    String answer = "";
    for (int i = 0; i < cArray.length; i++) {
      sum += String.valueOf(cArray[i]);
      if(sum.length() >= 3){
        for (int j = 0; j < intList.length; j++) {
          if(sum.equals(intList[j])){
            answer +=j;
            sum = "";
            break;
          }
        }
      }else if(sum.matches("[0-9]+")){
        answer += sum;
        sum = "";
      }
    }

    System.out.println(Integer.parseInt(answer));
  }
}

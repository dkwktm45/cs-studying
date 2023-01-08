public class Queue42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length -1; i++){
            int cnt = 0;
            for(int j = i+1; j < prices.length;j++){
                int price = prices[i];
                if(price <= prices[j]){
                    cnt++;
                }else if(price > prices[j]){
                    cnt++;
                    break;
                }
            }
            answer[i] = cnt;
        }
        answer[prices.length-1] = 0;

        for(int num : answer){
            System.out.print(num);
        }
    }
}

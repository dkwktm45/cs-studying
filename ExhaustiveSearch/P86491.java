public class P86491{
    /*최소 사이즈의 카드지갑을 만들자!
     * 이차원 배열 카드 sizes가 주어진다. 해당 지갑들을 모두 충족하는 지갑들을 만들자!
     * 단 해당 2차원 배열이 가로, 세로라 한다면 해당 가로 세로를 바꿀 수도있다.
     * 모두 충족하는 사이즈를 알아냈다면 곱하기를 하여 해당 답을 맞추자!
     */
    public static void main(String[] args) {
        int[][] sizes = {{10 , 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};

        // int a = 0;
        // int b = 0;
        // for(int i = 0; i < sizes.length; i++){
        //     int A = sizes[i][0];
        //     int B = sizes[i][1];
        //     if(A < B){
        //         int temp = sizes[i][0];
        //         sizes[i][0] = sizes[i][1];
        //         sizes[i][1] = temp;
        //     }

        //     if(sizes[i][0] > a) a = sizes[i][0];
        //     if(sizes[i][1] > b) b = sizes[i][1];
        // }
        // System.out.println(a*b);


        int length = 0;
        int height = 0;

        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        System.out.println(answer);
    }
}
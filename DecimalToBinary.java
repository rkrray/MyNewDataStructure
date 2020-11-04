public class DecimalToBinary {
    static String getNthBinaryNumberWithKOnes(int k, int N){
        String binaryNumber = Integer.toBinaryString(N);
        int count = 0;
        int length = binaryNumber.length();

        for(int i = 0; i < length; i++){
            if(binaryNumber.charAt(i) == 49){
                count++;
            }
        }
        if(count < k) {
            int diff = k - count;
            for (int i = 0; i <= diff; i++) {
                binaryNumber = binaryNumber + 1;
            }
        }
        if(binaryNumber.charAt(length-1) == 49){
            binaryNumber = binaryNumber + "0";
        }
        return binaryNumber;
    }

    public static void main(String[] args){
       System.out.println(DecimalToBinary.getNthBinaryNumberWithKOnes(2,5));
    }
}

public class ReverseInteger {
    public static void main(String[] args) {
        int reversed = reverse(623);
        System.out.println(reversed);
    }

    private static int reverse(int num) {
        boolean negative = false;
        if (num < 0){
            negative = true;
            num *= -1;
        }

        long reversed = 0;
        while (num > 0){
            reversed = (reversed * 10) + (num % 10);
            num /= 10;
        }

        if (reversed > Integer.MAX_VALUE){
            return 0;
        }
        return negative ? (int)(-1 * reversed) : (int)reversed;
    }
}

import java.util.Arrays;

public class FindnexthighernumberwithsameBits {
    public static void main(String[] args) {
        System.out.println(nextHigher(1253343));
    }

    public static int nextHigher(int n) {
        int rightOne, nextHigherOneBit, rightOnesPattern, next = 0;

        rightOne = n & -n;
        nextHigherOneBit = n + rightOne;

        rightOnesPattern = n ^ nextHigherOneBit;

        rightOnesPattern = rightOnesPattern / rightOne;

        rightOnesPattern >>= 2;

        next = nextHigherOneBit | rightOnesPattern;

        return next;
    }
}


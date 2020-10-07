public class EqualSidesOfAnArray {
    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[] {1,2,3,4,5,6}));
    }

    public static int findEvenIndex(int[] arr) {
        long leftSum = 0;
        long rightSum = 0;

        for (int i = 0; i < arr.length; i++) {
            leftSum = calculateLeftSum(arr, i);
            rightSum = calculateRightSum(arr, i);

            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    private static long calculateRightSum(int[] arr, int i) {
        long sum = 0;
        if (i < arr.length - 1){
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
            }
        }
        return sum;
    }

    private static long calculateLeftSum(int[] arr, int i) {
        long sum = 0;
        if (i > 0){
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
        }
        return sum;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class P02_Merge_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = mergeSort(arr);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int secondArrLength = arr.length - mid;

        int[] firstPartition = copyOfRange(arr, 0, mid);;
        int[] secondPartition = copyOfRange(arr, mid, arr.length);;

        mergeSort(firstPartition);
        mergeSort(secondPartition);

        int mainIndex = 0;
        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < mid && secondPartitionIndex < secondArrLength){
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]){
                arr[mainIndex] = firstPartition[firstPartitionIndex];
                mainIndex++;
                firstPartitionIndex++;
            }else {
                arr[mainIndex] = secondPartition[secondPartitionIndex];
                mainIndex++;
                secondPartitionIndex++;
            }
        }

        while (firstPartitionIndex < mid){
            arr[mainIndex] = firstPartition[firstPartitionIndex];
            mainIndex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex < secondArrLength){
            arr[mainIndex] = secondPartition[secondPartitionIndex];
            mainIndex++;
            secondPartitionIndex++;
        }

        return arr;
    }
}

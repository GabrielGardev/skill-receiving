import java.util.*;

public class P11_Array_Manipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("end")) {
                break;
            }

            String command = input[0];

            if (command.equals("exchange")) {
                int index = Integer.parseInt(input[1]);
                if (index >= arr.length || index < 0) {
                    System.out.println("Invalid index");
                    continue;
                }
                if (index == arr.length - 1) {
                    continue;
                }
                arr = ExchangeArray(arr, index);

            } else if (command.equals("max")) {
                String oddOrEven = input[1];
                PrintIndexOfMaxElement(arr, oddOrEven);

            } else if (command.equals("min")) {
                String oddOrEven = input[1];
                PrintIndexOfMinElement(arr, oddOrEven);

            } else if (command.equals("first")) {
                int count = Integer.parseInt(input[1]);
                String oddOrEven = input[2];
                if (count > arr.length) {
                    System.out.println("Invalid count");
                    continue;
                }
                PrintFirstElements(arr, count, oddOrEven);

            } else if (command.equals("last")) {
                int count = Integer.parseInt(input[1]);
                String oddOrEven = input[2];
                if (count > arr.length) {
                    System.out.println("Invalid count");
                    continue;
                }
                PrintLastElements(arr, count, oddOrEven);
            }
        }
        List<String> printer = new ArrayList<>();
        for (int num : arr) {
            printer.add(num + "");
        }
        System.out.println(printer);
    }

    private static void PrintLastElements(int[] arr, int count, String oddOrEven) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        if (oddOrEven.equals("even")) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] % 2 == 0) {
                    result.add(arr[i]);
                    counter++;
                }
                if (count == counter) {
                    break;
                }
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] % 2 != 0) {
                    result.add(arr[i]);
                    counter++;
                }
                if (count == counter) {
                    break;
                }
            }
        }
        Collections.reverse(result);
        System.out.println(result);
    }

    private static void PrintFirstElements(int[] arr, int count, String oddOrEven) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        if (oddOrEven.equals("even")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    result.add(arr[i]);
                    counter++;
                }
                if (count == counter) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    result.add(arr[i]);
                    counter++;
                }
                if (count == counter) {
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static void PrintIndexOfMinElement(int[] arr, String oddOrEven) {
        int position = -1;
        int min = Integer.MAX_VALUE;
        if (oddOrEven.equals("odd")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    if (arr[i] <= min) {
                        min = arr[i];
                        position = i;
                    }
                }
            }
        } else if (oddOrEven.equals("even")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    if (arr[i] <= min) {
                        min = arr[i];
                        position = i;
                    }
                }
            }
        }
        if (position < 0) {
            System.out.println("No matches");
        } else {
            System.out.println(position);
        }
    }

    private static void PrintIndexOfMaxElement(int[] arr, String oddOrEven) {
        int position = -1;
        int max = -1;
        if (oddOrEven.equals("odd")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    if (arr[i] >= max) {
                        max = arr[i];
                        position = i;
                    }
                }
            }
        } else if (oddOrEven.equals("even")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    if (arr[i] >= max) {
                        max = arr[i];
                        position = i;
                    }
                }
            }
        }
        if (position < 0) {
            System.out.println("No matches");
        } else {
            System.out.println(position);
        }
    }

    private static int[] ExchangeArray(int[] arr, int index) {
        int[] newNumbers = new int[arr.length];

        for (int i = 0; i < newNumbers.length; i++) {
            newNumbers[i] = arr[index + 1];
            index++;
            if (index == newNumbers.length - 1) {
                index = -1;
            }
        }

        return newNumbers;
    }
}



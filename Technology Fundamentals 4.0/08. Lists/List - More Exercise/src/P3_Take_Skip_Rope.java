import java.util.ArrayList;
import java.util.Scanner;

public class P3_Take_Skip_Rope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        var numbers = new ArrayList<Integer>();
        var nonNumbers = new ArrayList<Character>();

        for(int i = 0;i < input.length();i++)
        {
            if (Character.isDigit(input.charAt(i)))
            {
                String temp = input.charAt(i) + "";
                int num = Integer.parseInt(temp);
                numbers.add(num);
            }
            else
            {
                nonNumbers.add(input.charAt(i));
            }

        }
        var takeList = new ArrayList<Integer>();
        var skipList = new ArrayList<Integer>();

        for (int i = 0; i < numbers.size(); i++)
        {
            if (i % 2 == 0)
            {
                takeList.add(numbers.get(i));
            }
            else
            {
                skipList.add(numbers.get(i));
            }
        }

        String result = "";
        String tempooo = "";

        for (int i = 0; i < nonNumbers.size(); i++) {
            tempooo += nonNumbers.get(i) + "";
        }
        for (int i = 0; i < nonNumbers.size(); i++)
        {
            for (int j = 0; j < skipList.size(); j++) {
                int skipCount = skipList.get(j);
                int takeCount = takeList.get(j);

                if (i + takeCount > nonNumbers.size() - 1){
                    result += tempooo.substring(i, nonNumbers.size());
                    break;
                }
                result += tempooo.substring(i, i + takeCount);
                i += skipCount + takeCount;
            }

break;
        }
        System.out.println(result);
    }
    }


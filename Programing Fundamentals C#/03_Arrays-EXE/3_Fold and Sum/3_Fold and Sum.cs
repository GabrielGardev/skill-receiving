using System;
using System.Linq;

namespace _3_Fold_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int[] firstKnums = new int[numbers.Length / 2];
            int[] secondKnums = new int[numbers.Length / 2];

            int[] reversed = new int[numbers.Length / 4];
            int[] reversed2 = new int[numbers.Length / 4];

            int[] sum = new int[numbers.Length / 2];

            reversed = Reverse(numbers);
            reversed2 = Reverse2(numbers);

            for (int i = 0; i < numbers.Length / 4; i++)
            {
                firstKnums[i] = reversed[i];
                firstKnums[i + reversed2.Length] = reversed2[i];
            }

            for (int i = 0; i < numbers.Length / 2; i++)
            {
                secondKnums[i] = numbers[numbers.Length / 4 + i];
            }

            for (int i = 0; i < numbers.Length / 2; i++)
            {
                sum[i] = firstKnums[i] + secondKnums[i];
            }
            Console.WriteLine(string.Join(" ", sum));
        }

        static int[] Reverse(int[] numbers)
        {
            int[] reversed = new int[numbers.Length / 4];

            for (int i = 0; i <= numbers.Length / 4 - 1; i++)
            {
                reversed[i] = numbers[numbers.Length / 4 - 1 - i];
            }

            return reversed;
        }
        static int[] Reverse2(int[] numbers)
        {
            int[] reversed = new int[numbers.Length / 4];

            for (int i = 0; i <= numbers.Length / 4 - 1; i++)
            {
                reversed[i] = numbers[numbers.Length - 1 - i];
            }

            return reversed;
        }
    }
}

using System;

namespace _9_Multiply_Evens_by_Odds
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int sum = GetMultipleOfOddAndEvenSum(Math.Abs(n));
            Console.WriteLine(sum);

        }
        static int GetMultipleOfOddAndEvenSum(int n)
        {
            int sumEven = GetSumOfEvenDigits(n);
            int sumOdd = GetSumOfOddDigits(n);
            return sumEven * sumOdd;
        }
        static int GetSumOfOddDigits(int n)
        {
            int sum = 0;

            while (n > 0)
            {
                int lastDigit = n % 10;
                if (lastDigit % 2 != 0)
                {
                    sum += lastDigit;
                }

                n /= 10;
            }
            return sum;
        }
        static int GetSumOfEvenDigits(int n)
        {
            int sum = 0;

            while (n > 0)
            {
                int lastDigit = n % 10;
                if (lastDigit % 2 == 0)
                {
                    sum += lastDigit;
                }

                n /= 10;
            }
            return sum;
        }
    }
}

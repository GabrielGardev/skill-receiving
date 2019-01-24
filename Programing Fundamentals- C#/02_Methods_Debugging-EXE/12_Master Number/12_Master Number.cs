using System;

namespace _12_Master_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            for (int i = 1; i <= number; i++)
            {
                if (IsPalindrome(i) && SumOfDig7(i) && ContainsEven(i))
                {
                    Console.WriteLine(i);
                }
            }
        }

         static bool ContainsEven(int i)
        {
            bool isItTrueOrFalse;
            int currentNum = 0;
            while(i != 0)
            {
                currentNum = i % 10;
                if (currentNum % 2 == 0)
                {
                    return isItTrueOrFalse = true;
                }
                i /= 10;
            }
            return isItTrueOrFalse = false;
        }

        static bool SumOfDig7(int i)
        {
            int sum = 0;
            while (i > 0)
            {
                sum += i % 10;
                i /= 10;
            }
            if (sum % 7 ==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        static bool IsPalindrome(int i)
        {
            int reverset = 0;
            int oldNum = i;
            while (i != 0)
            {
                reverset *= 10;
                reverset += i % 10;
                i /= 10;
            }
            if (reverset == oldNum)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}

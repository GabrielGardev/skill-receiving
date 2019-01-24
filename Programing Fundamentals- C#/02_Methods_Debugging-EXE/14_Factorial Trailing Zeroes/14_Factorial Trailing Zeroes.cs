using System;
using System.Numerics;

namespace _14_Factorial_Trailing_Zeroes
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberInt = int.Parse(Console.ReadLine());

            
            Console.WriteLine(TrallingZeros(numberInt));


        }
        static BigInteger ToFactorial(int numberInt)
        {

            BigInteger factorial = 1;

            for (int i = 1; i <= numberInt; i++)
            {
                factorial = factorial * i;
            }
            return factorial;
        }
        static int TrallingZeros(int number)
        {
            BigInteger factorial = ToFactorial(number);
            int count = 0;
            while (factorial % 10 == 0)
            {
                count++;
                factorial /= 10;
            }
            return count;
        }
    }
}

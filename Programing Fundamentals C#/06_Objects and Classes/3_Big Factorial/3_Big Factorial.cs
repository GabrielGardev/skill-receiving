using System;
using System.Numerics;

namespace _3_Big_Factorial
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberInt = int.Parse(Console.ReadLine());

            BigInteger factorial = 1;

            for (int i = 1; i <= numberInt; i++)
            {
                factorial = factorial * i;
            }
            Console.WriteLine(factorial);
        }
    }
}

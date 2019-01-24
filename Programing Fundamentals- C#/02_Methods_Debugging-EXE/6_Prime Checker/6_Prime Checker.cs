using System;

namespace _02_Methods_Debugging_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            long n = long.Parse(Console.ReadLine());
            bool isItPrime = IsPrime(n);
            Console.WriteLine(isItPrime);

        }
        static bool IsPrime(long number)
        {
            if (number <= 1) return false;
            if (number == 2) return true;
            if (number % 2 == 0) return false;


            for (int i = 3; i <= Math.Sqrt(number); i++)
            {
                if (number % i == 0)
                {
                    return false;
                }
            }
            return true;

        }
    }
}

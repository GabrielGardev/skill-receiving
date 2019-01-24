using System;
using System.Collections.Generic;

namespace _07_Primes_In_Given_Range
{
    class Program
    {
        static void Main(string[] args)
        {
            long num1 = long.Parse(Console.ReadLine());
            long num2 = long.Parse(Console.ReadLine());

            string printPrimes = "";

            for (long i = num1; i <= num2; i++)
            {
                if (IsPrime(i))
                {
                   printPrimes += i + ", ";             
                }
            
            }
            if (printPrimes.EndsWith(", "))
            {
               printPrimes = printPrimes.Remove(printPrimes.Length - 2);
               Console.WriteLine(printPrimes);
            }


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

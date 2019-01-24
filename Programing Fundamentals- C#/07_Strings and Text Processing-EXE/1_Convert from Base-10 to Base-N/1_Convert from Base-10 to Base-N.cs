using System;
using System.Linq;
using System.Numerics;

namespace _07_Strings_and_Text_Processing_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();
            int n = int.Parse(input[0]);
            BigInteger number = new BigInteger();
            number = BigInteger.Parse(input[1]);
            BigInteger remainder = 0;
            string result = null;

            while (number > 0)
            {
                remainder = number % n;
                number /= n;
                result = remainder.ToString() + result;
            }

            Console.WriteLine(result);
        }
    }
}

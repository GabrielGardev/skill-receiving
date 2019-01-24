using System;
using System.Linq;
using System.Numerics;

namespace _2_Convert_from_Base_N_to_Base_10
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();
            int n = int.Parse(input[0]);
            char[] number = input[1].ToCharArray();
            BigInteger result = new BigInteger();

            for (int i = 0; i < number.Length; i++)
            {
                int curentNum = (int)char.GetNumericValue(number[i]);
                result += curentNum * BigInteger.Pow(n, number.Length - i - 1);

            }
            Console.WriteLine(result);
            
        }
        
    }
}

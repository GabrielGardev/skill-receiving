using System;
using System.Linq;

namespace _2_Email_me
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split('@');

            int sum1 = 0;
            int sum2 = 0;


            for (int i = 0; i < input[0].Length; i++)
            {
                sum1 += input[0][i];
            }

            for (int i = 0; i < input[1].Length; i++)
            {
                sum2 += input[1][i];
            }

            if (sum1 - sum2 >= 0)
            {
                Console.WriteLine("Call her!");
            }
            else
            {
                Console.WriteLine("She is not the one.");
            }
        }
    }
}

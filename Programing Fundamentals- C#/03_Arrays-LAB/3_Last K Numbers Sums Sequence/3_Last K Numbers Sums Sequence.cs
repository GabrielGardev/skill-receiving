using System;
using System.Linq;

namespace _3_Last_K_Numbers_Sums_Sequence
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());

            long[] numbers = new long[n];

            numbers[0] = 1;

            

            for (int i = 1; i < n; i++)
            {
                long sum = 0;
                for (int j = i - k; j <= i - 1; j++)
                {
                    if (j >= 0)
                    {
                        sum += numbers[j];
                    }
                }

                numbers[i] = sum;
            }
            
                Console.Write(string.Join(" ", numbers));   
        }
    }
}

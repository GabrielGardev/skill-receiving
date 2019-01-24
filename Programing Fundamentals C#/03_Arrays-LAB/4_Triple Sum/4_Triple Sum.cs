using System;
using System.Linq;

namespace _4_Triple_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] input = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();

            long max = long.MinValue;

            for (long curentMax = 0; curentMax < input.Length; curentMax++)
            {
                if (input[curentMax] > max)
                {
                    max = input[curentMax];
                }
            }
            bool isItEmpty = true;
            long sum = 0;

            for (long a = 0; a < input.Length; a++)
            {
                for (long b = a + 1; b < input.Length; b++)
                {
                    if (0 <= input[a] && a < b && input[b] < max)
                    {
                        sum = input[a] + input[b];

                        for (long j = 0; j < input.Length; j++)
                        {
                            if (sum == input[j])
                            {
                                Console.WriteLine($"{input[a]} + {input[b]} == {sum}");
                                isItEmpty = false;
                                break;
                            }
                        }
                        
                    }
                }
            }
            if (isItEmpty)
            {
                Console.WriteLine("No");
            }
        }
    }
}

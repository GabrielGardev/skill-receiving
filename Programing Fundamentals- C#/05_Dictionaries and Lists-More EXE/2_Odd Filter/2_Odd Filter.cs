using System;
using System.Collections.Generic;
using System.Linq;

namespace _2_Odd_Filter
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> input = Console.ReadLine().Split().Select(int.Parse).Where(x => x % 2 == 0).ToList();

           
                double aver = input.Average();

                for (int i = 0; i < input.Count; i++)
                {
                    if (input[i] > aver)
                    {
                        input[i] += 1;
                    }
                    else
                    {
                        input[i] -= 1;
                    }
                }

            Console.WriteLine(string.Join(" ", input));
            
        }
    }
}

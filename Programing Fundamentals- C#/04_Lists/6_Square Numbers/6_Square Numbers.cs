using System;
using System.Collections.Generic;
using System.Linq;

namespace _6_Square_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToList();
            List<int> squered = new List<int>();

            foreach (int num in numbers)
            {
                if (Math.Sqrt(num) == (int)Math.Sqrt(num))
                {
                    squered.Add(num);
                }
            }

            squered = squered.OrderByDescending(a => a).ToList();
           

            Console.WriteLine(string.Join(" ", squered));
        }
    }
}

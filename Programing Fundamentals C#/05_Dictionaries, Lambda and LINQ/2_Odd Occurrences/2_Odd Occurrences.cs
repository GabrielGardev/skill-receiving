using System;
using System.Collections.Generic;
using System.Linq;

namespace _2_Odd_Occurrences
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().ToLower().Split().ToArray();

            var counts = new Dictionary<string, int>();
            List<string> result = new List<string>();

            foreach (var item in input)
            {
                if (counts.ContainsKey(item) == false)
                {
                    counts[item] = 0;
                }
                counts[item]++;
            }

            foreach (var item in counts)
            {
                if (item.Value % 2 != 0)
                {
                    result.Add(item.Key);
                }
            }

            Console.WriteLine(string.Join(", ", result ));
            

           
        }
    }
}

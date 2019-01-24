using System;
using System.Collections.Generic;
using System.Linq;

namespace _2_Append_Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> input = Console.ReadLine().Split('|').Reverse().ToList();
            

            foreach (var element in input)
            {
                var result = element.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                var joined = string.Join(" ", result);
                Console.Write(joined + " ");
            }

            Console.WriteLine();
        }
    }
}

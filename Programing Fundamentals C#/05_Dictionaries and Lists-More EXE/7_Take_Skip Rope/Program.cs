using System;
using System.Collections.Generic;
using System.Linq;

namespace _7_Take_Skip_Rope
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            var numbers = new List<int>();
            var nonNumbers = new List<char>();

            foreach (var symbol in input)
            {
                if (char.IsDigit(symbol))
                {
                    int num = int.Parse(symbol.ToString());
                    numbers.Add(num);
                }
                else
                {
                    nonNumbers.Add(symbol);
                }

            }
            var takeList = new List<int>();
            var skipList = new List<int>();

            for (int i = 0; i < numbers.Count; i++)
            {
                if (i % 2 == 0)
                {
                    takeList.Add(numbers[i]);
                }
                else
                {
                    skipList.Add(numbers[i]);
                }
            }

            string result = null;

            var total = 0;
            for (int i = 0; i < skipList.Count; i++)
            {
                int skipCount = skipList[i];
                int takeCount = takeList[i];
                result += new string(nonNumbers.Skip(total).Take(takeCount).ToArray());
                total += takeCount + skipCount;
            }
            Console.WriteLine(result);
        }
    }
}

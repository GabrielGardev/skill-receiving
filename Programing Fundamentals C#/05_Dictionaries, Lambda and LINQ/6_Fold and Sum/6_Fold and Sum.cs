using System;
using System.Collections.Generic;
using System.Linq;

namespace _6_Fold_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int k = numbers.Length / 4;

            int[] leftPart = numbers.Take(k).Reverse().ToArray();
            int[] rightPart = numbers.Reverse().Take(k).ToArray();
            int[] firstRow = leftPart.Concat(rightPart).ToArray();
            int[] secondRow = numbers.Skip(k).Take(2 * k).ToArray();

            var sumArr = firstRow.Select((x, index) => x + secondRow[index]);
            Console.WriteLine(string.Join(" ", sumArr));
        }
    }
}

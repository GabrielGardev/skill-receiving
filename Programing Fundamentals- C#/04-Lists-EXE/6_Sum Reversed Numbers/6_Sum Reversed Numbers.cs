using System;
using System.Collections.Generic;
using System.Linq;

namespace _04_Lists_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            int sum = 0;
            

            for (int i = 0; i < numbers.Count; i++)
            {
                List<char> newNum = numbers[i].ToString().ToList();
                newNum.Reverse();
                sum += int.Parse(string.Join("", newNum));
                
            }
            Console.WriteLine(sum);
        }
    }
}
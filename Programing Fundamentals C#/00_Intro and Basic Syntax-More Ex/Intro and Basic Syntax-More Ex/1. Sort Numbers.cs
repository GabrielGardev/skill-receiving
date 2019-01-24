using System;
using System.Linq;

namespace Intro_and_Basic_Syntax_More_Ex
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = new int[3];

            for (int i = 0; i < 3; i++)
            {
                int number = int.Parse(Console.ReadLine());

                numbers[i] += number;
            }

            foreach (var num in numbers.OrderByDescending(x => x))
            {
                Console.WriteLine(num);
            }
        }
    }
}

using System;

namespace _02_Methods_Debugging
{
    class Program
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());

            PrintTopAndBottom(input);

            for (int i = 0; i < input - 2; i++)
            {
                PrintMiddleRow(input);
            }

            PrintTopAndBottom(input);
        }
        static void PrintTopAndBottom(int number)
        {
            string topAndBottom = new string('-', 2 * number);
            Console.WriteLine(topAndBottom);
        }
        static void PrintMiddleRow(int number)
        {
            Console.Write('-');
            for (int i = 1; i < number; i++)
            {
                Console.Write("\\/");
            }
            Console.WriteLine('-');
        }
    }
}

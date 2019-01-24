using System;

namespace _17_Print_Part_of_the_ASCII_Table
{
    class Program
    {
        static void Main(string[] args)
        {
           int start = int.Parse(Console.ReadLine());
           int end = int.Parse(Console.ReadLine());

            for (char i = (char)start; i <= (char)end; i++)
            {
                Console.Write($"{i} ");
            }
        }
    }
}

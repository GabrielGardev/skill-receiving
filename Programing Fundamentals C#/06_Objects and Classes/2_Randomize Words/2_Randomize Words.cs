using System;
using System.Linq;

namespace _2_Randomize_Words
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();

            Random obj = new Random();

            for (int i = 0; i < input.Length; i++)
            {
               int number = obj.Next(0, input.Length);

                string temp = input[i];
                input[i] = input[number];
                input[number] = temp;   
            }
            foreach (var item in input)
            {
                Console.WriteLine(item);
            }
        }
    }
}

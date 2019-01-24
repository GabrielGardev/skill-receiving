using System;
using System.Linq;

namespace _4_Grab_and_Go
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();        
            int number = int.Parse(Console.ReadLine());

            int position = 0;
            long sum = 0;

            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i] == number)
                {
                    position = i;
                }  
            }

            if (position > 0)
            {
                for (int j = 0; j < position; j++)
                {
                    sum += arr[j];
                }
                Console.WriteLine(sum);
            }
            else
            {
                Console.WriteLine("No occurrences were found!");
            }   
        }
    }
}

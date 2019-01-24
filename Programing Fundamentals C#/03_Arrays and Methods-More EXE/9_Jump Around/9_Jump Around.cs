using System;
using System.Linq;

namespace _9_Jump_Around
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int sum = 0;
            int index = 0;


            while (true)
            {

                sum += arr[index];

                int currentPosition = index + arr[index];

                if (currentPosition <= arr.Length - 1)
                {
                    index = currentPosition;
                    continue;
                }

                currentPosition = index - arr[index];

                if (currentPosition >= 0)
                {   
                    index = currentPosition;
                    continue;
                }
   
                    break;
                
            }
            Console.WriteLine(sum);
        }
    }
}

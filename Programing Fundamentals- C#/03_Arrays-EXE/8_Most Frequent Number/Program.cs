using System;
using System.Linq;

namespace _8_Most_Frequent_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            
            int counterMax = 0;
            int number = 0;

            for (int i = 0; i < arr.Length; i++)
            {
                int counters = 1;
                for (int j = i; j < arr.Length; j++)
                {
                    if (arr[i] == arr[j])
                    {
                        counters++;
                        if (counters > counterMax)
                        {
                            counterMax = counters;
                            number = arr[i];
                        }
                    }    
                }               
            } 
                Console.WriteLine(number);    
        }
    }
}

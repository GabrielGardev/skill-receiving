using System;
using System.Collections.Generic;
using System.Linq;

namespace _7_Count_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            
            numbers.Sort();
            

            for (int i = 0; i < numbers.Count; i++)
            {
                int forDelete = numbers[i];
                int counter = 0;
                for (int j = 0; j < numbers.Count; j++)
                {
                    
                    if (numbers[i] == numbers[j])
                    {
                        counter++;
                        
                    }
                   
                }
                for (int k = 0; k < counter; k++)
                {
                    numbers.Remove(forDelete);
                }

                Console.WriteLine($"{forDelete} -> {counter}");
                i--;
            }
        }
    }
}

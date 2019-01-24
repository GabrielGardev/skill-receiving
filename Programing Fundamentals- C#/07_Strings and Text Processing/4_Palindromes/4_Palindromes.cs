using System;
using System.Collections.Generic;
using System.Linq;

namespace _4_Palindromes
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split("?,;:.!()\"'\\/[] ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
            List<string> colection = new List<string>();
            for (int i = 0; i < input.Length; i++)
            {       
                if (input[i] == string.Join("",input[i].ToArray().Reverse()) && colection.Any(x => x == input[i]) == false)
                {
                    colection.Add(input[i]);
                }             
            }
            
            Console.WriteLine(string.Join(", ", colection.OrderBy(x => x)));
        }
        
    }
}

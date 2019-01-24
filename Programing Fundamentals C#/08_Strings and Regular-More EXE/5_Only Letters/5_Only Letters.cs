using System;
using System.Collections.Generic;
using System.Linq;

namespace _5_Only_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
          
            string oldValue = null;
         

           


            for (int i = 0; i < input.Length; i++)
            {
                
                
                if (char.IsDigit(input[i]))
                {
                    oldValue += input[i];
                }
                else if (oldValue != null)
                {
                    input = input.Replace(oldValue, input[i].ToString());
                    oldValue = null;
                }

                
            }
            Console.WriteLine(input);
        }
    }
}

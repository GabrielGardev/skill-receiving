using System;
using System.Collections.Generic;
using System.Linq;

namespace _5_Pizza_Ingredients
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] ingredient = Console.ReadLine().Split(' ').ToArray();
            int lenghtOfIngredients = int.Parse(Console.ReadLine());
            int count = 0;
            var newIngredients = new List<string>();
            

            for (int i = 0; i < ingredient.Length; i++)
            {
                if (ingredient[i].Length == lenghtOfIngredients)
                {
                    Console.WriteLine($"Adding {ingredient[i]}.");
                    count++;
                    newIngredients.Add(ingredient[i]);
                    if (count >= 10)
                    {
                        break;
                    }
                }
            }
           
            
            Console.WriteLine($"Made pizza with total of {count} ingredients.");
            Console.WriteLine($"The ingredients are: {string.Join(", ",newIngredients)}.");
        }
    }
}

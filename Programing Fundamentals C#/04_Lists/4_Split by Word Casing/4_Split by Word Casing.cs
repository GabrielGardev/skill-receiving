using System;
using System.Collections.Generic;
using System.Linq;

namespace _4_Split_by_Word_Casing
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split(",;:.!()\"'\\/[] ".ToCharArray(),StringSplitOptions.RemoveEmptyEntries);

            List<string> upperCase = new List<string>();
            List<string> lowerCase = new List<string>();
            List<string> mixedCase = new List<string>();

            for (int i = 0; i < text.Length; i++)
            {
                if (IsUpperCase(text[i]))
                {
                    upperCase.Add(text[i]);
                }
                else if (IsLowerCase(text[i]))
                {
                    lowerCase.Add(text[i]);
                }
                else
                {
                    mixedCase.Add(text[i]);
                }
            }
            Console.WriteLine($"Lower-case: {string.Join(", ", lowerCase)}");
            Console.WriteLine($"Mixed-case: {string.Join(", ", mixedCase)}");
            Console.WriteLine($"Upper-case: {string.Join(", ", upperCase)}");
        }
        static bool IsUpperCase(string word)
        {
            foreach (char element in word)
            {
                if ('A' > element || element > 'Z')
                {
                    return false;
                }
            }
            return true;
        }

        static bool IsLowerCase(string word)
        {
            foreach (char element in word)
            {
                if ('a' > element || element > 'z')
                {
                    return false;
                }
            }
            return true;
        }
    }
}

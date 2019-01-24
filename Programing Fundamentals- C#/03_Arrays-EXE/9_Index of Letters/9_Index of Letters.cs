using System;
using System.Linq;

namespace _9_Index_of_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] alphabet = new char[26];
            char a = 'a';

            for (int i = 0; i < alphabet.Length ; i++)
            {
                alphabet[i] = a++;
            }


            string input = Console.ReadLine();
            char[] inputInChars = input.ToCharArray();


            for (int i = 0; i < inputInChars.Length; i++)
            {
                for (int j = 0; j < alphabet.Length; j++)
                {
                    if (inputInChars[i].Equals(alphabet[j]))
                    {
                        Console.WriteLine($"{inputInChars[i]} -> {j}");
                    }
                }
            }
        }
    }
}

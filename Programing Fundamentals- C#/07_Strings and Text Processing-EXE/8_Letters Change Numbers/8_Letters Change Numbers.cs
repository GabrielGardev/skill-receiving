using System;
using System.Linq;

namespace _8_Letters_Change_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(new char[] {' ','\t' },StringSplitOptions.RemoveEmptyEntries);
            decimal sum = 0;


            for (int i = 0; i < input.Length; i++)
            {
                string word = input[i];
                char firstLetter = word[0];
                char secondLetter = word[word.Length - 1];
                word = word.Remove(0, 1);
                word = word.Remove(word.Length - 1, 1);
                decimal number = decimal.Parse(word);
                int posFirst = 0;
                int posSecond = 0;

                if (char.IsUpper(firstLetter))
                {
                     posFirst = firstLetter - 64;
                    number /= posFirst;
                }
                else
                {
                    posFirst = firstLetter - 96;
                    number *= posFirst;
                }

                if (char.IsUpper(secondLetter))
                {
                    posSecond = secondLetter - 64;
                    number -= posSecond;
                }
                else
                {
                    posSecond = secondLetter - 96;
                    number += posSecond;
                }

                sum += number;
            }
            Console.WriteLine($"{sum:f2}");
        }
    }
}

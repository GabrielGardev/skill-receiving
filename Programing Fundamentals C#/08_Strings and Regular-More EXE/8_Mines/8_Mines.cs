using System;
using System.Text.RegularExpressions;
using System.Linq;
using System.Collections.Generic;

namespace _08_Strings_and_Regular_More_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<char> mineLine = input.ToCharArray().ToList();
            string pattern = @"<([A-Za-z])([A-Za-z])>";

            var bombs = Regex.Matches(input, pattern);

            foreach (Match bomb in bombs)
            {
                char firstLetter = char.Parse(bomb.Groups[1].Value);
                char secondLetter = char.Parse(bomb.Groups[2].Value);

                int radius = Math.Abs(firstLetter - secondLetter);
                int index = input.IndexOf(bomb.ToString());

                int startIndex = index - radius;
                int endIndex = index + 3 + radius;

                if (startIndex < 0)
                {
                    startIndex = 0;
                }
                if (endIndex >= mineLine.Count)
                {
                    endIndex = mineLine.Count - 1;
                }

                for (int i = startIndex; i <= endIndex; i++)
                {
                    mineLine.RemoveAt(i);
                    mineLine.Insert(i, '_');
                }      
            }
            Console.WriteLine(string.Join("",mineLine));
        }
    }
}

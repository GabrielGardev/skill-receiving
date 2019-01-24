using System;
using System.IO;
using System.Text.RegularExpressions;

namespace Problem08
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            Console.SetIn(new StreamReader(Console.OpenStandardInput(8192)));
            const string pattern = @"<p>(.*?)<\/p>";

            var input = Console.ReadLine();

            var match = Regex.Match(input, pattern);

            while (match.Success)
            {
                var currentString = match.Groups[1].Value;
                currentString = Regex.Replace(currentString, @"[^a-z0-9]", " ");
                currentString = Regex.Replace(currentString, @"\s+", " ");

                foreach (var t in currentString)
                {
                    if (char.IsLetter(t))
                    {
                        char newChar;
                        if (t <= 109)
                        {
                            newChar = (char)(t + 13);
                        }
                        else
                        {
                            newChar = (char)(t - 13);
                        }
                        Console.Write(newChar);
                    }
                    else
                    {
                        Console.Write(t);
                    }
                }

                match = match.NextMatch();
            }

            Console.WriteLine();
        }
    }
}
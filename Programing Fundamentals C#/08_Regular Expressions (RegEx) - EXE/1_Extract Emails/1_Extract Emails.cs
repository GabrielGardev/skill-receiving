using System;
using System.Text.RegularExpressions;

namespace _08_Regular_Expressions__RegEx____EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"(^|(?<=\s))([A-Za-z0-9]+)([\._-]?)([A-Za-z0-9]*)@([A-Za-z]+)([-\.]*)([A-Za-z]*)([-\.]*)([A-Za-z]*)\.([a-z]+)";
            string input = Console.ReadLine();

            var regex = Regex.Matches(input, pattern);

            foreach (Match match in regex)
            {
                Console.WriteLine(match.Value);
            }

        }
    }
}

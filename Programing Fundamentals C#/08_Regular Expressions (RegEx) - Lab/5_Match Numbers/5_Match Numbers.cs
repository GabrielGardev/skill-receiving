using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace _5_Match_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"(^|(?<=\s))-?\d+(\.\d+)?($|(?=\s))";
            string input = Console.ReadLine();

            var regex = Regex.Matches(input, pattern);

            string[] result = regex.Cast<Match>().Select(x => x.Value).ToArray();
            Console.WriteLine(string.Join(" ", result));

        }
    }
}

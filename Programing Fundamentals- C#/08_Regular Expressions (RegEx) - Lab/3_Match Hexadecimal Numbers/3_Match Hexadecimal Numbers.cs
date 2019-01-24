using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace _3_Match_Hexadecimal_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"\b(?:0x)?[0-9A-F]+\b";
            string input = Console.ReadLine();

            var numbers = Regex.Matches(input, pattern).Cast<Match>().Select(x => x.Value).ToArray();
            Console.WriteLine(string.Join(" ", numbers));

        }
    }
}

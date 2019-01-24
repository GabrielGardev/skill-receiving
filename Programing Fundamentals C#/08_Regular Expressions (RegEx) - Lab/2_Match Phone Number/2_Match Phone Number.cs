using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace _3_Match_Phone_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"\+359(?<delimeter>\s|-)2(\k<delimeter>)(\d{3})(\k<delimeter>)(\d{4})\b";

            string input = Console.ReadLine();

            var phoneBook = Regex.Matches(input, pattern);

            var result = phoneBook.Cast<Match>().Select(x => x.Value).ToArray();
            Console.WriteLine(string.Join(", ",result));
        }
    }
}

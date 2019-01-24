using System;
using System.Text.RegularExpressions;

namespace _4_Match_Dates
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"\b(?<day>\d{2})(?<separator>[-.\/])(?<month>[A-Z]{1}[a-z]{2})(\k<separator>)(?<year>\d{4})\b";

            string input = Console.ReadLine();

            var regex = Regex.Matches(input, pattern);

            foreach (Match item in regex)
            {
                var day = item.Groups["day"].Value;
                var month = item.Groups["month"].Value;
                var year = item.Groups["year"].Value;

                Console.WriteLine($"Day: {day}, Month: {month}, Year: {year}");
            }
        }
    }
}

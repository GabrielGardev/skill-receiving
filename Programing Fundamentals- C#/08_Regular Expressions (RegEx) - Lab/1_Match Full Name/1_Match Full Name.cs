using System;
using System.Text.RegularExpressions;
using System.Linq;

namespace _08_Regular_Expressions__RegEx____Lab
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"\b[A-Z][a-z]+ [A-Z][a-z]+\b";

            string names = Console.ReadLine();

            var matchedNames = Regex.Matches(names, pattern);

            var result = matchedNames.Cast<Match>().Select(x => x.Value).ToArray();
            Console.WriteLine(string.Join(" ", result));
       
        }
    }
}

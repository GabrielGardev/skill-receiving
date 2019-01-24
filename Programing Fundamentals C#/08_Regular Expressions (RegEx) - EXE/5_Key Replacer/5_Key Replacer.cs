using System;
using System.Text;
using System.Text.RegularExpressions;

namespace _5_Key_Replacer
{
    class Program
    {
        static void Main(string[] args)
        {
            string keyString = Console.ReadLine();
            string pattern1 = @"^([A-Za-z]*)[\|<\.]*(.+)[\|<\.]([A-Za-z]*)$";
            var regex1 = Regex.Match(keyString, pattern1);
            var start = regex1.Groups[1].Value;
            var end = regex1.Groups[3].Value;

            string text = Console.ReadLine();
            string pattern2 = $@"{start}(?!{end})(.*?){end}";
            var regex2 = Regex.Matches(text, pattern2);

            string sb = string.Empty;

            foreach (Match item in regex2)
            {
                var word = item.Groups[1].Value;

                sb += word;
            }

            if (string.IsNullOrEmpty(sb))
            {
                Console.WriteLine("Empty result");
            }
            else
            {
                Console.WriteLine(sb);
            }
        }
    }
}

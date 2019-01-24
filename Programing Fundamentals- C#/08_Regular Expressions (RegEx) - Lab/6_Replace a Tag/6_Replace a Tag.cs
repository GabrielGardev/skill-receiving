using System;
using System.Text.RegularExpressions;

namespace _6_Replace_a_Tag
{
    class Program
    {
        static void Main(string[] args)
        {
                string input = Console.ReadLine();


            while (input != "end")
            {
                string pattern = @"<a.*?href.*?=(.*)>(.*?)<\/a>";
                string replacment = @"[URL href=$1]$2[/URL]";
                string repleced = Regex.Replace(input, pattern, replacment);
                Console.WriteLine(repleced);

                input = Console.ReadLine();
            }
        }
    }
}

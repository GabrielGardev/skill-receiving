using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace _3_Camera_View
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] numbers = Console.ReadLine().Split();
            int numberToSkip = int.Parse(numbers[0]);
            int numberToTake = int.Parse(numbers[1]);
            string input = Console.ReadLine();
            string pattern = @"\|<([\w]{" + numberToSkip + @"})([\w]{1," + numberToTake + "})";

            MatchCollection cameras = Regex.Matches(input, pattern);
            List<string> places = new List<string>();
            foreach (Match item in cameras)
            {
                var temp = item.Groups[2].Value;

                places.Add(temp);
            }

            
                Console.WriteLine(string.Join(", ", places));
            
        }
    }
}

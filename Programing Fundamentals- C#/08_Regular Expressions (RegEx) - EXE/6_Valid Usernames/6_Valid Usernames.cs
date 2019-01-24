using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace _6_Valid_Usernames
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] userNames = Console.ReadLine().Split(" \\/()".ToCharArray(),StringSplitOptions.RemoveEmptyEntries);

            string pattern = @"^([A-Za-z]{1})([\w]{2,24})$";
            List<string> names = new List<string>();
            foreach (var item in userNames)
            {
                if (Regex.IsMatch(item, pattern) && item.Length >= 3 && item.Length <= 25)
                {
                    names.Add(item);
                }
            }
            int counter = 0;
            int max = 0;
            int position = 0;
            for (int i = 0; i < names.Count - 1; i++)
            {
                counter = names[i].Length + names[i + 1].Length;

                if (counter > max)
                {
                    max = counter;
                    position = i;
                }
            }

            Console.WriteLine(names[position]);
            Console.WriteLine(names[position + 1]);
        }
    }
}

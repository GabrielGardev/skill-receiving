using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace _7_Hideout
{
    class Program
    {
        static void Main(string[] args)
        {
            string map = Console.ReadLine();
            int indexOfTheFirstChar = 0;
            while (true)
            {
                string[] clues = Console.ReadLine().Split();
                string hideout = Regex.Escape(clues[0]);
                int minSize = int.Parse(clues[1]);
                
                string patern = $@"[{hideout}]+";

                foreach (Match item in Regex.Matches(map, patern))
                {
                    if (item.Length >= minSize)
                    {
                        Console.WriteLine($"Hideout found at index {item.Index} and it is with size {item.Length}!");

                        return;
                    }
                }
            }
        }
    }
}

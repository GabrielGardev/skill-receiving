using System;
using System.Linq;

namespace _3_Text_Filter
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] badWords = Console.ReadLine().Split(" ,".ToCharArray(),StringSplitOptions.RemoveEmptyEntries);
            string text = Console.ReadLine();
            
            foreach (var badWord in badWords)
            {
                 text = text.Replace(badWord, new string('*', badWord.Length));
            }
            Console.WriteLine(text);
        }
    }
}

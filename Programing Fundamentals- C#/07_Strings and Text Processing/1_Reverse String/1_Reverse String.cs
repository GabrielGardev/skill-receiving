using System;
using System.Linq;
using System.Text;

namespace _07_Strings_and_Text_Processing
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string output = ReverseString(input);
            Console.WriteLine(output);
            
        }
        public static string ReverseString(string input)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = input.Length - 1; i >= 0; i--)
            {
                sb.Append(input[i]);
            }

            return sb.ToString();
        }

    }
}

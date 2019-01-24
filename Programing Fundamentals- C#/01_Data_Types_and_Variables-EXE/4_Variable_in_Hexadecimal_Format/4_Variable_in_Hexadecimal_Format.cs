using System;

namespace _4_Variable_in_Hexadecimal_Format
{
    class Program
    {
        static void Main(string[] args)
        {
            string toConvert = Console.ReadLine();

            int result = Convert.ToInt32(toConvert, 16);

            Console.WriteLine(result);
        }
    }
}

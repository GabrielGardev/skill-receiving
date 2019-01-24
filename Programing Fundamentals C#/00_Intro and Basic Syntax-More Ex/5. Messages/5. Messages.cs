using System;

namespace _5._Messages
{
    class Program
    {
        static void Main(string[] args)
        {
            int cycles = int.Parse(Console.ReadLine());
            string result = "";

            for (int i = 0; i < cycles; i++)
            {
                int combination = int.Parse(Console.ReadLine());
                int numberOfDigits = combination.ToString().Length;
                int mainDig = combination % 10;
                int offset = (mainDig - 2) * 3;

                if (mainDig == 7 || mainDig == 9)
                {
                    offset += 1;
                }

                int letterIndex = (offset + numberOfDigits - 1);

                char mainLetter = (char)(letterIndex + 97);

                result += mainLetter;
            }
            Console.WriteLine(result);
        }
    }
}

using System;

namespace _2._Name_of_the_Last_Digit
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            string letter = ConvertToLetter(number);

            Console.WriteLine(letter);
        }

        public static string ConvertToLetter(int number)
        {
            number = number % 10;
            string toWord = "";

            switch (number)
            {
                case 0: toWord = "zero"; break;
                case 1: toWord = "one"; break;
                case 2: toWord = "two"; break;
                case 3: toWord = "three"; break;
                case 4: toWord = "four"; break;
                case 5: toWord = "five"; break;
                case 6: toWord = "six"; break;
                case 7: toWord = "seven"; break;
                case 8: toWord = "eight"; break;
                case 9: toWord = "nine"; break;
            }

            return toWord;

        }
    }
}

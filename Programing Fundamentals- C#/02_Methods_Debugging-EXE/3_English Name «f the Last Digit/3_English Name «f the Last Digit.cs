using System;

namespace _3_English_Name_оf_the_Last_Digit
{
    class Program
    {
        static void Main(string[] args)
        {
            long num = long.Parse(Console.ReadLine());

            Console.WriteLine(GetLastDigitInString(Math.Abs(num)));
        }
        static string GetLastDigitInString(long a)
        {
            long num = a % 10;

            string result = "";

            switch (num)
            {
                case 1:
                    result = "one";
                    break;
                case 2:
                    result = "two";
                    break;
                case 3:
                    result = "three";
                    break;
                case 4:
                    result = "four";
                    break;
                case 5:
                    result = "five";
                    break;
                case 6:
                    result = "six";
                    break;
                case 7:
                    result = "seven";
                    break;
                case 8:
                    result = "eight";
                    break;
                case 9:
                    result = "nine";
                    break;
                case 0:
                    result = "zero";
                    break;

            }
            return result;

        }

    }
}

using System;

namespace _4_Numbers_in_Reversed_Order
{
    class Program
    {
        static void Main(string[] args)
        {
            string number = Console.ReadLine();
            ReverseNum(number);

        }
        static void ReverseNum(string number)
        {
            int a = 1;
            string result = "";

            for (int i = number.Length; i > 0; i--)
            {
                char digit = number[number.Length - a];
                result += digit;
                a++;
            }
            Console.WriteLine(result);
        }
    }
}

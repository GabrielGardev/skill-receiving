using System;
using System.Linq;
using System.Text;

namespace _7_Multiply_Big_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            string num1 = Console.ReadLine();
            string num2 = Console.ReadLine();
            if (int.Parse(num2) == 0)
            {
                Console.WriteLine("0");
                return;
            }
            int num = 0;
            int reminder = 0;
            int sum = 0;
            StringBuilder result = new StringBuilder();

            for (int i = num1.Length - 1; i >= 0; i--)
            {
                sum = (num1[i] - 48) * (num2[0] - 48) + reminder;
                num = sum % 10;
                
                if (sum > 9)
                {
                    reminder = sum / 10;
                }
                else
                {
                    reminder = 0;
                }

                result.Append(num);

                if (i == 0 && reminder > 0)
                {
                    result.Append(reminder);
                }
            }
            Console.WriteLine(result.ToString().TrimEnd('0').ToCharArray().Reverse().ToArray());
        }
    }
}

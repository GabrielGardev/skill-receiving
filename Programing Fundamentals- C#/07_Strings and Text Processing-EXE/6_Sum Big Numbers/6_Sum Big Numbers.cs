using System;
using System.Linq;
using System.Text;

namespace _6_Sum_Big_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string num1 = Console.ReadLine();
            string num2 = Console.ReadLine();
            
            int len1 = num1.Length;
            int len2 = num2.Length;

            if (len1 > len2)
            {
                num2 = num2.PadLeft(len1, '0');
            }
            else
            {
                num1 = num1.PadLeft(len2, '0');
            }

            int num = 0;
            int reminder = 0;
            int sum = 0;
            StringBuilder result = new StringBuilder();

            for (int i = num1.Length - 1; i >= 0; i--)
            {
                sum = num1[i] - 48 + num2[i] - 48 + reminder;
                num = sum % 10;           

                
                if (sum > 9)
                {
                    reminder = 1;
                }
                else
                {
                    reminder = 0;
                }
           
                result.Append(num);

                if (i == 0 && reminder == 1)
                {
                    result.Append(1);
                }
            }
            Console.WriteLine(result.ToString().TrimEnd('0').ToCharArray().Reverse().ToArray());
        }
    }
}

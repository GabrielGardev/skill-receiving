using System;

namespace _9_Refactor_Special_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            int total = 0;
            int sum = 0;
            bool isSpecial = false;
            for (int i = 1; i <= num; i++)
            {
                sum = i;
                while (i > 0)
                {
                    total += i % 10;
                    i = i / 10;
                }
                isSpecial = (total == 5) || (total == 7) || (total == 11);
                Console.WriteLine($"{sum} -> {isSpecial}");
                total = 0;
                i = sum;
            }

        }
    }
}

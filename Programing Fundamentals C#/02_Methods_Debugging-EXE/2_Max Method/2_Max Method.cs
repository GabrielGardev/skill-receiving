using System;

namespace _2_Max_Method
{
    class Program
    {
        static void Main(string[] args)
        {
            int firstNum = int.Parse(Console.ReadLine());
            int secondNum = int.Parse(Console.ReadLine());
            int thirdNum = int.Parse(Console.ReadLine());

            int maxFromFirstNums = GetMax(firstNum, secondNum);

            int maxNum = GetMax(maxFromFirstNums, thirdNum);
            Console.WriteLine(maxNum);

        }
        static int GetMax(int a, int b)
        {
             int temp = 0;
            if (a >= b)
            {
                temp = a;
            }
            else
            {
                temp = b;
            }
            return temp;
        }
    }
}

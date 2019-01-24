using System;

namespace _5_Fibonachi_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            ToFibonachiNumber(n);


        }
        static void ToFibonachiNumber(int n)
        {
            int f0 = 1;
            int f1 = 1;


            for (int i = 0; i < n - 1; i++)
            {
                int temp = f0;
                f0 = f1;
                f1 = temp + f1;
            }
            Console.WriteLine(f1);
        }
    }
}

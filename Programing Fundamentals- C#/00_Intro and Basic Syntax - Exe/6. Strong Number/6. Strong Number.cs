using System;

namespace _6._Strong_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            
            int currentNum = int.Parse(Console.ReadLine());
            int num = currentNum;
            int sum = 0;

            while (currentNum > 0)
            {
                int number = currentNum % 10;
                sum += Factorial(number);
                currentNum = currentNum / 10;
            }

            if (num == sum)
            {
                Console.WriteLine("yes");
            }
            else
            {
                Console.WriteLine("no");
            }
        }
        public static int Factorial(int facno)
        {
            int temno = 1;

            for (int i = 1; i <= facno; i++)
            {
                temno = temno * i;
            }

            return temno;
        }
    }
}

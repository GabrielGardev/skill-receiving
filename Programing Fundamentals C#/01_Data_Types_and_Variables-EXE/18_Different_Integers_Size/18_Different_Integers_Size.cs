using System;

namespace _18_Different_Integers_Size
{
    class Program
    {
        static void Main(string[] args)
        {
            string num = Console.ReadLine();

            try
            {
                long number = long.Parse(num);

                Console.WriteLine($"{number} can fit in:");
                if (-128 <= number && number <= 127)
                {
                    Console.WriteLine("* sbyte");
                }

                if (0 <= number && number <= 255)
                {
                    Console.WriteLine("* byte");
                }

                if (-32768 <= number && number <= 32767)
                {
                    Console.WriteLine("* short");
                }

                if (0 <= number && number <= 65535)
                {
                    Console.WriteLine("* ushort");
                }

                if (int.MinValue <= number && number <= int.MaxValue)
                {
                    Console.WriteLine("* int");
                }

                if (uint.MinValue <= number && number <= uint.MaxValue)
                {
                    Console.WriteLine("* uint");
                }

                if (long.MinValue <= number && number <= long.MaxValue)
                {
                    Console.WriteLine("* long");
                }

            }
            catch (Exception)
            {
                Console.WriteLine($"{num} can't fit in any type");
                
            }
        }
    }
}

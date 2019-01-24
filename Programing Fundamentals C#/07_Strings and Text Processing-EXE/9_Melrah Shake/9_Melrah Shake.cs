using System;
using System.Linq;

namespace _9_Melrah_Shake
{
    class Program
    {
        static void Main(string[] args)
        {
            int first = 0;
            int last = 0;
            string input = Console.ReadLine();
            string patern = Console.ReadLine();

            while (true)
            {
                first = input.IndexOf(patern);
                last = input.LastIndexOf(patern);

                if (patern.Length > 0 && first != -1 && last != -1)
                {
                    input = input.Remove(last, patern.Length);
                    input = input.Remove(first, patern.Length);
                    

                    Console.WriteLine("Shaked it.");
                    patern = patern.Remove(patern.Length / 2, 1);
                }
                else
                {
                    break;
                }
            }
            Console.WriteLine("No shake.");
            Console.WriteLine(input);
        }
    }
}

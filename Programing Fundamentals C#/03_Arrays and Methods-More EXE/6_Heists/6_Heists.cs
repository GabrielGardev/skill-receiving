using System;
using System.Linq;

namespace _6_Heists
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] prices = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
            string[] heists = Console.ReadLine().Split(' ').ToArray();
            

            long earnings = 0;
            long expences = 0;

            while (heists[0] != "Jail" && heists[1] != "Time")
            {
                string first = heists[0];
                
                for (int i = 0; i < first.Length; i++)
                {
                    // jewels
                    if (first[i] == '%')
                    {
                        earnings += prices[0];
                    }

                    //gold
                    if (first[i] == '$')
                    {
                        earnings += prices[1];
                    }
                }
                expences += long.Parse(heists[1]);

                heists = Console.ReadLine().Split(' ').ToArray();
            }
            earnings = earnings - expences;
            if (earnings >= 0)
            {
                Console.WriteLine($"Heists will continue. Total earnings: {earnings}.");
            }
            else
            {
                Console.WriteLine($"Have to find another job. Lost: {Math.Abs(earnings)}.");
            }
        }
    }
}

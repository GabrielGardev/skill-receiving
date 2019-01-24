using System;
using System.Collections.Generic;
using System.Linq;

namespace _05_Dictionaries_and_Lists_More_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            int hp = int.Parse(Console.ReadLine());
            int startHp = hp;
            int seconds;
            int minutes;
            int timeToDefeat;
            int virusStrength;
            var viruses = new Dictionary<string, int>();
            string virus = Console.ReadLine();

            while (virus != "end")
            {
                
                virusStrength = GetVirusStr(virus);
                timeToDefeat = virusStrength * virus.Length;
                seconds = timeToDefeat % 60;
                minutes = timeToDefeat / 60;

                if (viruses.ContainsKey(virus) == false)
                {
                    viruses.Add(virus, virusStrength);
                }
                else
                {
                    timeToDefeat = timeToDefeat / 3;
                    seconds = timeToDefeat % 60;
                    minutes = timeToDefeat / 60;
                }
                
                Console.WriteLine($"Virus {virus}: {virusStrength} => {timeToDefeat} seconds");

                if (hp - timeToDefeat <= 0)
                {
                    Console.WriteLine("Immune System Defeated.");
                    return;
                }
                hp -= timeToDefeat;
                Console.WriteLine($"{virus} defeated in {minutes}m {seconds}s.");
                Console.WriteLine($"Remaining health: {hp}");

                hp = hp + (int)(hp * 0.2);
                if (hp > startHp)
                {
                    hp = startHp;
                }
                virus = Console.ReadLine();
            }
            
            Console.WriteLine($"Final Health: {hp}");
        }

        private static int GetVirusStr(string virus)
        {
            int sum = 0;
            for (int i = 0; i < virus.Length; i++)
            {
                sum += (int)virus[i];
            }
            sum /= 3;
            return sum;
        }

    }
}

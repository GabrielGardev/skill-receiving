using System;

namespace _10._Rage_Expenses
{
    class Program
    {
        static void Main(string[] args)
        {
            int lostGames = int.Parse(Console.ReadLine());
            double headset = double.Parse(Console.ReadLine());
            double mouse = double.Parse(Console.ReadLine());
            double keyboard = double.Parse(Console.ReadLine());
            double display = double.Parse(Console.ReadLine());

            int trashedHeadset = 0;
            int trashedMouses = 0;
            int trashedKeyboards = 0;
            int trashedDisplays = 0;

            int secondGames = 0;
            int thirdGames = 0;
            int trashedKeyCounter = 0;

            for (int i = 0; i < lostGames; i++)
            {
                secondGames++;
                thirdGames++;

                if (secondGames == 2)
                {
                    trashedHeadset++;
                    secondGames = 0;
                }
                if (thirdGames == 3)
                {
                    trashedMouses++;
                    thirdGames = 0;
                }
                if (secondGames == 0 && thirdGames == 0)
                {
                    trashedKeyboards++;
                    trashedKeyCounter++;
                }
                if (trashedKeyCounter == 2)
                {
                    trashedDisplays++;
                    trashedKeyCounter = 0;
                }
            }

            double price = trashedHeadset * headset + trashedMouses * mouse + trashedKeyboards * keyboard + trashedDisplays * display;

            Console.WriteLine($"Rage expenses: {price:f2} lv.");
        }
    }
}

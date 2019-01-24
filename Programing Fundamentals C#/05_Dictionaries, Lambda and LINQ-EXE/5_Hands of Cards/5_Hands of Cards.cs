using System;
using System.Collections.Generic;
using System.Linq;

namespace _05_Dictionaries__Lambda_and_LINQ_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            var players = new Dictionary<string, List<string>>();
            int sum = 0;
            List<string> hand = Console.ReadLine().Split(':').ToList();
            List<string> cards = new List<string>();

            while (hand[0] != "JOKER")
            {
                string name = hand[0];
                hand.RemoveAt(0);
                cards = hand[0].Split(", ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries).Distinct().ToList();

                if (players.ContainsKey(name) == false)
                {
                    players.Add(name, cards);
                }
                else
                {
                    players[name].AddRange(cards);
                    players[name] = players[name].Distinct().ToList();

                }
                hand = Console.ReadLine().Split(':').ToList();
            }

            int multipleyer = 0;
            int mainValue = 0;
            foreach (var player in players)
            {
                foreach (var card in player.Value)
                {
                    switch (card[card.Length - 1])
                    {
                        case 'S': multipleyer = 4; break;
                        case 'H': multipleyer = 3; break;
                        case 'D': multipleyer = 2; break;
                        case 'C': multipleyer = 1; break;
                    }

                    switch (card[0])
                    {
                        case 'A': mainValue = 14; break;
                        case 'K': mainValue = 13; break;
                        case 'Q': mainValue = 12; break;
                        case 'J': mainValue = 11; break;
                        case '1': mainValue = 10; break;

                        default:
                            mainValue = int.Parse(card[0].ToString());
                            break;
                    }
                    sum += multipleyer * mainValue;
                }
                
                Console.WriteLine($"{player.Key}: {sum}");
                sum = 0;
            }

        }
    }
}

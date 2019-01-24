using System;
using System.Collections.Generic;
using System.Linq;

namespace _10_Сръбско_Unleashed
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var events = new Dictionary<string, Dictionary<string, long>>();

            while (input != "End")
            {
                if (string.IsNullOrEmpty(input))
                {
                    input = Console.ReadLine();
                    continue;
                }
                string[] temp = input.Split(' ');
                bool isInputValid = false;
                int count = 0;
                for (int i = 0; i < temp.Length; i++)
                {
                    if (temp[i].StartsWith("@"))
                    {
                        isInputValid = true;
                        count++;
                    }

                    if (count > 1)
                    {
                        isInputValid = false;
                        break;
                    }
                }

                if (temp.Length >= 4 && isInputValid)
                {
                    string[] tokens = input.Split('@');

                    string name = tokens[0];
                    string[] singerName = name.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                    string[] venue = tokens[1].Split(' ');
                    string[] venueName = venue.Take(venue.Length - 2).ToArray();

                    long ticketPrice;
                    long ticketCount;

                    bool isTicketCountValid = long.TryParse(venue[venue.Length - 1], out ticketCount);
                    bool isTicketPriceValid = long.TryParse(venue[venue.Length - 2], out ticketPrice);

                    if (name.EndsWith(" ") && singerName.Length > 0 && singerName.Length <= 3 && isTicketPriceValid
                        && isTicketCountValid && venueName.Length > 0 && venueName.Length <= 3)
                    {
                        string singerRealName = string.Join(" ", singerName);
                        string venueRealName = string.Join(" ", venueName);
                        long money = ticketPrice * ticketCount;

                        if (!events.ContainsKey(venueRealName))
                        {
                            events.Add(venueRealName, new Dictionary<string, long>());
                        }

                        if (!events[venueRealName].ContainsKey(singerRealName))
                        {
                            events[venueRealName].Add(singerRealName, money);
                        }
                        else
                        {
                            events[venueRealName][singerRealName] += money;
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (KeyValuePair<string, Dictionary<string, long>> venuesAndSingers in events)
            {
                Console.WriteLine($"{venuesAndSingers.Key}");

                foreach (KeyValuePair<string, long> singersAndIncome in venuesAndSingers.Value.OrderByDescending(x => x.Value))
                {
                    Console.WriteLine($"#  {singersAndIncome.Key} -> {singersAndIncome.Value}");
                }
            }
        }
    }
}

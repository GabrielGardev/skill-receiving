using System;
using System.Collections.Generic;
using System.Linq;

namespace _8_Logs_Aggregator
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            
            var aggregator = new Dictionary<string, Dictionary<string, int>>();
            string ip = "";
            string user = "";
            int currentDuration;


            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split().ToArray();
                ip = input[0];
                user = input[1];
                currentDuration = int.Parse(input[2]);

                if (aggregator.ContainsKey(user) == false)
                {
                    var currentLog = new Dictionary<string, int>();
                    currentLog.Add(ip, currentDuration);
                    aggregator.Add(user, currentLog);
                }
                else
                {
                    if (aggregator[user].ContainsKey(ip) == false)
                    {
                        aggregator[user].Add(ip, currentDuration);
                    }
                    else
                    {
                        aggregator[user][ip] += currentDuration;
                    }
                }
                
            }
            foreach (var currentUser in aggregator.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{currentUser.Key}: {currentUser.Value.Values.Sum()} [{string.Join(", ",currentUser.Value.Keys.OrderBy(x => x))}]");            
            }

        }
    }
}

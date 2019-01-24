using System;
using System.Collections.Generic;
using System.Linq;

namespace _6_User_Logs
{
    class Program
    {
        static void Main(string[] args)
        {
            var site = new Dictionary<string, Dictionary<string, int>>();
            string[] input = Console.ReadLine().Split().ToArray();
            string user;
            string ip;

            while (input[0] != "end")
            {
                string[] takeUser = input[2].Split('=').ToArray();
                user = takeUser[1];

                string[] takeIp = input[0].Split('=').ToArray();
                ip = takeIp[1];

                if (site.ContainsKey(user) == false)
                {
                    var temp = new Dictionary<string, int>();
                    temp.Add(ip, 1);
                    site.Add(user,temp);
                }
                else
                {
                    if (site[user].ContainsKey(ip) == false)
                    {
                        site[user].Add(ip, 1);
                    }
                    else
                    {
                        site[user][ip]++;
                    }
                }
                input = Console.ReadLine().Split().ToArray();
            }
            foreach (var currentUser in site.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{currentUser.Key}:");
                var helper = new List<string>();
                foreach (var ipPair in currentUser.Value)
                {
                    helper.Add($"{ipPair.Key} => {ipPair.Value}");
                }
                Console.WriteLine(string.Join(", ", helper) + ".");
            }
        }
    }
}

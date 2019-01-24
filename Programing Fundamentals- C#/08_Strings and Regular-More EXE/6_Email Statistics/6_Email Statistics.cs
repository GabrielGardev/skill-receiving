using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;

namespace _7_Email_Statistics
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string pattern = @"^([A-Za-z]{5,100})@([a-z]{3,100}[.com|.bg|.org]+)$";
            Dictionary<string, List<string>> validEmails = new Dictionary<string, List<string>>();
            

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();

                var regex = Regex.Matches(input, pattern);

                foreach (Match match in regex)
                {
                    var domain = match.Groups[2].Value;
                    var name = match.Groups[1].Value;

                    List<string> validNames = new List<string>();
                    validNames.Add(name);

                    if (validEmails.ContainsKey(domain) == false)
                    {  
                        validEmails.Add(domain, validNames);
                    }
                    else
                    {
                        if (validEmails[domain].Contains(name) == false)
                        {
                            validEmails[domain].Add(name);
                        }
                        
                    }
                }
            }


            foreach (var email in validEmails.OrderByDescending(x => x.Value.Count))
            {
                Console.WriteLine($"{email.Key}:");
                foreach (var item in email.Value)
                {
                    Console.WriteLine($"### {item}");
                }
            }
        }
    }
}

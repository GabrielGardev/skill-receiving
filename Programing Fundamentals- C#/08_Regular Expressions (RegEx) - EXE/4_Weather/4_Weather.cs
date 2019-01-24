using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _4_Weather
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string pattern = @"([A-Z]{2})([0-9]+\.[0-9]+)([A-Za-z]+)\|";
            Dictionary<string, List<string>> register = new Dictionary<string, List<string>>();
            
            while (input.Equals("end") == false)
            {
                var regex = Regex.Matches(input, pattern);

                foreach (Match match in regex)
                {
                    var city = match.Groups[1].Value;
                    var tempeture = match.Groups[2].Value;
                    var wether = match.Groups[3].Value;

                    if (register.ContainsKey(city) == false)
                    {
                        List<string> temp = new List<string>();
                        temp.Add(tempeture);
                        temp.Add(wether);
                        register.Add(city, temp);
                    }
                    else
                    {
                        register[city][0] = tempeture;
                        register[city][1] = wether;
                    }
                }



                input = Console.ReadLine();
            }

           

            foreach (var reg in register.OrderBy(x => double.Parse(x.Value[0])))
            {
                Console.WriteLine($"{reg.Key} => {double.Parse(reg.Value[0]):F2} => {reg.Value[1]}");
            }
        }
    }
}

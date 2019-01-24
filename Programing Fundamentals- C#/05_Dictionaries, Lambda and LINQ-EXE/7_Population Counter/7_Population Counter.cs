using System;
using System.Collections.Generic;
using System.Linq;

namespace _7_Population_Counter
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split('|').ToArray();
            Dictionary<string, Dictionary<string, long>> register = new Dictionary<string, Dictionary<string, long>>();
            string country = "";
            string city = "";
            long cityPopulation = 0;
           

            while (input[0] != "report")
            {
                city = input[0];
                country = input[1];
                cityPopulation = long.Parse(input[2]);
                var currentCity = new Dictionary<string, long>();

                if (register.ContainsKey(country) == false)
                {
                    currentCity.Add(city, cityPopulation);
                    register.Add(country, currentCity);                 
                }
                else
                {
                    register[country].Add(city, cityPopulation);
                }

                input = Console.ReadLine().Split('|').ToArray();
            }
            foreach (var currentCountry in register.OrderByDescending(x => x.Value.Values.Sum()))
            {
                Console.WriteLine($"{currentCountry.Key} (total population: {currentCountry.Value.Values.Sum()})");

                foreach (var currentCity in currentCountry.Value.OrderByDescending(x => x.Value))
                {
                    Console.WriteLine($"=>{currentCity.Key}: {currentCity.Value}");
                }
            }
        }
    }
}

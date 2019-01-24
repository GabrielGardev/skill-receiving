using System;
using System.Collections.Generic;
using System.Linq;

namespace _5_Parking_Validation
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var data = new Dictionary<string, string>();
            string command = "";
            string name = "";
            string licensePlate = "";

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split().ToArray();
                command = input[0].ToLower();
                name = input[1];

                if (command == "register")
                {
                    licensePlate = input[2];
                    bool IsItValidLicense = licensePlate.Length == 8
                        && char.IsUpper(licensePlate[0])
                        && char.IsUpper(licensePlate[1])
                        && char.IsUpper(licensePlate[7])
                        && char.IsUpper(licensePlate[6])
                        && char.IsDigit(licensePlate[2])
                        && char.IsDigit(licensePlate[3])
                        && char.IsDigit(licensePlate[4])
                        && char.IsDigit(licensePlate[5]);

                    if (data.ContainsKey(name))
                    {
                        Console.WriteLine($"ERROR: already registered with plate number {licensePlate}");
                        
                    }
                    else if (IsItValidLicense == false)
                    {
                        Console.WriteLine($"ERROR: invalid license plate {licensePlate}");
                        
                    }
                    else if (data.Any(x => x.Value == licensePlate))
                    {
                        Console.WriteLine($"ERROR: license plate {licensePlate} is busy");
                        
                    }else if (data.ContainsKey(name) == false)
                    {
                        data[name] = licensePlate;
                        Console.WriteLine($"{name} registered {licensePlate} successfully");

                    }
                }
                else if (command == "unregister")
                {
                    if (data.ContainsKey(name) == false)
                    {
                        Console.WriteLine($"ERROR: user {name} not found");
                        
                    }
                    else
                    {
                        Console.WriteLine($"user {name} unregistered successfully");
                        data.Remove(name);

                    }

                }
            }
            foreach (var currentName in data)
            {
                Console.WriteLine($"{currentName.Key} => {currentName.Value}");
            }
        }

        
    }
}

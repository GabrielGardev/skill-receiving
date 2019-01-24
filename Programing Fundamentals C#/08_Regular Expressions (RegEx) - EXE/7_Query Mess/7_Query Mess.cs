using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;

class Program
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();

        while (input != "END")
        {
            string build = RemoveSpaces(input);
            Dictionary<string, List<string>> data = GetCurrentFields(build);
            PrintCurrentResult(data);

            input = Console.ReadLine();
        }
    }

    static void PrintCurrentResult(Dictionary<string, List<string>> data)
    {
        foreach (var field in data)
        {
            Console.Write($"{field.Key}=[" + string.Join(", ", field.Value) + "]");
        }

        Console.WriteLine();
    }

    static Dictionary<string, List<string>> GetCurrentFields(string input)
    {
        Dictionary<string, List<string>> data = new Dictionary<string, List<string>>();
        MatchCollection matches = Regex.Matches(input, @"([^&=?]+)=([^&=?]+)");

        foreach (Match m in matches)
        {
            string field = m.Groups[1].Value.Trim();
            string value = m.Groups[2].Value.Trim();

            if (data.ContainsKey(field) == false)
            {
                data.Add(field, new List<string>());
            }
            data[field].Add(value);
        }

        return data;
    }

    static string RemoveSpaces(string input)
    {
        input = input.Replace("+", " ");
        input = input.Replace("%20", " ");
        input = Regex.Replace(input, @"\s+", " ");
        return input;
    }
}
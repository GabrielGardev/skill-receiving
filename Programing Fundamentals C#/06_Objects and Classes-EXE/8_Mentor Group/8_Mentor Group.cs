using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            Dictionary<string, Student> listStudents = new Dictionary<string, Student>();
            Dictionary<string, List<DateTime>> finalDates = new Dictionary<string, List<DateTime>>();
            while (input != "end of dates")
            {
                string[] arr = input.Split(new char[] {' ', ',' },StringSplitOptions.RemoveEmptyEntries).ToArray();
                string name = arr[0];
                List<DateTime> dates = new List<DateTime>();
                for (int i = 1; i < arr.Length; i++)
                {
                    dates.Add(DateTime.ParseExact(arr[i], "dd/MM/yyyy", CultureInfo.InvariantCulture));
                }
                
                    finalDates[name] = dates;

                    Student student = new Student();
                    student.Comment = new List<string>();
                    student.Date = finalDates[name];
                if (listStudents.ContainsKey(name) == false)
                {
                    listStudents.Add(name, student);
                }
                else
                {
                    listStudents[name].Date.AddRange(student.Date);
                }

                input = Console.ReadLine();
            }
            Dictionary<string, List<string>> comments = new Dictionary<string, List<string>>();
            input = Console.ReadLine();
            while (input != "end of comments")
            {
                string[] arr = input.Split('-').ToArray();
                string name = arr[0];
                string comment = arr[1];

                List<string> com = new List<string>() { comment };
                
                if (comments.ContainsKey(name) == false)
                { 
                    comments.Add(name, com);
                }
                else
                {
                    comments[name].Add(com[0]);
                }

                if (listStudents.ContainsKey(name))
                {
                    Student student = new Student();
                    
                    student.Comment = comments[name];
                    

                    listStudents[name].Comment = student.Comment;
                    
                }
                input = Console.ReadLine();
            }

            foreach (var currentStudent in listStudents.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{currentStudent.Key}");
                Console.WriteLine("Comments:");
                foreach (var item in currentStudent.Value.Comment)
                {
                    Console.WriteLine($"- {item}");
                }
                
                    Console.WriteLine($"Dates attended:");
                
                
                foreach (var item in currentStudent.Value.Date.OrderBy(x => x))
                {
                    
                    Console.WriteLine($"-- {item.ToString("dd/MM/yyyy")}");
                }
            }


        }
    }
    class Student
    {
        
        public List<string> Comment { get; set; }
        public List<DateTime> Date { get; set; }
    }
}

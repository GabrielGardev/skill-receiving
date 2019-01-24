using System;
using System.Collections.Generic;
using System.Linq;

namespace _4_Average_Grades
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());     
            List<Student> ourClass = new List<Student>();
            for (int i = 0; i < n; i++)
            {
                List<string> input = Console.ReadLine().Split().ToList();
                Student student = new Student();
                student.Name = input[0];
                input.RemoveAt(0);
                student.Grades = input.Select(double.Parse).ToList();
                ourClass.Add(student);
            }

            foreach (var currentStudent in ourClass.Where(x => x.AverageGrade >= 5).OrderBy(x => x.Name).ThenByDescending(x => x.AverageGrade))
            {
                Console.WriteLine($"{currentStudent.Name} -> {currentStudent.AverageGrade:f2}");
            }
        }
    }
    class Student
    {
        public string Name { get; set; }
        public List<double> Grades { get; set; }
        public double AverageGrade { get { return Grades.Average(); } }
        
               
    }
}

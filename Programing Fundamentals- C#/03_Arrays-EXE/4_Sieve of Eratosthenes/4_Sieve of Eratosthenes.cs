using System;

namespace _4_Sieve_of_Eratosthenes
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            int[] arr = new int[number + 1];

            bool[] checkPrime = new bool[number + 1];

            string primeNums = null;

            for (int i = 0; i <= number; i++)
            {
                arr[i] = i;
                checkPrime[i] = true;
            }

            checkPrime[0] = false;
            checkPrime[1] = false;

            for (int i = 2; i < arr.Length; i++)
            {


                if (checkPrime[i])
                {
                    primeNums += arr[i] + " ";
                }

                for (int j = i + 1; j < arr.Length; j++)
                {
                    if (arr[j] % i == 0 && checkPrime[j] == true)
                    {
                        checkPrime[j] = false;
                    }
                }

            }
            Console.WriteLine(primeNums);
        }
        
    }
}

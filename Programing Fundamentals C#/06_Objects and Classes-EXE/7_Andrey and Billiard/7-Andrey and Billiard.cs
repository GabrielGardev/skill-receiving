using System;
using System.Collections.Generic;
using System.Linq;

namespace _06_Objects_and_Classes_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Dictionary<string, decimal> shopList = new Dictionary<string, decimal>();
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split('-').ToArray();
                string nameOfProduct = input[0];
                decimal priceOfProducct = decimal.Parse(input[1]);

                if (shopList.ContainsKey(nameOfProduct) == false)
                {
                    shopList.Add(nameOfProduct, priceOfProducct);
                }
                else
                {
                    shopList[nameOfProduct] = priceOfProducct;
                }
            }

            string order = Console.ReadLine();
            List<Customer> totalCustomers = new List<Customer>();
            while (order != "end of clients")
            {
                string[] listOfClients = order.Split(new char[] { ',', '-' }, StringSplitOptions.RemoveEmptyEntries);
                
                string wantedProduct = listOfClients[1];
                

                if (shopList.ContainsKey(wantedProduct))
                {
                    string nameOfclient = listOfClients[0];
                    int quantity = int.Parse(listOfClients[2]);
                    decimal spend = quantity * shopList[wantedProduct];

                    Customer customer = new Customer();
                    customer.Name = nameOfclient;

                    customer.ShopList = new Dictionary<string, int>();
                    customer.ShopList.Add(wantedProduct, quantity);

                    customer.Bill = spend;


                    if (totalCustomers.Any(x => x.Name == customer.Name))
                    {
                        Customer exsistingCustomer = totalCustomers.First(x => x.Name == customer.Name);

                        if (exsistingCustomer.ShopList.ContainsKey(wantedProduct))
                        {
                            exsistingCustomer.ShopList[wantedProduct] += quantity;
                            exsistingCustomer.Bill += spend;
                        }
                        else
                        {
                            exsistingCustomer.ShopList[wantedProduct] = quantity;
                            exsistingCustomer.Bill += spend;
                        }
                    }
                    else
                    {
                        totalCustomers.Add(customer);
                    }
                }

                order = Console.ReadLine();
            }

            decimal totalBill = 0;
            foreach (var currentCustomer in totalCustomers.OrderBy(x => x.Name))
            {
                Console.WriteLine(currentCustomer.Name);

                foreach (var item in currentCustomer.ShopList)
                {
                    Console.WriteLine($"-- {item.Key} - {item.Value}");
                }
                Console.WriteLine($"Bill: {currentCustomer.Bill:f2}");
                totalBill += currentCustomer.Bill;
            }

            Console.WriteLine($"Total bill: {totalBill:f2}");


        }
    }
    class Customer
    {
        public string Name { get; set; }
        public Dictionary<string, int> ShopList { get; set; }
        public decimal Bill { get; set; }
    }
}

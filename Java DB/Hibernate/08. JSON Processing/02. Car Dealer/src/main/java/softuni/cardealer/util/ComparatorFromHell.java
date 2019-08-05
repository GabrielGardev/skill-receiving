package softuni.cardealer.util;

import softuni.cardealer.domains.entities.Customer;

import java.math.BigDecimal;
import java.util.Comparator;

public class ComparatorFromHell implements Comparator<Customer> {

    @Override
    public int compare(Customer x1, Customer x2) {

        BigDecimal totalMoneySpend1 = this.getTotalMoneySpend(x1);
        BigDecimal totalMoneySpend2 = this.getTotalMoneySpend(x2);

        int result = totalMoneySpend2.compareTo(totalMoneySpend1);

        if (result == 0) {

            int countOfCars1 = x1.getSales().size();
            int countOfCars2 = x2.getSales().size();

            result = Integer.compare(countOfCars2, countOfCars1);
        }

        return result;
    }

    private BigDecimal getTotalMoneySpend(Customer customer) {

        return customer.getSales()
                .stream()
                .map(x -> x.getCar()
                        .getParts()
                        .stream()
                        .map(y -> BigDecimal.valueOf(y.getQuantity()).multiply(y.getPrice()))
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}

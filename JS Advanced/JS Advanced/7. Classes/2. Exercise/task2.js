function solve(tickets, sortingCriteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }
    }

    tickets.forEach((x, i) => {
        let [des, price, status] = x.split('|');
        tickets[i] = new Ticket(des, price, status);
    })

    let sorter = {
        destination: (a, b) => a.destination.localeCompare(b.destination),
        price: (a, b) => a.price - b.price,
        status: (a, b) => a.status.localeCompare(b.status)
    };

    return tickets.sort(sorter[sortingCriteria]);
}


console.log(
    solve(
        ['Philadelphia|94.20|available',
            'New York City|95.99|available',
            'New York City|95.99|sold',
            'Boston|126.20|departed'],
        'destination'
    )
)
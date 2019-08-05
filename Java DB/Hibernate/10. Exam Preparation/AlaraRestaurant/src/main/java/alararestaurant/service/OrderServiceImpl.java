package alararestaurant.service;

import alararestaurant.domain.dtos.xml.ItemXmlDto;
import alararestaurant.domain.dtos.xml.OrderRootDto;
import alararestaurant.domain.dtos.xml.OrderXmlDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Item;
import alararestaurant.domain.entities.Order;
import alararestaurant.domain.entities.OrderItem;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.repository.OrderItemRepository;
import alararestaurant.repository.OrderRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import alararestaurant.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final static String ORDERS_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\orders.xml";

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;
    private final OrderItemRepository orderItemRepository;
    private final FileUtil fileUtil;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    @Autowired
    public OrderServiceImpl(ItemRepository itemRepository, OrderRepository orderRepository, EmployeeRepository employeeRepository, OrderItemRepository orderItemRepository, FileUtil fileUtil, ModelMapper mapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.orderItemRepository = orderItemRepository;
        this.fileUtil = fileUtil;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean ordersAreImported() {
        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {
        return fileUtil.readFile(ORDERS_PATH);
    }

    @Override
    public String importOrders() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        OrderRootDto orderRootDto = xmlParser.parseXml(OrderRootDto.class, ORDERS_PATH);

        OrderLoop:
        for (OrderXmlDto dto : orderRootDto.getOrders()) {
            Employee employee = employeeRepository.findByName(dto.getEmployee());
            if (employee == null){
                continue;
            }
            Order order = mapper.map(dto, Order.class);
            order.setEmployee(employee);
            order.setDateTime(LocalDateTime.parse(dto.getDateTime(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));


            List<ItemXmlDto> list = new ArrayList<>();
            for (ItemXmlDto itemXmlDto : dto.getItems().getItems()) {
                Item item = itemRepository.findByName(itemXmlDto.getName());
                if (item == null){
                    continue OrderLoop;
                }
                list.add(itemXmlDto);
            }

            orderRepository.saveAndFlush(order);

            list.forEach(e -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(e.getQuantity());
                orderItem.setItem(itemRepository.findByName(e.getName()));
                orderItem.setOrder(order);
                orderItemRepository.saveAndFlush(orderItem);
            });
            sb.append(String.format("Order for %s on %s added",
                    dto.getCustomer(),
                    dto.getDateTime()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        StringBuilder sb = new StringBuilder();
        String separator = System.lineSeparator();

        List<Order> list = orderRepository.findFinishedByBurgerFlippers();

        list
                .forEach(o -> {
                    sb.append("Name: ").append(o.getEmployee().getName()).append(separator)
                            .append("Orders:").append(separator)
                            .append("   Customer: ").append(o.getCustomer()).append(separator)
                            .append("Items:").append(separator);

                    o.getOrderItems().forEach(oi -> {
                        sb.append("      Name: ").append(oi.getItem().getName()).append(separator)
                                .append("      Price: ").append(oi.getItem().getPrice()).append(separator)
                                .append("      Quantity: ").append(oi.getQuantity()).append(separator)
                                .append(separator);
                    });
                });
        return sb.toString().trim();
    }
}

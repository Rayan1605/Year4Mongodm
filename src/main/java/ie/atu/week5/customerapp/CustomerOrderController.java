package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerOrderController {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public CustomerOrderController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/customer-with-orders")
    public ResponseEntity<String> createCustomerWithOrders(@RequestBody CustomerOrderRequest customerOrderRequest) {

        // 1. Save the Customer and get the generated customer ID
        if (customerOrderRequest.getCustomer().getId() != null) {
            ArrayList<Order> tempOrder = new ArrayList<>(customerOrderRequest.getOrders());
            orderRepository.saveAll(tempOrder);
            return ResponseEntity.ok("Added the orders for customer for "  + customerOrderRequest.getCustomer().getName() + " " + tempOrder);
        } else  {
            customerRepository.save(customerOrderRequest.getCustomer());
            ArrayList<Order> tempOrder = new ArrayList<>(customerOrderRequest.getOrders());
            orderRepository.saveAll(tempOrder);
            return ResponseEntity.ok("Added the orders for customer for "  + customerOrderRequest.getCustomer().getName() + " " + tempOrder);
        }

        // 2. Save the Orders and link them to the customer
    }
}

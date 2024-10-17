package ie.atu.week5.customerapp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CustomerOrderService {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public ResponseEntity<String> createCustomerWithOrders( CustomerOrderRequest customerOrderRequest) {

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
    }
}

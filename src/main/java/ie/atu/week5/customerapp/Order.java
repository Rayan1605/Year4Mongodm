package ie.atu.week5.customerapp;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    @NotBlank(message = "Please give an order code")
    private int orderCode;
    @NotBlank(message = "Please give an order details")
    private String orderDetails;
    @NotBlank(message = "Please give a customer id")
    private String customerId; // Reference to the associated customer
}

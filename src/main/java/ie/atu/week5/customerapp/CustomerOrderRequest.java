package ie.atu.week5.customerapp;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderRequest {
    @NotBlank(message = "Please add Customer")
    private Customer customer;
    @NotBlank(message = "Please add an order")
    private List<Order> orders;

}

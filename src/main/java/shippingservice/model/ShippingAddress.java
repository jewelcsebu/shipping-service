package shippingservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress extends BaseModel{

    private String fullName;
    private long phoneNumber;
    private String region;
    private String city;
    private String area;
    private String address;
    private long customerId;

}

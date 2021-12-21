package shippingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cities")
public class City extends BaseModel{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String city;

//    @OneToMany
//    @JoinColumn(name="city_id_fk")
//    private Set<Area> areas;

    @ManyToOne(targetEntity=Region.class, cascade = CascadeType.MERGE)
    private Region region;

}

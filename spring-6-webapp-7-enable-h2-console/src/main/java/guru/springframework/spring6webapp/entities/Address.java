package guru.springframework.spring6webapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jpa_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer address_id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    public Address(Integer address_id, String street, String city, String country) {
        this.address_id = address_id;
        this.street = street;
        this.city = city;
        this.country = country;
    }

}

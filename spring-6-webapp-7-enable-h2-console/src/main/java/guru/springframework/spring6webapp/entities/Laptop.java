package guru.springframework.spring6webapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jpa_laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer laptopId;
    private String laptopName;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}

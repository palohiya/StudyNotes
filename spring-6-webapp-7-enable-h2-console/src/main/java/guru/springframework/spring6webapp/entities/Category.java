package guru.springframework.spring6webapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cId")
    private Integer cId;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "c", cascade = CascadeType.ALL)
    @Column(name = "product_id")
    private List<Product> products = new ArrayList<>();

}

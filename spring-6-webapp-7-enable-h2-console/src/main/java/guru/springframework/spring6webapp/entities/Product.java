package guru.springframework.spring6webapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @ManyToMany
    @JoinColumn(name = "category_id")
    private List<Category> categories = new ArrayList<>();

}

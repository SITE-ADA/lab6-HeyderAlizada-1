package az.edu.ada.wm2.lab6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Product> products = new HashSet<>();
}
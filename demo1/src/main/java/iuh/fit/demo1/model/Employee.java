package iuh.fit.demo1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Admin 9/16/2025
 **/
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @ToString.Exclude
    private Department department;

}


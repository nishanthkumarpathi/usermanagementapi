package com.bibf.usermanagementapi.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity /* Marks the class as a database table */
@Table(name = "users")
@Data // PART2.5: @Getter + @Setter + @ToString + @RequiredArgsConstructor + @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor //Required for instantiating an empty object and filling it up in inputs.
public class User {

    @Id /* Set this property as the main table ID column */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Generate this value automatically based on DB type */
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "A Name is required")
    private String name;

    @Column(unique = true, nullable = false) /* Set this property to be unique (in DB)*/
    private String email;

    @Column(nullable = false)
    private String password;

}


// @Component Annotation is used to create a Bean of the Class
// @AllArgsConstructor Annotation is used to create a Constructor with all the Fields in the Class
// @NoArgsConstructor Annotation is used to create a Constructor with no Fields in the Class
// @Getter Annotation is used to create Getters for all the Fields in the Class
// @Setter Annotation is used to create Setters for all the Fields in the Class
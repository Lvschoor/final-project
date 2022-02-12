package be.intecbrussel.finalproject.data;

import javax.persistence.*;

@Entity
public class PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


}

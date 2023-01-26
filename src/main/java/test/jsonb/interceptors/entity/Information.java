package test.jsonb.interceptors.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    String name;
    @Basic
    @Temporal(TemporalType.DATE)
    Date age;


}

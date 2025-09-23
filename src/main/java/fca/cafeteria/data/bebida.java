package fca.cafeteria.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table (name = "bebida")
public class bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idbebida")

}

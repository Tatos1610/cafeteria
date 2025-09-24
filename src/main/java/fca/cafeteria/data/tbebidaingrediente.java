package fca.cafeteria.data;

import jakarta.persistence.*;

@Entity
@Table(name = "tbebidaingrediente")
public class tbebidaingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idbebidaingrediente")
    private int idbebidaingrediente;

    @ManyToOne
    @JoinColumn (name = "idbebida", unique = true, nullable = false)
    private tbebida tbebida;

    @ManyToOne
    @JoinColumn(name = "idingrediente", unique = true, nullable = false)
    private tIngrediente tingrediente;

    @Column (name = "cantidad")
    private String cantidad;
}

package fca.cafeteria.data;

import jakarta.persistence.*;

@Entity
@Table (name = "bebida")
public class tbebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idbebida")
    private int idbebida;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn (name = "idTipoBebida", unique = true, nullable = false)
    private tbebida tbebida;

    @Column (name = "descripcion")
    private String descripcion;

}
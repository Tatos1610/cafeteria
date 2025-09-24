package fca.cafeteria.data;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class tIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idingrediente")
    private int idingrediente;

    @Column(name = "nombre")
    private String nombre;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "costo")
    private String costo;
}

package fca.cafeteria.data;

import jakarta.persistence.*;

public class ttipoebida {

    @Entity
    @Table(name = "ttipobebida")
    public class ttipobebida {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "idttipobebida")
        private int idttipobebida;

        @Column (name = "descripcion")
        private String descripcion;

    }
}

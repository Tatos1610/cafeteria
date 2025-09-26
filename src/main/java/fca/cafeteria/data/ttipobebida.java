package fca.cafeteria.data;

import jakarta.persistence.*;

@Entity
@Table(name = "ttipobebida")
public class ttipobebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idttipobebida")
    private int idttipobebida;

    @Column(name = "descripcion")
    private String descripcion;

    // ========== GETTERS ==========

    /**
     * Obtiene el ID único del tipo de bebida
     * @return ID del tipo de bebida
     */
    public int getIdttipobebida() {
        return idttipobebida;
    }

    /**
     * Obtiene la descripción del tipo de bebida
     * @return Descripción (ej: "Café Caliente", "Té Frío", "Smoothie")
     */
    public String getDescripcion() {
        return descripcion;
    }

    // ========== SETTERS ==========

    /**
     * Establece el ID del tipo de bebida (usado por JPA)
     * @param idttipobebida ID único del tipo
     */
    public void setIdttipobebida(int idttipobebida) {
        this.idttipobebida = idttipobebida;
    }

    /**
     * Establece la descripción del tipo de bebida
     * @param descripcion Descripción del tipo (ej: "Bebida Energética")
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
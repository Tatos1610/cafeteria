package fca.cafeteria.data;

import jakarta.persistence.*;

@Entity
@Table(name = "tbebida")
public class tbebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbebida")
    private int idbebida;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idTipoBebida", nullable = false)
    private ttipobebida tipobebida;  // CORRECCIÓN: Cambié el nombre a 'tipobebida'

    @Column(name = "descripcion")
    private String descripcion;

    // ========== GETTERS ==========

    /**
     * Obtiene el ID único de la bebida
     * @return ID de la bebida
     */
    public int getIdbebida() {
        return idbebida;
    }

    /**
     * Obtiene el nombre de la bebida
     * @return Nombre de la bebida (ej: "Café Americano")
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo de bebida asociado
     * @return Objeto ttipobebida con la información del tipo
     */
    public ttipobebida getTipobebida() {
        return tipobebida;
    }

    /**
     * Obtiene la descripción de la bebida
     * @return Descripción detallada de la bebida
     */
    public String getDescripcion() {
        return descripcion;
    }

    // ========== SETTERS ==========

    /**
     * Establece el ID de la bebida (usado por JPA, no debería usarse manualmente)
     * @param idbebida ID único de la bebida
     */
    public void setIdbebida(int idbebida) {
        this.idbebida = idbebida;
    }

    /**
     * Establece el nombre de la bebida
     * @param nombre Nombre de la bebida (ej: "Té Verde")
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el tipo de bebida (RELACIÓN IMPORTANTE)
     * @param tipobebida Objeto ttipobebida que representa el tipo
     */
    public void setTipobebida(ttipobebida tipobebida) {
        this.tipobebida = tipobebida;
    }

    /**
     * Establece la descripción de la bebida
     * @param descripcion Descripción detallada o características
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
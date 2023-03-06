/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Bryan
 */

@Entity
@Table(name = "Productos")
@Data
@NoArgsConstructor
public class Producto  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "item", nullable = false)
    private String item;
    
    @Column(name = "detalle", nullable = false)
    private String detalle;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
    @Column(name = "percio_unitario", nullable = false)
    private float precioUnitario;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "producto",cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.ALL, CascadeType.REMOVE})
    private List<Factura> facturas;
    
    public Producto(String item, String detalle, int cantidad, float precioUnitario) {
        this.item = item;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    } 
    
    @PrePersist
    void insertDateCreate() {
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    void insertDateUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}

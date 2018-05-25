/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "ADMINISTRATIVO")
public class Administrativo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_ADMINISTRATIVO", nullable = false , length = 10)
    private String codigo;
    
    @Column(name = "NOMBRES", nullable = false , length = 50)
    private String nombres;
    
    @Column(name = "APELLIDOS", nullable = false, length = 50)
    private String apellidos;
    
    @Column(name = "DIRECCION", nullable = false, length = 150)
    private String direccion;
    
    @Column(name = "CORREO_PERSONAL", nullable = false, length = 50)
    private String correoPersonal;
    
    @Column(name = "CORREO_INSTITUCIONAL", nullable = false, length = 50)
    private String correoInstitucional;
    
    @JoinColumn(name = "COD_UNIDAD", referencedColumnName = "COD_UNIDAD", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Unidad codUnidad;

    public Administrativo() {
    }

    public Administrativo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public Unidad getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Unidad codUnidad) {
        this.codUnidad = codUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrativo)) {
            return false;
        }
        Administrativo other = (Administrativo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Administrativo{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", correoPersonal=" + correoPersonal + ", correoInstitucional=" + correoInstitucional + ", codUnidad=" + codUnidad + '}';
    }
    
}

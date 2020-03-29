
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais implements Serializable {

     private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigoPais")
    private int codigodePais;
    
    @Id
    @Column(name = "nombrePais", nullable = false, length = 50)
    private String nombredePais;
    
    @Column(name = "region", nullable = false, length = 50)
    private String region;
    
    @Column(name = "poblacion", nullable = false)
    private Long poblacion;

    @Column(name = "capitaldePais", nullable = false, length = 50)
    private String capitalPais;

    @Column(name = "latitud", nullable = false)
    private double latitud;

    @Column(name = "longitud", nullable = false)
    private double longitud;

    public Pais() {
    }

    public Pais(int codigoPais, String nombrePais, String capitalPais, String region, Long poblacion, double latitud, double longitud) {
        this.codigodePais = codigoPais;
        this.nombredePais = nombrePais;
        this.capitalPais = capitalPais;
        this.region = region;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getCodigodePais() {
        return codigodePais;
    }

    public void setCodigodePais(int codigodePais) {
        this.codigodePais = codigodePais;
    }

    public String getNombredePais() {
        return nombredePais;
    }

    public void setNombredePais(String nombredePais) {
        this.nombredePais = nombredePais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    public String getCapitalPais() {
        return capitalPais;
    }

    public void setCapitalPais(String capitalPais) {
        this.capitalPais = capitalPais;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

   
}

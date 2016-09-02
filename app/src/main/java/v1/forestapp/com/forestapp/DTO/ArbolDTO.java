package v1.forestapp.com.forestapp.DTO;

/**
 * Created by Jesualdo Martinez on 12/08/2016.
 */
public class ArbolDTO {
    private String NombreComun;
    private String NombreCientifico;
    private String Reino;
    private String Filo;
    private String Clase;
    private String Fruto;
    private String Flor;
    private String Descripcion;
    private int imagen;

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombreComun() {
        return NombreComun;
    }

    public void setNombreComun(String nombrecomun) {
        NombreComun = nombrecomun;
    }

    public String getNombreCientifico() {
        return NombreCientifico;
    }

    public void setNombreCientifico(String nombrecientifico) {NombreCientifico = nombrecientifico;}

    public String getReino(){return Reino;}

    public void setReino (String reino){Reino = reino;}

    public String getFilo(){return Filo;}

    public void setFilo (String filo){Filo = filo;}

    public String getClase(){return Clase;}

    public void setClase (String clase){Clase = clase;}

    public String getFruto(){return Fruto;}

    public void setFruto(String fruto){Fruto = fruto;}

    public String getFlor(){return Flor;}

    public void setFlor (String flor){Flor = flor;}

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}

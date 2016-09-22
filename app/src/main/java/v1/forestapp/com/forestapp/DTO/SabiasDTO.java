package v1.forestapp.com.forestapp.DTO;

/**
 * Created by Admin_Sena on 22/09/2016.
 */

public class SabiasDTO {

    private String Nombre;
    private String Descripcion;
    private int imagen;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}

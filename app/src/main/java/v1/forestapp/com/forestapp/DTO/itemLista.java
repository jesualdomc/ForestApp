package v1.forestapp.com.forestapp.DTO;

/**
 * Created by Jesualdo Martinez on 11/08/2016.
 */
public class itemLista {
    private String titulo;
    private String subtitulo;
    private int imagen;

    public itemLista(String titulo, String subtitulo, int imagen) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.imagen = imagen;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

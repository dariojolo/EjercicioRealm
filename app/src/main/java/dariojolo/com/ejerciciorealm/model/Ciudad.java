package dariojolo.com.ejerciciorealm.model;

import android.widget.ImageView;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by rodrigrl on 15/03/2017.
 */

public class Ciudad extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String nombre;
    @Required
    private String descripcion;
    private ImageView imagen;
    private String estrellas;

    public Ciudad() {
    }

    public Ciudad(int id, String nombre, String descripcion, ImageView imagen, String estrellas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estrellas = estrellas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }
}

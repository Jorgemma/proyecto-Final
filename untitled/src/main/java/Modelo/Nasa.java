package Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Nasa {
    private int Id;
    private String Nombre;
    private String Fecha;
    private String Funcion;
    private String Base;
    private String Url;

    public Nasa() {
    }

    public Nasa(int id, String nombre, String fecha, String funcion, String base, String url) {
        Id = id;
        Nombre = nombre;
        Fecha = fecha;
        Funcion = funcion;
        Base = base;
        Url = url;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getFuncion() {
        return Funcion;
    }

    public void setFuncion(String funcion) {
        Funcion = funcion;
    }

    public String getBase() {
        return Base;
    }

    public void setBase(String base) {
        Base = base;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImagen=new URL(this.Url);
        return new ImageIcon(urlImagen);
    }
}

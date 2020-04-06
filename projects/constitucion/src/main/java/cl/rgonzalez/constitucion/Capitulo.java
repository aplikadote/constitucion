/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rgonzalez.constitucion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Capitulo {

    private String id = "";
    private String title = "";
    private List<Seccion> secciones = new ArrayList<>();

    public Capitulo() {
    }

    public Capitulo(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Capitulo(String id, String title, Seccion... list) {
        this.id = id;
        this.title = title;
        this.secciones.addAll(Arrays.asList(list));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    @Override
    public String toString() {
        return "Capitulo{" + "id=" + id + ", title=" + title + '}';
    }

}

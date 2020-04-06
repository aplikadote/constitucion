/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this fragments file, choose Tools | Templates
 * and open the fragments in the editor.
 */
package cl.rgonzalez.constitucion;

/**
 *
 * @author usuario
 */
public class Articulo {

    private String id;
    private String title;
    //
    private Capitulo capitulo;
    private Seccion seccion;
    private int position;
    //
    private String href;
    private String fragment;

    public Articulo() {
    }

    public Articulo(String id, String title) {
        this.id = id;
        this.title = title;
        this.href = "/arts/" + id;
        this.fragment = "fragments/art" + id;
    }

    public Articulo(String id, String title, String href, String fragment) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.fragment = fragment;
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

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getHref() {
        return href;
    }

    public String getFragment() {
        return fragment;
    }

}

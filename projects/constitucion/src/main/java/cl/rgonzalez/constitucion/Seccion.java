/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rgonzalez.constitucion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aplik
 */
public class Seccion {

    private String title = "";
    private List<Articulo> articulos = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("000");

    public Seccion() {
    }

    public Seccion(int start, int end) {
        this("", start, end);
    }

    public Seccion(String title, int start, int end) {
        this.title = title;
        for (int i = start; i <= end; i++) {
            String id = df.format(i);
            articulos.add(new Articulo(id, "Articulo " + i));
        }
    }

    public Seccion(String title, String... ids) {
        this.title = title;

        for (String id : ids) {
            articulos.add(new Articulo(id, "Articulo " + id));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

}

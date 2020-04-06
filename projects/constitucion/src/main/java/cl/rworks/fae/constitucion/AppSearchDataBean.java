/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

/**
 *
 * @author aplik
 */
public class AppSearchDataBean {

    private Articulo articulo;
    private String line;

    public AppSearchDataBean(Articulo articulo, String line) {
        this.articulo = articulo;
        this.line = line;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}

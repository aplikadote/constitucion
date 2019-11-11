/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

import java.util.List;

/**
 *
 * @author usuario
 */
public class Capitulo {
    
    private String code;
    private String title;
    private int start;
    private int end;
    private List<Articulo> articulos;

    public Capitulo() {
    }

    public Capitulo(String code, String title, int start, int end) {
        this.code = code;
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        return "Capitulo{" + "code=" + code + ", title=" + title + ", start=" + start + ", end=" + end + '}';
    }
    
    
}

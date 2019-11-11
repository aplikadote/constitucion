/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

/**
 *
 * @author usuario
 */
public class Articulo {

    private String code;
    private String title;
    private String codeChapter;
    private int number;

    public Articulo() {
    }

    public Articulo(String code, String title, String codeChapter, int number) {
        this.code = code;
        this.title = title;
        this.codeChapter = codeChapter;
        this.number = number;
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

    public String getCodeChapter() {
        return codeChapter;
    }

    public void setCodeChapter(String codeChapter) {
        this.codeChapter = codeChapter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

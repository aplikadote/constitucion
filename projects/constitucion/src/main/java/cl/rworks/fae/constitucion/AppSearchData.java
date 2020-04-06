/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aplik
 */
public class AppSearchData {

    private String text = "";
    private List<AppSearchDataBean> beans = new ArrayList<>();

    public AppSearchData() {
    }

    public AppSearchData(String text, List<AppSearchDataBean> beans) {
        this.text = text;
        this.beans = beans;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<AppSearchDataBean> getBeans() {
        return beans;
    }

    public void setBeans(List<AppSearchDataBean> beans) {
        this.beans = beans;
    }
}

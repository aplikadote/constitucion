/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    AppService service;

    @RequestMapping("/")
    public String home(Model model) {
        Data data = new Data(service.getCapitulos());
        data.setCapitulo(new Capitulo("", "CONSTITUCIÓN POLÍTICA DE LA REPUBLICA DE CHILE"));
        data.setSeccion(new Seccion(""));
        data.setArticulo(new Articulo("", "", "/", "fragments/inicio"));
        model.addAttribute("data", data);
        return "base";
    }

    @RequestMapping("/arts/{id}")
    public String arts(@PathVariable String id, Model model) {
        List<Capitulo> capitulos = service.getCapitulos();
        List<Articulo> arts = service.getArticulos();
        Map<String, Articulo> index = service.getIndex();

        Articulo articulo = index.get(id);
        if (articulo != null) {
            int position = articulo.getPosition();
            Articulo articuloPrev = position - 1 >= 0 ? arts.get(position - 1) : null;
            Articulo articuloNext = position + 1 < arts.size() ? arts.get(position + 1) : null;

            Data data = new Data(capitulos);
            data.setCapitulo(articulo.getCapitulo());
            data.setSeccion(articulo.getSeccion());
            data.setArticulo(articulo);
            data.setArticuloPrev(articuloPrev);
            data.setArticuloNext(articuloNext);
            model.addAttribute("data", data);
            return "base";
        } else {
            Data data = new Data(capitulos);
            data.setError(true);
            data.setCapitulo(new Capitulo("", "Error"));
            data.setSeccion(new Seccion(""));
            data.setArticulo(new Articulo("", "", "/error", "fragments/error"));
            model.addAttribute("data", data);
            return "base";
        }
    }

    @RequestMapping("/ref*")
    public String refs(Model model) {
        Data data = new Data(service.getCapitulos());
        data.setCapitulo(new Capitulo("", "REFERENCIAS"));
        data.setSeccion(new Seccion(""));
        data.setArticulo(new Articulo("", "", "/refs", "fragments/refs"));
        model.addAttribute("data", data);
        return "base";
    }

    @RequestMapping("/publicacion")
    public String publicacion(Model model) {
        Data data = new Data(service.getCapitulos());
        data.setCapitulo(new Capitulo("", "PUBLICACION"));
        data.setSeccion(new Seccion(""));
        data.setArticulo(new Articulo("", "", "/publicacion", "fragments/publicacion"));
        model.addAttribute("data", data);
        return "base";
    }
    
    public class Data {

        private List<Capitulo> capitulos;
        private Capitulo capitulo = null;
        private Seccion seccion = null;
        private Articulo articulo = null;
        private Articulo articuloPrev = null;
        private Articulo articuloNext = null;
        private boolean error = false;

        public Data(List<Capitulo> capitulos) {
            this.capitulos = capitulos;
        }

        public List<Capitulo> getCapitulos() {
            return capitulos;
        }

        public void setCapitulos(List<Capitulo> capitulos) {
            this.capitulos = capitulos;
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

        public Articulo getArticulo() {
            return articulo;
        }

        public void setArticulo(Articulo articulo) {
            this.articulo = articulo;
        }

        public Articulo getArticuloPrev() {
            return articuloPrev;
        }

        public void setArticuloPrev(Articulo articuloPrev) {
            this.articuloPrev = articuloPrev;
        }

        public Articulo getArticuloNext() {
            return articuloNext;
        }

        public void setArticuloNext(Articulo articuloNext) {
            this.articuloNext = articuloNext;
        }

        public boolean getError() {
            return error;
        }

        public void setError(boolean error) {
            this.error = error;
        }

    }

}

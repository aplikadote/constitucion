/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @Autowired
    AppService service;

    @RequestMapping("/")
    public String home(Model model) {
        List<Capitulo> caps = service.getCapitulos();
        model.addAttribute("capitulos", caps);
        model.addAttribute("cid", "00");
        model.addAttribute("ctitle", "CONSTITUCIÓN POLÍTICA DE LA REPUBLICA DE CHILE");
        model.addAttribute("aid", "0");
        model.addAttribute("atitle", "");
        return "search";
    }

    @RequestMapping("/art")
    public String art(@RequestParam String id, Model model) {
        List<Capitulo> caps = service.getCapitulos();
        model.addAttribute("capitulos", caps);

        List<Articulo> arts = new ArrayList<>();
        int pos = 0;
        Map<String, Articulo> index = new HashMap<>();
        for (int i = 0; i < caps.size(); i++) {
            Capitulo c = caps.get(i);
            for (int j = 0; j < c.getSecciones().size(); j++) {
                Seccion s = c.getSecciones().get(j);
                for (int k = 0; k < s.getArticulos().size(); k++) {
                    Articulo a = s.getArticulos().get(k);
                    a.setCapitulo(c);
                    a.setPosition(pos++);

                    arts.add(a);
                    index.put(a.getId(), a);
                }
            }
        }

        Articulo articulo = index.get(id);
        if (articulo != null) {
            String cid = articulo.getCapitulo().getId();
            int position = articulo.getPosition();

            String prevId = position - 1 >= 0 ? arts.get(position - 1).getId() : "";
            String nextId = position + 1 < arts.size() ? arts.get(position + 1).getId() : "";
            String prevTitle = position - 1 >= 0 ? arts.get(position - 1).getTitle() : "";
            String nextTitle = position + 1 < arts.size() ? arts.get(position + 1).getTitle() : "";

            model.addAttribute("cid", cid);
            model.addAttribute("ctitle", articulo.getCapitulo().getTitle());
            model.addAttribute("aid", id);
            model.addAttribute("atitle", "Artículo " + id);
            model.addAttribute("prevId", prevId);
            model.addAttribute("nextId", nextId);
            model.addAttribute("prevTitle", prevTitle);
            model.addAttribute("nextTitle", nextTitle);
            return "search";
        } else {
            model.addAttribute("error", "error");
            return "search";
        }
    }

    @RequestMapping("/refs*")
    public String refs(Model model) {
        List<Capitulo> caps = service.getCapitulos();
        model.addAttribute("capitulos", caps);
        model.addAttribute("cid", "00");
        model.addAttribute("ctitle", "REFERENCIAS");
        model.addAttribute("aid", "refs");
        model.addAttribute("atitle", "");
        return "search";
    }

//    @RequestMapping("/cap")
//    public String cap(@RequestParam String id, Model model) {
//        List<Capitulo> caps = service.getCapitulos();
//        model.addAttribute("capitulos", caps);
//
//        try {
//            int capituloId = Integer.parseInt(id);
//            if (capituloId >= 0 && capituloId <= 15) {
//                String nro = capituloId < 10 ? "0" + capituloId : Integer.toString(capituloId);
//                model.addAttribute("cid", nro);
//                model.addAttribute("aid", -1);
//                return "search";
//            } else {
//                return "notfound";
//            }
//        } catch (NumberFormatException e) {
//            return "notfound";
//        }
//    }
//    @RequestMapping("/error")
//    public String error(Model model) {
//        List<Capitulo> caps = service.getCapitulos();
//        model.addAttribute("capitulos", caps);
//        return "error";
//    }
}
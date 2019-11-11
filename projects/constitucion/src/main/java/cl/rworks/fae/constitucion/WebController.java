/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.templateresource.ITemplateResource;
import org.thymeleaf.templateresource.StringTemplateResource;

@Controller
public class WebController {

    @Autowired
    AppService service;

    @RequestMapping("/")
    public String home(Model model) {
        List<Capitulo> caps = service.getCapitulos();
        model.addAttribute("capitulos", caps);
        return "home";
    }

//    @RequestMapping("/{capitulo}/{articulo}")
//    public String articulo(@PathVariable String capitulo, @PathVariable String articulo, Model model) {
    @RequestMapping("/search")
    public String search(@RequestParam String articulo, Model model) {
        List<Capitulo> caps = service.getCapitulos();
        model.addAttribute("capitulos", caps);

        try {
            int nro = Integer.parseInt(articulo);

            Map<Integer, String> map = new HashMap<>();
            caps.stream().flatMap(x -> x.getArticulos().stream()).forEach(a -> map.put(a.getNumber(), a.getCodeChapter()));
            String capitulo = map.get(nro);

            if (nro >= 1 && nro <= 129) {
                model.addAttribute("capitulo", capitulo);
                model.addAttribute("articulo", articulo);
                return "search";
            } else {
                return "notfound";
            }
        } catch (NumberFormatException e) {
            return "notfound";
        }
    }

//    @RequestMapping("/error")
//    public String error(Model model) {
//        List<Capitulo> caps = service.getCapitulos();
//        model.addAttribute("capitulos", caps);
//        return "error";
//    }
}

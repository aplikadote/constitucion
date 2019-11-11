/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/home")
    public String router() {
        return "home";
    }

    @RequestMapping("/{capitulo}/{articulo}")
    public String articulo(@PathVariable String capitulo, @PathVariable String articulo) {
        return "web" + "/" + capitulo + "/" + articulo;
    }
}

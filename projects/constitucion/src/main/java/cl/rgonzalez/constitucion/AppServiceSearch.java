/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rgonzalez.constitucion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AppServiceSearch {

    @Autowired
    AppService app;
    @Autowired
    ResourceLoader resourceLoader;

    public List<AppSearchDataBean> search(String text) {
        List<AppSearchDataBean> results = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return results;
        }

        for (Capitulo capitulo : app.getCapitulos()) {
            List<Seccion> secciones = capitulo.getSecciones();
            for (Seccion seccion : secciones) {
                List<Articulo> articulos = seccion.getArticulos();
                for (Articulo articulo : articulos) {
                    try {
//                        Resource resource = new ClassPathResource("/templates/" + articulo.getFragment() + ".html");
                        Resource resource = resourceLoader.getResource("classpath:/templates/" + articulo.getFragment() + ".html");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
                        List<String> lines = reader.lines().collect(Collectors.toList());
                        for (String line : lines) {
                            if (line.contains(text)) {
                                results.add(new AppSearchDataBean(articulo, line));
                                break;
                            }
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        return results;
    }

}

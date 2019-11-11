/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rworks.fae.constitucion;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    public List<Capitulo> getCapitulos() {
        List<Capitulo> caps = new ArrayList<>();
        caps.add(new Capitulo("capitulo01", "CAPITULO I BASES DE LA INSTITUCIONALIDAD", 1, 9));
        caps.add(new Capitulo("capitulo02", "CAPITULO II NACIONALIDAD Y CIUDADANIA", 10, 18));
        caps.add(new Capitulo("capitulo03", "CAPITULO III DE LOS DERECHOS Y DEBERES CONSTITUCIONALES", 19, 23));
        caps.add(new Capitulo("capitulo04", "CAPITULO IV GOBIERNO", 24, 45));
        caps.add(new Capitulo("capitulo05", "CAPITULO V CONGRESO NACIONAL", 46, 75));
        caps.add(new Capitulo("capitulo06", "CAPITULO VI PODER JUDICIAL", 76, 82));
        caps.add(new Capitulo("capitulo07", "CAPITULO VII MINISTERIO PUBLICO", 83, 91));
        caps.add(new Capitulo("capitulo08", "CAPITULO VIII TRIBUNAL CONSTITUCIONAL", 92, 94));
        caps.add(new Capitulo("capitulo09", "CAPITULO IX JUSTICIA ELECTORAL", 95, 97));
        caps.add(new Capitulo("capitulo10", "CAPITULO X CONTRALORIA GENERAL DE LA REPUBLICA", 98, 100));
        caps.add(new Capitulo("capitulo11", "CAPITULO XI FUERZAS ARMADAS, DE ORDEN Y SEGURIDAD PÚBLICA", 101, 105));
        caps.add(new Capitulo("capitulo12", "CAPITULO XII CONSEJO DE SEGURIDAD NACIONAL", 106, 107));
        caps.add(new Capitulo("capitulo13", "CAPITULO XIII BANCO CENTRAL", 108, 109));
        caps.add(new Capitulo("capitulo14", "CAPITULO XIV GOBIERNO Y ADMINISTRACION INTERIOR DEL ESTADO", 110, 126));
        caps.add(new Capitulo("capitulo15", "CAPITULO XV REFORMA DE LA CONSTITUCION", 127, 129));

        caps.stream().forEach(x -> {

            List<Articulo> articulos = new ArrayList<>();
            for (int i = x.getStart(); i <= x.getEnd(); i++) {
                String art = i < 10 ? "00" + i : i < 100 ? "0" + i : Integer.toString(i);
                articulos.add(new Articulo("articulo" + art, "Articulo " + i, x.getCode(), i));
            }
            x.setArticulos(articulos);

        });
        return caps;
    }

}

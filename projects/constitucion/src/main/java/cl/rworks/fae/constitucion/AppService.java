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
        caps.add(new Capitulo("01", "CAPITULO I BASES DE LA INSTITUCIONALIDAD", new Seccion(1, 9)));
        caps.add(new Capitulo("02", "CAPITULO II NACIONALIDAD Y CIUDADANIA", new Seccion(10, 18)));
        caps.add(new Capitulo("03", "CAPITULO III DE LOS DERECHOS Y DEBERES CONSTITUCIONALES", new Seccion(19, 23)));
        
        caps.add(new Capitulo("04", "CAPITULO IV GOBIERNO",
                new Seccion("Presidente de la República", 24, 32),
                new Seccion("Ministros de Estado", "33", "34", "35", "36", "37", "37bis"),
                new Seccion("Bases Generales de la Administración del Estado", 38, 38),
                new Seccion("Estados de Excepción Constitucional", 39, 45)
        ));
        
        caps.add(new Capitulo("05", "CAPITULO V CONGRESO NACIONAL",
                new Seccion(46, 46),
                new Seccion("Composición y generación de la Cámara de Diputados y del Senado", 47, 51),
                new Seccion("Atribuciones exclusivas de la Cámara de Diputados", 52, 52),
                new Seccion("Atribuciones exclusivas del Senado", 53, 53),
                new Seccion("Atribuciones exclusivas del Congreso", 54, 54),
                new Seccion("Funcionamiento del Congreso", "55", "56", "56bis"),
                new Seccion("Normas comunes para los Diputados y Senadores", 57, 62),
                new Seccion("Materias de Ley", 63, 64),
                new Seccion("Formación de la Ley", 65, 72)
        ));

        caps.add(new Capitulo("06", "CAPITULO VI PODER JUDICIAL", new Seccion(76, 82)));
        caps.add(new Capitulo("07", "CAPITULO VII MINISTERIO PUBLICO", new Seccion(83, 91)));
        caps.add(new Capitulo("08", "CAPITULO VIII TRIBUNAL CONSTITUCIONAL", new Seccion(92, 94)));
        
        caps.add(new Capitulo("09", "CAPITULO IX SERVICIO ELECTORAL Y JUSTICIA ELECTORAL", new Seccion("", "94bis", "95", "96", "97")));
        
        caps.add(new Capitulo("10", "CAPITULO X CONTRALORIA GENERAL DE LA REPUBLICA", new Seccion(98, 100)));
        caps.add(new Capitulo("11", "CAPITULO XI FUERZAS ARMADAS, DE ORDEN Y SEGURIDAD PÚBLICA", new Seccion(101, 105)));
        caps.add(new Capitulo("12", "CAPITULO XII CONSEJO DE SEGURIDAD NACIONAL", new Seccion(106, 107)));
        caps.add(new Capitulo("13", "CAPITULO XIII BANCO CENTRAL", new Seccion(108, 109)));
        
        caps.add(new Capitulo("14", "CAPITULO XIV GOBIERNO Y ADMINISTRACION INTERIOR DEL ESTADO",
                new Seccion("Gobierno y Administración Regional", "111", "112", "113", "114", "115", "115bis"),
                new Seccion("Gobierno y Administración Provincial", 116, 117),
                new Seccion("Administración Comunal", 118, 122),
                new Seccion("Disposiciones Generales", 123, 126),
                new Seccion("Disposiciones Especiales", "126bis")
        ));
        
        caps.add(new Capitulo("15", "CAPITULO XV REFORMA DE LA CONSTITUCION", new Seccion(127, 129)));

        return caps;
    }

}

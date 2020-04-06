/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rgonzalez.constitucion;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author aplik
 */
public class AppRunner {

    private File dirInput = new File("D:\\trabajo\\aplikadote\\constitucion\\projects\\constitucion\\src\\main\\resources\\templates\\capitulos");
    private File dirOutput = new File("D:\\temp");

    public void run() throws Exception {
//        File[] files = dirInput.listFiles();
//        for (File file : files) {
//            System.out.println(file);
//        }

        File file = new File(dirInput, "capitulo16.html");
        List<String> lines = Files.readAllLines(file.toPath());
//        lines.forEach(System.out::println);

        Pattern p1 = Pattern.compile("<div.*");
        Pattern p2 = Pattern.compile("</div>");

        String id = "";
        List<String> aux = null;
        for (String line : lines) {
            if (p1.matcher(line).matches()) {
                id = line.split("=")[1];
                id = id.substring(1, id.length() - 2);
                aux = new ArrayList<>();
            }

            if (p2.matcher(line).matches()) {
                aux.add(line);
                Files.write(new File(dirOutput, "art" + id + ".html").toPath(), aux, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
                aux = null;
            }

            if (aux != null) {
                aux.add(line);
            }

        }

//        String m = "<div th:fragment";
//        Pattern p = Pattern.compile("<div.*");
//        Matcher matcher = p.matcher(m);
//        if(matcher.matches()){
//            System.out.println(m);
//        }
    }

    public static void main(String[] args) {
        try {
            AppRunner runner = new AppRunner();
            runner.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

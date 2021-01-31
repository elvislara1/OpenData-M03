package com.company;

import com.opencsv.bean.CsvToBean;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void consultas(CsvToBean<Nacimiento> nacimientoCsvToBean) {
        System.out.println("                 OPEN-DATA-NACIDOS-2008                 ");
        System.out.println("--------------------------------------------------------");
        System.out.println("1.  Todos los barrios registrados (sin repeticiones)");
        System.out.println("2.  La nacionalidad de las madres");
        System.out.println("3.  Numero de niños con madres españolas");
        System.out.println("4.  El numero total de los nacidos en el año 2008");
        System.out.println("5.  Nacidos en \"Les Corts\"");
        System.out.println("6.  Buscar un distrito en concreto");
        System.out.println("7.  Buscar un barrio en concreto");
        System.out.println("8.  Distritos ordenados alfabeticamente:");
        System.out.println("0.  Salir");
        System.out.println("--------------------------------------------------------");
        System.out.println("ELIJA UNA OPCIÓN \n");
        int opcion = scanner.nextInt();

        CsvToBean<Nacimiento> lista = nacimientoCsvToBean;
        switch(opcion){
            case 1:
                //Distinct
                lista.stream().map(Nacimiento::getnom_barri).distinct().forEach(System.out::println);
                break;

            case 2:
                //Map
                lista.stream().map(Nacimiento::getlloc_de_naixement).distinct().forEach(System.out::println);
                break;

            case 3:
                //Filter
                System.out.println(lista.stream().filter(nacimiento -> nacimiento.getlloc_de_naixement().contains("Espanya")).count());
                break;

            case 4:
                //Count
                System.out.println(lista.stream().map(Nacimiento::getNombre).count());
                break;

            case 5:
                //Filter
                lista.stream().filter(nacimiento -> nacimiento.getnom_districte().contains("Les Corts")).forEach(System.out::println);
                break;

            case 6:
                //Filter
                System.out.println("Introduce el nombre del distrito:");
                scanner.nextLine();
                String nombreDistrito = scanner.nextLine();
                lista.stream().filter(nacimiento -> nacimiento.getnom_districte().equals(nombreDistrito)).distinct().forEach(System.out::println);
                break;

            case 7:
                //anyMatch
                System.out.println("Introduce el nombre del barrio: ");
                scanner.nextLine();
                String barrio = scanner.nextLine();
                System.out.println(lista.stream().anyMatch(nacimiento -> nacimiento.getnom_barri().equals(barrio)));
                break;

            case 8:
                //Collections - distinct
                System.out.println("Distritos ordenados alfabeticamente: \n");

                List<String> alfabeticamente = new ArrayList<>();
                for (Nacimiento distritos: lista) {
                    alfabeticamente.add(distritos.getnom_districte());
                }

                Collections.sort(alfabeticamente);
                List<String> distinctElements = alfabeticamente.stream().distinct().collect(Collectors.toList());

                for (String distritos : distinctElements) {
                    System.out.println(distritos);
                }
                break;

            case 9:
                //Comparator - sorted
                lista.stream().sorted(Comparator.comparing(Nacimiento::getNombre).reversed()).forEach(System.out::println);
                break;
            case 0:
                System.out.println("Saliendo......");
            break;
        }
    }
}

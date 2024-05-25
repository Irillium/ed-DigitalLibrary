package com.iesam.digitallibrary.features.digitalResource.presentation;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.presentation.DigitalBookPresentation;

import java.util.Scanner;

public class DigitalResourcePresentation {
    public static void digitalResourceMenu(){
        int select=-1;
        while(select!=0){
            Scanner scan = new Scanner(System.in);
            System.out.println("----------------------------------------");
            System.out.println("--------MENÚ RECURSOS DIGITALES---------");
            System.out.println("----------------------------------------");
            System.out.println("\t[1] LIBROS DIGITALES");
            System.out.println("\t[0] Salir");
            System.out.println("----------------------------------------");
            select=scan.nextInt();
            switch (select){
                case 1:
                    DigitalBookPresentation.digitalBookMenu();
                    break;
                case 0:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("Esa opción no existe");
            }
        }
    }
}

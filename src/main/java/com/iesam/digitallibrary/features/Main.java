package com.iesam.digitallibrary.features;

import com.iesam.digitallibrary.features.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       int select=-1;
       System.out.println("¡Hola! Bienvenido a Ditilal Library");
       System.out.println("¿Qué desea hacer?");
       while (select!=0){
           System.out.println("\t[0] Salir");
           System.out.println("\t[1] Menú Usuario");
           System.out.println("-------------------------");
           select=scan.nextInt();
           switch (select){
               case 0:
                   break;
               case 1:
                   UserPresentation.userMenu();
                   break;
               default:
           }
       }
    }
}
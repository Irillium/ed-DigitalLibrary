package com.iesam.digitallibrary.features.digitalBook.presentation;

import com.iesam.digitallibrary.features.digitalBook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.features.digitalBook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.features.digitalBook.domain.DeleteDigitalBookUseCase;
import com.iesam.digitallibrary.features.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.digitalBook.domain.SaveDigitalBookUseCase;

import java.util.Scanner;

public class DigitalBookPresentation {
    public static void digitalBookMenu(){
        Scanner scan = new Scanner(System.in);
        int select=-1;
        while(select!=0) {
            System.out.println("------------------------------------");
            System.out.println("-----MENÚ DE RECURSOS DIGITALES-----");
            System.out.println("------------------------------------");
            System.out.println("\t [1] Registrar un libro digital.");
            System.out.println("\t [2] Eliminar un libro digital.");
            System.out.println("\t [0] Salir");
            System.out.println("------------------------------------");

            select = scan.nextInt();
            switch (select) {
                case 0:
                    break;
                case 1:
                    save();
                    break;
                case 2:
                    delete();
                    System.out.println("Libro eliminado");
                    break;
                default:
                    System.out.println("Lo sentimos pero esa opción no existe");
            }
        }

    }

    private static void save() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el idbn del libro digital");
        String idbn = scan.nextLine();
        System.out.println("Introduce el titulo");
        String title = scan.nextLine();
        System.out.println("Introduce el autor");
        String author = scan.nextLine();
        System.out.println("Introduce la editorial");
        String publisher = scan.nextLine();
        System.out.println("Introduce el/los genero/s");
        String genre = scan.nextLine();
        System.out.println("Introduce la sinopsis");
        String synopsis = scan.nextLine();
        System.out.println("Introduce el número de páginas que tiene");
        String pageCount = scan.nextLine();

        DigitalBook book = new DigitalBook(idbn,title,author,publisher,genre,synopsis,pageCount);
        SaveDigitalBookUseCase saveDigitalBookUseCase= new SaveDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        saveDigitalBookUseCase.execute(book);
    }
    private static void delete() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el idbn del libro digital que desea eliminar");
        String idbn = scan.nextLine();

        DeleteDigitalBookUseCase deleteDigitalBookUseCase = new DeleteDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        deleteDigitalBookUseCase.execute(idbn);
    }
}

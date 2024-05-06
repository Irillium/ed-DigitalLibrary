package com.iesam.digitallibrary.features.digitalBook.presentation;

import com.iesam.digitallibrary.features.digitalBook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.features.digitalBook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.features.digitalBook.domain.*;

import java.util.ArrayList;
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
            System.out.println("\t [3] Modificar un libro digital.");
            System.out.println("\t [4] Ver lista.");

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
                    System.out.println("LIBRO ELIMINADO");
                    break;
                case 3:
                    modify();
                    System.out.println("LIBRO MODIFICADO");
                    break;
                case 4:
                    obtains();
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
    private  static void modify(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el idbn del libro digital que desea modificar");
        String idbn = scan.nextLine();
        System.out.println("Introduce el nuevo titulo");
        String title = scan.nextLine();
        System.out.println("Introduce el nuevo autor");
        String author = scan.nextLine();
        System.out.println("Introduce la nueva editorial");
        String publisher = scan.nextLine();
        System.out.println("Introduce el/los nuevo/s genero/s");
        String genre = scan.nextLine();
        System.out.println("Introduce la nuevo sinopsis");
        String synopsis = scan.nextLine();
        System.out.println("Introduce el nuevo número de páginas que tiene");
        String pageCount = scan.nextLine();

        DigitalBook book = new DigitalBook(idbn,title,author,publisher,genre,synopsis,pageCount);
        ModifyDigitalBookUseCase modifyDigitalBookUseCase = new ModifyDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        modifyDigitalBookUseCase.execute(idbn,book);

    }
    public static void obtains(){
        GetDigitalBooksUseCase getDigitalBooksUseCase=new GetDigitalBooksUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        ArrayList<DigitalBook> bookList = getDigitalBooksUseCase.execute();
        int indice = 0;
        System.out.println("\tLISTA DE LIBROS DIGITALES REGISTRADOS\n");
        System.out.printf("%-5s %-10s %-40s %-15s %-10s %-20s %-65s %-5s\n", " ","ISBN", "TITULO", "AUTOR", "EDITORIAL", "GENERO", "SINOPSIS","Nº PAGINAS");
        for ( DigitalBook book : bookList) {
            indice++;
            System.out.printf("%-5s %-10s %-40s %-15s %-10s %-20s %-65s %-5s \n", indice,
                    (book.getIdbn() != null ? book.getIdbn() : " "),
                    (book.getTitle() != null ? book.getTitle(): " "),
                    (book.getAuthor() != null ? book.getAuthor() : " "),
                    (book.getPublisher() != null ? book.getPublisher() : " "),
                    (book.getGenre() != null ? book.getGenre() : " "),
                    (book.getSynopsis() != null ? book.getSynopsis() : ""),
                    (book.getPageCount() != null ? book.getPageCount() : ""));
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("\n--Introduce cualquier caracter para volver al menú--");
        String c = scan.next();
        System.out.println();
    }

}

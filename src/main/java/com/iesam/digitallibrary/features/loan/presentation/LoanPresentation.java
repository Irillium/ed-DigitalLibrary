package com.iesam.digitallibrary.features.loan.presentation;

import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.GetDigitalBookUseCase;
import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.features.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.features.loan.domain.*;
import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.features.user.domain.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LoanPresentation {
    static LoanDataRepository loanDataRepository= new LoanDataRepository(new LoanFileLocalDataSource());

    public static void loanMenu(){
        int select=-1;
        while(select!=0){
            Scanner scan = new Scanner(System.in);
            System.out.println("-----------------------------------------------");
            System.out.println("-----------------MENÚ PRESTAMOS----------------");
            System.out.println("-----------------------------------------------");
            System.out.println("\t[1] Registrar un prestamo");
            System.out.println("\t[2] Eliminar un prestamo");
            System.out.println("\t[3] Devolver prestamo");
            System.out.println("\t[4] Lista de prestamos no devueltos");
            System.out.println("\t[5] Lista de prestamos finalizados");
            System.out.println("\t[0] Salir");
            System.out.println("-----------------------------------------------");
            select=scan.nextInt();
            switch (select){
                case 0:
                    break;
                case 1:
                    save();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    returnLoan();
                    break;
                case 4:
                    unfinishedList();
                    break;
                case 5:
                    completedList();
                    break;
                default:
                    System.out.println("Esa opción no existe");
            }
        }
    }
    private static void save(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el identificador del prestamo");
        String id=scan.nextLine();
        System.out.println("Introduce tu dni");
        String dni=scan.nextLine();
        GetUserUseCase getUserUseCase= new GetUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        User user=getUserUseCase.execute(dni);
        if(user==null){
            while(true){
                System.out.println("El usuario no existe, introduzca otro dni");
                dni=scan.nextLine();
                user=getUserUseCase.execute(dni);
                if(user!=null){
                    System.out.println("Ese si existe");
                    break;
                }
            }
        }
        System.out.println("Introduce el código del recurso digital(isbn)");
        String isbn=scan.nextLine();
        GetDigitalBookUseCase getDigitalBookUseCase= new GetDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        DigitalBook digitalBook= getDigitalBookUseCase.execute(isbn);
        if(digitalBook==null){
            while(true){
                System.out.println("El libro no existe, introduzca otro codigo");
                isbn=scan.nextLine();
                digitalBook= getDigitalBookUseCase.execute(isbn);
                if(digitalBook!=null){
                    System.out.println("Ese si existe");
                    break;
                }
            }
        }
        System.out.println("Introduce la fecha en la que se realiza del prestamo");
        String starDate=scan.nextLine();
        System.out.println("Introduce la fecha de devolución  del prestamo");
        String endDate=scan.nextLine();

        Loan loan=new Loan(id,user,digitalBook,starDate,endDate);
        CreateLoanUserCase createLoanUserCase= new CreateLoanUserCase(loanDataRepository);
        createLoanUserCase.execute(loan);


    }
    private static void delete(){
        System.out.println("Introduce el id del prestamo a eliminar");
        Scanner scan = new Scanner(System.in);
        String id= scan.nextLine();
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(loanDataRepository);
        deleteLoanUseCase.execute(id);
    }
    private static void unfinishedList(){
        GetLoansUnfinishedUseCase getLoansUnfinishedUseCase=new GetLoansUnfinishedUseCase(loanDataRepository);
        ArrayList<Loan> loans = getLoansUnfinishedUseCase.execute();

        // Mostrar los préstamos por consola
        System.out.println("---------------LISTADO DE PRESTAMOS NO DEVUELTOS---------------");
        System.out.printf("%-10s %-15s %-30s %-30s %-30s %-12s\n",
                "  ID", "  Usuario", "  Libro", "Fecha Préstamo", "Fecha Límite", "Fecha Devolución");
        System.out.println("------------------------------------------------------------------------------");

        for (Loan loan : loans) {
            System.out.printf("%-10s | %-15s | %-35s | %-20s | %-20s | %-12s\n",
                    loan.getId(), loan.getUser().getName(), loan.getDigitalResource().getName(),
                    loan.getLoanDate(), loan.getDeadline(), "No devuelto");
        }
        System.out.println("-------------------------------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("\n--Introduce cualquier caracter para volver al menú--");
        String c = scan.next();
        System.out.println();
    }
    private static void completedList(){
        GetCompletedLoansUserCase getCompletedLoansUserCase=new GetCompletedLoansUserCase(loanDataRepository);
        ArrayList<Loan> loans = getCompletedLoansUserCase.execute();

        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------LISTADO DE PRESTAMOS FINALIZADOS--------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-35s %-20s %-15s %-15s\n",
                "  ID", "  Usuario", "          Libro", "   Fecha Préstamo", "  Fecha Límite", "    Fecha Devolución");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        for (Loan loan : loans) {
            System.out.printf("%-10s | %-15s | %-35s | %-15s | %-15s | %-12s\n",
                    loan.getId(), loan.getUser().getName(), loan.getDigitalResource().name,
                    loan.getLoanDate(), loan.getDeadline(), loan.getReturnDate());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("\n--Introduce cualquier caracter para volver al menú--");
        String c = scan.next();
        System.out.println();
    }
    private static void returnLoan(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el identificador del prestamo que quieres finalizar");
        String isbn = scan.nextLine();
        System.out.println("Introduce la fecha en la que se esta devolviendo (DD/MM/AAAA)");
        String finishDate = scan.nextLine();
        ReturnLoanUseCase returnLoanUseCase=new ReturnLoanUseCase(loanDataRepository);
        returnLoanUseCase.execute(isbn,finishDate);
    }
}

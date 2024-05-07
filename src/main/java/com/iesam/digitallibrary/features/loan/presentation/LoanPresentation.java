package com.iesam.digitallibrary.features.loan.presentation;

import com.iesam.digitallibrary.features.digitalBook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.features.digitalBook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.features.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.features.digitalBook.domain.GetDigitalBookUseCase;
import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.features.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.features.loan.domain.CreateLoanUserCase;
import com.iesam.digitallibrary.features.loan.domain.DeleteLoanUseCase;
import com.iesam.digitallibrary.features.loan.domain.Loan;
import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.features.user.domain.User;

import java.util.Scanner;

public class LoanPresentation {
    static LoanDataRepository loanDataRepository= new LoanDataRepository(new LoanFileLocalDataSource());

    public static void loanMenu(){
        int select=-1;
        while(select!=0){
            Scanner scan = new Scanner(System.in);
            System.out.println("-------Menú Prestamos-------");
            System.out.println("[1] Registrar un prestamo");
            System.out.println("[2] Eliminar un prestamo");
            System.out.println("[0] Salir");
            System.out.println("----------------------------");
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
}

package com.iesam.digitallibrary.features.user.presentation;

import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.domain.SaveUserUseCase;
import com.iesam.digitallibrary.features.user.domain.User;

import java.util.Scanner;

public class UserPresentation {
    public static void userMenu(){
        Scanner scan = new Scanner(System.in);
        int select=-1;

        while(select!=0){
            System.out.println("-------------------------");
            System.out.println("\t [1] Registrar Usuario");
            System.out.println("\t [2] Modificar Usuario");
            System.out.println("\t [3] Eliminal Usuario");
            System.out.println("\t [0] Salir");
            System.out.println("-------------------------");
            select = scan.nextInt();
            switch (select){
                case 1:
                    save();
                    break;
                default:
                    System.out.println("Lo sentimos pero esa opción no existe");
            }
        }
    }
    public static void save(){
        SaveUserUseCase saveUserUseCase = new SaveUserUseCase(new UserDataRepository());
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca su dni");
        String dni= scan.nextLine();
        System.out.println("Introduzca su nombre");
        String name= scan.nextLine();
        System.out.println("Introduzca su apellidos");
        String surnames= scan.nextLine();
        System.out.println("Introduzca su correo");
        String email= scan.nextLine();
        System.out.println("Introduzca su telefono");
        String phone= scan.nextLine();
        System.out.println("Introduzca su fecha de nacimiento en formato DD/MM/AAAA");
        String birthDate= scan.nextLine();
        User user = new User(dni,name,surnames,email,phone,birthDate);
        saveUserUseCase.execute(user);
    }
}

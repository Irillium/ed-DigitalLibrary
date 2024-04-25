package com.iesam.digitallibrary.features.user.presentation;

import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.domain.*;

import java.util.ArrayList;
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
            System.out.println("\t [4] Obtener Listado de usuarios existentes");
            System.out.println("\t [0] Salir");
            System.out.println("-------------------------");
            select = scan.nextInt();
            switch (select){
                case 0:
                    break;
                case 1:
                    save();
                    break;
                case 2:
                    modify();
                    System.out.println("Usuario modificado");
                    break;
                case 3:
                    delete();
                    System.out.println("Usuario eliminado");
                    break;
                case 4:
                    System.out.println("  LISTADO DE USUARIOS REGISTRADOS\n");
                    obtains();
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
    public static void delete(){
        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(new UserDataRepository());
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el dni del usuario que quieres eliminar");
        String dni = scan.nextLine();
        deleteUserUseCase.execute(dni);
    }
    public static void modify(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el dni del usuario que quieres modificar");
        String dni = scan.nextLine();
        System.out.println("Intruduce el nuevo nombre(o el que ya tenia)");
        String name = scan.nextLine();
        System.out.println("Introduce los nuevos apellidos(o el que ya tenia)");
        String surnames = scan.nextLine();
        System.out.println("Intruduce el nuevo correo(o el que ya tenia)");
        String email = scan.nextLine();
        System.out.println("Intruduce el nuevo telefono(o el que ya tenia)");
        String phone = scan.nextLine();
        System.out.println("Intruduce la nueva fecha de nacimiento(o el que ya tenia)");
        String birthDate = scan.nextLine();
        User userModify = new User(dni,name,surnames,email,phone,birthDate);
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(new UserDataRepository());
        modifyUserUseCase.execute(dni,userModify);
    }
    public static void obtains(){
        GetUsersUseCase getUsersUseCase=new GetUsersUseCase(new UserDataRepository());
        ArrayList<User> listaUsuarios = getUsersUseCase.execute();
        int indice=0;
        for(User user: listaUsuarios){
            indice++;
            System.out.println("\tDNI\tNOMBRE\tAPELLIDOS\tCORREO\tTELEFONO\tF. NACIMIENTO");
            System.out.println(indice + "\t"+user.getDni()+"\t"+user.getName()+"\t"+user.getSurnames()+"\t"+user.getEmail()+"\t"+user.getPhone()+"\t"+user.getBirthDate());
        }

    }
}

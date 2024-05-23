package com.iesam.digitallibrary.features.user.presentation;

import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPresentation {
    private static UserDataRepository userDataRepository=new UserDataRepository(new UserFileLocalDataSource());
    public static void userMenu(){
        Scanner scan = new Scanner(System.in);
        int select=-1;

        while(select!=0){
            System.out.println("------------------------------------------------");
            System.out.println("---------------MENÚ DE USUARIO------------------");
            System.out.println("------------------------------------------------");
            System.out.println("\t [1] Registrar Usuario");
            System.out.println("\t [2] Modificar Usuario");
            System.out.println("\t [3] Eliminar Usuario");
            System.out.println("\t [4] Obtener un usuario");
            System.out.println("\t [5] Obtener Listado de usuarios existentes");
            System.out.println("\t [0] Salir");
            System.out.println("-----------------------------------------------");
            select = scan.nextInt();
            switch (select){
                case 0:
                    break;
                case 1:
                    save();
                    break;
                case 2:
                    modify();
                    System.out.println("USUARIO MODIFICADO");
                    break;
                case 3:
                    delete();
                    System.out.println("USUARIO ELIMINADO");
                    break;
                case 4:
                    obtain();
                    break;
                case 5:
                    obtains();
                    break;
                default:
                    System.out.println("Lo sentimos pero esa opción no existe");
            }
        }
    }
    private static void save(){
        SaveUserUseCase saveUserUseCase = new SaveUserUseCase(userDataRepository);
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
    private static void delete(){
        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(userDataRepository);
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el dni del usuario que quieres eliminar");
        String dni = scan.nextLine();
        deleteUserUseCase.execute(dni);
    }
    private static void modify(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el dni del usuario que quieres modificar");
        String dni = scan.nextLine();
        System.out.println("Intruduce el nuevo nombre(o el que ya tenía)");
        String name = scan.nextLine();
        System.out.println("Introduce los nuevos apellidos(o el que ya tenía)");
        String surnames = scan.nextLine();
        System.out.println("Intruduce el nuevo correo(o el que ya tenía)");
        String email = scan.nextLine();
        System.out.println("Intruduce el nuevo telefono(o el que ya tenía)");
        String phone = scan.nextLine();
        System.out.println("Intruduce la nueva fecha de nacimiento(o el que ya tenía)");
        String birthDate = scan.nextLine();
        User userModify = new User(dni,name,surnames,email,phone,birthDate);
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(userDataRepository);
        modifyUserUseCase.execute(dni,userModify);
    }
    private static void obtain(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el dni de usuario que desea buscar");
        String dni= scan.nextLine();
        GetUserUseCase getUserUseCase= new GetUserUseCase(userDataRepository);
        User user=getUserUseCase.execute(dni);
        if(user!=null){
            System.out.printf("%-5s %-15s %-10s %-20s %-20s %-15s %-10s\n", " ","DNI", "NOMBRE", "APELLIDOS", "CORREO", "TELEFONO", "F. NACIMIENTO");
                System.out.printf("%-15s %-10s %-20s %-20s %-15s %-10s\n",
                        (user.getDni() != null ? user.getDni() : " "),
                        (user.getName() != null ? user.getName() : " "),
                        (user.getSurnames() != null ? user.getSurnames() : " "),
                        (user.getEmail() != null ? user.getEmail() : " "),
                        (user.getPhone() != null ? user.getPhone() : " "),
                        (user.getBirthDate() != null ? user.getBirthDate() : ""));
        }
    }
    private static void obtains(){
        GetUsersUseCase getUsersUseCase=new GetUsersUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        ArrayList<User> userList = getUsersUseCase.execute();
        int indice = 0;
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------LISTADO DE USUARIOS REGISTRADOS----------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------\n");
        System.out.printf("%-5s %-15s %-10s %-20s %-20s %-15s %-10s\n", " ","DNI", "NOMBRE", "APELLIDOS", "CORREO", "TELEFONO", "F. NACIMIENTO");
        for (User user : userList) {
            indice++;
            System.out.printf("%-5d %-15s %-10s %-20s %-20s %-15s %-10s\n", indice,
                    (user.getDni() != null ? user.getDni() : " "),
                    (user.getName() != null ? user.getName() : " "),
                    (user.getSurnames() != null ? user.getSurnames() : " "),
                    (user.getEmail() != null ? user.getEmail() : " "),
                    (user.getPhone() != null ? user.getPhone() : " "),
                    (user.getBirthDate() != null ? user.getBirthDate() : ""));
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("\n--Introduce cualquier caracter para volver al menú--");
        String c = scan.next();
        System.out.println();
    }
}

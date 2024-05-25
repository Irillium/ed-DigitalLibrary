package com.iesam.digitallibrary.features.user.presentation;

import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.features.user.domain.*;

import java.util.List;
import java.util.Scanner;

public class UserPresentation {

        private static final UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        private static final Scanner scan = new Scanner(System.in);
        public static void userMenu() {
            int select = -1;

            while (select != 0) {
                System.out.println("--------------------------------");
                System.out.println("------- MENÚ DE USUARIO --------");
                System.out.println("--------------------------------");
                System.out.println("\t [1] Registrar Usuario");
                System.out.println("\t [2] Modificar Usuario");
                System.out.println("\t [3] Eliminar Usuario");
                System.out.println("\t [4] Obtener un Usuario");
                System.out.println("\t [5] Listado de Usuarios");
                System.out.println("\t [0] Salir");
                System.out.println("--------------------------------");
                System.out.print("Seleccione una opción: ");
                select = scan.nextInt();
                scan.nextLine(); // Consume newline

                switch (select) {
                    case 0:
                        System.out.println("Saliendo del menú...");
                        break;
                    case 1:
                        save();
                        break;
                    case 2:
                        modify();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        obtain();
                        break;
                    case 5:
                        obtains();
                        break;
                    default:
                        System.out.println("Lo sentimos, esa opción no existe.");
                }
            }
        }

        private static void save() {
            SaveUserUseCase saveUserUseCase = new SaveUserUseCase(userDataRepository);
            System.out.println("---- Registro de Usuario ----");
            System.out.print("Introduzca su DNI: ");
            String dni = scan.nextLine();
            System.out.print("Introduzca su nombre: ");
            String name = scan.nextLine();
            System.out.print("Introduzca sus apellidos: ");
            String surnames = scan.nextLine();
            System.out.print("Introduzca su correo: ");
            String email = scan.nextLine();
            System.out.print("Introduzca su teléfono: ");
            String phone = scan.nextLine();
            System.out.print("Introduzca su fecha de nacimiento (DD/MM/AAAA): ");
            String birthDate = scan.nextLine();

            User user = new User(dni, name, surnames, email, phone, birthDate);
            saveUserUseCase.execute(user);
            System.out.println("Usuario registrado exitosamente.");
        }

        private static void delete() {
            DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(userDataRepository);
            System.out.println("---- Eliminación de Usuario ----");
            System.out.print("Introduzca el DNI del usuario que quiere eliminar: ");
            String dni = scan.nextLine();

            deleteUserUseCase.execute(dni);
            System.out.println("Usuario eliminado exitosamente.");
        }

        private static void modify() {
            System.out.println("---- Modificación de Usuario ----");
            System.out.print("Introduzca el DNI del usuario que quiere modificar: ");
            String dni = scan.nextLine();
            System.out.print("Introduzca el nuevo nombre (o el actual): ");
            String name = scan.nextLine();
            System.out.print("Introduzca los nuevos apellidos (o los actuales): ");
            String surnames = scan.nextLine();
            System.out.print("Introduzca el nuevo correo (o el actual): ");
            String email = scan.nextLine();
            System.out.print("Introduzca el nuevo teléfono (o el actual): ");
            String phone = scan.nextLine();
            System.out.print("Introduzca la nueva fecha de nacimiento (o la actual): ");
            String birthDate = scan.nextLine();

            User userModify = new User(dni, name, surnames, email, phone, birthDate);
            ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(userDataRepository);
            modifyUserUseCase.execute(dni, userModify);
            System.out.println("Usuario modificado exitosamente.");
        }

        private static void obtain() {
            System.out.println("---- Búsqueda de Usuario ----");
            System.out.print("Introduzca el DNI del usuario que desea buscar: ");
            String dni = scan.nextLine();

            GetUserUseCase getUserUseCase = new GetUserUseCase(userDataRepository);
            User user = getUserUseCase.execute(dni);
            System.out.println("----------------------------------------------------------------------------------------------------");
            if (user != null) {
                System.out.println("Usuario encontrado:");
                System.out.printf("%-15s %-10s %-20s %-20s %-15s %-10s\n",
                        "DNI", "NOMBRE", "APELLIDOS", "CORREO", "TELÉFONO", "F. NACIMIENTO");
                System.out.printf("%-15s %-10s %-20s %-20s %-15s %-10s\n",
                        (user.getDni() != null ? user.getDni() : " "),
                        (user.getName() != null ? user.getName() : " "),
                        (user.getSurnames() != null ? user.getSurnames() : " "),
                        (user.getEmail() != null ? user.getEmail() : " "),
                        (user.getPhone() != null ? user.getPhone() : " "),
                        (user.getBirthDate() != null ? user.getBirthDate() : ""));
            } else {
                System.out.println("Usuario no encontrado.");
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("\n-- Introduzca cualquier carácter para volver al menú --");
            scan.nextLine();
            System.out.println();
        }

        private static void obtains() {
            GetUsersUseCase getUsersUseCase = new GetUsersUseCase(userDataRepository);
            List<User> userList = getUsersUseCase.execute();

            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------- LISTADO DE USUARIOS REGISTRADOS ---------------------------------");
            System.out.println("----------------------------------------------------------------------------------------------------\n");
            System.out.printf("%-5s %-15s %-10s %-20s %-20s %-15s %-10s\n", " ", "DNI", "NOMBRE", "APELLIDOS", "CORREO", "TELÉFONO", "F. NACIMIENTO");

            int indice = 0;
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
            System.out.println("\n-- Introduzca cualquier carácter para volver al menú --");
            scan.nextLine();
            System.out.println();
        }
    }


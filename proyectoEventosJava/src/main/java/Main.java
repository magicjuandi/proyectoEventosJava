import domain.models.Usuario;
import repository.impl.HistoricoRepositortimpl;
import repository.impl.UsuarioRepositoryimpl;
import singledomain.ConexionDB;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try (Connection conn = ConexionDB.getInstance()) {
            UsuarioRepositoryimpl usRepo = new UsuarioRepositoryimpl();
            HistoricoRepositortimpl hisRepo = new HistoricoRepositortimpl();
            String opcion;

            do{
                System.out.println("\n Menu:" +
                    "\n1. Registro" +
                    "\n2. Ingreso" +
                    "\n3. Actualizar"+
                    "\n4. Listar"+
                    "\n5. Salida");
                opcion = scan.next();
                switch (opcion){
                    case "1":{
                        System.out.println("Registro Usuarios");
                        System.out.println("Nombre");
                        String nombreS = scan.next();
                        System.out.println("Correo");
                        String correoS = scan.next();
                        System.out.println("Contraseña");
                        String contraS = scan.next();
                        Usuario usuario = Usuario.builder()
                                .nombre(nombreS)
                                .correo(correoS)
                                .contrasena(contraS).build();
                        usRepo.guardarUsuario(usuario);
                        break;
                    }
                    case "2":{
                        usRepo.intentos();
                        break;
                    }
                    case "3":{
                        System.out.println("Actualizar Usuario");
                        System.out.println("Id");
                        Long idS = scan.nextLong();
                        System.out.println("Nombre");
                        String nombreS = scan.next();
                        System.out.println("Correo");
                        String correoS = scan.next();
                        System.out.println("Contraseña");
                        String contraS = scan.next();
                        System.out.println("Estado");
                        String estadoS = scan.next();
                        Usuario usuario = Usuario.builder()
                                .id(idS)
                                .nombre(nombreS)
                                .correo(correoS)
                                .contrasena(contraS)
                                .estado(estadoS).build();
                        usRepo.guardarUsuario(usuario);
                        System.out.println("Usuario actualizado!");
                    }
                    case "4":{
                        usRepo.listaUsuarios().forEach(System.out::println);
                        break;
                    }
                }

            }while(!opcion.equals("5"));
        } catch (Exception e) {

        }
    }
}

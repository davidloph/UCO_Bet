import javax.swing.*;
import java.util.ArrayList;

public class DatosJugador {
    public static void datosJugador(ArrayList<Jugador> jugadores) {
        String nombre;
        String email;
        String cedula;
        String celular;
        String numSorteo;
        while(true) {
            nombre = JOptionPane.showInputDialog("Nombre: ");
            if (nombre == null || nombre.isBlank()) {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido.");
            } else {
                break;
            }
        }
        while (true) {
            email = JOptionPane.showInputDialog("Correo: ");
            if (email == null || email.isBlank()) {
                JOptionPane.showMessageDialog(null, "Ingrese un correo válido.");
            } else {
                break;
            }
        }
        while (true) {
            cedula = JOptionPane.showInputDialog("Cédula: ");
            if (cedula == null || cedula.isBlank()) {
                JOptionPane.showMessageDialog(null, "Ingrese un documento válido.");
            } else {
                break;
            }
        }
        while (true) {
            celular = JOptionPane.showInputDialog("Celular: ");
            if (celular == null || celular.isBlank()) {
                JOptionPane.showMessageDialog(null, "Ingrese un celular válido.");
            } else {
                break;
            }
        }
        while (true) {
            numSorteo = JOptionPane.showInputDialog("Sorteo: ");
            if (numSorteo == null || numSorteo.isBlank() || numSorteo.length() > 4 || numSorteo.matches("\\d")) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero válido.");
            } else {
                break;
            }
        }



        Jugador jugador = new Jugador(nombre, email, cedula, celular, numSorteo);
        jugadores.add(jugador);

    }
}

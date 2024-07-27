import javax.swing.*;
import java.util.ArrayList;

public class DatosJugador {
    public static void datosJugador(ArrayList<Jugador> jugadores) {
        String nombre = JOptionPane.showInputDialog("Nombre: ");
        String email = JOptionPane.showInputDialog("Correo: ");
        String cedula = JOptionPane.showInputDialog("Cédula: ");
        String celular = JOptionPane.showInputDialog("Celular: ");
        String numSorteo = JOptionPane.showInputDialog("Sorteo: ");


        Jugador jugador = new Jugador(nombre, email, cedula, celular, numSorteo);
        jugadores.add(jugador);

    }
}

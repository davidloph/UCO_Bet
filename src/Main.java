import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
public class Main {
    public static void main(String[] args){
        final int INGRESAR_JUGADOR = 0;
        final int ESTADISTICAS = 1;
        final int SORTEAR = 3;
        final ImageIcon UCOLOGO = new ImageIcon(Main.class.getResource("uco.png"));

        //Puro testeo de push papi

        ArrayList<Jugador> jugadores = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime momentoSorteo;
        String numGanador;

        while (true) {
            momentoSorteo = FechaHoraDeJuego.obtenerFechaSorteo();
            if (Duration.between(LocalDateTime.now(), momentoSorteo).toSeconds() >= 360){
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha y hora correctas.");
            }
        }
        while (true) {
            numGanador = JOptionPane.showInputDialog("Ingresa el número que ganará: ");
            if (numGanador.length()==4){
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }


        while(Duration.between(LocalDateTime.now(), momentoSorteo).toSeconds() > 0) {
            int ingresarJugador = JOptionPane.showOptionDialog(null, "Fecha y hora del sorteo: " + momentoSorteo.getYear() + "/" + momentoSorteo.getMonth() + "/" +  momentoSorteo.getDayOfMonth() + "  " +  momentoSorteo.getHour() + ":" +  momentoSorteo.getMinute() + ":" + momentoSorteo.getSecond(), "UCO Bet", 0 , 0, UCOLOGO, Arrays.asList("Ingresar jugador", "Estadísticas", "Cancelar Sorteo", "Sortear").toArray(),0);

           if (LocalDateTime.now().compareTo(momentoSorteo) >=0) {
               for (Jugador jugador : Ganadores.ganadores(jugadores, numGanador)) {
                   System.out.println(jugador.toString());
               }

           }else if (ingresarJugador == INGRESAR_JUGADOR && ValidacionParaJugar.validacion(momentoSorteo)) {
                DatosJugador.datosJugador(jugadores);

                jugadores.forEach(jugador -> {
                    JOptionPane.showMessageDialog(null, jugador.toString());
                });
            } else if (ingresarJugador == INGRESAR_JUGADOR && !ValidacionParaJugar.validacion(momentoSorteo)) {
                JOptionPane.showMessageDialog(null, "Tiempo agotado...");
            } else if (ingresarJugador == 2 || ingresarJugador == -1) {
                JOptionPane.showMessageDialog(null, "Sorteo cancelado.");
                System.exit(0);
            } else if (ingresarJugador == SORTEAR && momentoSorteo.compareTo(LocalDateTime.now()) > 0){
                Duration tiempoRestante = Duration.between(LocalDateTime.now(), momentoSorteo);
                JOptionPane.showMessageDialog(null, "Tiempo restante:\n" + tiempoRestante.toDays() + ":" + tiempoRestante.toHours() %24 + ":" + tiempoRestante.toMinutes() %60 + ":" + tiempoRestante.toSeconds() %60);
            }
        }
        Ganadores.ganadores(jugadores, numGanador).forEach(jugador -> {
            JOptionPane.showMessageDialog(null, jugador.toString()
            );
        });
    }
}
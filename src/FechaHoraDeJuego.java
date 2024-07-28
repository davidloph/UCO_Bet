import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaHoraDeJuego {
    public static LocalDateTime obtenerFechaSorteo() {
        DateTimeFormatter momentoDeSorteoFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTimeGame = null;

        while (true) {
            try {
                String momentoDeSorteo = JOptionPane.showInputDialog("Ingresa la fecha y hora en que se jugará el sorteo:\n'yyyy-MM-dd  Hora:Minuto:Segundo'");

                dateTimeGame = LocalDateTime.parse(momentoDeSorteo, momentoDeSorteoFormat);

                int confirmar = JOptionPane.showConfirmDialog(null, "Fecha y hora de sorteo:\n" + dateTimeGame);
                if (confirmar == 0){
                    return dateTimeGame;
                }

            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha y hora incorrecto, intente nuevamente.");
            }
        }
    }
}

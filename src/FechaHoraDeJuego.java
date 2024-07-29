import javax.swing.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class FechaHoraDeJuego {
    public static LocalDateTime obtenerFechaSorteo() {
        DateTimeFormatter momentoDeSorteoFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTimeGame;

        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM//yyyy HH:mm");
        dateSpinner.setEditor(timeEditor);

        while (true) {
            int option = JOptionPane.showOptionDialog(null, dateSpinner, "Seleccioan la fecha y hora del sorteo:",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
            if (option == JOptionPane.OK_OPTION){
                Date selectedDate = (Date) dateSpinner.getValue();

                return selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            } else if (option == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Se ha cancelado el sorteo.");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fehca y hora válidas.");
            }
        }
    }
}

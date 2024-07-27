import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ValidacionParaJugar {
    public static boolean validacion(LocalDateTime momentoSorteo) {
        LocalDateTime momentoActual = LocalDateTime.now();
        if (Duration.between(momentoActual, momentoSorteo).toSeconds() > 300) {
            return true;
        } else {
            return false;
        }
    }
}

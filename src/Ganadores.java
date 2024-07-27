import java.util.ArrayList;

public class Ganadores {
    public static ArrayList<Jugador> ganadores(ArrayList<Jugador> jugadores, String numGanador) {
        ArrayList<Jugador> winners = new ArrayList<>();
        for (Jugador jugador: jugadores) {
            if (jugador.getNumSorteo().equals(numGanador)){
                winners.add(jugador);
            }
        }
        return winners;
    }
}

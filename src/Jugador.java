public class Jugador {
    private String nombre;
    private String email;
    private String cedula;
    private String celular;
    private String numSorteo;

    public Jugador(String cedula, String celular, String email, String nombre, String numSorteo) {
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
        this.nombre = nombre;
        this.numSorteo = numSorteo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumSorteo() {
        return numSorteo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", numSorteo='" + numSorteo + '\'' +
                '}';
    }
}

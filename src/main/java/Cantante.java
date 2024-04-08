public class Cantante {
    private int id_artistas;
    private String nombre;
    private int edad;
    private String nacionalidad;
    private String generoMusical;

    public Cantante(int id_artistas, String nombre, int edad, String nacionalidad, String generoMusical) {
        this.id_artistas = id_artistas;
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.generoMusical = generoMusical;
    }

    public Cantante(String nombre, int edad, String nacionalidad, String generoMusical) {
        this.id_artistas = -1;
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.generoMusical = generoMusical;
    }

    public int getId_artistas() {
        return id_artistas;
    }

    public void setId_artistas(int id_artistas) {
        this.id_artistas = id_artistas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    @Override
    public String toString() {
        return this.id_artistas + " - " + this.nombre;
    }
}

public class Cantante {
    private int id;
    private String nombre;

    public Cantante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Cantante(String nombre) {
        this(-1,nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nombre;
    }
}

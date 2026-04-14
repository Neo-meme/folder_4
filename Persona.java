abstract class Persona {
    String nombre;

    //constructor
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    //getter y setter
    public String getNombre() {
        return nombre;
    }   
    

    public abstract String getIdentificador();
}
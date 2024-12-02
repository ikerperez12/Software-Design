package E1;


public abstract class EHUMANO {
    private final String nombre;
    private final String apellido;
    private final String DNI;
    private  int telefono;
    private  String nacionalidad;



    public EHUMANO(String nombre, String apellido, String DNI, String nacionalidad , int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.DNI = DNI ;

        setAtelefono(telefono);
        /*this.salario = salario ;
        this.puesto = puesto ; */



    }



    public String getnombre() {return nombre;}

    public String setnombre() {return this.nombre;}


    public String getapellido() {return apellido;}

    public String setapellido() {return this.apellido;}


    public String getDNI() {return DNI;}

    public String setDNI() {return this.DNI;}


    public int gettelefono() {return telefono;}

    private void setAtelefono(int telefono) {setTelefono(telefono);}

    public void setTelefono(int telefono) {
        if ((telefono >= 600000000) && (telefono <= 999999999)) {
            this.telefono = telefono;
        } else throw new IllegalArgumentException("telefono");
    }

    public void setnacionalidad (String nacionalidad) {
         this.nacionalidad = nacionalidad;
    }
    public String getnacionalidad () {
        return nacionalidad;
    }


    @Override
    public abstract String toString();
}
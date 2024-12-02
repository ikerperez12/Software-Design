package E1;
import java.util.Collection;
import java.util.HashSet;



public class Pelicula {


    private final Collection<ProduccionCine> SetEQUIPOS = new HashSet<>();
    private final String titulo;
    private static int recaudacion;

    public Pelicula(String titulo, int recaudacion) {
        this.titulo = titulo;
        Pelicula.recaudacion = recaudacion;
    }

    public void agregarEquipo(EQUIPOS eq){ SetEQUIPOS.add(eq);}
    public void agregarEquipo(EQUIPOA eq){ SetEQUIPOS.add(eq);}


    public String getTitulo() {
        return titulo;
    }
    public String setTitulo() {
        return this.titulo;
    }

    public int getRecaudacion() { return recaudacion;}
    public int setRecaudacion() { return recaudacion;}


    // METODO printSalaries que devolvera un String con un listado de las personas involucradas su salario y el pago total de salarios
    public String printSalaries(){
        System.out.println("La nómina total de la pelicula " + getTitulo() + " es " + sumasalarios());
        return equipoPelicula().toString();

    }

    // DEVUELVE UNA LISTA CON TODAS LAS PERSONAS INVOLUCRADAS EN LA PELICULA
    public Collection<EHUMANO> equipoPelicula(){
        Collection<EHUMANO> set = new HashSet<>();
        set.addAll(this.SetEQUIPOS);
        return set;
    }

    // DEVUELVE UNA LISTA CON TODAS LAS PERSONAS QUE TIENEN DERECHOS DE AUTOR
    public Collection<EHUMANO> equipoDerechos(){
        Collection<EHUMANO> setderechos = new HashSet<>();
        setderechos.addAll(this.SetEQUIPOS);
        return setderechos;
    }

    //METODO printRoyalties que devolvera un String con un listado con los  derechos de autor de la pel´ıcula

    public String printRoyalties(){
        return equipoPelicula().toString();

    }


    // DEVUELVE LA SUMA TOTAL DE LOS SUELDOS DE LAS PERSONAS INVOLUCRADAS EN LA PELICULA
    public int sumasalarios(){
        int sum = 0;
        for (ProduccionCine e : SetEQUIPOS){
            sum+=e.getSalario();
        }
        return sum;
    }

}





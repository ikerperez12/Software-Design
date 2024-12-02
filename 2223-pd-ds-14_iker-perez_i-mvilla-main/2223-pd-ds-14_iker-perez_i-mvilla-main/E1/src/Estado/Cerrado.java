package Estado;

import Gestion.Estado;

public class Cerrado implements Estado {
    private static final Cerrado instancia = new Cerrado();
    private Cerrado(){}
    public static Cerrado getInstance() {return instancia;}
}

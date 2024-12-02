package Estado;


import Gestion.MetodoPago;
import Gestion.Estado;
import Gestion.Order;
import Gestion.Producto;



public class Cobro implements Estado {
    private static final Cobro instancia = new Cobro();
    private Cobro(){}
    public static Cobro getInstance() {return instancia;}

    private MetodoPago metodoPago;

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public boolean pedir(Order c, Producto pedido) {
        c.setEstado(Pedir.getInstance());
        return c.pedir(pedido);
    }

    @Override
    public String pagar(Order c) {
        c.setEstado(Cerrado.getInstance());
        return metodoPago.pagar(c);
    }
}

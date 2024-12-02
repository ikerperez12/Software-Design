package Estado;


import Gestion.Estado;
import Gestion.MetodoPago;
import Gestion.Order;
import Gestion.Producto;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Impagado implements Estado {
    private static final Impagado instancia = new Impagado();
    private Impagado(){}
    public static Impagado getInstance() {return instancia;}

    private MetodoPago metodoPago;

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String solicitarCuenta(Order c) {
        StringBuilder output = new StringBuilder();
        float total=0;
        float totalNoImpuestos=0;

        output.append("# Mesa numero ").append(c.getMesa()).append("\n");
        output.append("# ").append(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())).append("\n");
        output.append("Producto\t nstock \t Precio \t PVP unidad \t PVP total\n");
        output.append("==============================================================\n");
        for(Producto i : c.getPedidos()){
            output.append(i.toString()).append("\n");
            totalNoImpuestos += i.getprecio();
            total += (i.getprecio()+i.getprecio());
        }
        output.append("\n# Pendiente de combro\n");
        output.append("Total sin impuestos ").append(String.format("%.2f",totalNoImpuestos)).append("\n");
        output.append("Total de impuestos ").append(String.format("%.2f",total-totalNoImpuestos)).append("\n");
        output.append("PVP total ").append(String.format("%.2f",total));

        c.setEstado(Cobro.getInstance());
        return output.toString();
    }

    @Override
    public String pagar(Order c) {
        c.setEstado(Cerrado.getInstance());
        return metodoPago.pagar(c);
    }
}

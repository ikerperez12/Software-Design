package Estado;

import Gestion.Estado;
import Gestion.Order;
import Gestion.Producto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedir implements Estado {
    private static final Pedir instancia = new Pedir();
    private Pedir(){}
    public static Pedir getInstance() {return instancia;}

   // @Override
    public boolean pedir(Order c, Producto pedido) {
        if(pedido.decrementarProducto(c.getAlmacen(), pedido.getnstock())){
            c.getPedidos().add(pedido);
            return true;
        }
        return false;
    }

 //   @Override
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
}

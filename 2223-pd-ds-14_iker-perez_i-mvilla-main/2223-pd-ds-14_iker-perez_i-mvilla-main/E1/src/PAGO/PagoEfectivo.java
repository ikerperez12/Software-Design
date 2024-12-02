package PAGO;

import Gestion.MetodoPago;
import Gestion.Order;
import Gestion.Producto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PagoEfectivo implements MetodoPago {

    @Override
    public String pagar(Order c) {
        StringBuilder output = new StringBuilder();
        float total=0;
        float totalNoImpuestos=0;

        output.append("# Factura simplificada numero ")
                .append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())).append("\n");
        output.append("# Mesa numero ").append(c.getMesa()).append("\n");
        output.append("# ").append(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())).append("\n");
        output.append("Producto\t nstock \t Precio \t PVP unidad \t PVP total\n");
        output.append("==============================================================\n");
        for(Producto i : c.getPedidos()){
            output.append(i.toString()).append("\n");
            total += i.getprecio();
        }
        output.append("\n# Total\n");
        output.append("Total sin impuestos ").append(String.format("%.2f",totalNoImpuestos)).append("\n");
        output.append("Total de impuestos ").append(String.format("%.2f",total-totalNoImpuestos)).append("\n");
        output.append("PVP total ").append(String.format("%.2f",total)).append("\n");

        output.append("\n# Forma de pago: Efectivo\n");

        output.append("Total ").append(String.format("%.2f",total - total*descuento)).append("\n");

        return output.toString();
    }
}

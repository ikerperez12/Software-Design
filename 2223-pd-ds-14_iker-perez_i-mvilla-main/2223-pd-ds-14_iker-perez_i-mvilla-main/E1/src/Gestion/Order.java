
package Gestion;

import java.util.ArrayList;
import java.util.List;
import Estado.Pedir;
import PAGO.PagoEfectivo;

public class Order {
    private int mesa;
    private final Almacen almacen;
    private final List<Producto> pedidos = new ArrayList<>();
    private Estado estado = Pedir.getInstance();

    public Order(int mesa, Almacen almacen, Almacen almacen1) {
        this.mesa = mesa;
        this.almacen = almacen;

    }


    public void setEstado(Estado estado){
        this.estado = estado;
    }

    /**
     * Introduce un pedido en la comanda
     * @param producto, pedido a introducir
     * @return true si se lleva a cabo
     */
    public boolean pedir(Producto producto){
        return estado.pedir(this, producto);
    }

    /**
     * Devuelve una cuenta con los producto pedidos de la comanda
     * @return cuenta
     */
    public String solicitarCuenta(){
        return this.estado.solicitarCuenta(this);
    }

    /**
     * Devuelve un factura simplificada del pago de la comanda
     * @param metodoPago a usar
     * @return factura
     */
    public String pagar(MetodoPago metodoPago){
        this.estado.setMetodoPago(metodoPago);
        return this.estado.pagar(this);
    }
    /**
     * Devuelve un factura simplificada del pago de la comanda
     * @param metodoPago a usar
     * @param descuento a aplicar
     * @return factura
     */
    public String pagar(MetodoPago metodoPago, double descuento){
        this.estado.setMetodoPago(metodoPago);
        return this.estado.pagar(this);
    }
    /**
     * Devuelve un factura simplificada del pago de la comanda
     * @param efectivo, dinero entregado par pagar
     * @return factura
     */
    public String pagar(double efectivo){
        this.estado.setMetodoPago(new PagoEfectivo());
        return this.estado.pagar(this);
    }
    /**
     * Devuelve un factura simplificada del pago de la comanda
     * @param efectivo, dinero entregado par pagar
     * @param descuento a aplicar
     * @return factura
     */
    public String pagar(double efectivo, double descuento){
        this.estado.setMetodoPago(new PagoEfectivo());
        return this.estado.pagar(this);
    }

    //getters y setters
    public int getMesa() {
        return mesa;
    }
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    public Almacen getAlmacen() {
        return almacen;
    }
    public List<Producto> getPedidos() {return pedidos;}
}
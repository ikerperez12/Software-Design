package Gestion;

public interface MetodoPago {
    /**
     * Devuelve un factura simplificada del pago de la comanda
     * @param c, comanda a pagar
     * @return factura
     */
    String pagar(Order c );
}

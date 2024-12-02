package Gestion;
import Gestion.Producto;

public interface Estado {

    default boolean pedir(Order c, Producto pedido){ return false; }

    default String solicitarCuenta(Order c){ return null; }

    default String pagar(Order c) { return null; }

    default void setMetodoPago(MetodoPago metodoPago){}
}

package Gestion;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;



public class ShoppingCart {
    private final List<Producto> pedidos = new ArrayList<>();
   double totalAmount;
   private final Almacen almacen;
 //  private Estado estado = Pedir.getInstance();


    public ShoppingCart(Almacen almacen) {
        this.totalAmount = 0;
        this.almacen = almacen;
    }
    public void addToCart(Producto Producto) {
        this.Producto.add(Producto);
    }
    public void showCart() {
        ListIterator<Producto> iterator = Producto.listIterator();
        while(iterator.hasNext()) {
            Producto Producto1 = iterator.next();
            System.out.println(Producto1);
        }
    }
    public void removeFromCart(Producto i) {
        ListIterator<Producto> iterator1 = Producto.listIterator();
        while(iterator1.hasNext()) {
            Producto Producto2 = iterator1.next();
            if (Producto2.getnombreProducto().equals(i.getnombreProducto())) {
                this.Producto.remove(i);
                break;
            }
        }
    }
    public double getTotalAmount() {
        ListIterator<Producto> iterator2 = Producto.listIterator();
        this.totalAmount = 0;
        while(iterator2.hasNext()) {
            Producto Producto3 = iterator2.next();
            this.totalAmount = this.totalAmount + (Producto3.getprecio() * Producto3.getnstock());
        }
        return this.totalAmount;
    }



    public void printInvoice() {
        ListIterator<Producto> iterator3 = Producto.listIterator();
        while(iterator3.hasNext()) {
            Producto Producto4 = iterator3.next();
            System.out.print(Producto4.getnombreProducto() + "\t");
            System.out.print(Producto4.getnstock() + "\t");
            System.out.print(Producto4.getprecio() + "\t");
            System.out.println(Producto4.getprecio() * Producto4.getnstock());
        }
        System.out.println("\t\t\t" + "Total    : " + this.getTotalAmount());
    }


    public Almacen getAlmacen() {
        return almacen;
    }

    public List<Producto> getPedidos (){ return pedidos ;}
}

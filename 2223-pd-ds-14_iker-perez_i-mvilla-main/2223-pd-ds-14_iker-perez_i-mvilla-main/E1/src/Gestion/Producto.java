package Gestion;
import java.util.Objects;

public abstract class Producto {
    private final String nombreProducto;
    private String descripcion;
    private double nstock;
    private double precio;


    public Producto(String nombreProducto,String descripcion, double nstock, double precio) {
        this.nombreProducto = nombreProducto;
        this.nstock = nstock;
        this.precio = precio;
        this.descripcion= descripcion;
    }


    /**
     * Decrementa en la Gestion.Almacen
     *
     * @param almacen
     * @param nstock
     * @return true si se lleva a cabo correctamente
     */
    public boolean decrementarProducto(Almacen almacen, double nstock) {
        for (Producto i : Almacen.getproducto())
            if (i.equals(this)) {
                if (i.getnstock() - nstock > 0) {
                    i.setnstock(i.getnstock() - nstock);
                    return true;
                } else break;
            }
        return false;
    }


    public String toString() {
        String s = this.nombreProducto + ":";
        s = s + this.nstock + "\n";
        return s;
    }

    //GETTERS AND SETTERS //


    public String getnombreProducto() {
        return this.nombreProducto;
    }

    public double getnstock() {
        return this.nstock;
    }

    public double getprecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setnstock(double nstock) {

        this.nstock = nstock;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Double.compare(producto.precio, precio) == 0 &&
                nombreProducto.equals(producto.nombreProducto) &&
                Objects.equals(descripcion, producto.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreProducto, descripcion, precio);
    }
}


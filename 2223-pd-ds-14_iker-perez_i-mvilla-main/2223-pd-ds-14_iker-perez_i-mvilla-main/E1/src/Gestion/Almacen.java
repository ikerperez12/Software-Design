package Gestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Almacen {
    private final List<Producto> producto = new ArrayList<>();

    /**
     * Introduce un producto nuevo a la lista
     * @param producto a introducir
     */
    public void addProducto(Producto producto){
        this.producto.add(producto);
    }

    /**
     * Elimina un producto de la lista
     * @param producto a eliminar
     */
    public void removeProducto(Producto producto){
        this.producto.remove(producto);
    }

    /**
     * Incrementa la nstock de un producto
     * @param producto a incrementar
     * @param nstock a incrementar
     * @return true si el producto existe
     */
    public boolean incrementarProducto(Producto producto, float nstock){
        for(Producto i : this.producto)
            if(Objects.equals(i, producto)){
                i.setnstock(i.getnstock()+nstock);
                return true;
            }
        return false;
    }

    /**
     * Decrementa la nstock de un producto
     * @param producto a decrementar
     * @param nstock a decrementar
     * @return true si el producto puede ser decrementado
     */
    public boolean decrementarProducto(Producto producto, double nstock) {
        return producto.decrementarProducto(this, nstock);
    }

    public List<Producto> getproducto() {
        return producto;
    }
}

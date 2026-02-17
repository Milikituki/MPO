package controller;

import model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class GestorProductos {
    private ArrayList<Producto> productos;

    public GestorProductos() {
        productos = new ArrayList<>();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        Predicate<Producto> p = (x) -> x.getCodigo().equals(producto.getCodigo());
        if (productos.stream().noneMatch(p)) {
            productos.add(producto);
            System.out.println("Producto agregado correctamente");
        } else {
            System.out.println("Error: el producto ya existe");
        }
    }
    public void asignarPrecios(){
        if (productos.stream().map(Producto::getPrecio).anyMatch(precio -> precio == -1)) {
            productos.forEach(x -> {
                if (x.getPrecio() == -1){
                    x.setPrecio(Math.round(Math.random()*101)+1.00);
                }
            });
            System.out.println("Precio asignado correctamente");
            productos.stream().map(Producto::getPrecio).forEach(System.out::println);
        }
    }
    public void mostrarProductos(){
        productos.forEach(Producto::mostrarDatos);
    }
    public double calcularPrecioMedio(){
        return Math.round(productos.stream().mapToDouble(Producto::getPrecio).average().orElse(0.0));
    }
    public long getNumeroProductosCaros(double limite){
        return productos.stream().filter(x -> x.getPrecio() >= limite).count();
    }
    public List<Producto> getProductosCaros(double limite){
        return productos.stream().filter(x -> x.getPrecio() >= limite).toList();
    }
    public Optional<Producto> buscarPorCodigo(String codigo){
        return productos.stream().filter(x -> x.getCodigo().equalsIgnoreCase(codigo)).findFirst();

    }
    public void ordenarPorPrecioDesc() {
        productos.sort((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()));
        //productos.sort(Comparator.comparingDouble(Producto::getPrecio).reversed());
        System.out.println("Productos ordenados por precio (mayor a menor)");
    }
    public List<Producto> getProductosPorCondicion(BiPredicate<Producto, Double> condicion, double valor) {
        return productos.stream().filter(p -> condicion.test(p, valor)).toList();
    }

}

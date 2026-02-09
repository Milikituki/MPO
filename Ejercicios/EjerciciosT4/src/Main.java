import controller.GestorProductos;
import model.Producto;

import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        GestorProductos gestor = new GestorProductos();
        gestor.agregarProducto(new Producto("Laptop HP", "Electrónica", "P001", 599.9));
        gestor.agregarProducto(new Producto("Mouse Logitech", "Electrónica", "P002", 25.5));
        gestor.agregarProducto(new Producto("Teclado Mecánico", "Electrónica", "P003", 89.9));
        gestor.agregarProducto(new Producto("Monitor Samsung", "Electrónica", "P004"));
        gestor.agregarProducto(new Producto("Webcam HD", "Electrónica", "P005"));
        gestor.agregarProducto(new Producto("Auriculares", "Audio", "P006"));

        System.out.println();
        gestor.agregarProducto(new Producto("Ratón Inalámbrico", "Electrónica", "P002", 15.0));

        gestor.asignarPrecios();
        System.out.println();
        gestor.mostrarProductos();
        System.out.println();
        System.out.println(gestor.calcularPrecioMedio());
        System.out.println();
        System.out.println(gestor.getNumeroProductosCaros(50.5));
        System.out.println();
        gestor.getProductosCaros(50.5).forEach(Producto::mostrarDatos);
        System.out.println();
        gestor.buscarPorCodigo("P006").ifPresent(Producto::mostrarDatos);
        System.out.println();
        String codigoBuscado = "P100";
        gestor.buscarPorCodigo(codigoBuscado).ifPresentOrElse(Producto::mostrarDatos, () -> {
            gestor.agregarProducto(new Producto("Producto Nuevo", "General", codigoBuscado));
            System.out.println("Producto Nuevo, con código " + codigoBuscado + " agregado correctamente");
        });
        gestor.asignarPrecios();
        System.out.println();
        gestor.ordenarPorPrecioDesc();
        gestor.mostrarProductos();
        System.out.println();
        // Condición 1: Precio mayor o igual que valor
        BiPredicate<Producto, Double> precioMayorIgual = (p, valor) -> p.getPrecio() >= valor;
        System.out.println("\nProductos con precio >= 50:");
        gestor.getProductosPorCondicion(precioMayorIgual, 50.0).forEach(Producto::mostrarDatos);

        // Condición 2: Precio menor que valor
        BiPredicate<Producto, Double> precioMenor = (p, valor) -> p.getPrecio() < valor;
        System.out.println("\nProductos con precio < 30:");
        gestor.getProductosPorCondicion(precioMenor, 30.0).forEach(Producto::mostrarDatos);

        // Condición 3: Precio exactamente igual
        BiPredicate<Producto, Double> precioExacto = (p, valor) -> p.getPrecio() == valor;
        System.out.println("\nProductos con precio exacto 50.0:");
        gestor.getProductosPorCondicion(precioExacto, 50.0).forEach(Producto::mostrarDatos);

        // Condición 4: Precio en rango (usando valor como límite superior, precio > 20 y < valor)
        BiPredicate<Producto, Double> precioEnRango = (p, valor) -> p.getPrecio() > 20 && p.getPrecio() < valor;
        System.out.println("\nProductos con precio entre 20 y 60:");
        gestor.getProductosPorCondicion(precioEnRango, 60.0).forEach(Producto::mostrarDatos);


    }
}

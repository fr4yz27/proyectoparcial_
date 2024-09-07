import java.util.Scanner;

class Producto {
    String nombre;
    double precio = 0.0;
    int cantidad = 0;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String toString() {
        return "Producto: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad;
    }
}

public class YamahitaGabrielCano {
    Scanner sc = new Scanner(System.in);
    int filas = 0, columnas = 0;

    public void ejecutar() {
        System.out.println("Ingrese el número de filas de la matriz:");
        filas = sc.nextInt();
        System.out.println("Ingrese el número de columnas de la matriz:");
        columnas = sc.nextInt();

        Producto[][] matrizYamaha = llenarMatriz(filas, columnas);

        // Obtener y mostrar el nombre del producto más caro
        String nombreProductoMasCaro = obtenerProductoMasCaro(matrizYamaha);
        if (nombreProductoMasCaro != null) {
            System.out.println("El producto con el precio más elevado es: " + nombreProductoMasCaro);
        } else {
            System.out.println("No se encontró ningún producto.");
        }
    }

    // Método para llenar la matriz de productos
    public Producto[][] llenarMatriz(int filas, int columnas) {
        Producto[][] matriz = new Producto[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese el nombre del producto (" + i + "," + j + "):");
                String nombreProducto = sc.next();
                System.out.println("Ingrese el precio del producto (" + i + "," + j + "):");
                double precioProducto = sc.nextDouble();
                System.out.println("Ingrese la cantidad del producto (" + i + "," + j + "):");
                int cantidadProducto = sc.nextInt();

                matriz[i][j] = new Producto(nombreProducto, precioProducto, cantidadProducto);
            }
        }

        return matriz;
    }

    // Método para encontrar el producto con el precio más alto
    public String obtenerProductoMasCaro(Producto[][] matriz) {
        String nombreMasCaro = null;
        double precioMayor = 0.0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getPrecio() > precioMayor) {
                    precioMayor = matriz[i][j].getPrecio();
                    nombreMasCaro = matriz[i][j].getNombre();
                }
            }
        }

        return nombreMasCaro;
    }
}

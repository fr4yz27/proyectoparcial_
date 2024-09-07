import java.util.Scanner;

public class YamahitaAlejoGarcia {
    private String nombre;
    private double precio;
    private int cantidad;
    Scanner entrada = new Scanner(System.in);

    public YamahitaAlejoGarcia() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método que permite llenar la matriz ...
    public YamahitaAlejoGarcia[][] llenarMatrizYamahitaAlejoGarcia(int dim){
        YamahitaAlejoGarcia[][] servidorCentral = new YamahitaAlejoGarcia[dim][dim];
        System.out.println("\n ----- REGISTROS DEL SERVIDOR ----- ");

        // For para llenar la matriz objetual YAMAHITA que simula el servidor ...
        for (int i = 0; i < servidorCentral.length; i++) {
            for (int j = 0; j < servidorCentral.length; j++) {
                YamahitaAlejoGarcia infoS = new YamahitaAlejoGarcia();
                System.out.print("\nNombre producto: ");
                infoS.setNombre(entrada.next());
                System.out.print("Precio: ");
                infoS.setPrecio(entrada.nextDouble());
                System.out.print("Cantidad: ");
                infoS.setCantidad(entrada.nextInt());
                servidorCentral[i][j] = infoS;
            }
        } // Fin ciclos for

        return servidorCentral;
    }
    
    // Método que hace la busqueda del producto por el nombre ...
    public void buscarProducto(YamahitaAlejoGarcia[][] matrizSearch ,String nombre){
        String nombreSearch = nombre;
        boolean encontrado = false;

        // For que recorre la matriz para la busqueda por el nombre ...
        for (int i = 0; i < matrizSearch.length; i++) {
            for (int j = 0; j < matrizSearch.length; j++) {
                if(matrizSearch[i][j].getNombre().equalsIgnoreCase(nombreSearch)){
                    System.out.println("\n ---------- ELEMENTO ENCONTRADO ----------");
                    encontrado = true;
                    System.out.println("Nombre producto: " + matrizSearch[i][j].getNombre());
                    System.out.println("Precio: " + matrizSearch[i][j].getPrecio());
                    System.out.println("Cantidad: " + matrizSearch[i][j].getCantidad());
                }
            }
        } // Fin ciclos for

        if(encontrado == false){
            System.out.println("\n ----- EL PRODUCTO " + nombre + " NO HACE PARTE DEL PEDIDO ----- ");
        }

    }

    // Método que imprime el producto con el precio mayor ...
    public void buscarPrecioMayor(YamahitaAlejoGarcia[][] matrizSearchPrecio){
        double precioMax = 0;
        String nombreMax = "";
        int cantidadMax = 0;

        // For que recorre la matriz para la busqueda del precio más alto ...
        for (int i = 0; i < matrizSearchPrecio.length; i++) {
            for (int j = 0; j < matrizSearchPrecio.length; j++) {
                if(matrizSearchPrecio[i][j].getPrecio() > precioMax){
                    precioMax = matrizSearchPrecio[i][j].getPrecio();
                    nombreMax = matrizSearchPrecio[i][j].getNombre();
                    cantidadMax = matrizSearchPrecio[i][j].getCantidad();
                }
            }
        } // Fin ciclos for
        
        System.out.println("\n ----- INFORMACIÓN PRODUCTO MÁS COSTOSO ----- ");
        System.out.println("Nombre: " + nombreMax);
        System.out.println("Precio: " + precioMax);
        System.out.println("Cantidad: " + cantidadMax);
    }

    public void ejecutarAlejoGarcia() {
        Scanner entrada = new Scanner(System.in);
        YamahitaAlejoGarcia servidor = new YamahitaAlejoGarcia();

        System.out.print("\n INGRESE LA DIMENSIÓN DE LA MATRIZ: ");
        int dim = entrada.nextInt();
        YamahitaAlejoGarcia[][] matrizServidor = new YamahitaAlejoGarcia[dim][dim];
        matrizServidor = servidor.llenarMatrizYamahitaAlejoGarcia(dim);

        int opcion = 0;
        while(opcion != 3){
            System.out.print("\n 1. Buscar producto por nombre " + 
                            "\n 2. Mostrar producto con mayor valor" +
                            "\n 3. SALIR " + 
                            "\n Ingrese opción: ");
        
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el nombre del producto que desea buscar: ");
                    String nombreProducto = entrada.next();
                    servidor.buscarProducto(matrizServidor, nombreProducto);
                    break;
                case 2:
                    servidor.buscarPrecioMayor(matrizServidor);
                    break;
                case 3:
                    System.out.println("\n ----- FIN PROGRAMA ----- ");
                    break;
                default:
                    System.out.println("Opción no válida, ingrese nuevamente una opción ... ");
                    opcion = entrada.nextInt();
                    break;
            }
        }

    }
    
}

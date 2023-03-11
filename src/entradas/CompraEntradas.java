package entradas;

import java.util.Scanner;

public class CompraEntradas {

    static int[] factura = new int[10];
    static int[] cedula = new int[10];
    static String[] nombre = new String[10];
    static int[] localidad = new int[10];
    static int[] entradas = new int[10];
    static String[] espacio = new String[10];
    static int[] subtotal = new int[10];
    static int[] total = new int[10];
    static int[] cargo = new int[10];
    static int precioentra;
    static int entrasol = 0;
    static int entrasom = 0;
    static int entrapref = 0;
    static int acumulasol = 0;
    static int acumulasom = 0;
    static int acumulapref = 0;
    static int indice = 0;
    public static Scanner leer = new Scanner(System.in);

    public CompraEntradas() {
    }

    public static void IncluirComprador() {

        char seguir = 'n';
        Scanner leer = new Scanner(System.in);
        do {
            if (indice > 9) {
                System.out.println("La cantidad de compradores alcanzo el limite");
                seguir = 'n';
            }
            System.out.println("Digite el numero de factura:");
            factura[indice] = leer.nextInt();
            System.out.println("Digite su numero de cedula:");
            cedula[indice] = leer.nextInt();
            System.out.println("Digite su nombre:");
            nombre[indice] = leer.next();
            do {
                System.out.println("Digite la opcion de la localidad deseada:\n1- Sol Norte/Sur Precio: 10500\n2- Sombra Este/Oeste Precio: 20500\n3- Preferencial Precio: 25500");
                localidad[indice] = leer.nextInt();
                switch (localidad[indice]) {
                    case 1:
                        espacio[indice] = "Sol Norte/Sur";
                        System.out.println("Sol Norte/Sur");
                        break;
                    case 2:
                        espacio[indice] = "Sombra Este/Oeste";
                        System.out.println("Sombra Este/Oeste");
                        break;
                    case 3:
                        espacio[indice] = "Preferencial";
                        System.out.println("Preferencial");
                        break;
                }
            } while (localidad[indice] > 3);
            do {
                System.out.println("Cuantas entradas desea comprar? (*Maximo 4 entradas por cliente*)");
                entradas[indice] = leer.nextInt();
                if (entradas[indice] > 4) {
                    System.out.println("Maximo cuatro entradas por persona");
                }
            } while (entradas[indice] > 4);
            SistemaCobro();
            System.out.println("GRACIAS POR SU COMPRA\nNumero de factura: " + factura[indice] + "\nCedula: " + cedula[indice]
                    + "\nNombre: " + nombre[indice] + "\nLocalidad: " + espacio[indice] + "\nCantidad de entradas: " + entradas[indice]
                    + "\nSubtotal: " + subtotal[indice] + "\nCargos por servicio " + cargo[indice] + "\nTotal a pagar: " + total[indice]);
            indice++;
            System.out.println("Desea registrarse?");
            seguir = leer.next().toLowerCase().charAt(0);
        } while (seguir != 'n');
    }

    public static void SistemaCobro() {
        if (localidad[indice] == 1) {
            precioentra = 10500;
        }
        if (localidad[indice] == 2) {
            precioentra = 20500;
        }
        if (localidad[indice] == 3) {
            precioentra = 25500;
        }

        subtotal[indice] = precioentra * entradas[indice];
        cargo[indice] = 1000 * entradas[indice];
        total[indice] = subtotal[indice] + cargo[indice];

        if (localidad[indice] == 1) {
            acumulasol = acumulasol + subtotal[indice];
        }
        if (localidad[indice] == 2) {
            acumulasom = acumulasom + subtotal[indice];
        }
        if (localidad[indice] == 3) {
            acumulapref = acumulapref + subtotal[indice];
        }

        if (localidad[indice] == 1) {
            entrasol = entrasol + entradas[indice];
        }
        if (localidad[indice] == 2) {
            entrasom = entrasom + entradas[indice];
        }
        if (localidad[indice] == 3) {
            entrapref = entrapref + entradas[indice];
        }
    }

    public static void Vaciar() {
        for (int i = 0; i < cedula.length; i++) {
            factura[i] = 0;
            cedula[i] = 0;
            nombre[i] = "";
            localidad[i] = 0;
            entradas[i] = 0;
            subtotal[i] = 0;
            total[i] = 0;
            entrasol = 0;
            entrasom = 0;
            entrapref = 0;
            acumulasol = 0;
            acumulasom = 0;
            acumulapref = 0;
        }
        System.out.println("Datos inicializados en cero");
    }

    public static void Estadisticas() {
            System.out.println("-------------------------------------------------------");
            System.out.println("Cantidad de entradas en Localidad Sol Norte/Sur:" + entrasol);
            System.out.println("Dinero acumulado en Localidad Sol Norte/Sur: " + acumulasol);
            System.out.println("-------------------------------------------------------");
            System.out.println("Cantidad de entradas en Localidad Sombra Este/Oeste:" + entrasom);
            System.out.println("Dinero acumulado en Localidad Sombra Este/Oeste: " + acumulasom);
            System.out.println("-------------------------------------------------------");
            System.out.println("Cantidad de entradas en Localidad Preferencial:" + entrapref);
            System.out.println("Dinero acumulado en Localidad Preferencial: " + acumulapref);
            System.out.println("-------------------------------------------------------");
    }
}


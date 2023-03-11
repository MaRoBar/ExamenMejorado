package entradas;

import java.util.Scanner;

public class MenuEntradas {
    public byte opcion;
    public Scanner leer = new Scanner(System.in);
    
    public MenuEntradas(){
        opcion = 10;
    }
    public void Mostrar(){    
        do {
            System.out.println("BIENVENIDO A SU PROGRAMA");
            System.out.println("1- Incluir Comprador");
            System.out.println("2- Inicializar datos");
            System.out.println("3- Estadisticas");
            System.out.println("4- Salir");
            System.out.println("Digite una opcion");
            opcion = leer.nextByte();
            
            switch (opcion) {
                case 1: CompraEntradas.IncluirComprador();
                break;
                case 2: CompraEntradas.Vaciar();
                break;
                case 3: CompraEntradas.Estadisticas();
                break;
            } 
        }while (opcion!=4);
    }
}

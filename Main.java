public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // 5 ciudades: A–E

        // Agregamos las rutas según la tabla
        grafo.agregarArco('A', 'B', 3);
        grafo.agregarArco('A', 'D', 7);
        grafo.agregarArco('B', 'C', 1);
        grafo.agregarArco('B', 'E', 8);
        grafo.agregarArco('C', 'D', 2);
        grafo.agregarArco('D', 'E', 3);
        grafo.agregarArco('E', 'A', 4);

        // Imprimir matriz de adyacencia
        int[][] matriz = grafo.getMatriz();
        char[] ciudades = {'A', 'B', 'C', 'D', 'E'};

        System.out.println("Matriz de adyacencia:");
        System.out.print("    ");
        for (char ciudad : ciudades) {
            System.out.print(ciudad + "   ");
        }
        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            System.out.print(ciudades[i] + " ");
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] >= Integer.MAX_VALUE / 2) {
                    System.out.print("INF ");
                } else {
                    System.out.printf("%3d ", matriz[i][j]);
                }
            }
            System.out.println();
        }
    }
}

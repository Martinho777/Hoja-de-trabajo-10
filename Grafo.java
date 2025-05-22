import java.util.HashMap;

public class Grafo {
    private final int INF = Integer.MAX_VALUE / 2; // Usamos esto para representar ∞ sin desbordar al sumar
    private int[][] matriz;
    private HashMap<Character, Integer> mapaCiudades;

    public Grafo(int tamaño) {
        matriz = new int[tamaño][tamaño];
        mapaCiudades = new HashMap<>();

        // Inicializar todas las conexiones como infinitas, excepto cuando i == j
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = INF;
                }
            }
        }

        // Asignar letras a índices
        mapaCiudades.put('A', 0);
        mapaCiudades.put('B', 1);
        mapaCiudades.put('C', 2);
        mapaCiudades.put('D', 3);
        mapaCiudades.put('E', 4);
    }
}

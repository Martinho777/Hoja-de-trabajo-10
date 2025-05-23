import java.util.HashMap;

public class Grafo {
    private final int INF = Integer.MAX_VALUE / 2; // Usamos esto para representar ∞ sin desbordar
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

    public void agregarArco(char origen, char destino, int peso) {
        int i = mapaCiudades.get(origen);
        int j = mapaCiudades.get(destino);
        matriz[i][j] = peso;
    }

    public void eliminarArco(char origen, char destino) {
        int i = mapaCiudades.get(origen);
        int j = mapaCiudades.get(destino);
        matriz[i][j] = INF;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int[][] floydWarshall() {
    int n = matriz.length;
    int[][] dist = new int[n][n];

    // Copiar la matriz original a dist[][]
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dist[i][j] = matriz[i][j];
        }
    }

    // Aplicar el algoritmo de Floyd-Warshall
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    return dist;
    }
    //obtener el centro del grafo
    public char obtenerCentro() {
    int[][] distancias = floydWarshall();
    int n = distancias.length;
    int menorExcentricidad = INF;
    int indiceCentro = -1;

    for (int i = 0; i < n; i++) {
        int excentricidad = 0;
        for (int j = 0; j < n; j++) {
            if (distancias[i][j] > excentricidad) {
                excentricidad = distancias[i][j];
            }
        }

        if (excentricidad < menorExcentricidad) {
            menorExcentricidad = excentricidad;
            indiceCentro = i;
        }
    }

    // Buscar la letra correspondiente al índice
    for (var entrada : mapaCiudades.entrySet()) {
        if (entrada.getValue() == indiceCentro) {
            return entrada.getKey();
        }
    }

    return '?'; // Si algo falla

}

}


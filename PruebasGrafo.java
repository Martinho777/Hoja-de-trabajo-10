import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PruebasGrafo {

    @Test
    public void testAgregarYEliminarArco() {
        Grafo grafo = new Grafo(5);
        grafo.agregarArco('A', 'B', 3);
        assertEquals(3, grafo.getMatriz()[0][1]);

        grafo.eliminarArco('A', 'B');
        assertTrue(grafo.getMatriz()[0][1] >= Integer.MAX_VALUE / 2); // Verificamos que sea "infinito"
    }

    @Test
    public void testFloydWarshallBasico() {
        Grafo grafo = new Grafo(5);
        grafo.agregarArco('A', 'B', 3);
        grafo.agregarArco('B', 'C', 1);
        grafo.agregarArco('C', 'D', 2);
        grafo.agregarArco('D', 'E', 3);
        grafo.agregarArco('E', 'A', 4);

        int[][] resultado = grafo.floydWarshall();
        // A -> B -> C = 3 + 1 = 4
        assertEquals(4, resultado[0][2]);
        // A -> B -> C -> D = 3 + 1 + 2 = 6
        assertEquals(6, resultado[0][3]);
    }

    @Test
    public void testCentroDelGrafo() {
        Grafo grafo = new Grafo(5);
        grafo.agregarArco('A', 'B', 3);
        grafo.agregarArco('A', 'D', 7);
        grafo.agregarArco('B', 'C', 1);
        grafo.agregarArco('B', 'E', 8);
        grafo.agregarArco('C', 'D', 2);
        grafo.agregarArco('D', 'E', 3);
        grafo.agregarArco('E', 'A', 4);

        assertEquals('A', grafo.obtenerCentro());
    }
}

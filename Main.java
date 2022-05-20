/**
* @date 19/05/2022
*/

/*
   * Distancia entre ciudades - Algoritmo de Floyd.
   * La ruta más corta entre cada vértice en el gráfico estadístico.
 *
   * Parámetros:
   * Dibujo G
   * camino-el camino. ruta [i] [j] = k significa que la ruta más corta desde el "vértice i" al "vértice j" pasará por el vértice k.
   * matriz dist-length. Es decir, dist [i] [j] = sum indica que la longitud del camino más corto desde el "vértice i" hasta el "vértice j" es la suma.
 */
void floyd(Graph G, int path[][MAX], int dist[][MAX])
{
    int i,j,k;
    int tmp;
 
         // inicializar
    for (i = 0; i < G.vexnum; i++)
    {
        for (j = 0; j < G.vexnum; j++)
        {
                         dist [i] [j] = G.matrix [i] [j]; // La longitud de la ruta desde "vértice i" hasta "vértice j" es "peso de i a j".
                         ruta [i] [j] = j; // La distancia desde el "vértice i" al "vértice j" es a través del vértice j.
        }
    }
 
         // Calcular la distancia
    for (k = 0; k < G.vexnum; k++)
    {
        for (i = 0; i < G.vexnum; i++)
        {
            for (j = 0; j < G.vexnum; j++)
            {
                                 // Si la ruta que pasa por el índice k es más corta que la ruta entre los dos puntos originales, actualice dist [i] [j] y la ruta [i] [j]
                tmp = (dist[i][k]==INF || dist[k][j]==INF) ? INF : (dist[i][k] + dist[k][j]);
                if (dist[i][j] > tmp)
                {
                                         // El valor correspondiente a "la ruta mas corta de i a j" se establece en uno más pequeño (es decir, después de k)
                    dist[i][j] = tmp;
                                         // La ruta correspondiente a "i to j la ruta más corta", después de k
                    path[i][j] = path[i][k];
                }
            }
        }
    }
 
         // Imprimir el resultado de la distancia 
    printf("floyd: \n");
    for (i = 0; i < G.vexnum; i++)
    {
        for (j = 0; j < G.vexnum; j++)
            printf("%2d  ", dist[i][j]);
        printf("\n");
    }
}


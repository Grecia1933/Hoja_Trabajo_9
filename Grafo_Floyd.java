#include<iostream>
#include<string>
using namespace std; 

class Grafo_Floyd { 
  private:
    int vexnum; // Número de vertices del gráfico 
    int edge; // Número de aristas del gráfico 
    int arc; // Matriz de Adyacencia 
    int dis; // Registro de la información acerca de la ruta más corta entre cada vertice 
    int path; // Registro de la información de cada ruta corta 
  
public : 
  // Constructor 
  Grafo_Floyd(int vexnum, int edge); 
  // Destructor 
   ~Grafo_Floyd();
    // Verificar si la información del borde ingresada es legal cada vez
    // Los vértices están numerados de 1
    bool check_edge_value(int start, int end, int weight);
    // Crear gráfico
    void createGraph(int);
    // Imprimir la matriz de adyacencia
    void print();
    // Encuentrar el camino más corto
    void Floyd();
    // Imprimir el camino más corto
    void print_path();
};

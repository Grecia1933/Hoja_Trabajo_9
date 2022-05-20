#include"Floyd.h"
 
 
// Constructor
Grafo_Floyd::Grafo_Floyd(int vexnum, int edge) {
    // Inicializa el número de vértices y aristas
    this->vexnum = vexnum;
    this->edge = edge;
    // Abrir el espacio y asignar valores iniciales para la matriz de adyacencia
    arc = new int*[this->vexnum];
    dis = new int*[this->vexnum];
    path = new int*[this->vexnum];
    for (int i = 0; i < this->vexnum; i++) {
        arc[i] = new int[this->vexnum];
        dis[i] = new int[this->vexnum];
        path[i] = new int[this->vexnum];
        for (int k = 0; k < this->vexnum; k++) {
            // La matriz de adyacencia se inicializa al infinito
            arc[i][k] = INT_MAX;
        }
    }
}
// Destructor
Grafo_Floyd::~Grafo_Floyd() {
 
    for (int i = 0; i < this->vexnum; i++) {
        delete this->arc[i];
        delete this->dis[i];
        delete this->path[i];
 
    }
    delete dis;
    delete arc;
    delete path;
}
 

// Los vértices están numerados de 1
bool Grafo_Floyd::check_edge_value(int start, int end, int weight) {
    if (start<1 || end<1 || start>vexnum || end>vexnum || weight < 0) {
        return false;
    }
    return true;
}
 
void Grafo_Floyd::createGraph(int kind) {
    cout << "Ingrese el inicio y el final de cada borde (el número de vértice comienza desde 1) y su peso" << endl;
    int start;
    int end;
    int weight;
    int count = 0;
    while (count != this->edge) {
        cin >> start >> end >> weight;
        // Primero determine si la información de borde es legal
        while (!this->check_edge_value(start, end, weight)) {
            cout << "La información ingresada es ilegal, vuelva a ingresar" << endl;
            cin >> start >> end >> weight;
        }
        // Asigna los puntos correspondientes en la matriz de adyacencia
        arc[start - 1][end - 1] = weight;
        // Agregue esta línea de código al gráfico no dirigido
        if(kind==2)
        arc[end - 1][start - 1] = weight;
        ++count;
    }
}
 
void Grafo_Floyd::print() {
    cout << "La matriz de adyacencia del gráfico es:" << endl;
    int count_row = 0; // Imprime la etiqueta de la línea
    int count_col = 0; // Imprime la etiqueta de la columna
                       // Comienza a imprimir
    while (count_row != this->vexnum) {
        count_col = 0;
        while (count_col != this->vexnum) {
            if (arc[count_row][count_col] == INT_MAX)
                cout << "∞" << " ";
            else
                cout << arc[count_row][count_col] << " ";
            ++count_col;
        }
        cout << endl;
        ++count_row;
    }
}
 
void Grafo_Floyd::Floyd() {
    int row = 0;
    int col = 0;
    for (row = 0; row < this->vexnum; row++) {
        for (col = 0; col < this->vexnum; col++) {
            // Inicializa la matriz D al valor de la matriz de adyacencia
            this->dis[row][col] = this->arc[row][col];
            // El valor inicial de la matriz P es el índice del vértice final de cada borde
            this->path[row][col] = col;
        }
    }
 
    // Triple loop, usado para calcular la ruta más corta de cada par de puntos
    int temp = 0;
    int select = 0;
    for (temp = 0; temp < this->vexnum; temp++) {
        for (row = 0; row < this->vexnum; row++) {
            for (col = 0; col < this->vexnum; col++) {
                // Para evitar el desbordamiento, es necesario introducir un valor de selección
                select = (dis[row][temp] == INT_MAX || dis[temp][col] == INT_MAX) ? INT_MAX : (dis[row][temp] + dis[temp][col]);
                if (this->dis[row][col] > select) {
                    // Actualiza nuestra matriz D
                    this->dis[row][col] = select;
                    // Actualiza nuestra matriz P
                    this->path[row][col] = this->path[row][temp];
                }
            }
        }
    }
}
 
void Grafo_Floyd::print_path() {
    cout << "La ruta más corta de cada par de vértices:" << endl;
    int row = 0;
    int col = 0;
    int temp = 0;
    for (row = 0; row < this->vexnum; row++) {
        for (col = row + 1; col < this->vexnum; col++) {
            cout << "v" << to_string(row + 1) << "---" << "v" << to_string(col+1) << " weight: "
                << this->dis[row][col] << " path: " << " v" << to_string(row + 1);
            temp = path[row][col];
            // Cada ruta de la ruta de salida del bucle.
            while (temp != col) {
                cout << "-->" << "v" << to_string(temp + 1);
                temp = path[temp][col];
            }
            cout << "-->" << "v" << to_string(col + 1) << endl;
        }
 
        cout << endl;
    }
}


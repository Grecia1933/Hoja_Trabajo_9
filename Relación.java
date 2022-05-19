#include"Floyd.h"
 
 
// La relación entre el número de vértices y el número de aristas es: ((Vexnum * (Vexnum-1)) / 2) <edge
bool check(int Vexnum, int edge) {
    if (Vexnum <= 0 || edge <= 0 || ((Vexnum*(Vexnum - 1)) / 2) < edge)
        return false;
    return true;
}
int main() {
    int vexnum; int edge;
    cout << "Tipos de gráficos de entrada: 1 para gráficos dirigidos, 2 para gráficos no dirigidos" << endl;
    int kind;
    cin >> kind;
    // Determinar si el tipo de entrada es legal
    while (1) {
        if (kind == 1 || kind == 2) {
            break;
        }
        else {
            cout << "El número de tipo de la imagen de entrada es ilegal, vuelva a ingresar: 1 para el gráfico dirigido, 2 para el gráfico no dirigido << endl;
            cin >> kind;
        }
    }
    cout << "Número de vértices y aristas del gráfico de entrada:" << endl;
    cin >> vexnum >> edge;
    while (!check(vexnum, edge)) {
        cout << "El valor ingresado es ilegal, vuelva a ingresar" << endl;
        cin >> vexnum >> edge;
    }
    Grafo_Ciudad graph(vexnum, edge);
    graph.createGraph(kind);
    graph.print();
    graph.Floyd();
    graph.print_path();
    system("pause");
    return 0;
}


import java.util.Scanner;

class Matrix {
    private Scanner Scanf = new Scanner(System.in);
    private int m;
    private int n;
    private int matrix[][];

    //Inicializar la variable con la dimensión deseada
    public void SetDimention(int m, int n) {
        this.m = m;
        this.n = n;
        Memory();
    }

    //Reserva la memoria adecuada deacuerdo a las dimensiones
    private void Memory() {
        matrix = new int[m][n];
    }

    //Inicializar los valores de cada posición de la matriz
    public void SetValues() {
        System.out.println("Matrix[" + m + "][" + n + "]");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                System.out.print("Matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = Scanf.nextInt();
            }
    }

    //Cambiar el valor de una posición de la matriz
    public void SetValue(int m, int n, int v) {
        matrix[m][n] = v;
    }

    //Imprime la matriz
    public void PrintMatrix() {
        System.out.println("Matrix[" + m + "][" + n + "]" + " = ");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (j == n - 1)
                    System.out.println(" | " + matrix[i][j] + " | ");
                else
                    System.out.print(" | " + matrix[i][j]);
            }
    }

    //Operacion de suma entre matrices 
    public void AddMatrix(Matrix B) {
        if (m != B.m || n != B.n) {
            System.out.println("No se puede hacer suma");
        } else {
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    matrix[i][j] += B.matrix[i][j];
                }
        }
    }

    //Operación de resta entre matrices
    public void DiffMatrix(Matrix B) {
        if (m != B.m || n != B.n) {
            System.out.println("No se puede hacer Resta");
        } else {
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    matrix[i][j] -= B.matrix[i][j];
                }
        }
    }

    //Operacion de multiplicacion entre matrices
    public void MultMatrix(Matrix B) {
        Matrix aux = new Matrix();
        aux.SetDimention(m, B.n);

        if (n != B.m) {
            System.out.println("No se puede hacer Multiplicacion");
        } 
        else {
            for (int i = 0; i < m; i++)
                for (int j = 0; j < B.n; j++) {
                    aux.matrix[i][j] = 0;
                    for (int k = 0; k < n; k++)
                        aux.matrix[i][j] += this.matrix[i][k] * B.matrix[k][j];
                }
        }
        

        this.SetDimention(m, B.n);

        for(int i = 0; i < m; i++)
           for(int j = 0; j < B.n; j++)
               this.matrix[i][j] = aux.matrix[i][j];
    }

}

public class matrices {
    public static void main(String argumentos[]) {
        Matrix A, B;
        A = new Matrix();
        B = new Matrix();


        A.SetDimention(2, 3);
        B.SetDimention(3, 2);

        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 3; j++){
                A.SetValue(i, j, 1);
            }

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 2; j++){
                B.SetValue(i, j, 1);
            }



        
        System.out.println("A");
        A.PrintMatrix();
        System.out.println("B");
        B.PrintMatrix();
    
        A.MultMatrix(B);
        A.PrintMatrix();

    }
}
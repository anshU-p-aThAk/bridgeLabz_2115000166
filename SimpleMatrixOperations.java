import java.util.Random;

public class SimpleMatrixOperations {

    public static void main(String[] args) {
        int rows = 3, cols = 3;

        int[][] matrix1 = generateRandomMatrix(rows, cols);
        int[][] matrix2 = generateRandomMatrix(rows, cols);

        System.out.println("Matrix 1:");
        displayMatrix(matrix1);

        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        int[][] sum = addMatrices(matrix1, matrix2);
        System.out.println("Sum of Matrix 1 and Matrix 2:");
        displayMatrix(sum);

        int[][] difference = subtractMatrices(matrix1, matrix2);
        System.out.println("Difference of Matrix 1 and Matrix 2:");
        displayMatrix(difference);

        int[][] product = multiplyMatrices(matrix1, matrix2);
        System.out.println("Product of Matrix 1 and Matrix 2:");
        displayMatrix(product);

        int[][] transpose = transposeMatrix(matrix1);
        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transpose);

        if (rows == 2) {
            System.out.println("Determinant of Matrix 1: " + determinant2x2(matrix1));
        }

        if (rows == 3) {
            System.out.println("Determinant of Matrix 1: " + determinant3x3(matrix1));
        }
    }

    public static int[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10) + 1; // Random values from 1 to 10
            }
        }

        return matrix;
    }

    public static int[][] addMatrices(int[][] m1, int[][] m2) {
        int rows = m1.length;
        int cols = m1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return result;
    }

    public static int[][] subtractMatrices(int[][] m1, int[][] m2) {
        int rows = m1.length;
        int cols = m1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = m1[i][j] - m2[i][j];
            }
        }

        return result;
    }

    public static int[][] multiplyMatrices(int[][] m1, int[][] m2) {
        int rows = m1.length;
        int cols = m2[0].length;
        int common = m1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}

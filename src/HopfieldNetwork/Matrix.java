package HopfieldNetwork;

/**
 * Matrice math�matique, g�rer l'initialisation et les op�rations d'addition de
 * matrices et multiplication avec un vecteur.
 */
public class Matrix {

    /**
     * Multiplier une matrice et un vecteur
     * @param matrix (double), la matrice
     * @param vector (double), le vecteur
     * @return (double), le vecteur r�sultant
     */
    public static double[] matrixVectorMultiplication(double[][] matrix, double[] vector) {

        double[] result = new double[vector.length];

        for (int i = 0; i < matrix.length; ++i) {
            double sum = 0;

            for (int j = 0; j < matrix.length; ++j)
                sum += matrix[i][j] * vector[j];

            result[i] = sum;
        }

        return result;
    }

    /**
     * Initialiser une matrice de taille donn�e.
     * @param numOfRows (int), entier du nombre de lignes
     * @param numOfCols (int), entier du nombre de colonnes
     * @return (double), la matrice
     */
    public static double[][] createMatrix(int numOfRows, int numOfCols) {
        return new double[numOfRows][numOfCols];
    }

    /**
     * Produit externe d'un vecteur afin d'obtenir la matrice correspondante
     * @param vector (double), le vecteur
     * @return (double), la matrice r�sultant du produit externe
     */
    public static double[][] outerProduct(double[] vector) {

        double[][] result = new double[vector.length][vector.length];

        for (int i = 0; i < vector.length; ++i)
            for (int j = 0; j < vector.length; ++j)
                result[i][j] = vector[i] * vector[j];

        return result;
    }

    /**
     * Mettre la diagonale de la matrice � 0.
     * @param matrix (double), la matrice � modifier
     * @return (double), la matrice avce la diagonale � 0.
     */
    public static double[][] clearDiagonals(double[][] matrix) {

        for (int i = 0; i < matrix.length; ++i)
            matrix[i][i] = 0;

        return matrix;
    }

    /**
     * Additionner deux matrices
     * @param matrix1 (double), premi�re matrice � additionner
     * @param matrix2 (double), deuxi�me matrice � additionner
     * @return result (double), la somme des matrices
     */
    public static double[][] addMatrix(double[][] matrix1, double[][] matrix2) {

        double[][] result = new double[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; ++i)
            for (int j = 0; j < matrix1.length; ++j)
                result[i][j] = matrix1[i][j] + matrix2[i][j];

        return result;
    }
    
}

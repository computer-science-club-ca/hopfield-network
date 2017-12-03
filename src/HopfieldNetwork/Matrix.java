package HopfieldNetwork;

/**
 * Matrice mathématique, gérer l'initialisation et les opérations d'addition de
 * matrices et multiplication avec un vecteur.
 */
public class Matrix {

    /**
     * Multiplier une matrice et un vecteur
     * @param matrix (double), la matrice
     * @param vector (double), le vecteur
     * @return (double), le vecteur résultant
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
     * Initialiser une matrice de taille donnée.
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
     * @return (double), la matrice résultant du produit externe
     */
    public static double[][] outerProduct(double[] vector) {

        double[][] result = new double[vector.length][vector.length];

        for (int i = 0; i < vector.length; ++i)
            for (int j = 0; j < vector.length; ++j)
                result[i][j] = vector[i] * vector[j];

        return result;
    }

    /**
     * Mettre la diagonale de la matrice à 0.
     * @param matrix (double), la matrice à modifier
     * @return (double), la matrice avce la diagonale à 0.
     */
    public static double[][] clearDiagonals(double[][] matrix) {

        for (int i = 0; i < matrix.length; ++i)
            matrix[i][i] = 0;

        return matrix;
    }

    /**
     * Additionner deux matrices
     * @param matrix1 (double), première matrice à additionner
     * @param matrix2 (double), deuxième matrice à additionner
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

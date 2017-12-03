package HopfieldNetwork;

/**
 * L'Algorithme du r�seau d'Hopfield est un entrainement non supervis� pour la
 * reconnaissance de motifs (patterns). C'est un bon exercice, car on met en
 * pratique les notions d'apprentissage/entrainement d'un r�seau de neurones,
 * puis on on tente d'identifier des patterns. 
 * Note : l'inverses des patterns appris sont reconnus (c'est un d�faut de cette m�thode). 
 * Note : plus il y a d'apprentissages, moins le r�seau reconnaitra correctement les patterns...
 */
public class HopfieldNetwork {

    // Matrice de connaissances qui re�oit l'entrainement et � l'aide de
    // laquelle on compare.
    private double[][] knowledgeMatrix;

    public HopfieldNetwork(int dimension) {
        this.knowledgeMatrix = new double[dimension][dimension];
    }

    /**
     * Entrainement du r�seau
     * 
     * @param pattern
     *            (double), le vecteur d'un pattern � apprendre.
     */
    public void train(double[] pattern) {

        double[] patternBipolar = getBipolarFormat(pattern);
        double[][] patternMatrix = Matrix.createMatrix(patternBipolar.length, patternBipolar.length);

        // D�finir le pattern dans la matrice
        patternMatrix = Matrix.outerProduct(patternBipolar);
        patternMatrix = Matrix.clearDiagonals(patternMatrix);

        // Conserver le pattern dans la matrice de connaissance � l'aide de
        // l'addition
        this.knowledgeMatrix = Matrix.addMatrix(this.knowledgeMatrix, patternMatrix);
    }

    /**
     * V�rifier si un pattern est reconnu.
     * 
     * @param pattern
     *            (double), vecteur d'un pattern � reconnaitre
     * @return (boolean), true si trouv�, sinon false
     */
    public boolean isRecall(double[] pattern) {

        double[] patternBipolar = getBipolarFormat(pattern);
        double[] result = Matrix.matrixVectorMultiplication(this.knowledgeMatrix, patternBipolar);

        for (int i = 0; i < patternBipolar.length; ++i) {
            result[i] = activationFunction(result[i]);
        }

        for (int i = 0; i < patternBipolar.length; ++i) {
            if (patternBipolar[i] != result[i]) {
                System.out.println("Pattern non reconnu...");
                return false;
            }
        }
        System.out.println("Pattern reconnu...");
        return true;

    }

    /**
     * La fonction d'activation pour un r�seau d'Hopfield : Si plus grand ou
     * �gale � 0 alors retourner 1. Sinon retourner -1.
     * 
     * @param x
     *            (double), valeur � tester pour l'activation
     * @return result (int), la valeur activ�e 1, ou non -1
     */
    private static int activationFunction(double x) {

        int result;
        if (x >= 0) {
            result = 1;
        } else {
            result = -1;
        }
        return result;
    }

    /**
     * Transformer un pattern dans sa forme bipolaire : convertir les 0 en -1
     * 
     * @param pattern
     *            (double), vecteur
     * @return pattern (double), vecteur du pattern dans sa forme bipolaire
     */
    private double[] getBipolarFormat(double[] pattern) {

        for (int i = 0; i < pattern.length; ++i) {
            if (pattern[i] == 0) {
                pattern[i] = -1;
            }
        }
        return pattern;
    }
}

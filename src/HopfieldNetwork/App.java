package HopfieldNetwork;

/**
 * Lancer l'application d'un réseau d'Hopfield
 */
public class App {

    public static void main(String[] args) {

        HopfieldNetwork hopfieldNetwork = new HopfieldNetwork(4);
        //Apprendre deux patterns
        hopfieldNetwork.train(new double[] { 1, 0, 1, 0 });
        hopfieldNetwork.train(new double[] { 1, 1, 1, 1 });

        // Patterns non reconnus
        hopfieldNetwork.isRecall(new double[] { 1, 0, 1, 1 });
        hopfieldNetwork.isRecall(new double[] { 1, 0, 0, 1 });
        hopfieldNetwork.isRecall(new double[] { 1, 1, 0, 1 });
        hopfieldNetwork.isRecall(new double[] { 0, 0, 0, 1 });
        hopfieldNetwork.isRecall(new double[] { 0, 1, 0, 0 });
        hopfieldNetwork.isRecall(new double[] { 0, 0, 1, 0 });
        hopfieldNetwork.isRecall(new double[] { 1, 0, 0, 0 });
        hopfieldNetwork.isRecall(new double[] { 0, 1, 1, 0 });

        // Patterns reconnus
        hopfieldNetwork.isRecall(new double[] { 1, 1, 1, 1 });
        hopfieldNetwork.isRecall(new double[] { 1, 0, 1, 0 });
        // Patterns reconnus, car ils sont l'inverses de ceux appris : problème
        // avec le réseau d'Hopfield
        hopfieldNetwork.isRecall(new double[] { 0, 0, 0, 0 });
        hopfieldNetwork.isRecall(new double[] { 0, 1, 0, 1 });

    }
}

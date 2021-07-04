public class wheee {
    public static void main(String[] args) {
        int zahl = 5;
        //Fortlaufende Schleife
        for (int i = 1; i <= zahl; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        //Rücklaufende Schleife
        for (int i = zahl-1; i >= 1; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
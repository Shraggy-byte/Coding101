public class Ladebalken {
    //Methode zur Darstellung des Ladebalkens
    public void laden(int progress){
        System.out.print("[");
        for(int i = 0; i<progress; i++){
            System.out.print("#");
        }
        for(int i = 0; i<(10-progress);i++){
            System.out.print(" ");
        }
        System.out.print("] ");
        if(progress == 10){
            System.out.print("100 %");
        }else{
            System.out.print(" "+progress*10+" %");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        Ladebalken laden = new Ladebalken();
        int state = 0;
        //Aufruf der Methoden in einer Schleife
        for (int i = state / 10; i <= 10; i++) {
            laden.laden(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

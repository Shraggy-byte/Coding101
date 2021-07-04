public class Matrix {
    public static void main(String[] args) {
        int width = 3;
        int length = 3;
        int randoms = 9;
        //Zähler für die Setzung der Sterne
        int count = 1;
        //Variablen um zu schauen ob die Zufallszahl bereits im Array ist
        int check;
        boolean check2;
        //Variable zum setzen der Sterne
        boolean further = true;
        int [] numbers = new int [randoms];
        //Einfügen der Random Int-Werte in das Array
        for(int i = 1; i<=randoms; i++){
            do{
                check2 = true;
                check = (int) ((Math.random() * (width * length + 1)));
                for(int j = 0; j<numbers.length;j++){
                    if(numbers[j] == check) {
                        check2 = false;
                        break;
                    }
                }
            }while(!check2);
            numbers[i - 1] = check;
            //System.out.println(numbers[i-1]);
        }

        //Ausgabe
        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= width; j++) {
                for (int k = 0; k < randoms; k++) {
                    if (count == numbers[k]) {
                        System.out.print("*");
                        further = false;
                    }
                }
                count++;
                if (further) {
                    System.out.print("#");
                }
                further = true;
            }System.out.println("");
        }
    }
}

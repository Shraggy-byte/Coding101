import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args) {
        int age;
        boolean korrekt = true;
        String text;
        String username = "Daniel";
        String password = "123";
        String filename = "test.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Abfragen/Zahlenausgabe\n2. beliebiger Text in Datei\nEingabe: ");
        //option1 Altersabfrage, Einloggen und Ausgabe von Zahlen
        if (scanner.nextInt() == 1) {
            System.out.println("Alter eingeben: ");
            age = scanner.nextInt();
            if (age < 18) {
                System.out.println("Nicht alt genug");
            } else {
                do {
                    System.out.print("Benutzername: ");
                    if (username.equals(scanner.next())) {
                        System.out.print("Passwort: ");
                        if (password.equals(scanner.next())) {
                            korrekt = true;
                        } else {
                            korrekt = false;
                        }
                    } else {
                        korrekt = false;
                    }
                } while (!korrekt);
                try {
                    File output = new File(filename);
                    output.createNewFile();

                    PrintWriter pw = new PrintWriter(new FileWriter(output));
                    for (int i = 1; i <= 99; i++) {
                        if ((i % 5) == 0) {
                            pw.println(i);
                        } else {
                            System.out.println(i);
                        }
                    }
                    pw.flush();
                    pw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //option2 beschreiben einer Text Datei mit Wunschtext
        } else {
            System.out.println("enter text: ");
            scanner.nextLine();
            text = scanner.nextLine();
            do {
                System.out.print("save to file: ");
                filename = scanner.next();
            }while(filename.contains("../"));
            try {
                File output = new File(filename);
                output.createNewFile();
                PrintWriter pw = new PrintWriter(new FileWriter(output));
                pw.println(text);
                pw.flush();
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
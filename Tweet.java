import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tweet {
    public static void main(String[] args) {
        //String textfile = "test.txt";

        //Path/Verzeichnis der Textdateien
        File f = new File("C:/Users/Daniel/eclipse-workspace/coding101");
        //Dateien des Verzeichnises in einem Array speichern
        String[] pathnamesinput = f.list();
        //Name der output Datei
        String filenameoutput = "output.txt";
        int randoms = 20;
        //Variable zum Zöhlen der Wörter / Variable der maximalen Wörter
        int count = 0;
        int maxcount = 10000;
        //Zwischenspeicher eines Wortes
        String word;
        List<String> wordslist = new ArrayList<>();
        Scanner scanner = null;
        //Wörter der Dateien werden in einem Array gespeichert
        for (String pathname : pathnamesinput) {
            if (pathname.contains(".txt")) {
                try {
                    scanner = new Scanner(new File(pathname));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                while (scanner.hasNext()) {
                    word = scanner.next();
                    if ((count = count + word.length()) < maxcount) {
                        wordslist.add(word);
                    }
                }
            }
        }
        //durchmischen des Arrays
        Collections.shuffle(wordslist);
        //Datei wird geöffnet und beschrieben
        try {
            File output = new File(filenameoutput);
            output.createNewFile();
            PrintWriter pw = new PrintWriter(new FileWriter(output));
            for (int i = 0; i < randoms; i++) {
                pw.print(wordslist.get(i)+" ");
            }
            pw.flush();
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
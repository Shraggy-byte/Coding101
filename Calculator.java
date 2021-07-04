import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    //Methoden für die Rechnung

    public double solve(String operator, double number1, double number2){
        switch (operator) {
            case "\\+":
                return number1 + number2;
            case "\\-":
                return number1 - number2;
            case "\\*":
                return number1 * number2;
            case "\\/":
                return number1 / number2;
        }
        return 0;
    }


    public double rechnen(String input) {
        double number1, number2;
        int operatorplace = 0;
        String operator = " ";
        List<String> operators = new ArrayList<>();
        List<Integer> operatorsplace = new ArrayList<>();
        //Suche nach dem Operator im String
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '*':
                    operator = "\\*";
                    operators.add(operator);
                    operatorsplace.add(i);
                    break;
                case '/':
                    operator = "\\/";
                    operators.add(operator);
                    operatorsplace.add(i);
                    break;
                case '+':
                    operator = "\\+";
                    operators.add(operator);
                    operatorsplace.add(i);
                    break;
                case '-':
                    operator = "\\-";
                    operators.add(operator);
                    operatorsplace.add(i);
                    break;
            }
        }
        if(operators.size() == operatorsplace.size()){
            switch(operators.size()){
                case 1:
                    operator = operators.get(0); //falls 1 operator dann den nehmen
                    operatorplace = operatorsplace.get(0);
                    break;
                case 3:
                    operator = operators.get(1); //falls 3 operatoren dann mitte
                    operatorplace = operatorsplace.get(1);
                    break;
                case 2:
                    //System.out.println(input.substring(operatorsplace.get(0)+1,operatorsplace.get(1)));
                    if(input.substring(operatorsplace.get(0)+1,operatorsplace.get(1)).matches("(.*)\\d(.*)")){
                        //System.out.println("Test");
                        operator = operators.get(1);
                        operatorplace = operatorsplace.get(1);
                    }else {
                        operator = operators.get(0);
                        operatorplace = operatorsplace.get(0);
                    }
                    break;
            }
        }else{
            return 0;
        }
        //Umwandlung der Zahlen in eine Int-Variable
        if (!operator.equals(" ")) {
            //String[] zahlen = input.split(operator);
            String number1str = input.substring(0, operatorplace);
            String number2str = input.substring(operatorplace+1);
            number1str = number1str.replaceAll("[\\D+&&[^(.\\-)]]", "");
            //System.out.println(number1str);
            number2str = number2str.replaceAll("[\\D+&&[^(.\\-)]]", ""); //Zahlen aus String nehmen (ohne Leerzeichen) zum parsen
            //System.out.println(number2str);
            number1 = Double.parseDouble(number1str);
            number2 = Double.parseDouble(number2str);
        } else {
            return 0;
        }
        //Berechnung nach Operator
        return solve(operator, number1, number2);
    }


    public double rechnen(String input, double number1) {
        String operator = " ";
        double number2;
        List<String> operators = new ArrayList<>();
        List<Integer> operatorsplace = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '*':
                    operator = "\\*";
                    operators.add(operator);
                    operatorsplace.add(i);
                    break;
                case '/':
                    operator = "\\/";
                    operators.add(operator);
                    operatorsplace.add(i);
                    break;
                case '+':
                    operator = "\\+";
                    operators.add(operator);
                    operatorsplace.add(i);
                    break;
                case '-':
                    operator = "\\-";
                    operators.add(operator);
                    operatorsplace.add(i);
                    break;
            }
        }
        if (!operator.equals(" ")) {
            if(operators.size() == 2){
                input = input.substring(operatorsplace.get(1));
                String numbers = input.replaceAll("[\\D+&&[^(.\\-)]]", "");
                //System.out.println(numbers);
                number2 = Double.parseDouble(numbers);
            }else{
                String numbers = input.replaceAll("[\\D+&&[^(.)]]", "");
                //System.out.println(numbers);
                number2 = Double.parseDouble(numbers);
            }
        } else {
            return 0;
        }
    return solve(operators.get(0), number1, number2);
    }


    public boolean check(String input) {
        boolean numbercheck = false;
        boolean operatorcheck = false;
        //Check ob 2 Zahlen und ein Operator existieren
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) { numbercheck = true; }
            if (numbercheck) {
                switch (input.charAt(i)) {
                    case '*':
                    case '/':
                    case '+':
                    case '-':
                        operatorcheck = true;
                        break;
                }
            }
            if ((operatorcheck) & (Character.isDigit(input.charAt(i)))) { return true; }
        }
        return false;
    }


    public static void main(String[] args) {
        String input;
        Calculator rechnen = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean clear = true;
        double prev = 0;
        //Schleife mit Aufruf der Methoden
        do {
            System.out.print("Eingabe: ");
            input = scanner.nextLine();
            if (input.equals("clear")) {clear = true;continue;}
            if (rechnen.check(input)) {clear = true;}
            if (clear) {
                prev = rechnen.rechnen(input);
                System.out.println("Ausgabe: " + prev);
                clear = false;
            }else{
                prev = rechnen.rechnen(input, prev);
                System.out.println("Ausgabe: " + prev);
            }
        }while (true) ;
    }
}
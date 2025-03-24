import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args){
    
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hvor mange rader vil du ha?: ");
        int rad = scanner.nextInt();

        System.out.print("Hvor mange kolonner vil du ha?: ");
        int kolonne = scanner.nextInt();

        /*System.out.print("Hvor mange generasjoner skal den ha?: ");
        int ganger = scanner.nextInt();*/

        Verden verden = new Verden(rad,kolonne);
        verden.tegn();

        System.out.print("Trykk 1 for å generere og 0 for å avslutte: ");
        int input = scanner.nextInt();

        while (input == 1){
            verden.oppdatering();
            verden.tegn();
            System.out.print("Trykk 1 for å generere og 0 for å avslutte: ");
            input = scanner.nextInt();
        }
        
        System.exit(1);
        
        
    }

}

import java.util.Scanner;

public class Ratespiel {

    public static void main(String[] args) {
        int[] arrOf100 = new int[100];
        for (int i = 0; i < arrOf100.length; i++) {
            arrOf100[i] = 1;
        }

        int max = 99;
        int tries = 10;
        int rand;
        for (int i = 0; i < tries; i++) {
            rand = (int) (Math.random() * max); //generiere 10 randome Nummern €[0;99]
            if (arrOf100[rand] == 1) {
                arrOf100[rand] = 0; // Stelle im 100er Array mit der Zahl 0 überschreiben
            } else {                // wenn die Stelle im 100er Array ist schon gleich 0, eine weitere Stelle suchen
                tries++;            // den Counter ausgleichen
            }
        }

        Scanner scn = new Scanner(System.in);
        int input = -1;
        int counter = 0;
        do {
            int eingabe = -1;
            while (eingabe == -1) {
                try {
                    System.out.println("Geben Sie bitte eine Zahl zwischen 0 und 99 inklusiv:");
                    eingabe = scn.nextInt();
                    if (eingabe < 0 || eingabe > 99) {
                        System.out.println("Bitte nur gueltige Zahl.");
                        eingabe = -1;
                    }
                    scn.nextLine();
                } catch (Exception e) {
                    System.out.println("Bitte nur Zahlen eingeben!");
                    scn.nextLine();
                }
            }
            if (arrOf100[eingabe] == 2 || arrOf100[eingabe] == 3) {
                System.out.println("hatten wir schon");
            } else {
                if (arrOf100[eingabe] == 0) {
                    System.out.println("Treffer");
                    arrOf100[eingabe] = 2;
                } else {
                    System.out.println("daneben");
                    arrOf100[eingabe] = 3;
                }
                counter++;
            }
        }

        while (counter != 10);
        // wird Anzahl von Zweier im 100er Array kalkuliert und am Ende die Summe von Zweiern ausgegeben
        int counterOfTwo = 0;
        for (int i = 0; i < arrOf100.length; i++) {
            if (arrOf100[i] == 2) {
                counterOfTwo++;
            }
        }
        System.out.print("Anzahl von Zweier = " + counterOfTwo);
        scn.close();
    }
}
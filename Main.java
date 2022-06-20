import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String ISBN;
        boolean poprawnosc = false;
        Scanner skaner = new Scanner(System.in);

        System.out.println();
        System.out.print("Podaj numer ISBN10: ");
        ISBN = skaner.nextLine();

        poprawnosc = Weryfikacja(ISBN);

        if (poprawnosc == true) {
            System.out.println();
            System.out.println("Numer ISBN " + ISBN + " jest prawidłowy!");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Numer ISBN " + ISBN + " jest nieprawidłowy!");
            System.out.println();
        }

        skaner.close();
    }

    public static boolean Weryfikacja(String ISBN) {

        boolean wynik = false;
        int osobno[] = new int[10];
        int suma = 0;
        int kontrolna = 0;

        ISBN = ISBN.replaceFirst(" ", "");
        ISBN = ISBN.replaceAll("-", "");

        if (ISBN.length() != 10 && ISBN.length() != 15) {
            wynik = false;
        } else {
            for (int i = 0; i < 10; i++) {
                osobno[i] = Integer.parseInt(ISBN.substring(i, i + 1));
            }

            kontrolna = osobno[9];

            for (int j = 0; j < 9; j++) {
                suma = suma + (10 - j) * osobno[j];
            }

            suma = suma % 11;
            suma = 11 - suma;
            suma = suma % 11;

            if (suma == kontrolna) {
                wynik = true;
            }

        }

        return wynik;
    }

}
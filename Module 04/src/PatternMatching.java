import java.util.*;
 /*
Skriv et program som får inn to strenger fra bruker,  str og pattern,  og som sjekker ut om pattern finnes inni str,
dersom den finnes så skal program returnere indeks for første tegn av pattern inni str, ellers skal den returnere -1.
*/
public class PatternMatching {
    public static void main(String[] args) {
        String str;
        String pattern;
        Scanner input = new Scanner(System.in);

        System.out.println("- Skriv inn til programmet -\n");
        System.out.print("str: ");
        str = input.nextLine();
        pattern = input.nextLine();
    }

}
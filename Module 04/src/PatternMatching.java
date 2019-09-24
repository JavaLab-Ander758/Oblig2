import java.util.*;
 /*
Skriv et program som får inn to strenger fra bruker,  str og pattern,  og som sjekker ut om pattern finnes inni str,
dersom den finnes så skal program returnere indeks for første tegn av pattern inni str, ellers skal den returnere -1.
*/
public class PatternMatching {
     public String matching(String str, String pattern) {

         int index = -1;
         int k = 0;
         for (int i = 0; i < str.length(); i++) {
             if (k == pattern.length()) {
                 //returner index av start match
             } else
                 System.out.print(str.charAt(i));
                 k++;
   // else
          //   k = 0;
         }
         return "Lol";
     }
 }
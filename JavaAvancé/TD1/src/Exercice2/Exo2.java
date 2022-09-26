package Exercice2;
import java.util.*;
import java.io.*;

public class Exo2 {
    public static void main(String argv[]) {
        ecritureMultiple();
    }
    public static void ecritureMultiple(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Multiples de : ");
            float a = sc.nextFloat();
            System.out.println("jusqu'à : ");
            float b = sc.nextFloat();
            BufferedWriter bw = new BufferedWriter(new FileWriter("multiple.txt", false));
            bw.write("Multiples de " + a + " jusqu'à " + b + " : ");
            bw.newLine();
            for(int i = 1; a*i <= b; i++){
                bw.write(i + " ");
                String c = String.valueOf(a*i);
                bw.write(c);
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

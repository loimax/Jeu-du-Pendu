import java.util.*;
import java.io.*;

public class Exo2 {
    public static void main(String argv[]) {
        ecritureMultiple();
    }
    public static void ecritureMultiple(){
        try{
            Scanner sc = new Scanner(System.in);
            String nom = sc.nextLine();
            System.out.println("Multiples de : ");
            float a = sc.nextFloat();
            System.out.println("jusqu'à : ");
            float b = sc.nextFloat();
            BufferedWriter bw = new BufferedWriter(new FileWriter("multiple.txt", true));
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

package CAADAA;

public class CAADAA_Main {
    public static void main(String[] args) {
        CAADAA a = new CAADAA();
        String [] b = a.ciph("ALLEN BRYANT LINESES", 2);
        for (String b1 : b) {
            System.out.print(b1);
        }
        String ciph = a.deciph(b, 2);
        System.out.println("\n"+ciph);
    }
}

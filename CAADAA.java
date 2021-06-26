package CAADAA;

import java.util.ArrayList;

public class CAADAA {
    private final static String [] alphabet = {"A","B","C","D","E","F","G","H","I","J",
        "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",",","!","?",".",
        "1","2","3","4","5","6","7","8","9","0"};
    private final static String[] morse = {".-", "-..." ,"-.-." ,"-..", "."
                ,"..-." ,"--.", "...." ,".." ,".---"
                ,"-.-" ,".-.." ,"--" ,"-." ,"---" ,".--."
                ,"--.-" ,".-." ,"..." ,"-" ,"..-" ,"...-" ,".--"
                ,"-..-" ,"-.--" ,"--..",",","!","?"," .",
                "1","2","3","4","5","6","7","8","9","0"};
    private static int secondTracker;
    private int transform = 0;
    private int compare = 0;
    private int length = 0;
    private final ArrayList<Integer> comparisons = new ArrayList<>();
    private final ArrayList<Integer> trans = new ArrayList<>();
    private final ArrayList<Integer> lengths = new ArrayList<>();
    private String Stage1cipher(String cipher,int s){
        cipher= cipher.toUpperCase();
        int index;
        int loc;
        length = cipher.length();
        String b = "";
        for (int i = 0; i < cipher.length(); i++) {
            String a = ""+cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                compare++;
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index + s;
                    if(loc > 39) loc-= 40;
                    b+=alphabet[loc];
                    transform++;
                }
                else if(a.equals(" ")){
                    b+=a;
                    break;
                }
            }
        }
        return b;
    }
    private String Stage2cipher(String cipher,int s){
        cipher= cipher.toUpperCase();
        int index;
        int loc;
        String b = "";
        for (int i = 0; i < cipher.length(); i++) {
            String a = ""+cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                compare++;
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index + s++;
                    while(loc > 39) loc-= 40;
                    b+=alphabet[loc];
                    transform++;
                }
                else if(a.equals(" ")){
                    b+=a;
                    s++;
                    break;
                }
            }
        }
        
        return b;
    }
    private String[] Stage3cipher(String cipher,int s){
        cipher= cipher.toUpperCase();
        int index;
        int loc;
        String [] b = new String[cipher.length()];
        for (int i = 0; i < cipher.length(); i++) {
            String a = ""+cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                compare++;
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index +s;
                    if(loc > 39) loc-= 40;
                    b[i] = morse[loc];
                    transform++;
                }
                else if(a.equals(" ")){
                    b[i] =""+a;
                    break;
                }
            }
        }
        return b;
    }
    private String [] Stage4cipher(String[] cipher,int s){
        int index;
        int loc;
        String [] b = new String[cipher.length];
        for (int i = 0; i < cipher.length; i++) {
            String a = cipher[i];
            for (int j = 0; j < morse.length; j++) {
                compare++;
                if(a.equals(morse[j])){ 
                    index = j;
                    loc = index +s;
                    if(loc > 39) loc-= 40;
                    b[i] = ""+alphabet[loc];
                    transform++;
                }
                else if(a.equals(" ")){
                    b[i] =""+a;
                    break;
                }
            }
        }
        return b;
    }
    private void ins(){
        comparisons.add(compare);
        trans.add(transform);
        lengths.add(length);
    }

    public ArrayList<Integer> getComparisons() {
        return comparisons;
    }

    public ArrayList<Integer> getTrans() {
        return trans;
    }
    
    public ArrayList<Integer> getLengths() {
        return lengths;
    }
    
    private static String Stage1decipher(String cipher,int s){
        cipher= cipher.toUpperCase();
        int index;
        int loc;
        String b = "";
        for (int i = 0; i < cipher.length(); i++) {
            String a = ""+cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index - s;
                    if(loc < 0) loc+= 40;
                    b+=alphabet[loc];
                }
                else if(a.equals(" ")){
                    b+=a;
                    break;
                }
            }
        }
        return b;
    }
    private static String Stage2decipher(String cipher,int s){
        cipher= cipher.toUpperCase();
        int index;
        int loc;
        String b = "";
        int x = cipher.length()-1;
        for (int i = 0; i < cipher.length(); i++) {
            String a = ""+cipher.charAt(x);
            for (int j = 0; j < alphabet.length; j++) {
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index - --s;
                    while(loc < 0) loc+= 40;
                    b = alphabet[loc]+b;
                }
                else if(a.equals(" ")){
                    b=a+b;
                    --s;
                    break;
                }
            }
            x--;
        }
        return b;
    }
    private static String Stage3decipher(String[] cipher,int s){
        int index;
        int loc;
        String b = "";
        for (int i = 0; i < cipher.length; i++) {
            String a = cipher[i];
            for (int j = 0; j < morse.length; j++) {
                if(a.equals(morse[j])){ 
                    index = j;
                    loc = index - s;
                    if(loc < 0) loc+= 40;
                    b+=alphabet[loc];
                }
                else if(a.equals(" ")){
                    b+=a;
                    break;
                }
            }
        }
        return b;
    }
    private static String[] Stage4decipher(String[] cipher,int s){
        int index;
        int loc;
        String [] b = new String[cipher.length];
        for (int i = 0; i < cipher.length; i++) {
            String a = cipher[i];
            for (int j = 0; j < alphabet.length; j++) {
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index - s;
                    if(loc < 0) loc+= 40;
                    b[i]=morse[loc];
                }
                else if(a.equals(" ")){
                    b[i]=a;
                    break;
                }
            }
        }
        return b;
    }
    public String [] ciphStorage(String cip,int s){
        return Stage4cipher(Stage3cipher(Stage2cipher(Stage1cipher(cip,s),s),s),s);
    }
    public void printCipher(String cip, int s){
        String [] cipher = ciphStorage(cip,s);
        for (String out : cipher) {
            System.out.print(out);
        }
        ins();
        System.out.println("");
    }
    public String deciph(String cip,int s){
        secondTracker = s+cip.length();
        String []ciph = new String[cip.length()];
        for (int i = 0; i < cip.length(); i++) {
            ciph[i] = ""+cip.charAt(i);
        }
        return Stage1decipher(Stage2decipher(Stage3decipher(Stage4decipher(ciph,s),s),secondTracker),s);
    }
}

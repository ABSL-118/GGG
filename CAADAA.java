package CAADAA;

public class CAADAA {
    private final static String [] alphabet = {"A","B","C","D","E","F","G","H","I","J",
        "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",",","!","?"};
    private final static String[] morse = {".-", "-..." ,"-.-." ,"-..", "."
                ,"..-." ,"--.", "...." ,".." ,".---"
                ,"-.-" ,".-.." ,"--" ,"-." ,"---" ,".--."
                ,"--.-" ,".-." ,"..." ,"-" ,"..-" ,"...-" ,".--"
                ,"-..-" ,"-.--" ,"--..",",","!","?"};
    private static int secondTracker;
    private static String Stage1cipher(String cipher,int s){
        cipher= cipher.toUpperCase();
        int index;
        int loc;
        String b = "";
        for (int i = 0; i < cipher.length(); i++) {
            String a = ""+cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index + s;
                    if(loc > 28) loc-= 29;
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
    private static String Stage2cipher(String cipher,int s){
        cipher= cipher.toUpperCase();
        int index;
        int loc;
        String b = "";
        for (int i = 0; i < cipher.length(); i++) {
            String a = ""+cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index + s++;
                    while(loc > 28) loc-= 29;
                    b+=alphabet[loc];
                }
                else if(a.equals(" ")){
                    b+=a;
                    break;
                }
            }
        }
        secondTracker = s;
        return b;
    }
    private static String[] Stage3cipher(String cipher,int s){
        cipher= cipher.toUpperCase();
        int index;
        int loc;
        String [] b = new String[cipher.length()];
        for (int i = 0; i < cipher.length(); i++) {
            String a = ""+cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index +s;
                    if(loc > 28) loc-= 29;
                    b[i] = morse[loc];
                }
                else if(a.equals(" ")){
                    b[i] =""+a;
                    break;
                }
            }
        }
        return b;
    }
    private static String [] Stage4cipher(String[] cipher,int s){
        int index;
        int loc;
        String [] b = new String[cipher.length];
        for (int i = 0; i < cipher.length; i++) {
            String a = cipher[i];
            for (int j = 0; j < morse.length; j++) {
                if(a.equals(morse[j])){ 
                    index = j;
                    loc = index +s;
                    if(loc > 28) loc-= 29;
                    b[i] = ""+alphabet[loc];
                }
                else if(a.equals(" ")){
                    b[i] =""+a;
                    break;
                }
            }
        }
        return b;
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
                    if(loc < 0) loc+= 29;
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
                    while(loc < 0) loc+= 29;
                    b = alphabet[loc]+b;
                }
                else if(a.equals(" ")){
                    b=a+b;
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
                    if(loc < 0) loc+= 29;
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
                    if(loc < 0) loc+= 29;
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
    public String [] ciph(String cip,int s){
        return Stage4cipher(Stage3cipher(Stage2cipher(Stage1cipher(cip,s),s),s),s);
    }
    public String deciph(String [] cip,int s){
        return Stage1decipher(Stage2decipher(Stage3decipher(Stage4decipher(cip,s),s),secondTracker),s);
    }
}

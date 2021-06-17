package CAADAA;

public class CAADAA {
    private final String [] alphabet = {"A","B","C","D","E","F","G","H","I","J",
        "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private final String[] morse = {".-", "-..." ,"-.-." ,"-..", "."
                ,"..-." ,"--.", "...." ,".." ,".---"
                ,"-.-" ,".-.." ,"--" ,"-." ,"---" ,".--."
                ,"--.-" ,".-." ,"..." ,"-" ,"..-" ,"...-" ,".--"
                ,"-..-" ,"-.--" ,"--.."};
    private static int secondTracker;
    public String Stage1cipher(String cipher,int s){
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
                    if(loc > 25) loc-= 25;
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
    public String Stage2cipher(String cipher,int s){
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
                    if(loc > 25) loc-= 25;
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
    public String[] Stage3cipher(String cipher,int s){
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
                    if(loc > 25) loc-= 25;
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
    public String [] Stage4cipher(String[] cipher,int s){
        int index;
        int loc;
        String [] b = new String[cipher.length];
        for (int i = 0; i < cipher.length; i++) {
            String a = cipher[i];
            for (int j = 0; j < morse.length; j++) {
                if(a.equals(morse[j])){ 
                    index = j;
                    loc = index +s;
                    if(loc > 25) loc-= 25;
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
    public String Stage1decipher(String cipher,int s){
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
                    if(loc < 0) loc+= 25;
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
    public String Stage2decipher(String cipher,int s){
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
                    if(loc < 0) loc+= 25;
                    b = alphabet[loc]+b;
                }
                else if(a.equals(" ")){
                    b+=a;
                    break;
                }
            }
            x--;
        }
        return b;
    }
    public String Stage3decipher(String[] cipher,int s){
        int index;
        int loc;
        String b = "";
        for (int i = 0; i < cipher.length; i++) {
            String a = cipher[i];
            for (int j = 0; j < morse.length; j++) {
                if(a.equals(morse[j])){ 
                    index = j;
                    loc = index - s;
                    if(loc < 0) loc+= 25;
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
    public String[] Stage4decipher(String[] cipher,int s){
        int index;
        int loc;
        String [] b = new String[cipher.length];
        for (int i = 0; i < cipher.length; i++) {
            String a = cipher[i];
            for (int j = 0; j < alphabet.length; j++) {
                if(a.equals(alphabet[j])){ 
                    index = j;
                    loc = index - s;
                    if(loc < 0) loc+= 25;
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
    public static void main(String[] args) {
        CAADAA a = new CAADAA();
        String []ab = a.Stage3cipher(a.Stage2cipher(a.Stage1cipher("ALLEN BRYANT LINESES", 2), 2),2);
//        for(String aaa : ab){
//            System.out.println(aaa);
//        }
        String[] bbb = a.Stage4cipher(ab, 2);
//        for(String b : a.Stage3cipher(a.Stage2cipher(a.Stage1cipher("AAA", 2), 2),2)){
//            System.out.print(b);
//        }
        for (String bbb1 : bbb) {
            System.out.println(bbb1);
        }
        String [] aaaa = a.Stage4decipher(bbb, 2);
        for (String aaaa1 : aaaa) {
            System.out.println(aaaa1);
        }
        String ba=a.Stage3decipher(aaaa, 2);
        System.out.println(ba);
        ba=a.Stage2decipher(ba, secondTracker);
        System.out.println(ba);
        ba = a.Stage1decipher(ba, 2);
        System.out.println(ba);
    }
}

package CAADAA;

public class CAADAA {
    private final char [] alphabet = {'A','B','C','D','E','F','G','H','I','J',
        'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
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
            char a = cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(a==alphabet[j]){ 
                    index = j;
                    loc = index + s;
                    if(loc > 25) loc-= 25;
                    b+=alphabet[loc];
                }
                else if(a==' '){
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
            char a = cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(a==alphabet[j]){ 
                    index = j;
                    loc = index + s++;
                    if(loc > 25) loc-= 25;
                    b+=alphabet[loc];
                }
                else if(a==' '){
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
            char a = cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(a==alphabet[j]){ 
                    index = j;
                    loc = index +s;
                    if(loc > 25) loc-= 25;
                    b[i] = morse[loc];
                }
                else if(a==' '){
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
            char a = cipher.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if(a==alphabet[j]){ 
                    index = j;
                    loc = index - s;
                    if(loc > 25) loc-= 25;
                    b+=alphabet[loc];
                }
                else if(a==' '){
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
            char a = cipher.charAt(x);
            for (int j = 0; j < alphabet.length; j++) {
                if(a==alphabet[j]){ 
                    index = j;
                    loc = index - --s;
                    if(loc < 0) loc+= 25;
                    b = alphabet[loc]+b;
                }
                else if(a==' '){
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
    public static void main(String[] args) {
        CAADAA a = new CAADAA();
        String[] bbb =a.Stage3cipher(a.Stage2cipher(a.Stage1cipher("AAA", 2), 2),2);
//        for(String b : a.Stage3cipher(a.Stage2cipher(a.Stage1cipher("Hello Anje", 2), 2),2)){
//            System.out.print(b);
//        }
        String aaa = a.Stage3decipher(bbb, 2);
        aaa = a.Stage2decipher(aaa, secondTracker);
        aaa = a.Stage1decipher(aaa, 2);
        System.out.println(aaa);
    }
}

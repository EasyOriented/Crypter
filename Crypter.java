import java.util.Random;

public class Crypter {
    
    // 1 - add
    // 2 - subtract
    // 3 - multiply
    // 4 - divide
    
    public static String encrypt(String code) {
        
        System.out.println("Encrypting...");
        String key = "";
        Random r = new Random();
        // key = "c3\\2\"2'2/N";
        for (char c : code.toCharArray()) {
            
            for (int i = r.nextInt(10); i > 1; i = r.nextInt(10)) {
                key = key + i;
            }
            
            int num = (c*2)-2;
            key = key + "0" + (num);
            
            int randInt = ((r.nextInt(2))*32) + 65;
            char c2 = (char) (r.nextInt(26) + randInt);
            key = key + c2;
            
            
        }
        
        for (int i = r.nextInt(10); i >  1; i = r.nextInt(10)) {
            key = key + i;
        }
        
        System.out.println("Encryption complete\n");
        return key;
    }
    
    public static String decrypt(String code) {
        
        String key = "";
        boolean buildAscii = false;
        String ascii = "";
        
        for (char c : code.toCharArray()) {
            
            if (c == '0' && !buildAscii) buildAscii = true;
            else if (buildAscii 
                && c != '0' 
                && c != '1' 
                && c != '2' 
                && c != '3' 
                && c != '4' 
                && c != '5' 
                && c != '6' 
                && c != '7' 
                && c != '8' 
                && c != '9') {
                    buildAscii = false;
                    key = key + ((char) ((Integer.parseInt(ascii)+2)/2));
                    ascii = "";
            }
            else if (buildAscii) ascii = ascii + c;
            
        }
        
        return key;
    }
    
}

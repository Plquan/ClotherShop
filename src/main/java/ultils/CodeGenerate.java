package ultils;

import java.util.Random;

public class CodeGenerate {
	 public static String generateCode() {
		   int length = 8;
	        String charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        Random random = new Random();
	        StringBuilder code = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(charPool.length());
	            code.append(charPool.charAt(randomIndex));
	        }
	        return code.toString();
	    }
}

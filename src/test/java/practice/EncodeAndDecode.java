package practice;

import java.util.Base64;

public class EncodeAndDecode {
	
	public static void main(String[] args) {
		String str="Nithesh";
		byte[] nit=Base64.getEncoder().encode(str.getBytes());
		System.out.println(new String(nit));
		
		String decode = new String(Base64.getDecoder().decode(nit));
		System.out.println(decode);
	}

}

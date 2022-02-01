package practice;

import java.util.regex.Pattern;

public class CountryPhone {

	public static void main(String[] args) {
		boolean isIndiaPhNo = Pattern.matches("[6789]{1}[0-9]{9}", "99728178921");
		//6,7,8,9 9numbern 0-9
		System.out.println(isIndiaPhNo);
	}
}

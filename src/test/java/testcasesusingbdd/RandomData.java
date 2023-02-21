package testcasesusingbdd;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

	public static String getName() {
		String gen = RandomStringUtils.randomAlphabetic(4);
		return "Puju" + gen;// PujubFe
	}

	public static String getJob() {
		String gen = RandomStringUtils.randomAlphabetic(3);
		return "Dancer" + gen;
	}

	public static String getFirstName() {
		String gen = RandomStringUtils.randomAlphabetic(4);
		return "Priye" + gen;
	}

	public static String getLastName() {
		String gen = RandomStringUtils.randomAlphabetic(4);
		return "Ranjan" + gen;
	}

}

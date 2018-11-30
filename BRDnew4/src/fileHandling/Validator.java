package fileHandling;

import java.util.regex.Pattern;

public class Validator {
	public static Boolean validator(Customers customer) {

		Boolean pincodeResult = PincodeValidation(customer.getCustomerPinCode());
		Boolean EmailResult = EmailValidation(customer.getEmailAddress());
		Boolean RecordStatusResult = RecordStatusValidation(customer.getRecordStatus());
		Boolean ActiveInactiveResult = ActiveInactiveFlag(customer.getActiveInactiveFlag());
		Boolean customerNameResult = customerNameValidate(customer.getCustomerName());

		if (pincodeResult && EmailResult && RecordStatusResult && ActiveInactiveResult && customerNameResult) {
			return true;
		}
		return false;

	}

	public static Boolean PincodeValidation(String string) {
		if (string.length() == 6) {
			return true;
		}
		return false;
	}

	public static Boolean customerNameValidate(String string) {
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		if (p.matcher(string).find()) {
			return true;
		}
		return false;
	}

	public static boolean EmailValidation(String string) {
		if (string.contains("@") || string.contains(".")) {
			if (!string.contains(" ")) {
				return true;
			}
		}
		return false;

	}

	public static boolean RecordStatusValidation(String string) {
		if (string.contains("N") || string.contains("M") || string.contains("D") || string.contains("A")
				|| string.contains("R")) {
			return true;
		}
		return false;

	}

	public static boolean ActiveInactiveFlag(String string) {
		if (string.contains("A") || string.contains("I")) {
			return true;
		}
		return false;
	}

}

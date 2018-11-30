package fileHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.upload.DataBaseDao;

import fileHandling.Customers;


public class RecordValidation {
	static List<String> list = new ArrayList<>();

	public static void RecordLevelValidayion(InputStream fileContent, String fileName) {

		if (!fileName.endsWith(".txt")) {
			System.exit(0);
		}
		BufferedReader bufferedReader;
		bufferedReader = new BufferedReader(new InputStreamReader(fileContent));

		String files;
		try {
			while ((files = bufferedReader.readLine()) != null) {
				files += "~";
				list.add(files);

			}

		}

		catch (IOException ioException) {
			System.out.println("Error: " + ioException);
		}
		

		String s = null;
		String[] records;
		Customers customer = new Customers();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			s = list.get(i);
			records = s.split("(?<=~)");
			customer.setCustomerID(count += 1);
			customer.setCustomerCode(records[0].substring(0, records[0].lastIndexOf("~")));
			customer.setCustomerName(records[1].substring(0, records[1].lastIndexOf("~")));
			customer.setCustomerAddress1(records[2].substring(0, records[2].lastIndexOf("~")));
			customer.setCustomerAddress2(records[3].substring(0, records[3].lastIndexOf("~")));
			customer.setCustomerPinCode(records[4].substring(0, records[4].lastIndexOf("~")));
			customer.setEmailAddress(records[5].substring(0, records[5].lastIndexOf("~")));
			customer.setContactNumber(records[6].substring(0, records[6].lastIndexOf("~")));
			customer.setPrimaryContactPerson(records[7].substring(0, records[7].lastIndexOf("~")));
			customer.setRecordStatus(records[8].substring(0, records[8].lastIndexOf("~")));
			customer.setActiveInactiveFlag(records[9].substring(0, records[9].lastIndexOf("~")));
			customer.setCreateDate(records[10].substring(0, records[10].lastIndexOf("~")));
			customer.setCreatedBy(records[11].substring(0, records[11].lastIndexOf("~")));
			customer.setModifiedDate(records[12].substring(0, records[12].lastIndexOf("~")));
			customer.setModifiedBy(records[13].substring(0, records[13].lastIndexOf("~")));
			customer.setAuthorizedDate(records[14].substring(0, records[14].lastIndexOf("~")));
			customer.setAuthorizedBy(records[15].substring(0, records[15].lastIndexOf("~")));
			try {
				if (Validator.validator(customer) == true) {
					DataBaseDao.databaseMethod(customer);

				} else {
					System.out.println("missing field");
				}

			} catch (SQLException sqlException) {
				System.out.println("Error: " + sqlException);
			}

		}

	}


}
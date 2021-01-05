package HyveAssignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataExtractor {

	private List<Integer> data = new ArrayList<Integer>();
	
	public DataExtractor(String inFile) {
		// start data extraction
		try(
				InputStream inStream = new FileInputStream(inFile);
				){
			int dataByte;
			while((dataByte = inStream.read()) != -1) {
				getData().add(dataByte);
			}
		// catch exceptions
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> getData() {
		return data;
	}

}

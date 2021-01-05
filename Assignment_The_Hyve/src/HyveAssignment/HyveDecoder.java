package HyveAssignment;
import java.util.List;

public class HyveDecoder {
	
	// main method
	public static void main(String[] args) {
		// check if all input args are given
		checkInputArgs(args);
		
		// set variables from input args
		String inFile = args[0];
		
		// get data from input file (as Integer List)
		DataExtractor extractor = new DataExtractor(inFile);
		List<Integer> myData = extractor.getData();
		
		// decode data
		List<Integer> decodedData = Decoder.decode(myData);
		System.out.println(decodedData);
		
		// write output to std out
		for (int dataByte: decodedData) {
			System.out.write(dataByte);
		}
		// re encode and write to std error
		List<Integer> reEncodedData = Decoder.reEncode(decodedData, true);
		for (int dataByte: decodedData) {
			System.err.write(dataByte);
		}
		// flush output to see in in cmd
		System.out.flush();
		System.err.flush();
	}

	private static void checkInputArgs(String[] args) {
		if (args.length < 1) {
			System.err.println("give input file! exit...");
			System.exit(0);
		}
	}
}

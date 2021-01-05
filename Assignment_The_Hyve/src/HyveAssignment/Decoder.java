package HyveAssignment;

import java.util.ArrayList;
import java.util.List;

public class Decoder {
	
	public static List<Integer> decode(List<Integer> inData) {
		List<Integer> outData = new ArrayList<Integer>();
		
		// loop over every pair of bytes
		for (int i = 0; i < inData.size(); i += 2) {
			int[] dataPair = {inData.get(i), inData.get(i+1)};
			
			// if first byte is 0, store the second byte in outData
			if (dataPair[0] == 0) {
				outData.add(dataPair[1]);
			}
			else {
				// check if: 0 < qi ≤ pi, else put byte 3F (int 63)
				if (dataPair[1] < 0) {
					System.err.println("Second byte of pair < 0... exit");
					outData.add(63);
				}
				else if (dataPair[0] < dataPair[1]) {
					System.err.println("First byte of pair < second byte of pair... exit");
					outData.add(63);
				}
				else {
					// if first byte is not 0 and byte values are okay, get the start and end of sublist to add to the output
					int startList = outData.size() - dataPair[0];
					int listSize = dataPair[1];
					int endList = startList + listSize;
					
					// check if startList and endList are valid values, if valid, add sublist to result list
					if ((startList >= 0) && (endList <= outData.size())) {
						List<Integer> subList = outData.subList(startList, endList);
						outData.addAll(subList);
					}
					// if values are not valid, add byte 3F (int 63)
					else {
						System.err.println("Invalid list values... exit");
						outData.add(63);
					}
				}			
			}
		}
		return outData;
	}

	public static List<Integer> reEncode(List<Integer> inData, int USE_TRIVIAL_IMPLEMENTATION){
		List<Integer> reEncodedData = new ArrayList<Integer>();
		// simple version
		if (USE_TRIVIAL_IMPLEMENTATION == 1) {
			for(int dataByte: inData) {
				reEncodedData.add(0);
				reEncodedData.add(dataByte);
			}
		}
		// more difficult version
		else{
			System.out.println("time was up...");
			/* probably something like:
			1. take a few bytes from end of list (for loop to test different sizes?)
			2. check if bytes are present earlier in the same list
			3. get offset and lenght of bytes and return byte pair (offset, length) */
		}
		return reEncodedData;
	}
	
	// if implementation is not specified -> default to non trivial implementation (value of 0)
	public static List<Integer> reEncode(List<Integer> inData){
		return reEncode(inData, 0);
	}
}


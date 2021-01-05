package HyveAssignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void dataExtractionTest() {
		// get inputData from file
		DataExtractor extractor = new DataExtractor("Test_in.bin");
		List<Integer> inputData = extractor.getData();
		
		// expected input data
		List<Integer> expectedInputData = new ArrayList<>(Arrays.asList(3,250,85,18,32,102,103,80,232,171));
		
		// test if imported data from file is equal to expected data
		assertEquals(inputData, expectedInputData);
	}
		
	@Test
	void decoderTest() {
		// input data
		List<Integer> inData = new ArrayList<Integer>(Arrays.asList(0, 61, 1, 1, 0, 62, 3, 2, 3, 3));
		// decoded output data
		List<Integer> outData = Decoder.decode(inData);
		// expected output data
		List<Integer> expectedOutputData = new ArrayList<>(Arrays.asList(61, 61, 62, 61, 61, 62, 61, 61));


		// check if expected output is equal to produced output
		assertEquals(expectedOutputData, outData);
	}
	
	@Test
	void encoderTest() {
		// input data
		List<Integer> inData = new ArrayList<Integer>(Arrays.asList(61, 61, 62, 61, 61, 62, 61, 61));
		// reEncoded output data (1 for trivial implementation)
		List<Integer> outData = Decoder.reEncode(inData, 1);
		// expected output data
		List<Integer> expectedOutputData = new ArrayList<>(Arrays.asList(0, 61, 0, 61, 0, 62, 0, 61, 0, 61, 0, 62, 0, 61, 0, 61));


		// check if expected output is equal to produced output
		assertEquals(expectedOutputData, outData);
	}
	
}

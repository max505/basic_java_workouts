package com.workout.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {

	public static void main(String[] args) throws Exception  {
		try {
			if (args.length > 0) {
				System.out.println("first");
				testException(-10);
			} else {
				mysub(5);
				// throw new FileNotFoundException("length check");
			}
		} catch (FileNotFoundException e) {
			System.out.println("filenotfound");
			throw new FileNotFoundException("error in main FNF " + e);
		} catch (IOException e) {
			System.out.println("io exception");
			throw new IOException("error in main IO " + e);
		} finally {
			System.out.println("Releasing resources");
		}
		System.out.println("last loop");
		testException(15);
	}

	public static void mysub(int i) throws IOException {

		try {
			testException(15);
			for (int j = i; j < 5; j++) {
				System.out.println("i " + j);
			}
		} catch (Exception e) {
			throw new IOException("my sub ", e);
		}

	}

	public static void testException(int i) throws FileNotFoundException, IOException {
		if (i < 0) {
			System.out.println("am in");
			FileNotFoundException myException = new FileNotFoundException("Negative Integer " + i);
			throw myException;
		} else if (i > 10) {
			System.out.println("last");
			throw new IOException("Only supported for index 0 to 10");
		}

	}

}
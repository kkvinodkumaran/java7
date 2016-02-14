package com.vinod.test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Java7File1Test {
	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream("file.txt");
				DataOutputStream dos = new DataOutputStream(fos)) {
			dos.writeUTF("test");
			SimpleDateFormat ff = new SimpleDateFormat("MM-dd-yyyy");
			ff.parse("2012-12-12");
		} catch (IOException | ParseException e) {
		}
	}
}
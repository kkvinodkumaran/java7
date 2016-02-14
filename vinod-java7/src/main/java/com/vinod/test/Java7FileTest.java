package com.vinod.test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Java7FileTest {
	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream("file.txt");
				DataOutputStream dos = new DataOutputStream(fos)) {
			dos.writeUTF("test");
		} catch (IOException e) {
		}
	}
}
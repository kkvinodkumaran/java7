package com.vinod.test;

import java.io.*;

public class FileTest {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("file.txt");
			dos = new DataOutputStream(fos);
			dos.writeUTF("test");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				dos.close();
			} catch (IOException e) {
			}
		}
	}
}

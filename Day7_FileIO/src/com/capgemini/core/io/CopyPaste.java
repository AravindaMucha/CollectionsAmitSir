package com.capgemini.core.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPaste {
	public static void main(String[] args) {
		String sourceFile = "D:\\153118 - java pdf\\line.txt";
		String destinationFile = "D:\\153118 - java pdf\\PDF\\line.txt";
		
		try(FileInputStream fis = new FileInputStream(sourceFile);
				FileOutputStream fos = new FileOutputStream(destinationFile)){
			
//			long startTime = System.currentTimeMillis();
			int binRead= fis.read();
			
			while(binRead != -1) {
				fos.write(binRead);
				binRead = fis.read();
			}
			
//			long endTime = System.currentTimeMillis();
//			long timeElapesed = (endTime - startTime) / 1000;
//			System.out.println("Copy Sucessful. Took " + timeElapesed + " seconds");
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

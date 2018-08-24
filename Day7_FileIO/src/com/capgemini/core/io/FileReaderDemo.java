package com.capgemini.core.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] abc) {
		try(FileReader fileReader = new FileReader("D:\\153118 - java pdf\\line.txt")){
			int charRead = fileReader.read();
			int counter = 0;
			while(charRead != 0) {
				
				System.out.println((char)charRead);
				charRead = fileReader.read();
				counter++;
			}
			System.out.println("IO Permission Asked " + counter + "times");			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

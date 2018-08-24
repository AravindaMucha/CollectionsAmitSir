package com.capgemini.core.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
	public static void main(String[] abc) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("D:\\153118 - java pdf\\line.txt "))){
			String lineRead= br.readLine();
			int counter = 0;
			while(lineRead != null) {
				Thread.sleep(200);
				System.out.println(lineRead);
				lineRead = br.readLine();
				counter++;
			}
			
			System.out.println("IO Permission Asked " + counter + " times");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}

package impl;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Random;
import java.util.Scanner;

import stockage.Nuplet;

public class SerialisableNuplet {
	
	private Scanner scanner ;
	private Path path ; 
	private File file ; 
	private BufferedWriter writer;

	public SerialisableNuplet() {
		super();
	}

	
	
	public void preLock(Nuplet nuplet) {
		
		try {
			path = Paths.get(nuplet.hashCode()+"");
			file = new File(nuplet.hashCode()+".txt") ;
			
			if(!file.exists() && !file.isDirectory()) {
				file.createNewFile();
				writer = new BufferedWriter(new FileWriter(nuplet.hashCode()+".txt"));
				writer.write("true");
				writer.close();
				return;
			}
			

			scanner = new Scanner(file);
			
			if(scanner.hasNext()) {
				
				Boolean bool = scanner.nextBoolean();
				while(bool) {
					System.out.print(".");
					Thread.sleep(new Random().nextInt(100));
					scanner = new Scanner(file);
					bool = scanner.nextBoolean();
				}
				
				
					
			}
			writer = new BufferedWriter(new FileWriter(nuplet.hashCode()+".txt"));
			writer.write("true");
			writer.close();
			scanner.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		


		
		
		
		return ; 
	}
	
	public void afterLock(Nuplet nuplet) {
		path = Paths.get(nuplet.hashCode()+".txt");
		file = new File(nuplet.hashCode()+".txt") ;
		try {
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));

			writer.write("false");
			writer.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} 

		
		
		
		return ; 
	}
	
}

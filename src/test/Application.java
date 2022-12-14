package test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		//Nous d?clarons nos objets en dehors du bloc try/catch
		FileInputStream fis;
		BufferedInputStream bis;
		
		try 
		{
			fis = new FileInputStream(new File("test.txt"));
			bis = new BufferedInputStream(new FileInputStream(new File("test.txt")));
			byte[] buf = new byte[8];
			
			//On r?cup?re le temps du syst?me
			long startTime = System.currentTimeMillis();
			
			//Inutile d'effectuer des traitements dans notre boucle
			while(fis.read(buf) != -1);
			
			//On affiche le temps d'ex?cution
			System.out.println("Temps de lecture avec FileInputStream : " + (System.currentTimeMillis() - startTime));
			
			//On r?initialise
			startTime = System.currentTimeMillis();
			
			//Inutile d'effectuer des traitements dans notre boucle
			while(bis.read(buf) != -1);
			
			//On r?affiche
			System.out.println("Temps de lecture avec BufferedInputStream : " + (System.currentTimeMillis() - startTime));
			
			//On ferme nos flux de donn?es
			fis.close();
			bis.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
}

package kr.ac.halla.ics.advanced_programming.week4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Learn iterator pattern
 * 
 * @author jack
 *
 */
public class Practice2 {

	public static void main(String[] args) {

		try {
			FileReader fin = new FileReader("/home/jack/CRAWDAD/email/Email-EuAll.txt");

			BufferedReader br = new BufferedReader(fin);

			HashSet<String> sourceIDSet = new HashSet<>();

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				if (line.startsWith("#") == true)
					continue;
				String[] arr = line.split("\t");

				sourceIDSet.add(arr[0]);

			}
			
			Iterator<String> iterator = sourceIDSet.iterator();
			while(iterator.hasNext()) {
				String id = iterator.next();
				System.out.println(id);
			}
			
			System.out.println("# of IDs :" + sourceIDSet.size());
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

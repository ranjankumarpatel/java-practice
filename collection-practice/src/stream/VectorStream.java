package stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class VectorStream {
	
	private Vector<FileInputStream> getFileStreamVector() throws FileNotFoundException{
		Vector<FileInputStream> fileInputStreams = new Vector<FileInputStream>();
		fileInputStreams.add(new FileInputStream("E:/Workspace support/Ranjan.txt"));
		fileInputStreams.add(new FileInputStream("E:/Workspace support/Kumar.txt"));
		fileInputStreams.add(new FileInputStream("E:/Workspace support/Patel.txt"));
		return fileInputStreams;
	}
	
	public void printVectorStream(Vector<FileInputStream> vStreams) throws IOException{
		
		Enumeration<FileInputStream> enums = vStreams.elements();
		SequenceInputStream sis = new SequenceInputStream(enums);
		InputStreamReader isr = new InputStreamReader(sis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
		System.out.println(line);
		}
		br.close();
		
	}
	
	public static void main(String[] args){
		VectorStream vectorStream = new VectorStream();
		try {
			Vector<FileInputStream> vStreams = vectorStream.getFileStreamVector();			
			vectorStream.printVectorStream(vStreams);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}

package stockpredictor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileOperations {
	
	public static int writeToFile(String fileName, String tarDir, ArrayList<String> data){
		
		int responseCode = -1;
		boolean exceptionOccurred=false;
		
		if(fileName!=null&&data!=null){
			try{
				
				File f = new File(tarDir+fileName);
				FileWriter fileWriter = new FileWriter(f);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				
				for(String temp : data){
					bufferedWriter.write(temp);
					bufferedWriter.newLine();
					//bufferedWriter.write(" ");
				}
				
				//bufferedWriter.newLine();
	
				bufferedWriter.close();
				fileWriter.close();
				
				responseCode=0;
			}
			catch(Exception e){
				exceptionOccurred=true;
				e.printStackTrace();
			}
			finally{
				if(!exceptionOccurred){
					//System.out.println("Operation SUCCESSFUL - Method Name - writeToFile(String fileName, String tarDir, ArrayList<String> data)");
				}
				else{
					System.out.println("Operation UNSUCCESSFUL - An EXCEPTION occurred - Method Name - writeToFile(String fileName, String tarDir, ArrayList<String> data)");
					
				}
			}
		}
		else{
			System.out.println("Operation UNSUCCESSFUL - one or more arguments is NULL - Method Name - writeToFile(String fileName, String tarDir, ArrayList<String> data)");
		}
		
		
		
		
		return responseCode;
	}
	
	
}

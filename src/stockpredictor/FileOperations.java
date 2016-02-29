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
	
	public static ArrayList<String> readFile(String fileName, String srcDir){
		
		
		
		ArrayList<String> fileLines = null;
        String line = null;
        boolean exceptionOccurred = false;
		
		if(fileName!=null){
			
		
			try{
				
			
			 FileReader fileReader =  new FileReader(srcDir+fileName);
			 
			 BufferedReader bufferedReader = new BufferedReader(fileReader);
			 
			 fileLines = new ArrayList<String>();
			
			  // boolean previousLineWasParseText = false;
			   
			     while((line = bufferedReader.readLine()) != null) {
	            	   if(line.startsWith("URL::")){
	            		   
	            	   }
	            	   else if(line.startsWith("ParseText::")){
	            		   
	            	   }
	            	   else{
		            	for(String temp : line.split("\\W+")){
		            		fileLines.add(temp);
		            	}
	            	   }
                  }
		                 

			 
			 bufferedReader.close();
			 
			 fileReader.close();
			}
			catch(Exception e){
				exceptionOccurred=true;
				e.printStackTrace();
			}
			finally{
				if(!exceptionOccurred){
					//System.out.println("Operation SUCCESSFUL - Method Name - readFile(String fileName, String srcDir)");
				}
				else{
					System.out.println("Operation UNSUCCESSFUL - An EXCEPTION occurred - Method Name - readFile(String fileName, String srcDir)");
				}
			}
		}
		else{
			System.out.println("Operation UNSUCCESSFUL - an argument is NULL - Method Name - readFile(String fileName, String srcDir)");
		}
		return fileLines;
	}
}



import java.io.File;
import java.io.IOException;

public class FileReader {
 public static void main(String[] args) {
	 
	 try {
		 
		 File obj=  new File("file.txt");
		 if(obj.createNewFile()) {
			 System.out.println("file created :"+obj.getName());
		 }
		 else {
			 System.out.println("file not created");
		 }
		 
	 }catch(IOException e) {
		 e.printStackTrace();
	 }
	 
	 
	 
	 
	 
	 
 }
 
 
}

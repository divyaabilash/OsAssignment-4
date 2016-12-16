import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class RandomGenerator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of memory need (any number)");
		int sizeofMemory = sc.nextInt();
		File file = new File("/Users/divya/Desktop/OsAssignment4sol.txt");

	      if (file.createNewFile()){
	        System.out.println("File is created!");
	         }else{
	        System.out.println("File already exists.");
	      }
	      PrintWriter writer = new PrintWriter("/Users/divya/Desktop/OsAssignment3sol.txt", "UTF-8");
		     writer.println("File is created!");
	}


}

package pagefault;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class PageFaultGenerator {

	public static void main(String[] args) throws IOException {
//		System.out.println("enter the memory size");
		Scanner sc = new Scanner(System.in);
		int i1=0,highbit=128;
		System.out.println("enter maximum frame size");
		int framenumber = sc.nextInt();	
		sc.close();
		 File file = new File("/Users/divya/Desktop/try.txt");
		 if (file.createNewFile()){
		        System.out.println("File is created!");
		         }else{
		        System.out.println("File already exists.");
		      }
		 Scanner scan = new Scanner(file); 
		 int [] page = new int[10000];
		 int [][] frame_faults = new int[framenumber][2];
		 //size of memory is 8.
		 int [][] memory = new int[8][2];

	     
	      @SuppressWarnings("resource")
		PrintWriter writer = new PrintWriter("/Users/divya/Desktop/try.txt");
	      //random generator of frame size. 
	      
		     for(int i=0;i<10000;i++){
		    	int k=(int)(Math.floor(Math.random()*framenumber));
//		    	numbers will be from frame to frame number
		    writer.println(k+1);
		     }
		     writer.close();
		     
		 	while(scan.hasNextLine()){
		    	 String s = scan.nextLine().trim();
		    	 page[i1] = Integer.parseInt(s);
		    	 i1++;
		    }

		     scan.close();
		     for(int i :page){
		    	 boolean stillnotfound = false,dobreak =false;
//		    	 check the page in memory reference .if found increase its value. else reduce its value.
//		   every input is one clk .
		    	 while(!stillnotfound){
		    	 for(int []m:memory){
		    		 if(m[0]==i){
//		    			page found increase the count and break.
		    			 m[1]=m[1]|highbit;
		    			 stillnotfound = false;
		    			 dobreak=true;
		    			 break;
		    		 }
		    	 }
		    	 stillnotfound=true;
		     }
		   if(stillnotfound == true && !dobreak){
//		    	found that memory doesnot have it 
//		    	 so shift all the memory values by one position right
		    	 for(int []m:memory){
		    		 m[1]= m[1]>>1;
		    	 }
//		    	 after shifting find the least value and replace with the value in memory
		    	 int lowest = 0;
		    	 for(int i11 = 0;i11<7;i11++){
		    		 if(memory[i11][1] > memory[i11+1][1]){
		    			 lowest = i11+1;
		    		 }
		    	 }
//		    	 assinging the value in to memory
		    	 memory[lowest][0]=i;
		    	 memory[lowest][1]=128;
//		    	 increasing the page fault
		    	 frame_faults[i-1][0]=i;
		    	 frame_faults[i-1][1]=frame_faults[i-1][1]+1;
		    	 }
		    
		   
		  }
		     
		     System.out.println("memory");
		     for(int []h:memory){
		    	 System.out.println(h[0]+"    "+h[1]);
		     } 
		     
		     System.out.println("page faults");
		     for(int []h:frame_faults){
		    	 if(h[0] >0){
		    	 System.out.println(h[0]+"    "+h[1]);
		    		 System.out.println(h[0]);
		    	 }
		     }    
	}
	
	

}

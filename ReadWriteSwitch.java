package filehandling;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

// create and write file

public class ReadWriteSwitch 
{

	public static void main(String[] args) throws IOException 
	{
            
            System.out.println("\tFILE HANDLING OPERATIONS");
            
            BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
            System.out.println("\nSelect your desired operation:");
            System.out.print("\n1. Write.");
	        System.out.print("\t2. Read.");
	        System.out.print("\t3. Efficiency.\n");
	        System.out.print("\n4. FileReader.");
	        System.out.print("\t5. FileWriter.");
	        System.out.println("\t6. Zipping.");
	        System.out.print("\n7. Unzipping.");
	        System.out.print("\t8. Exit.");
	        System.out.print("\n\nPlease enter your selection between 1-8: ");
            int rd=Integer.parseInt(br.readLine());
                     
    switch (rd) 
    {
    case 1:
      
	  DataInputStream dis=new DataInputStream(System.in);
	  FileOutputStream fout=new FileOutputStream("G:/James.txt");
	  System.out.println("Enter Text (! at the End): ");
	  char ch;
	  while ((ch=(char)dis.read()) != '!')
	  fout.write(ch);
	  fout.close();
	  	  
	case 2:
		    int pl;
		    FileReader fr=null;
		    try
		    {
		        fr=new FileReader("G:/James.txt");
		    }
		    catch (Exception e)
		    {
		        System.err.println(e);
		        return;
		    }
		    while ((pl= fr.read()) !=- 1)
		    System.out.println((char)pl);
    		
    case 3:
    	Long starttime = System.currentTimeMillis();
		DataInputStream di=new DataInputStream(System.in);
		FileOutputStream fos=new FileOutputStream("G:/James2.txt",true);
		
		BufferedOutputStream bos=new BufferedOutputStream(fos,512);
		System.out.println("Enter Text (# to end): ");
		char kl;
		
		System.out.println("Total time spent in writing "+ "without buffered input is (in millisec) "
			    + (System.currentTimeMillis() - starttime));
		
		while ((kl=(char)di.read()) !='#')
			bos.write(kl);
		
		System.out.println("Total time spent in writing "+ "without buffered input is (in millisec) "
			    + (System.currentTimeMillis() - starttime));
		bos.close();
		
    case 4:
    	BufferedReader tk=new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Enter Text: ");
    	String k=br.readLine();
    	
    	FileWriter fw= new FileWriter("text");
    	
    	for (int i=0;i<k.length();i++)
    		fw.write(k.charAt(i));
    	fw.close();
    	
    case 5:
    	int ar;
    	FileReader op=null;
    	try
    	{
    		op=new FileReader("text");
    	}
    	catch (Exception q)
    	{
    		System.err.println(q);
    		return;
    	}
    	while((ar=op.read()) != -1)
    		System.out.println((char)ar);
    	op.close();
    
    case 6:
    	try
    	{
    	FileInputStream fi=new FileInputStream("text");
    	FileOutputStream fs=new FileOutputStream("text2");
    	DeflaterOutputStream dfs= new DeflaterOutputStream (fs);
    	
    	int dat;
    	while ((dat=fi.read())!= -1)
    		dfs.write(dat);
    	fi.close();
    	dfs.close();
    	} catch (Exception x) {
    		System.err.println(x);
    	}
    	
    case 7:
    	try
    	{
    	FileInputStream fy=new FileInputStream("text");
    	FileOutputStream fo=new FileOutputStream("text3");
    	InflaterInputStream ds= new InflaterInputStream (fy);
    	
    	int d;
    	while ((d=ds.read())!= -1)
    		fo.write(d);
    	fy.close();
    	ds.close();
    	}
    	catch (Exception x) {
    		System.err.println(x);
    	}
    	
    case 8:
    	return;
	}
  }
 }
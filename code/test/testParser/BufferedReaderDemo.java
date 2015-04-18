import java.io.*;
class BufferedReaderDemo
{


  int count=0;
 
 public static void main(String args[])
  {
   
  BufferedReaderDemo brd = new BufferedReaderDemo();
  RandomAccessFile br;
  int countTemp=0;

 //--------------------------need the count(total no of mails)--------------------------------------
  
  try
     {
 
	
  	 br = new RandomAccessFile("Inbox.txt", "r"); 
  	String strLine;
  	//Read File Line By Line
 	 while ((strLine = br.readLine()) != null) 
  	{
  		// Print the content on the console
  
   
   		if(strLine.startsWith("Message-ID: <") || strLine.startsWith("Message-Id: <"))
  			{
  
 			 //System.out.println (strLine);
	
 		 	brd.count++;
	
  
 			  }

 	 } // end of while

	System.out.println(brd.count);

	String str[] = new String[brd.count];
  	br.seek(0);

//---------------------------need to store all the message ids in decending order in array if strings---------

	countTemp=(brd.count-1);
	 while ((strLine = br.readLine()) != null) 
  	{
  		
		
	if(strLine.startsWith("Message-ID: <") || strLine.startsWith("Message-Id: <"))
  		{
  		
		
  		//System.out.println (strLine);
		String s = strLine.substring(13);
		//System.out.println(s);
		//int i=s.length();
		//System.out.println(""+i);
		//i=i-2;
		//System.out.println(s.substring(0,i) );

			str[countTemp]=strLine;
 			//str[countTemp]=s.substring(0,i);
			//System.out.println(str[countTemp]);
			countTemp=countTemp-1;
			//System.out.println(countTemp);
			//System.out.println("hiiii...");
				
  	
	
  
   		} // end of if

	} // end of while

	for(int kk=0;kk<11;kk++)
		{
		System.out.println(str[kk]);
		}

	
//-----------------------------search for he message-id -----------------------------------

	br.seek(0);



while ((strLine = br.readLine()) != null) 
  	{
  		
		
	if(strLine.equals(str[7]))
  		{
  		
		strLine = br.readLine();
		
		
		
  		//System.out.println (strLine);
		//strLine = br.readLine();
		//strLine = br.readLine();
		//strLine = br.readLine();
		//System.out.println (strLine);
		
		while (!(strLine.startsWith("Date: ")) )
  		{
		if((strLine.startsWith("Message-ID: <")))
		{
			break;
		}
		else
		 strLine = br.readLine();
		}	
		System.out.println (strLine);

		
		while (!(strLine.startsWith("Subject: ")) )
  		{
		if((strLine.startsWith("Message-ID: <")))
		{
			break;
		}
		else
		 strLine = br.readLine();
		}	
		System.out.println (strLine); 

		while (!(strLine.startsWith("From: ")) )
  		{
		if((strLine.startsWith("Message-ID: <")))
		{
			break;
		}
		else
		 strLine = br.readLine();
		}	
		System.out.println (strLine); 		
		




		


		//String s = strLine.substring(13);
		//System.out.println(s);
		//int i=s.length();
		//System.out.println(""+i);
		//i=i-2;
		//System.out.println(s.substring(0,i) );

			//str[countTemp]=strLine;
 			//str[countTemp]=s.substring(0,i);
			//System.out.println(str[countTemp]);
			//countTemp=countTemp-1;
			//System.out.println(countTemp);
			//System.out.println("hiiii...");
				
  	
	
  
   		} // end of if

	} // end of while





 


		

      } // end of try
  
  catch (Exception e)
      {
       	//Catch exception if any
 	 System.out.println("Error: " +e);
       }
  







  
/*
while ((strLine = br.readLine()) != null) 
  {
  // Print the content on the console
  
   
   if(strLine.startsWith("Message-ID: <") || strLine.startsWith("Message-Id: <"))
  {
  
  System.out.println (strLine);
	String s = strLine.substring(13);
	//System.out.println(s);
	int i=s.length();
	//System.out.println(""+i);
	i=i-2;
	System.out.println(s.substring(0,i) );
/*
	for(int k=brd.count;k<0;k--)
	{
 	str[k]=s.substring(0,i);
	System.out.println("hiiii...");
	}
  	
	
  
   }

  } // end of while





*/
 


  //Close the input stream

   
  } // end of main()
} // end of class

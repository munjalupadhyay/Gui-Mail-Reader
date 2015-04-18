import java.io.FileDescriptor;
import java.io.*;
import java.io.EOFException;

public class Parser
{
 
 public int count=0; 
 
  int temp=0;























 public int getMail(String mailId , DetailMailResp detailMailResp , String userId ) throws java.io.EOFException  
 {

 // BufferedReaderDemo brd = new BufferedReaderDemo();
  RandomAccessFile br;
  int countTemp=5;
  int ret=1;
  //String mailId = new String("cba1748c62ff6f7595adf02d3ad640bf.squirrel@dcis.uohyd.ernet.in");


/*
  detailMailResp.from="munjal";
  detailMailResp.subject="Hello munjal I am subject";
  detailMailResp.date="I am date";
  detailMailResp.cc="I am cc";
  detailMailResp.bcc="I am bcc";
  detailMailResp.mailBody="I am body";
  detailMailResp.priority=1;

*/

  try
     {
 
	
  	 br = new RandomAccessFile(userId, "r"); 
  	String strLine;
  	//Read File Line By Line
 	 	 while ((strLine = br.readLine()) != null) 
  	{
  		// Print the content on the console
  
   
   		if(strLine.contains(mailId))
  			{
                       
                  while (countTemp>0 && !strLine.isEmpty())
  		{
		   strLine = br.readLine();
                if((strLine.startsWith("Date:")))
		{
		                  
                    // System.out.println("from salil module  "+strLine);
		       detailMailResp.date=strLine.substring(6);
                       countTemp--;

		}
	         
                             
                 else if((strLine.startsWith("Subject:")))
		{
		                  
                   // System.out.println("from salil module  "+strLine);
		     detailMailResp.subject=strLine.substring(9);
                          countTemp--;
		}
		 
	         
                  else if((strLine.startsWith("From:")))
		{
		                  
                     // System.out.println("from salil module  "+strLine);
		     detailMailResp.from=strLine.substring(6);
                      countTemp--;
		}
		 
	         
                    else if((strLine.startsWith("Cc:")))
		{
		                  
                     // System.out.println("from salil module  "+strLine);
		     detailMailResp.cc=strLine.substring(4);
                        countTemp--;
		}
		 
	         
                  else if((strLine.startsWith("X-Priority")))
		{
		                  
                    //System.out.println("from salil module  "+strLine);
		     detailMailResp.priority=strLine.substring(11);
                        countTemp--;
		}
	
	         

                    
               }//end of internal while
 	//	 	brd.count++;
                     while(!strLine.isEmpty())//skipping the header lines till blank line before mailbody
                       {
                        strLine=br.readLine();
                       }
                        detailMailResp.mailBody = " " ;  
                       while(!strLine.startsWith("From") && !strLine.contains("@dcis.uohyd.ernet.in") && !strLine.startsWith("> "))
                        {
                          detailMailResp.mailBody = detailMailResp.mailBody +"\n"+ strLine ;
                          //System.out.println(strLine);
                             strLine=br.readLine();
                           if(strLine.startsWith(">From"))
                
                               { 
                                      while(!strLine.isEmpty())
                                        {
                                            detailMailResp.mailBody = detailMailResp.mailBody+"\n" + strLine ;
                                             //System.out.println(strLine);
                                             strLine=br.readLine();
                                         }//end while

                                              ret=0;
                                     }//end if

                              }//end while
	
	

                        //  }//end of while




  
 			  }//end of if


 	} // end of while
   } // end of try

catch (Exception e)
      {
       	//Catch exception if any
 	 System.out.println("Error: " +e);
       }
  





                   if(detailMailResp.date!="null")
                       {
                      
                        return 0;              //  return the error number ...
                        }
                        else
                        {
                         return 1;
                         }


                       }//end of getMail()







  public int getList(String userId , GetMailListResp getMailListResp , int countt)

  {
   	//countt=3;
	//count = countt;

	
	for(int i=0;i<20;i++)
	{
	 getMailListResp.mailInfo[i]=new MailInfo();
	 }
   



//	getMailListResp.mailInfo[0].from="munjal";
//	getMailListResp.mailInfo[0].subject="hi I am munjal's subject";
//	getMailListResp.mailInfo[0].date="I am munjal's date";
//	getMailListResp.mailInfo[1].from="salil";
//	getMailListResp.mailInfo[1].subject="hi I am salil's subject";
//	getMailListResp.mailInfo[1].date="I am salil's date";
//	getMailListResp.mailInfo[2].from="adi";
//	getMailListResp.mailInfo[2].subject="hi I am adi's subject";
//	getMailListResp.mailInfo[2].date="I am adi's date";


         //-----------------------------------------------------------------------------------------


 //BufferedReaderDemo brd = new BufferedReaderDemo();
  RandomAccessFile br;
  int countTemp=0;

 //--------------------------need the count(total no of mails)--------------------------------------
  
  try
     {
 
	
  	 br = new RandomAccessFile( userId, "r"); 
  	String strLine;
  	//Read File Line By Line
 	 while ((strLine = br.readLine()) != null) 
  	{
  		// Print the content on the console
  		//System.out.println (strLine);
		//count++;               
		               
   		if(strLine.startsWith("Message-ID: <") /*|| strLine.startsWith("Message-Id: <")*/)
			//System.out.println (strLine);
  			{
                          //strLine=br.readLine();
                          
			count++;
			}
   			 if(strLine.startsWith(">From"))
                          {
                        while(!strLine.isEmpty())
                         {
                        strLine=br.readLine();

                        }
                      }
  
 			  

 	 } // end of while

	//System.out.println (count);	
	getMailListResp.no=count;

	System.out.println(count);

	String str[] = new String[count];
  	br.seek(0);

//-------------------------need to store all the message ids in decending order in array if strings---------

	countTemp=(count-1);
	


	 while ((strLine = br.readLine()) != null) 
  	{
  		
		
	    if(strLine.startsWith("Message-ID: <") /*|| strLine.startsWith("Message-Id:")*/	)

  	       {
			//System.out.println (strLine);
                          //strLine=br.readLine();
                        //  if(strLine.startsWith("Return-Path:")/* && strLine.contains("@dcis.uohyd.ernet.in>")*/)
 			    
  		
  		/*while(!strLine.startsWith("Message-ID:"))
                      {
			System.out.println (strLine);
                        strLine=br.readLine();
			
                       }
		*/
  		//System.out.println (strLine);
		String s = strLine.substring(13);
		//System.out.println(s);
		//int i=s.length();
		//System.out.println(""+i);
		//i=i-2;
		//System.out.println(s.substring(0,i) );

			str[countTemp]=strLine;
 			//str[countTemp]=s.substring(0,i);
			System.out.println(str[countTemp]);
			countTemp=countTemp-1;
			//System.out.println(countTemp);
			//System.out.println("hiiii...");
				
  	
	             // }//end of if
  
   		} // end of if

		if(strLine.startsWith(">From"))
                          {
                        while(!strLine.isEmpty())
                         {
                        strLine=br.readLine();

                        }
                      }


	} // end of while

	
//-----------------------------search for he message-id -----------------------------------

	br.seek(0);

 temp =count-1;
 if( count <= 20)
 {

while ((strLine = br.readLine()) != null ) 
  	{
  		
        
            
	if(strLine.equals(str[temp]))
  		{
                    int i=strLine.length();
		//System.out.println(""+i);
		  i=i-1;
		//System.out.println(s.substring(0,i) );
  		getMailListResp.mailInfo[temp].mailId=strLine.substring(13,i);



                //System.out.println(str[temp]);
		
		strLine = br.readLine();
		
		
		
  		//System.out.println (strLine);
		//strLine = br.readLine();
		//strLine = br.readLine();
		//strLine = br.readLine();
		//System.out.println (strLine);
		
		while (!(strLine.startsWith("Date: ")) )
  		{
		 strLine = br.readLine();
	         }
		getMailListResp.mailInfo[temp].date=strLine.substring(6);
		// System.out.println (strLine);
                
		 strLine = br.readLine();
		getMailListResp.mailInfo[temp].subject=strLine.substring(9);
		//getMailListResp.mailInfo[temp].mailId=strLine;
		//System.out.println (strLine); 
                   strLine = br.readLine();
		getMailListResp.mailInfo[temp].from=strLine.substring(6);	
		//System.out.println (strLine); 		
                 temp--;




		


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


   }
 else 
 {

   temp = 20;
   
	while ((strLine = br.readLine()) != null ) 
  	{
  		
        
            
	if(strLine.equals(str[temp]))
  		{
                    int i=strLine.length();
		//System.out.println(""+i);
		  i=i-1;
		//System.out.println(s.substring(0,i) );
  		getMailListResp.mailInfo[temp].mailId=strLine.substring(13,i);



                //System.out.println(str[temp]);
		
		strLine = br.readLine();
		
		
		
  		//System.out.println (strLine);
		//strLine = br.readLine();
		//strLine = br.readLine();
		//strLine = br.readLine();
		//System.out.println (strLine);
		
		while (!(strLine.startsWith("Date: ")) )
  		{
		 strLine = br.readLine();
	         }
		getMailListResp.mailInfo[temp].date=strLine.substring(6);
		// System.out.println (strLine);
                
		 strLine = br.readLine();
		getMailListResp.mailInfo[temp].subject=strLine.substring(9);
		//getMailListResp.mailInfo[temp].mailId=strLine;
		//System.out.println (strLine); 
                   strLine = br.readLine();
		getMailListResp.mailInfo[temp].from=strLine.substring(6);	
		//System.out.println (strLine); 		
                 temp--;




		


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


 }  // end of else


 


		

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

   
  










          if(count==0)
            {

                return 3; 
            }

         if(getMailListResp.mailInfo[count-1].mailId!="null")
          {
             return 0; 
             }





	// for rest of the ovject values  , pease make it null or enprt string 
	return 0;
    }
 }

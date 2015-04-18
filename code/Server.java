import java.io.*;
import java.net.*;
import java.lang.*;
import java.io.FileDescriptor;

/*
public class Server
{
 

 public static void main(String args[]) throws IOException , ClassNotFoundException ,ClassCastException
 {
 	


 	ServerSocket serverSocket = new ServerSocket(6553);
	System.out.println("server up and ready for the connection");
	Socket socket = serverSocket.accept();
	ObjectOutputStream objectOutputstream = new ObjectOutputStream(socket.getOutputStream());
	ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

   	
         AuthReq authReq;
	 DetailMailReq detailMailReq;
	 GetMailReq getMailReq;
	 LogoutReq logoutReq;


 	Object obj = (Object)objectInputStream.readObject();
	
	try
	{
   	 authReq=(AuthReq)obj;
 	 System.out.println("receives message having message id = 20");
	 
          }
    	 catch(ClassCastException cce)
	 {
 		try
	         { 
	
	 	   getMailReq=(GetMailReq)obj;
		   System.out.println("receives message having message id = 30");
	           }

	         catch(ClassCastException ccee)
		 {
		     try{ 

 	 		  detailMailReq=(DetailMailReq)obj;
	    		  System.out.println("receives message having message id = 40");
 		
 			}
       		    catch(ClassCastException cceee)
	    		{
	    		  try{ 

 	     			 logoutReq=(LogoutReq)obj;
	      			 System.out.println("receives message having message id = 50");
 	        		}
 	  		 catch(ClassCastException cceeee)
	 		      {
	    			System.out.println("Something is going wrong , server is not getting the defined msgId"+cceeee);   
	  			 }		 
	    		       }	


 
		   	}
	       
	    }
 
  	
		
 
         
	  
		

	
 	

	//Message message = Message ();
	//Message1 message1 = (Message1)objectInputStream.readObject();
	
 
	//message.result=(message.firstNumber) * (message.secondNumber);
       //	System.out.println("\n"+message.result);
	 //objectOutputstream.writeObject(message);

 }
} 



import java.io.*;  
import java.net.*;  
import java.util.*;  
  
*/

public class Server implements Runnable  
{  
    Socket csocket;
    int idRec=0;  
      
    public Server(Socket csocket)   
    {  
    this.csocket = csocket;  
    }  
      
    public static void main(String args[]) throws Exception , IOException , ClassNotFoundException   
    {  
    ServerSocket ssock = null;  
  
    try  
        {  
        ssock = new ServerSocket(6552);  
        System.out.println("Echo Server Listening....");  
        int i = 1;  
          
        while (true)   
            {  
            Socket sock = ssock.accept();  
            System.out.println("Connected");  
            Runnable r = new Server(sock);  
            Thread t = new Thread(r);  
            t.start();  
            System.out.println("Spawning Thread " + i);  
            i++;  
            }   // end of while 
        }  
    catch(Exception e)  
        {  
        e.printStackTrace();  
        }  
  
    }  // end of main()
      
    public void run()   
    {  
    System.out.println("Inside run");  
    try   
        {  
        try  
            {  
          
           
	 AuthReq authReq;
	 AuthResp authResp;
	 DetailMailReq detailMailReq;
	 DetailMailResp detailMailResp;
	 GetMailReq getMailReq;
	 GetMailListResp getMailListResp;
	 LogoutReq logoutReq;
	 LogoutResp logoutResp;

	ObjectOutputStream objectOutputstream = new ObjectOutputStream(csocket.getOutputStream());
	ObjectInputStream objectInputStream = new ObjectInputStream(csocket.getInputStream());

 	String userId="";
	FileDescriptor fd;

	while(true)
	{

        Object obj = (Object)objectInputStream.readObject();
	
	




	try
	{
   	 authReq=(AuthReq)obj;
 	 System.out.println("receives message having message id = 20");
	 idRec=20;
	 
          }
    	 catch(ClassCastException cce)
	 {
 		try
	         { 
	
	 	   getMailReq=(GetMailReq)obj;
		   System.out.println("receives message having message id = 30");
		   idRec=30;
	           }

	         catch(ClassCastException ccee)
		 {
		     try{ 

 	 		  detailMailReq=(DetailMailReq)obj;
	    		  System.out.println("receives message having message id = 40");
 		          idRec=40;
 			}
       		    catch(ClassCastException cceee)
	    		{
	    		 	 try{ 

 	     				 logoutReq=(LogoutReq)obj;
	      				 System.out.println("receives message having message id = 50");
					 idRec=50;
 	        		      }
 	  		 	 catch(ClassCastException cceeee)
	 		      	    {
	    				  System.out.println("Something is going wrong , server is not getting the defined msgId"+cceeee);   
	  			       }		 
	    		    } // catch of cceee	


			} // catch of ccee 

		
		     } // catch of cce
 	
		if(idRec==20)
		{
			
			//System.out.println("file exists or nor ?? 0 : exist , 1 : do not exist "+retVal);
			

			authReq=(AuthReq)obj;
			String s = authReq.userId;
			userId=s;
			int retVal=authenticate(s);
			System.out.println("========================"+userId+"========================");
			authResp = new AuthResp();
			authResp.authRetValue=retVal;
			objectOutputstream.writeObject(authResp);	
			
		}
		else if(idRec==30)
		{
			getMailReq=(GetMailReq)obj;
			int retVal;
			
			Parser p = new Parser();
			getMailListResp = new GetMailListResp();
			int count=0;
			retVal=p.getList(userId,getMailListResp,count);

			//System.out.println("========================"+userId+"========================");
			getMailListResp.getMailListRetVal=retVal;
			//getMailListResp.no=p.count;
			objectOutputstream.writeObject(getMailListResp);
	
			//----------------------------------------------------------------------


			System.out.println("count=="+getMailListResp.no);
			System.out.println("retValue=="+getMailListResp.getMailListRetVal);
			 


			if(getMailListResp.no<=20)
			{
			for(int sal=0 ; sal<getMailListResp.no ; sal++)
			{
			System.out.println("Mail-ID   "+getMailListResp.mailInfo[sal].mailId);
			System.out.println("from   "+getMailListResp.mailInfo[sal].from);
			System.out.println("subject   "+getMailListResp.mailInfo[sal].subject);
			System.out.println("date   "+getMailListResp.mailInfo[sal].date);
			 
			}	
			}
			else
			{
			for(int sal=0 ; sal<getMailListResp.no ; sal++)
			{
			System.out.println("Mail-ID   "+getMailListResp.mailInfo[sal].mailId);
			System.out.println("from   "+getMailListResp.mailInfo[sal].from);
			System.out.println("subject   "+getMailListResp.mailInfo[sal].subject);
			System.out.println("date   "+getMailListResp.mailInfo[sal].date);
			 
			}

			}




			//-------------------------------------------------------------------------
			 
		 	

		}
		else if(idRec==40)
		{
		   	detailMailReq=(DetailMailReq)obj;
			String s = detailMailReq.mailId;
			int retVall;
			Parser p = new Parser();
			detailMailResp = new DetailMailResp();
			
		  	retVall = p.getMail(s , detailMailResp , userId);
			detailMailResp.eNo=retVall;
			//System.out.println("date is :"+detailMailResp.date);
			
			objectOutputstream.writeObject(detailMailResp);
		}
		else
		{ // idRec==50 
			logoutResp = new LogoutResp();
        		logoutResp.msgId=50;
			objectOutputstream.writeObject(logoutResp);
		   	//csocket.close();   // server SHOULD not close the socket . it's clients work 
		}


		}// end of while


            }  
        finally  
            {  
            csocket.close();  
            }   // end of second try
    }   // end of first try
      
    catch (IOException ioe)   
    {  
        System.out.println(ioe);  
    }  
  catch (ClassNotFoundException cnf)   
    {  
        System.out.println(cnf);  
    } 
 

  } // end of run() 


private int authenticate(String userId)  
{
File f = new File(userId);
if (f.exists()) 
return 0;
else
return 1;

}

private FileDescriptor openFile(String path) throws FileNotFoundException, IOException 
 {
    File file = new File(path);
    FileOutputStream fos = new FileOutputStream(file);
    // remember th 'fos' reference somewhere for later closing it
    //fos.write((new Date() + " Beginning of process...").getBytes());
    return fos.getFD();
}

}  // end of class


import java.io.*;
import java.net.*;

public class Client 
 {
	int idSent=0;
	int idRec=0;
	 AuthReq authReq;
	 AuthResp authResp;
	 AuthResp dauthResp;
	 GetMailReq getMailReq;
	 GetMailListResp getMailListResp;
	 GetMailListResp dgetMailListResp;	 
	 DetailMailReq detailMailReq;
	 DetailMailResp detailMailResp;
	 DetailMailResp ddetailMailResp;
	 LogoutReq logoutReq;
	 LogoutResp logoutResp;
	 LogoutResp dlogoutResp;

   	Socket socket;
	ObjectOutputStream objectOutputstream;
	ObjectInputStream objectInputStream;


 public static void main(String args[]) throws UnknownHostException , IOException , ClassNotFoundException

 {
	//String name="munjal";
 	

         Socket socket = new Socket("localhost" , 6552);
	//int msgId= Integer.parseInt(args[0]);	
	//int firstNumber= Integer.parseInt(args[1]);
	//int secondNumber= Integer.parseInt(args[2]);

	Object obj ;

	ObjectOutputStream objectOutputstream = new ObjectOutputStream(socket.getOutputStream());
	ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

	Client client = new Client();
       // client.sendAuthReq("notes");
	// client.sendGetMailReq();
	//client.sendDetailMailReq("13mcmt19");
	//client.sendLogoutReq();  

	if (client.idSent==20)
	objectOutputstream.writeObject(client.authReq);
 	else if(client.idSent==30)
	objectOutputstream.writeObject(client.getMailReq);
	else if(client.idSent==40)
	objectOutputstream.writeObject(client.detailMailReq);
	else 
	objectOutputstream.writeObject(client.logoutReq);
	
        
	
	obj = (Object)objectInputStream.readObject();

	try
	{
   	 client.dauthResp=(AuthResp)obj;
 	 System.out.println("receives message having message id = 20");
	 client.idRec=20;
	 
          }
    	 catch(ClassCastException cce)
	 {
 		try
	         { 
	
	 	   client.dgetMailListResp=(GetMailListResp)obj;
		   System.out.println("receives message having message id = 30");
		   client.idRec=30;
	           }

	         catch(ClassCastException ccee)
		 {
		     try{ 

 	 		  client.ddetailMailResp=(DetailMailResp)obj;
	    		  System.out.println("receives message having message id = 40");
 		          client.idRec=40;
 			}
       		    catch(ClassCastException cceee)
	    		{
	    		 	 try{ 

 	     				 client.dlogoutResp=(LogoutResp)obj;
	      				 System.out.println("receives message having message id = 50");
					 client.idRec=50;
 	        		      }
 	  		 	 catch(ClassCastException cceeee)
	 		      	    {
	    				  System.out.println("Something is going wrong , server is not getting the defined msgId"+cceeee);   
	  			       }		 
	    		    } // catch of cceee	


			} // catch of ccee 

		
		     } // catch of cce

 // so now I know which type of response message it is ,....

		 if(client.idRec==20)
		 {
 		  client.authResp = client.dauthResp ;
		  client.authResp.authRetValue = client.dauthResp.authRetValue;
		  System.out.println("return value of authenticate is "+client.authResp.authRetValue);
		 }
		else if (client.idRec==30)
		 {
		  
		  client.getMailListResp = client.dgetMailListResp ;
		  int retVal = client.getMailListResp.getMailListRetVal;
		  int count = client.getMailListResp.no;
		  System.out.println("return value =="+retVal);	
		  System.out.println("count value =="+count);
		  for(int k=0;k<count;k++)
		  {
			System.out.println("mailId   "+client.getMailListResp.mailInfo[k].mailId);
			System.out.println("from   "+client.getMailListResp.mailInfo[k].from);
			System.out.println("subject   "+client.getMailListResp.mailInfo[k].subject);
			System.out.println("date   "+client.getMailListResp.mailInfo[k].date);
		   }

		  
	 	  }
		else if (client.idRec==40)
		 {
		  
	  	  client.detailMailResp = client.ddetailMailResp ;
		  int retVal = client.detailMailResp.eNo;
		  String from = client.detailMailResp.from;  
		  String subject = client.detailMailResp.subject;
		  String date = client.detailMailResp.date;
		  String cc = client.detailMailResp.cc;
		  String bcc = client.detailMailResp.bcc;
		  String mailBody = client.detailMailResp.mailBody; 
		  String priority = client.detailMailResp.priority;
		  
	          System.out.println("retVal received = "+retVal);
		  System.out.println ("from received = "+from);
		  System.out.println ("subject received = "+subject);
		  System.out.println ("date received = "+date);
		  System.out.println ("cc received = "+cc);
		  System.out.println ("bcc received = "+bcc);
		  System.out.println ("mailBody received = "+mailBody);
		  System.out.println ("priority received = "+priority);
		  }
		else 
		{ // idRec==50
		
		   socket.close();
		 }




 	for(int j=0;j<100;j++)
	{
 	 j--;
	}
        //Message returnMessage = (Message)objectInputStream.readObject();
	//System.out.println(returnMessage.result);

	 socket.close();
  }

  private void sendAuthReq(String userId)   
    {  
      
	idSent=20;
        authReq = new AuthReq();
        authReq.msgId=20;
	authReq.userId=userId;
 	//objectOutputstream.writeObject(authReq);
        
       
       }

  private  void sendGetMailReq()   
    {  
	
	idSent=30;
        getMailReq = new GetMailReq();
        getMailReq.msgId=30;
	//objectOutputstream.writeObject(getMailReq);
         
	   
   }

 private  void sendDetailMailReq(String mailId)   
    {  
 	
	idSent=40;
        detailMailReq = new DetailMailReq();
        detailMailReq.msgId=40;
	detailMailReq.mailId=mailId;
	//objectOutputstream.writeObject(detailMailReq);
  	 
	
 
        }

  private void sendLogoutReq()   
    {  
	
	idSent=50;
        logoutReq = new LogoutReq();
        logoutReq.msgId=50;
	//objectOutputstream.writeObject(authReq);
        
    }

public int authenticate(String userId)
{

return 0;
}

public int getList()
{

return 0;
}

public int getMail(String mailId)
{

return 0;
}

public int logout()
{

return 0;
} 
 
 }	

import java.io.*;
import java.net.*;

public class Client1 

 {
    
    Object obj ;    
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
     ObjectOutputStream objectOutputstream;
     ObjectInputStream objectInputStream;
     Socket socket;

     public void initialize() throws UnknownHostException , IOException , ClassNotFoundException
	{
        socket = new Socket("localhost" , 6552);
    
   objectOutputstream = new ObjectOutputStream(socket.getOutputStream());
    objectInputStream = new ObjectInputStream(socket.getInputStream());
        }
    
 //    public static void main(String args[]) throws UnknownHostException , IOException , ClassNotFoundException

     {
    //String name="aditya";
     

         
    //int msgId= Integer.parseInt(args[0]);    
    //int firstNumber= Integer.parseInt(args[1]);
    //int secondNumber= Integer.parseInt(args[2]);
   // Client1 client = new Client1(); 
        
   // client.initialize();

     

        
     
     //client.authenticate("notess");
    //client.getList();
    //client.getMail("13mcmt19");
    //client.logout();  

    
        
/*    
    obj = (Object)client.objectInputStream.readObject();

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

*/

 // so now I know which type of response message it is ,....

    
///     for(int j=0;j<100;j++)
    {
//      j--;
     }
        //Message returnMessage = (Message)objectInputStream.readObject();
    //System.out.println(returnMessage.result);

//     client.socket.close();
      } // end of main()/////////////////////////////

  private void sendAuthReq(String userId) throws UnknownHostException , IOException , ClassNotFoundException
    {  
      
    idSent=20;
        authReq = new AuthReq();
        authReq.msgId=20;
    authReq.userId=userId;
     objectOutputstream.writeObject(authReq);
        
       
       }

  private  void sendGetMailReq()  throws UnknownHostException , IOException , ClassNotFoundException  
    {  
    
    idSent=30;
        getMailReq = new GetMailReq();
        getMailReq.msgId=30;
    objectOutputstream.writeObject(getMailReq);
         
       
   }

 private  void sendDetailMailReq(String mailId) throws UnknownHostException , IOException , ClassNotFoundException 
    {  
     
    idSent=40;
        detailMailReq = new DetailMailReq();
        detailMailReq.msgId=40;
    detailMailReq.mailId=mailId;
    objectOutputstream.writeObject(detailMailReq);
       
    
 
        }

  private void sendLogoutReq() throws UnknownHostException , IOException , ClassNotFoundException 
    {  
    	//Syetem.out.println("in side sendLogoutReq");
    	idSent=50;
        logoutReq = new LogoutReq();
        logoutReq.msgId=50;
    	objectOutputstream.writeObject(logoutReq);
	
        
    }


public int authenticate(String userId) throws UnknownHostException , IOException , ClassNotFoundException
        {
      
      sendAuthReq(userId);       
      decompose(idSent);
        return  authResp.authRetValue;
        }

public int getList() throws UnknownHostException , IOException , ClassNotFoundException
        {
	sendGetMailReq();
	decompose(idSent);
        return getMailListResp.getMailListRetVal;
        }

public int getMail(String mailId) throws UnknownHostException , IOException , ClassNotFoundException
        {
 	sendDetailMailReq(mailId);
	decompose(idSent);
        return detailMailResp.eNo;
        }

public int logout() throws UnknownHostException , IOException , ClassNotFoundException
        {
	//System.out.println("Sent ....... :)");
	sendLogoutReq();
	decompose(idSent);
	
        return 0;
    } 

public GetMailListResp retGetMailListResp()
{
 return getMailListResp;
}
 
public DetailMailResp retDetailMailResp()
{
 return detailMailResp;
}

private void decompose(int msgId) throws UnknownHostException , IOException , ClassNotFoundException
{
  obj = (Object)objectInputStream.readObject();
  
switch (msgId)
    {
    case 20:  
          dauthResp=(AuthResp)obj;
            System.out.println("receives message having message id = 20");
          authResp = dauthResp ;
          authResp.authRetValue = dauthResp.authRetValue;
          System.out.println("return value of authenticate is "+authResp.authRetValue);
             break;

    case 30: 
           dgetMailListResp=(GetMailListResp)obj;
           System.out.println("receives message having message id = 30");
          getMailListResp = dgetMailListResp ;
          int retVall = getMailListResp.getMailListRetVal;
          int count = getMailListResp.no;


          System.out.println("return value =="+retVall);    
          System.out.println("count value =="+count);
        /*  for(int k=0;k<count;k++)
          {
	    System.out.println("mailId   "+getMailListResp.mailInfo[k].mailId);
            System.out.println("from   "+getMailListResp.mailInfo[k].from);
            System.out.println("subject   "+getMailListResp.mailInfo[k].subject);
            System.out.println("date   "+getMailListResp.mailInfo[k].date);
           }*/
           break;

    case 40: 
          ddetailMailResp=(DetailMailResp)obj;
          System.out.println("receives message having message id = 40");
          detailMailResp = ddetailMailResp ;
          int retVal = detailMailResp.eNo;
          String from = detailMailResp.from;  
          String subject = detailMailResp.subject;
          String date = detailMailResp.date;
          String cc = detailMailResp.cc;
          String bcc = detailMailResp.bcc;
          String mailBody = detailMailResp.mailBody; 
          String priority = detailMailResp.priority;
          
          System.out.println("retVal received = "+retVal);
          System.out.println ("from received = "+from);
          System.out.println ("subject received = "+subject);
          System.out.println ("date received = "+date);
          System.out.println ("cc received = "+cc);
          System.out.println ("bcc received = "+bcc);
          System.out.println ("mailBody received = "+mailBody);
          System.out.println ("priority received = "+priority);
          break;

    case 50: 
          dlogoutResp=(LogoutResp)obj;
          System.out.println("receives message having message id = 50");
          socket.close();
         break;
   
    default: System.out.println("you need to learn code ...");
                     break;
   

    
    }

  }// end of decompose()............



 }    // end of class ....

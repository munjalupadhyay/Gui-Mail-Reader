import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;



class GUI //extends JFrame implements ActionListener

{
   GetMailListResp getMailListResp;
	DetailMailResp detailMailResp;
	String userId;
   Client1 c1 = new Client1();


   int retAuth=15;
   int retGetList=15;
	int retGetMail=15;

  public static void main ( String[] args )  
  {
    GUI gui = new GUI();
    gui.run();
  /*  
      try{

    gui.c1.initialize();
      }
    catch(UnknownHostException uhe)
	{
	System.out.println("error :::"+uhe);
	}
catch(IOException ioe)
	{
	System.out.println("error :::"+ioe);
	}
catch( ClassNotFoundException cnfe)
	{
	System.out.println("error :::"+cnfe);
	}    

*/

    //frm.setSize( 800, 800 );     
   // frm.setVisible( true );   
  }



public void run()
	{
		 java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
				
      try{

    c1.initialize();
      }
    catch(UnknownHostException uhe)
	{
	System.out.println("error :::"+uhe);
	}
catch(IOException ioe)
	{
	System.out.println("error :::"+ioe);
	}
catch( ClassNotFoundException cnfe)
	{
	System.out.println("error :::"+cnfe);
	}    

				Login l1 = new Login();
				 l1.setVisible(true);
				 l1.setSize( 800, 800 );
            }
        });
	}




	public class Login extends javax.swing.JFrame 
	{
	  JButton bChange ; // reference to the button object
	  JTextField t1; 
      JLabel label;
   

	  // constructor for ButtonFrame2
		  Login() 
		  {
		    super();                   // invoke the JFrame constructor
		    setLayout( new FlowLayout() );    // set the layout manager
            setTitle("UOH-Bird");
		    label = new JLabel("Enter UserID") ;
            t1 = new JTextField(20); 
            
		
		    // construct a Button
		    bChange = new JButton("Login"); 
    
		    // register the Login object as the listener for the JButton.
		    bChange.addActionListener( new java.awt.event.ActionListener()
           {
             public void actionPerformed(java.awt.event.ActionEvent evt) 
               {
                    bChangeActionPerformed(evt);
               }
           }                        ); 

		    //bChange.setBounds(200,100,200,100); 
            add( label);
		    add( t1 );
		    add( bChange );                   // add the button to the JFrame
           
           // bchange.setLocation(1150, 700);
		    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		  }
  
		  public void bChangeActionPerformed( ActionEvent evt) 
		  {
		    //getContentPane().setBackground( Color.blue );     // Change the Frame's background
		    String s1= t1.getText();
		    System.out.println(s1);
			userId=s1;
            if(s1.length() != 8 )
              {
                 JOptionPane.showMessageDialog(this, "UserId Length not sufficient");
              }
			else
			{
		    try{

		    retAuth=c1.authenticate(s1);
		      }
		    catch(UnknownHostException uhe)
			{
			System.out.println("error :::"+uhe);
			}
		catch(IOException ioe)
			{
			System.out.println("error :::"+ioe);
			}
		catch( ClassNotFoundException cnfe)
			{
			System.out.println("error :::"+cnfe);
			}
   
 			
			
		   if(retAuth==0)
			{

			 try{

			  retGetList=c1.getList();
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}
   			}
              else
             {
               JOptionPane.showMessageDialog(this, "Invalid User");
             }

			if(retGetList==0)
			{
			this.dispose();
 			MailList ml = new MailList();
			ml.setVisible(true);
			 getMailListResp=c1.retGetMailListResp();
			

			int count = getMailListResp.no;
			System.out.println("count value =="+count);
				
				for(int k=0;k<count;k++)
          			{
					//str[k]=getMailListResp.mailInfo[k].mailId;
	    			System.out.println("mailId   "+getMailListResp.mailInfo[k].mailId);
            			System.out.println("from   "+getMailListResp.mailInfo[k].from);
            			System.out.println("subject   "+getMailListResp.mailInfo[k].subject);
            			System.out.println("date   "+getMailListResp.mailInfo[k].date);
           			}

				
				ml.jLabel16.setText(getMailListResp.mailInfo[0].from);
				ml.jLabel17.setText(getMailListResp.mailInfo[0].subject);
						
				ml.jLabel18.setText(getMailListResp.mailInfo[0].date);	
				ml.jLabel21.setText(getMailListResp.mailInfo[1].from);
				ml.jLabel22.setText(getMailListResp.mailInfo[1].subject);		
				ml.jLabel23.setText(getMailListResp.mailInfo[1].date);
				ml.jLabel24.setText(getMailListResp.mailInfo[2].from);
				ml.jLabel25.setText(getMailListResp.mailInfo[2].subject);		
				ml.jLabel26.setText(getMailListResp.mailInfo[2].date);
				ml.jLabel27.setText(getMailListResp.mailInfo[3].from);
				ml.jLabel28.setText(getMailListResp.mailInfo[3].subject);		
				ml.jLabel29.setText(getMailListResp.mailInfo[3].date);
				ml.jLabel30.setText(getMailListResp.mailInfo[4].from);
				ml.jLabel31.setText(getMailListResp.mailInfo[4].subject);		
				ml.jLabel32.setText(getMailListResp.mailInfo[4].date);
				ml.jLabel33.setText(getMailListResp.mailInfo[5].from);
				ml.jLabel34.setText(getMailListResp.mailInfo[5].subject);		
				ml.jLabel35.setText(getMailListResp.mailInfo[5].date);	
				ml.jLabel36.setText(getMailListResp.mailInfo[6].from);
				ml.jLabel37.setText(getMailListResp.mailInfo[6].subject);		
				ml.jLabel38.setText(getMailListResp.mailInfo[6].date);	
				ml.jLabel39.setText(getMailListResp.mailInfo[7].from);
				ml.jLabel40.setText(getMailListResp.mailInfo[7].subject);		
				ml.jLabel41.setText(getMailListResp.mailInfo[7].date);	
				ml.jLabel42.setText(getMailListResp.mailInfo[8].from);
				ml.jLabel43.setText(getMailListResp.mailInfo[8].subject);		
				ml.jLabel44.setText(getMailListResp.mailInfo[8].date);	
				ml.jLabel45.setText(getMailListResp.mailInfo[9].from);
				ml.jLabel46.setText(getMailListResp.mailInfo[9].subject);		
				ml.jLabel47.setText(getMailListResp.mailInfo[9].date);	
				ml.jLabel48.setText(getMailListResp.mailInfo[10].from);
				ml.jLabel49.setText(getMailListResp.mailInfo[10].subject);		
				ml.jLabel50.setText(getMailListResp.mailInfo[10].date);	
				ml.jLabel51.setText(getMailListResp.mailInfo[11].from);
				ml.jLabel52.setText(getMailListResp.mailInfo[11].subject);		
				ml.jLabel53.setText(getMailListResp.mailInfo[11].date);	
				ml.jLabel54.setText(getMailListResp.mailInfo[12].from);
				ml.jLabel55.setText(getMailListResp.mailInfo[12].subject);		
				ml.jLabel56.setText(getMailListResp.mailInfo[12].date);		
                                ml.jLabel57.setText(getMailListResp.mailInfo[13].from);
				ml.jLabel58.setText(getMailListResp.mailInfo[13].subject);		
				ml.jLabel59.setText(getMailListResp.mailInfo[13].date);	
				ml.jLabel60.setText(getMailListResp.mailInfo[14].from);
				ml.jLabel61.setText(getMailListResp.mailInfo[14].subject);		
				ml.jLabel62.setText(getMailListResp.mailInfo[14].date);
				ml.jLabel63.setText(getMailListResp.mailInfo[15].from);
				ml.jLabel64.setText(getMailListResp.mailInfo[15].subject);		
				ml.jLabel65.setText(getMailListResp.mailInfo[15].date);
				ml.jLabel66.setText(getMailListResp.mailInfo[16].from);
				ml.jLabel67.setText(getMailListResp.mailInfo[16].subject);		
				ml.jLabel68.setText(getMailListResp.mailInfo[16].date);
				ml.jLabel69.setText(getMailListResp.mailInfo[17].from);
				ml.jLabel70.setText(getMailListResp.mailInfo[17].subject);		
				ml.jLabel71.setText(getMailListResp.mailInfo[17].date);
				ml.jLabel72.setText(getMailListResp.mailInfo[18].from);
				ml.jLabel73.setText(getMailListResp.mailInfo[18].subject);		
				ml.jLabel74.setText(getMailListResp.mailInfo[18].date);	
				ml.jLabel75.setText(getMailListResp.mailInfo[19].from);
				ml.jLabel76.setText(getMailListResp.mailInfo[19].subject);		
				ml.jLabel77.setText(getMailListResp.mailInfo[19].date);	
				ml.userid.setText(s1);
			}
 
    }
    //repaint();  // ask the system to paint the screen.

		  } // end of action performed()........

	} // end of Login







class MailList extends JFrame
{

	
	 MailList()
	{
	 initComponents();
	}





 private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();

	
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(841, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Sender");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Subject");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Date");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jLabel2)
                .addComponent(jLabel3))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(74, 74, 74)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jLabel19.setText("UserID");

        userid.setText("jLabel20");

        jButton1.setText("Logout");
jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel21.setText("jLabel16");

        jLabel22.setText("jLabel17");

        jLabel23.setText("jLabel18");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(74, 74, 74)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel24.setText("jLabel16");

        jLabel25.setText("jLabel17");

        jLabel26.setText("jLabel18");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(74, 74, 74)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel27.setText("jLabel16");

        jLabel28.setText("jLabel17");

        jLabel29.setText("jLabel18");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(74, 74, 74)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel36.setText("jLabel16");

        jLabel37.setText("jLabel17");

        jLabel38.setText("jLabel18");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(74, 74, 74)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel30.setText("jLabel16");

        jLabel31.setText("jLabel17");

        jLabel32.setText("jLabel18");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(74, 74, 74)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel39.setText("jLabel16");

        jLabel40.setText("jLabel17");

        jLabel41.setText("jLabel18");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(74, 74, 74)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel33.setText("jLabel16");

        jLabel34.setText("jLabel17");

        jLabel35.setText("jLabel18");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(74, 74, 74)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel42.setText("jLabel16");

        jLabel43.setText("jLabel17");

        jLabel44.setText("jLabel18");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addGap(74, 74, 74)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel45.setText("jLabel16");

        jLabel46.setText("jLabel17");

        jLabel47.setText("jLabel18");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addGap(74, 74, 74)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel48.setText("jLabel16");

        jLabel49.setText("jLabel17");

        jLabel50.setText("jLabel18");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addGap(74, 74, 74)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel51.setText("jLabel16");

        jLabel52.setText("jLabel17");

        jLabel53.setText("jLabel18");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addGap(74, 74, 74)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel18.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel54.setText("jLabel16");

        jLabel55.setText("jLabel17");

        jLabel56.setText("jLabel18");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addGap(74, 74, 74)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel57.setText("jLabel16");

        jLabel58.setText("jLabel17");

        jLabel59.setText("jLabel18");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addGap(74, 74, 74)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel20.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel60.setText("jLabel16");

        jLabel61.setText("jLabel17");

        jLabel62.setText("jLabel18");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addGap(74, 74, 74)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel21.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel63.setText("jLabel16");

        jLabel64.setText("jLabel17");

        jLabel65.setText("jLabel18");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addGap(74, 74, 74)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel22.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel66.setText("jLabel16");

        jLabel67.setText("jLabel17");

        jLabel68.setText("jLabel18");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addGap(74, 74, 74)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67)
                    .addComponent(jLabel68))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel23.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel69.setText("jLabel16");

        jLabel70.setText("jLabel17");

        jLabel71.setText("jLabel18");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addGap(74, 74, 74)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel24.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel72.setText("jLabel16");

        jLabel73.setText("jLabel17");

        jLabel74.setText("jLabel18");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addGap(74, 74, 74)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel73)
                    .addComponent(jLabel74))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel25.setPreferredSize(new java.awt.Dimension(86, 22));

        jLabel75.setText("jLabel16");

        jLabel76.setText("jLabel17");

        jLabel77.setText("jLabel18");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75)
                .addGap(74, 74, 74)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel76)
                    .addComponent(jLabel77))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(userid))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );



 jPanel2.setBackground(Color.LIGHT_GRAY ); 
 jPanel6.setBackground(Color.LIGHT_GRAY ); 
jPanel7.setBackground(Color.LIGHT_GRAY ); 
jPanel8.setBackground(Color.LIGHT_GRAY ); 
jPanel9.setBackground(Color.LIGHT_GRAY ); 
jPanel10.setBackground(Color.LIGHT_GRAY ); 
jPanel11.setBackground(Color.LIGHT_GRAY ); 
jPanel13.setBackground(Color.LIGHT_GRAY ); 
jPanel14.setBackground(Color.LIGHT_GRAY ); 
jPanel15.setBackground(Color.LIGHT_GRAY ); 
jPanel16.setBackground(Color.LIGHT_GRAY ); 
jPanel17.setBackground(Color.LIGHT_GRAY ); 
jPanel18.setBackground(Color.LIGHT_GRAY ); 
jPanel19.setBackground(Color.LIGHT_GRAY ); 
jPanel20.setBackground(Color.LIGHT_GRAY ); 
jPanel21.setBackground(Color.LIGHT_GRAY ); 
jPanel22.setBackground(Color.LIGHT_GRAY ); 
jPanel23.setBackground(Color.LIGHT_GRAY );
jPanel24.setBackground(Color.LIGHT_GRAY ); 
jPanel25.setBackground(Color.LIGHT_GRAY );  


 jPanel2.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
       //         System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
        //        System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
         //       System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel2.setBackground(Color.LIGHT_GRAY ); 		
		

            }
            @Override
            public void mouseEntered(MouseEvent e) {
            //    System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel2.setBackground(Color.gray );       
	    	
                //jPanel2.repaint();
	     }
            @Override
            public void mouseClicked(MouseEvent e) {
  			
			String s11 = getMailListResp.mailInfo[0].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}

 			
         //       System.out.println(":MOUSE_CLICK_EVENT:");
            }
        });

jPanel6.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
          //      System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
          //      System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
        //        System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel6.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
        //        System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel6.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
         //       System.out.println(":MOUSE_CLICK_EVENT:");
			String s11 = getMailListResp.mailInfo[1].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });

jPanel7.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
          //      System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
          //      System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
         //       System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel7.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
          //      System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel7.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
         //       System.out.println(":MOUSE_CLICK_EVENT:");

  			
			String s11 = getMailListResp.mailInfo[2].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}




            }
        });

jPanel8.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
          //      System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
         //       System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
          //      System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel8.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
        //        System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel8.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
        //        System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[3].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}



            }
        });
jPanel9.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
         //       System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
        //        System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
        //        System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel9.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
       //         System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel9.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
       //         System.out.println(":MOUSE_CLICK_EVENT:");

  			
			String s11 = getMailListResp.mailInfo[4].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });

jPanel10.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
         //       System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
        //        System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
         //       System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel10.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
          //      System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel10.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
          //      System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[5].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });

jPanel11.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
         //       System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
        //        System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
        //        System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel11.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
          //      System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel11.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
         //       System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[6].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel13.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
          //      System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
          //      System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
           //     System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel13.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
           //     System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel13.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
          //      System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[7].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });

jPanel14.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
           //     System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
            //    System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
            //    System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel14.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
           //     System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel14.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            //    System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[8].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });

jPanel15.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
           //     System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
           //     System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
           //     System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel15.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
           //     System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel15.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
           //     System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[9].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel16.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
           //     System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
           //     System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
            //    System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel16.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
           //     System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel16.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
             //   System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[10].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });

jPanel17.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            //    System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
           //     System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
             //   System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel17.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
             //   System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel17.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            //    System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[11].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel18.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
              //  System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
              //  System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
              //  System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel18.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
              //  System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel18.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               // System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[12].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel19.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
              //  System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
               // System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
              //  System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel19.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
             //   System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel19.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
              //  System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[13].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });

jPanel20.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
             //   System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
              //  System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
              //  System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel20.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
             //   System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel20.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
             //   System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[14].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel21.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
              //  System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
             //   System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
               // System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel21.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
               // System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel21.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
              //  System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[15].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel22.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
              //  System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
               // System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
              //  System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel22.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
               // System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel22.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               // System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[16].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel23.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
              //  System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
               // System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
              //  System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel23.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
               // System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel23.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
              //  System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[17].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel24.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
             //   System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
             //   System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
              //  System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel24.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
              //  System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel24.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
              //  System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[18].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });


jPanel25.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
              //  System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
               // System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
              //  System.out.println(":MOUSE_EXITED_EVENT:");
		jPanel25.setBackground(Color.LIGHT_GRAY ); 
            }
            @Override
            public void mouseEntered(MouseEvent e) {
               // System.out.println(":MOUSE_ENTER_EVENT:");
		jPanel25.setBackground(Color.gray );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
               // System.out.println(":MOUSE_CLICK_EVENT:");
  			
			String s11 = getMailListResp.mailInfo[19].mailId;
			System.out.println(s11);


			

			 try{

			      retGetMail=c1.getMail(s11);
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}


			System.out.println("---------"+retGetMail+"----------------");
			if(retGetMail==0)
			{
			//this.dispose();
			DetailMail dml = new DetailMail() ; 
			 detailMailResp = c1.retDetailMailResp();
			 dml.userid.setText(userId);
				dml.jLabel7.setText(detailMailResp.from);			 
				dml.jLabel8.setText(detailMailResp.subject);
				dml.jLabel6.setText(detailMailResp.date);
				dml.jLabel9.setText(detailMailResp.cc);
				dml.jLabel10.setText(detailMailResp.priority);
				dml.jTextArea1.setText(detailMailResp.mailBody);


				retGetMail=15;
			dml.setVisible(true);
			}


            }
        });



        pack();
    }// </editor-fold>                        


 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:

			GUI g1  = new GUI();
			 this.dispose();

 try{

			c1.logout();
			      }
			    catch(UnknownHostException uhe)
				{
				System.out.println("error :::"+uhe);
				}
			catch(IOException ioe)
				{
				System.out.println("error :::"+ioe);
				}
			catch( ClassNotFoundException cnfe)
				{
				System.out.println("error :::"+cnfe);
				}

			g1.run();
			
		//	l2.setVisible(true);

    }   


 // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel userid;
    // End of variables declaration  





} // Maillist class ends here ------------------------------------------------------------------------------





class DetailMail extends javax.swing.JFrame
{  


   //MailList ml= new MailList();
    public DetailMail() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel19.setText("Date");

        userid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel1.setText("cc");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel2.setText("From");

        jLabel3.setText("userID");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel4.setText("Subject");

        jLabel20.setText("Priority");

        jLabel5.setText("MailBody");

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 484, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();


	jButton2.setVisible(false);
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
		
    }                                        

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel userid;
    // End of variables declaration       
 


}

} // end of GUI


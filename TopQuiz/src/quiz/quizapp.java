/*OOAD assignment 3 
 * A Swing-based interactive quiz
 * The target group may be first to 5th graders
 * 
 * This is the quizapp class which creates a quiz app 
 */
package quiz;

import java.util.*;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.SwingConstants;
import java.awt.Color;

public class quizapp extends javax.swing.JFrame {

/* variable devlarations */
	
	String[][] questions;
	String[][] answers;
	int points;
	int q=0;
	int count;
	int count1=1;
	static String s;
/* Jlabel components */
	private static final long serialVersionUID = 1L;
	private javax.swing.JRadioButton button1;
	private javax.swing.JRadioButton button2;
	private javax.swing.JRadioButton button3;
	private javax.swing.JButton buttonnext;
	private javax.swing.ButtonGroup buttongroup;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JRadioButtonMenuItem RadioButton1;
	private javax.swing.JRadioButtonMenuItem RadioButton2;
	private javax.swing.JSeparator jSeparator1;
	

/*
 * Design of various components of the Quiz UI
 * 
 */
    @SuppressWarnings("resource")
    
// Content pane
	public quizapp() throws FileNotFoundException {
    	getContentPane().setBackground(Color.GRAY);
    	getContentPane().setForeground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        initComponents();
        points=0;
        count=0;
        questions=new String[10][5];
        answers=new String[10][2];
        int l=0;      
        Scanner read;
        ArrayList<String> qList;					
/*
 * A file is being read and the parsed into question , list of options and correct answers
 * 	
 */
        try {
        		read = new Scanner(new File("Questionfile.txt"));
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        read = new Scanner(new File("Questionfile.txt"));
		qList = new ArrayList<String>();
		while (read.hasNext()) {
			qList.add(read.nextLine());

			Random randomNo = new Random();
			int randomIndex = randomNo.nextInt(qList.size());
			String randomLine = qList.get(randomIndex);

			String[] questionString = randomLine.split(":");
             		
				int count = 0;
					 for (int j=0;j<4;j++){
						 if(count==questionString.length) break;
						 questions[l][j]=questionString[count];
						 
						 count++;
						 System.out.println(questions[l][j]);
					 }
					
					 answers[l][0]=questions[l][0];
					 answers[l][1]=questions[l][3];			
					 System.out.println(answers[l][1]);
					 l++;
				}
		start(0);
    }

  /*
   * Creation of various buttons such as Radio button, next and exit button
   * The required action listeners are added to the buttons
   * 
   */
   private void initComponents() {

        RadioButton1 = new javax.swing.JRadioButtonMenuItem();
        RadioButton2 = new javax.swing.JRadioButtonMenuItem();

        RadioButton1.setSelected(true);
        RadioButton1.setText("RadioButton1");

        RadioButton2.setSelected(true);
        RadioButton2.setText("RadioButton2");
        new javax.swing.JColorChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonnext = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        buttongroup = new javax.swing.ButtonGroup();
        button1 = new javax.swing.JRadioButton();
        button2 = new javax.swing.JRadioButton();
        button3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttongroup.add(button1);
        button1.setText("option1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        buttongroup.add(button2);
        button2.setText("jRadioButton2");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        buttongroup.add(button3);
        button3.setText("jRadioButton3");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 18)); 
        jLabel2.setText("");

        buttonnext.setText("Next Question");
        buttonnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonnextActionPerformed(evt);
            }
        });

        jButton1.setText("Exit Quiz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
/* Jlabel design
 * Adding buttons to the respective content panes
 * 
 * */
        
        JLabel lblQuiz = new JLabel("Quiz");
        lblQuiz.setForeground(new Color(255, 0, 0));
        lblQuiz.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuiz.setFont(new Font("Tahoma", Font.BOLD, 37));
        
        JLabel label = new JLabel("");
        label.setIcon(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        layout.createParallelGroup(Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addGap(21)
        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        .addPreferredGap(ComponentPlacement.RELATED)
        .addComponent(jLabel2)
        .addGap(142))
        .addGroup(layout.createSequentialGroup()
        .addGap(465)
        .addComponent(buttonnext, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        .addGap(64)
        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        .addGap(122))
        .addGroup(layout.createSequentialGroup()
        .addGap(312)
        .addComponent(lblQuiz, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(537, Short.MAX_VALUE))    		
        .addGroup(layout.createSequentialGroup()
        .addGap(56)
        .addGroup(layout.createParallelGroup(Alignment.LEADING)
        .addComponent(button2)
        .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(Alignment.LEADING)
        .addComponent(button3)
        .addComponent(button1))
        .addGap(752)
        .addComponent(label, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        .addGap(55)
        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        );
        
        layout.setVerticalGroup(
        layout.createParallelGroup(Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lblQuiz)
        .addGap(28)
        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createSequentialGroup()
        .addGap(64)
        .addComponent(jLabel2)))
        .addGap(18)
        .addGroup(layout.createParallelGroup(Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(Alignment.TRAILING)
        .addGroup(layout.createSequentialGroup()
        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
        .addGap(3))
        .addGroup(layout.createSequentialGroup()
        .addComponent(button1)
        .addGap(18)))
        .addComponent(button3)
        .addGap(18)
        .addComponent(button2))
        .addComponent(label, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
        .addComponent(jButton1)
        .addComponent(buttonnext))
        .addContainerGap())
        );
        
        getContentPane().setLayout(layout);
        pack();
    }                       
    
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {                                   
      
    }                                  

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        
    }                                  

    String getSelectedButtonText(ButtonGroup buttonGroup) {
    for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
        AbstractButton button = (AbstractButton) buttons.nextElement();

        if (button.isSelected()) {
            return button.getText();
        }
    }

    return null;
}
    
   /*
    * This part checks if the questions are answered correctly , if yes the user is given 10 points for each question
    * and total number of questions attempted is returned
    * 
    */
    private void buttonnextActionPerformed(java.awt.event.ActionEvent evt) {                                      
     
	if(count1<100)
     {         
        if(getSelectedButtonText(buttongroup)==answers[q][1])
        {points=points+10;
        
        }else{
            count1++;
        }
         q++;
         start(q);
         jLabel2.setText("Points (out of 100):"+points);
        System.out.println(points+" and " + count1);
     
     }
    }                                     

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
System.exit(0);
       
    }    
    
    /*
     * Assigning the text to the corresponding buttons
     * 
     */
    public void start(int i){
        
            jLabel1.setText(questions[i][0]);
            button1.setText(questions[i][1]);
            button2.setText(questions[i][2]);
            button3.setText(questions[i][3]);
       
    }

    public void quizstart() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(quizapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new quizapp().setVisible(true);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
            }
        });
    }
}

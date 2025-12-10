import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame{
String value="hello";
  String passwordin;
  JPanel employeeInterface;
  JButton submit;
    JPanel loginPanel;
   JButton loginbutton;
   JLabel error;
    JPanel firstPanel;
     JPanel emailPanel;
     JPanel passwordPanel;
 JTextField password;
     JTextField email;
   JLabel emailabel;
     JLabel passwordlabel;
     //logedin stuff
    JLabel loggedin;
    //objects
    Container container=getContentPane();
    Employee_Login log=new Employee_Login();
    DataBaseConnector conn=new DataBaseConnector();
    //constructor
    public LoginGUI(){
        super("Employee Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginPanel=new JPanel();
        loginPanel.setBackground(Color.CYAN);
        container.add(loginPanel);
 loginbutton=new JButton("Login");


        setSize(800,800);
        container.setBackground(Color.YELLOW);//this must be edited
        loginbutton.setBackground(Color.GREEN);
        loginPanel.setLayout(null);
        loginbutton.setBounds(300,300,100,100);
        loginPanel.add(loginbutton);


        loginbutton.addActionListener(new actiontaken());
setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public String repeater(String value){
return value;
    }
    class actiontaken implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==loginbutton){

loginPanel.setVisible(false);

//while(!(value.length()==0))
firstPanel=new JPanel();
firstPanel.setLayout(null);
firstPanel.setBackground(new Color(153,255,51));
firstPanel.setBorder(new TitledBorder("Log in"));
container.add(firstPanel,BorderLayout.CENTER);
container.revalidate();
container.repaint();

                setDefaultCloseOperation(EXIT_ON_CLOSE);

emailabel=new JLabel("Email Address:");
passwordlabel=new JLabel("Password:");
emailabel.setBackground(Color.ORANGE);//this will not paint the label because labels can't be painted
email=new JTextField();
password=new JTextField();
submit=new JButton("GO");
submit.setBackground(Color.BLUE);
firstPanel.add(submit);
firstPanel.add(email);
firstPanel.add(password);
email.setBounds(100,50,300,40);
password.setBounds(100,100,300,40);
submit.setBounds(400,400,300,100);



firstPanel.add(passwordlabel);
passwordlabel.setBounds(0,100,100,40);
emailabel.setBounds(0,50,100,40);
firstPanel.add(emailabel);
email.addActionListener(new SecondAction());
password.addActionListener(new SecondAction());
submit.addActionListener(new SecondAction());
firstPanel.setVisible(true);


//constrainb.fill=GridBagConstraints.HORIZONTAL;
//constrainb.weightx=1.0;
//constrainb.gridx=1;
//constrainb.gridy=0;

//email=new JTextField();//email in


//constrainb.gridx=0;
///constrainb.gridy=1;
//constrainb.anchor=GridBagConstraints.EAST;//put the label to the left
/*constrainb.weightx=0;
constrainb.weighty=0;
constrainb.fill=GridBagConstraints.NONE;// extend horizontally

constrainb.gridx=1;//set the column and rows
constrainb.gridy=1;
constrainb.weightx=1.0;// identify whether the label or textfield will expand to its maximum possible
constrainb.fill=GridBagConstraints.HORIZONTAL;*/

//firstPanel.add(email);



//Employee_Login Login=new Employee_Login();
/*Login.login(email.getText().toString(),password.getText().toString());
if (value.equals("invalid email address! Enter a valid email address: ")){
    error=new JLabel(value);
   /* constrainb.gridy=3;
    constrainb.fill=GridBagConstraints.HORIZONTAL;
    constrainb.weighty=0.0;
    constrainb.weightx=1.0;
    firstPanel.add(error);
}*/

// to call the employee login class

//loginPanel.hide();
               /* email=new JTextField(7);
                email.setText("hello");
                container.add(loginPanel);
                loginPanel.setLayout(new GridLayout(1,1,0,0));
                loginPanel.add(email);*/
               /* email=new JTextField("Email");

                password=new JTextField("password");
                 loginPanel=new JPanel();
                 loginPanel.setLayout(new GridLayout(2,1,0,0));
                container.add(loginPanel);
                loginPanel.add(email);
                loginPanel.add(password);
                container.add(email);*/
            }
        }

    }
    public void EmployeeInterface(){
        firstPanel.setVisible(false);
        employeeInterface=new JPanel();
        loggedin=new JLabel("hello Frans");
        employeeInterface.setBackground(Color.YELLOW);
        employeeInterface.setLayout(null);
        employeeInterface.setLocation(300,300);
        container.add(employeeInterface);
        container.revalidate();
        container.repaint();
        employeeInterface.setVisible(true);

    }class SecondAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            if (ev.getSource()==submit){
                passwordin=password.getText().toString();
                String checkemail=email.getText().toString();
                String value=log.login(checkemail,passwordin);
               // String value=conn.getLoginvalue();// i am not receving any value
                System.out.println(value);
                if(value.equals("Access Granted")){
                    EmployeeInterface();
                }
                else{
                    error=new JLabel(value);
                    firstPanel.add(error);
                    error.setBounds(100,100,300,100);
                    firstPanel.setVisible(true);
                }

            }else{

            }}
    }
   // public static void ErrorShow(){

 //   }
public static void main(String [] args){
        new LoginGUI();
}
}

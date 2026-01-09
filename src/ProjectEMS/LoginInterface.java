package ProjectEMS;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface extends  JFrame implements EmployeeMInterface{
    private CardLayout cardLayout;
    private JPanel cardPanel;
   private JPanel loginPanel;
   private JButton loginbutton;
   private JButton register;
   private JPanel firstPanel;
   private JMenuBar employeeAdminBar;
    private String g;private String ms;
    private String Etype;
    private String contry;
    private String martlST;
    JMenuItem Back;
    JButton submit;
    JTextField password;
    JTextField email;
    JLabel emailabel;
    JLabel passwordlabel;
    JLabel error;


    //objects
    private EmployeeBasicDetails bd=new EmployeeBasicDetails();
   private DataBaseConnector conn=new DataBaseConnector();
   private Employee_Login log=new Employee_Login();
   Container container=getContentPane();

    public LoginInterface(){
        super("Employee Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cardLayout= new CardLayout();
        conn.dtcConnectmethod(bd,"Check Registration");
        String registrationCheck=conn.getRegistrationStatus();
        cardPanel=new JPanel(cardLayout);

        Image image=new ImageIcon("C:\\Users\\admin\\Downloads\\company-building-min.jpg").getImage();
        loginPanel=new JPanel(new BorderLayout()){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponents(g);
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        loginbutton=new JButton("Login");

        if (conn.getResult().equals("Open") && checkMaxApplications(conn.getResult())==true){
            register=new JButton("Register");

            loginPanel.add(register);
            // loginPanel.add(register);
            register.setBackground(new Color(160,160,160));
            register.setBounds(200,500,300,100);
            register.addActionListener(e -> registr());


        }




        setSize(800,800);
        //container.setBackground(Color.YELLOW);//this must be edited
        //loginPanel.setLayout(new BorderLayout());

        JPanel logNorth=new JPanel();
        JPanel butP=new JPanel();

        logNorth.setBackground(Color.orange);
//loginPanel.setLayout(new BorderLayout());
        butP.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(0,20,0,20);

        loginbutton.setPreferredSize((new Dimension(150,100)));
        register.setPreferredSize(new Dimension(150,100));

        butP.add(loginbutton,gbc); butP.add(register,gbc);
        butP.setOpaque(false);
        loginPanel.add(logNorth,BorderLayout.NORTH);
        loginPanel.add(butP,BorderLayout.CENTER);
        loginbutton.setBackground(Color.GREEN);
        // loginPanel.add(loginbutton);

        cardPanel.add(loginPanel,"loginView");

        container.add(cardPanel);
        loginbutton.addActionListener(new actiontaken());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public String repeater(String value){
        return value;
    }
    class actiontaken implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==loginbutton){
                firstPanel=new JPanel();

                //loginPanel.setVisible(false);
                cardPanel.add(firstPanel,"firstPanel");
                cardLayout.show(cardPanel,"firstPanel");

//while(!(value.length()==0))

                firstPanel.setLayout(null);

                firstPanel.setBackground(new Color(153,255,51));
                firstPanel.setBorder(new TitledBorder("Log in"));

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

            }
        }

    }
    private void registr(){
        String titles[]=new String[0];

        JPanel RegistrationInterface=new JPanel();
        cardPanel.add(RegistrationInterface,"RegistrationInterface");
        cardLayout.show(cardPanel,"RegistrationInterface");
        RegistrationInterface.setBackground(Color.ORANGE);
        employeeAdminBar =new JMenuBar();

        JTextField fName=new JTextField();JLabel Fname=new JLabel("First Name");

        JTextField mName=new JTextField();JLabel Mname=new JLabel("Middle Name");

        JTextField lName=new JTextField();JLabel Lname=new JLabel("Last Name");


        JTextField email=new JTextField();JLabel Emal=new JLabel("Email Address");
        JTextField password=new JTextField();JLabel passw=new JLabel("Password");
        JTextField confpassw=new JTextField();JLabel confPass=new JLabel("Confirm Password");
        JTextField bDay=new JTextField();JLabel Bday=new JLabel("Birth Date");
        JTextField bMonth=new JTextField();JLabel Bmonth=new JLabel("Birth Month");
        JTextField bYear=new JTextField();JLabel Byear=new JLabel("Birth Year");
        JTextField phoneNumber=new JTextField();JLabel Phoneno=new JLabel("Phone Number");

        String[] maritals={"Single(never married)","Married","Divorced","Separated"};
        JComboBox maritalStatus=new JComboBox(maritals);JLabel Maritalst=new JLabel("Marital Status");
        String[] countries={"Ethiopia","Kenya","Sudan","USA","Uk","China"};
        JComboBox AddressCountry=new JComboBox(countries);JLabel country=new JLabel("Country");

        JTextField City=new JTextField();JLabel city=new JLabel("City");
        JTextField kebele=new JTextField();JLabel Keble=new JLabel("Kebele");
        conn.dtcConnectmethod(bd,"getAdminTitles");
        titles=conn.getEtitles();
        JComboBox employeetype=new JComboBox(titles);JLabel type=new JLabel("What are you applying for?");
        JTextField Skills=new JTextField();JLabel skill=new JLabel("Skills");
        JTextField postal_code=new JTextField();JLabel postal=new JLabel("Postal Code");
        String[] gend={"M","F"};JLabel gen=new JLabel("Gender");
        JComboBox Gender=new JComboBox(gend);
        JTextField Qualifications=new JTextField();JLabel qualification=new JLabel("Qualifications");
        RegistrationInterface.setLayout(new GridLayout(14,2));
        JPanel spac=new JPanel();


        RegistrationInterface.add(Fname);RegistrationInterface.add(fName);
        RegistrationInterface.add(Mname);RegistrationInterface.add(mName); RegistrationInterface.add(Lname);
        RegistrationInterface.add(lName); RegistrationInterface.add(Emal);RegistrationInterface.add(email);
        RegistrationInterface.add(Bday);RegistrationInterface.add(bDay);RegistrationInterface.add(Bmonth);
        RegistrationInterface.add(bMonth);RegistrationInterface.add(Byear);
        RegistrationInterface.add(bYear);  RegistrationInterface.add(Phoneno);RegistrationInterface.add(phoneNumber);RegistrationInterface.add(Maritalst);
        RegistrationInterface.add(maritalStatus);     RegistrationInterface.add(country);RegistrationInterface.add(AddressCountry);
        RegistrationInterface.add(city); RegistrationInterface.add(City);RegistrationInterface.add(Keble);RegistrationInterface.add(kebele);
        RegistrationInterface.add(type); RegistrationInterface.add(employeetype);RegistrationInterface.add(spac);
        JButton nextPage=new JButton("Next Page");
        RegistrationInterface.add(nextPage);
        nextPage.setBackground(Color.ORANGE);
        nextPage.setBackground(Color.green);
        // RegistrationInterface.add(spac);
        Gender.addActionListener((e)->{
            Object a=e.getSource();
            g=((JComboBox)a).getSelectedItem().toString();

        });
        maritalStatus.addActionListener((e -> {
            Object a=e.getSource();
            ms=((JComboBox)a).getSelectedItem().toString();
        }));
        employeetype.addActionListener((e)->{
            Object a=e.getSource();
            Etype=((JComboBox)a).getSelectedItem().toString();
        });
        AddressCountry.addActionListener((e -> {
            Object a=e.getSource();
            contry=((JComboBox)a).getSelectedItem().toString();
        }));
        maritalStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object a=e.getSource();
                String n=((JComboBox)a).getSelectedItem().toString();
                martlST=n;
            }
        });





        nextPage.addActionListener((eve)->{
            JMenuBar regBar=new JMenuBar();
            JPanel r2=new JPanel();
            r2.setLayout(new GridLayout(12,1,10,10));
            cardPanel.add(r2,"r2");
            cardLayout.show(cardPanel,"r2");
            JButton subit=new JButton("Submit");
            Back=new JMenuItem("Back");
            Back.setBackground(Color.cyan);
            r2.add(skill); r2.add(Skills);
            r2.add(postal); r2.add(postal_code);r2.add(gen);r2.add(Gender); r2.add(qualification);r2.add(Qualifications);r2.add(passw);
            r2.add(password); r2.add(confPass);r2.add(confpassw);
            r2.setBackground(Color.ORANGE);

            //r2.add(adminMenuBar);
            setJMenuBar(regBar);
            regBar.add(Back);
            Back.addActionListener((e)->{employeeAdminBar.remove(Back);
                cardLayout.show(cardPanel,"RegistrationInterface");});



            r2.add(subit);
            subit.setBackground(Color.green);
            subit.addActionListener((e)->{
                String re1=checkName(fName.getText().toString());
                String re3=checkName(lName.getText().toString());
                String re2=checkName(mName.getText().toString());
                String[] nameresults={re1,re2,re3};
                boolean checkerror=true;
                for(int i=0;i<3;i++){
                    if(nameresults[i].equals("Invalid Name Entry")){
                        if (i==0){Fname.setText(nameresults[i]);}
                        if(i==1){Mname.setText("Invalid Name Entry");}
                        if(i==2){Lname.setText("Invalid Name Entry");}
                        checkerror=false;break;}}
                String checmail=checkEmail(email.getText().toString());
                if(checmail.equals("Invalid Email Address!")){
                    Emal.setText("Invalid Email Address!");
                    checkerror=false;}
                String checkBDate=checkBDay(bDay.getText().toString());
                if(checkBDate.equals("invalid Birth Date Entry")){
                    Bday.setText("invalid Birth Date Entry");
                    checkerror=false;
                }
                String checkBMonth=chckmonth(bMonth.getText().toString());
                if(checkBMonth.equals("invalid Birth Date Entry")){
                    Bmonth.setText("invalid Birth Date Entry");
                    checkerror=false;
                }
                String chckBYear=checkBYear(bYear.getText().toString());
                if(chckBYear.equals("invalid Birth Date Entry")){
                    Byear.setText("invalid Birth Date Entry");
                    checkerror=false;
                }
                String phoneno=checkPhone(phoneNumber.getText().toString());
                if(phoneno.equals("invalid phone number")){
                    Phoneno.setText("invalid phone number");
                    checkerror=false;
                }
                String checkCity=chckCity(City.getText().toString());
                if(checkCity.equals("invalid name for city")){
                    city.setText("invalid name for city");
                    checkerror=false;
                }
                String checkkeb=chckCity(kebele.getText().toString());
                if(checkCity.equals("invalid name for city")){
                    Keble.setText("invalid name for Kebele");
                    checkerror=false;
                }
                String checkPost=chckPostalCode(postal_code.getText().toString());
                if (checkPost.equals("invalid postal code")){
                    postal.setText("invalid postal code");
                    checkerror=false;
                }
                String checkpass=chckPassword(password.getText().toString(),confpassw.getText().toString());
                if (checkpass.equals("passwords don't match")){
                    passw.setText("passwords don't match");
                    checkerror=false;
                }
                if(checkpass.equals("password cannot be null")){
                    passw.setText("password cannot be null");
                    checkerror=false;
                }

                if(checkerror==true){
                    boolean check2=true;
                    conn.dtcConnectmethod(bd,"retrieve employee data for deleting");
                    conn.dtcConnectmethod(bd,"retrieve applicant data");
                    String[] ckEmpEmail=conn.getEmployeeEml();
                    for (int i=0;i<ckEmpEmail.length;i++){
                        System.out.println(ckEmpEmail[i]);
                    }
                    String[] ckAppEmail=conn.getApplicantEmail();
                    System.out.println(ckEmpEmail.length);
                    for (int i=0;i<ckEmpEmail.length;i++){
                        if(ckEmpEmail[i].equals(email.getText().toString())){
                            JOptionPane.showMessageDialog(null,"You can not register with this email");
                            check2=false;
                            break;
                        }
                    }
                    for (int i=0;i<ckAppEmail.length;i++){
                        if(ckAppEmail[i].equals(email.getText().toString())){
                            JOptionPane.showMessageDialog(null,"You can not register with this email");
                            check2=false;
                            break;
                        }
                    }
                    if(check2==true){
                        PasswordHash hash=new PasswordHash();
                        String p=hash.encode(password.getText().toString());

                        conn.setAdmintrue(false);
                        EmployeeBasicDetails regi=new EmployeeBasicDetails( fName.getText().toString(), mName.getText().toString(), lName.getText().toString(),
                                Integer.parseInt(bDay.getText().toString()), Integer.parseInt(bMonth.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                                phoneNumber.getText().toString(), ms, contry,City.getText().toString(),kebele.getText().toString(),Etype, Skills.getText().toString(), Integer.parseInt(postal_code.getText().toString()),
                                g, Qualifications.getText().toString(), email.getText().toString(),p);
                        conn.dtcConnectmethod(regi,"add employee");
                        JOptionPane.showMessageDialog(null,conn.getResult());
                    }}




            });
        });


    }
    class actiontaken1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==loginbutton){
                firstPanel=new JPanel();
                //loginPanel.setVisible(false);
                cardPanel.add(firstPanel,"firstPanel");
                cardLayout.show(cardPanel,"firstPanel");


                firstPanel.setLayout(null);

                firstPanel.setBackground(new Color(153,255,51));
                firstPanel.setBorder(new TitledBorder("Log in"));

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

            }
        }

    } private class SecondAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ev){

            if (ev.getSource()==submit){
                System.out.println("in");
               String passwordin=password.getText().toString();
                String checkemail=email.getText().toString();
                String value=log.login(checkemail,passwordin);
                String identity=log.getAdminChecker();
                // String value=conn.getLoginvalue();// i am not receving any value
                System.out.println(value);
                System.out.println(identity.equals("Not admin"));
                if(value.equals("Access Granted")){
                    switch(identity){
                        case "Admin":
                            cardPanel.add(new AdminInterface(),"Admin");
                            cardLayout.show(cardPanel,"Admin");
                            break;
                        case "Manager":
                           cardPanel.add(new ManagerInterface(),"Manager");

                           cardLayout.show(cardPanel,"Manager");
                            break;
                        default:

                           cardPanel.add(new EmployeeGUI(),"Employee");
                           cardLayout.show(cardPanel,"Employee");
                            break;
                    }
                }

                else{
                    if((error)!=null){error.setText("");} ;
                    error=new JLabel(value);
                    firstPanel.add(error);
                    error.setBounds(100,100,300,100);
                    firstPanel.setVisible(true);
                }

            }}


    }
    public static void main(String [] args){
        new LoginInterface();
    }
}


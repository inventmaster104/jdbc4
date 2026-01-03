package ProjectEMS;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//
// go to line around 1080 and connect the data gathered with database
public class LoginGUI extends JFrame implements DatabasemethodsInterface, EmployeeMInterface {
private String[] taskArray;
    private String[] titls;
    private JPanel Set;
    private String[] settitles=new String[0];
    private JRadioButton addManager;
    private JRadioButton deleteManager;
    private JRadioButton setVacancy;// to add existing job titles
    private JRadioButton deleteVacancy;
    private JRadioButton addNewVacancy;
private String ms="";
    private String g="";
    private String [] titles=new String[0];
    private String Etype="";
    private String contry="";
    private String martlST="";
    private JMenuBar employeeAdminBar;
    private JMenuBar managerBar;
 private JMenuItem close;
    private JMenuItem reg;
   private String[] empName=new String[0];
   private String[] empEmail=new String[0];
    int[] indeces=new int[0];
    private JMenuItem reload;
    private JMenuItem Back;
    private JPanel cardPanel;
    private JPanel mPanel;
    private CardLayout cardLayout;
    private CardLayout empshow;
    private CardLayout mcardLayout;
private String[] inemail=new String[0];
    List <String> inputs= new ArrayList<>(0);
    private JComboBox datatype=new JComboBox();
    Dictionary <String,String> dict=new Hashtable<>();
    JLabel colDType;
    JLabel showResult;
    JLabel columnlen;
    private JTextField colLen;
    private JTextField colDataType;
    private JComboBox tables;
    private JRadioButton setRegistration;
    private JTextField newCol;
   private JLabel sTChoose;
    private JPanel Employee;
    private JPanel File;
    private JMenuItem logout;
    private JButton back;
private JTable employeeTable;
    private JMenu Settings;
    private JMenu Registration;
    private JMenu sendEmail;
    private JMenuBar adminMenuBar;
    private JRadioButton addColumn;
    private JRadioButton addTable;
    private JRadioButton viewEmployees;
    // employee menu variables
    private JRadioButton addemployee;
    private JRadioButton updateEmployee;
    private JRadioButton deleteEmployee;
    private JRadioButton deleteColumn;
    private JRadioButton save;
    private JRadioButton AcceptEmployee;
    // applicant menu variables
    private JRadioButton viewApplicants;
    private JButton register;
   // private JRadioButton acceptApplicant;


String value="hello";
  String passwordin;
  JPanel adminInterface;
  JPanel employeeInterface;
  JPanel managerInterface;
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
 Employee_Login log=new ProjectEMS.Employee_Login();
    DataBaseConnector conn=new DataBaseConnector();
    EmployeeBasicDetails bd=new EmployeeBasicDetails();
    //constructor
    public LoginGUI(){
        super("Employee Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container=getContentPane();

cardLayout= new CardLayout();
conn.dtcConnectmethod(bd,"Check Registration");

String registrationCheck=conn.getRegistrationStatus();
cardPanel=new JPanel(cardLayout);












        loginPanel=new JPanel();
        loginPanel.setBackground(Color.CYAN);
       // container.add(cardLayout);
        //container.add(loginPanel);
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

        logNorth.setBackground(Color.orange);
loginPanel.setLayout(null);
        //loginPanel=new JPanel();
        loginPanel.setBackground(Color.MAGENTA);
      //  loginPanel.add(logcen,BorderLayout.CENTER);
        loginPanel.add(logNorth);
        logNorth.setBounds(0,0,1800,50);
        loginbutton.setBackground(Color.GREEN);
     // logcen.setLayout(null);
        loginbutton.setBounds(200,300,300,100);
        loginPanel.add(loginbutton);

        cardPanel.add(loginPanel,"loginView");
       // cardPanel.add(firstPanel,"firstPanel");
        //  cardPanel.add(adminInterface,"adminInterface");
        container.add(cardPanel);
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
                firstPanel=new JPanel();
                //loginPanel.setVisible(false);
cardPanel.add(firstPanel,"firstPanel");
                cardLayout.show(cardPanel,"firstPanel");

//while(!(value.length()==0))

firstPanel.setLayout(null);
firstPanel.setBackground(new Color(153,255,51));
firstPanel.setBorder(new TitledBorder("Log in"));
//cardPanel.add(firstPanel,BorderLayout.CENTER);
//container.revalidate();
//container.repaint();

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



//ProjectEMS.Employee_Login Login=new ProjectEMS.Employee_Login();
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
public void managerInterface(){
        managerInterface=new JPanel();
    mcardLayout=new CardLayout();
        managerInterface.setLayout(new BorderLayout());
        managerBar=new JMenuBar();
        cardPanel.add(managerInterface,"managerInterface");
        cardLayout.show(cardPanel,"managerInterface");
        JButton roles=new JButton("Assign roles");
        JButton recommendations=new JButton("Give Recommendations");
        JButton viewOverallPerformance=new JButton("view Overall Performance");
        JButton home=new JButton("Home");
        // panels

    mPanel=new JPanel(mcardLayout);
    JPanel m1=new JPanel();// for the buttons
    JPanel m2=new JPanel();// for showing tables and notices
    JPanel m3=new JPanel();//for saying hello to the manager
    JPanel m4=new JPanel(); // to contain both m1 and m2
    mPanel.add(m2,"m2");
    mcardLayout.show(mPanel,"m2");
    JTextArea tm=new JTextArea();
    tm.setText("Today's News");
    tm.setFont(new Font("Times New Roman",Font.BOLD,20));
    //jmenu items
    setJMenuBar(managerBar);
    logout=new JMenuItem("Signout");
    managerBar.add(logout);
    logout.setBackground(Color.red);
    //panel components
    m1.setLayout(new FlowLayout());
    m1.setBackground(new Color(23,233,80));
    m1.add(home);
    m1.add(roles);
    m1.add(recommendations);
    m1.add(viewOverallPerformance);
    m4.setLayout(new BorderLayout());
    m4.add(m1,BorderLayout.NORTH);
    m4.add(m2,BorderLayout.CENTER);
   mcardLayout=new CardLayout();
    m2=new JPanel(mcardLayout);
    m2.setBackground(Color.gray);
    managerInterface.add(m4,BorderLayout.CENTER);
    managerInterface.add(m3,BorderLayout.EAST);
// actionlisteners
   logout.addActionListener((et)->{
       managerBar.removeAll();
       cardLayout.show(cardPanel,"firstPanel");
   });
   roles.addActionListener((es)->{
       conn.setTemp_in("View id, name and email");
       conn.dtcConnectmethod(bd,"retrieve employee data");
       String[] cols=conn.getEcolumnNames();
       String[] emails=conn.getEmployeeEml();
        empName=conn.getViewEmployeeName();
        String[] ids=conn.getIds();
        Object[][] edata=new Object[empName.length][3];
        for (int i=0;i<empName.length;i++){
            edata[i][0]=ids[i];
            edata[i][1]=empName[i];
            edata[i][2]=emails[i];
        }
        JTable showt=new JTable(edata,cols);
        JScrollPane p1=new JScrollPane(showt);
        p1.getViewport();
        p1.setBackground(Color.orange);
       ListSelectionModel model=showt.getSelectionModel();
       model.addListSelectionListener(new ListSelectionListener() {
           @Override
           public void valueChanged(ListSelectionEvent e) {
               if(!model.isSelectionEmpty()){
                   conn.setId(String.valueOf(model.getMinSelectionIndex()));
                  taskArray=new String[0];
                   JPanel tsk=new JPanel();
                   JPanel po=new JPanel();// contain the label and the text field
                   JPanel bcont=new JPanel();// contain the buttons
                   JPanel space=new JPanel();
                   mPanel.add(tsk,"tsk");
                   mcardLayout.show(mPanel,"tsk");
                   // buttons
                   JButton setTask=new JButton("Set Task");
                   JButton addtsk=new JButton("Add Task");
                   //label
                   JLabel l1=new JLabel("Task Name");
                   JLabel l2=new JLabel("Due date");
                   JLabel l3=new JLabel("Description");
                   // text fields
                   JTextField f1=new JTextField();
                   JTextField f2=new JTextField();// due date
                   JTextField f3=new JTextField();// description
                   // menu bars
                   Back=new JMenuItem("Back");
                   // structure
                   tsk.setLayout(new BorderLayout());
                   tsk.add(po,BorderLayout.WEST);
                   po.setLayout(new GridLayout(3,2,10,10));
                   po.add(l1);po.add(f1);
                   po.add(l2);po.add(f2);
                   po.add(l3);po.add(f3);
                   bcont.setLayout(new GridLayout(1,2,20,20));
                   bcont.add(addtsk); bcont.add(setTask);
                   tsk.add(bcont,BorderLayout.SOUTH);
                   // colors
                   addtsk.setBackground(Color.cyan);
                   setTask.setBackground(new Color(150,200,250));
                   // actionlisteners
                   addtsk.addActionListener((et)->{
                       if((f1.getText().toString())!=null && (f1.getText().toString()).length()!=0){
                           String temp[]=new String[taskArray.length+1];
                           for(int i=0;i<taskArray.length;i++){
                               temp[i]=taskArray[i];
                           }
                           temp[taskArray.length]=f1.getText().toString();
                           taskArray=temp;
                           f1.setText("");

                       }
                       else{
                           JOptionPane.showMessageDialog(null,"Invalid");
                       }


                   });
                   setTask.addActionListener((e2)->{
for (int i=0;i<taskArray.length;i++){
    conn.setTask(taskArray[i]);
    conn.dtcConnectmethod(bd,"add task");
}
                   });




               }
           }
       });
   });







}
    public void EmployeeInterface(){
        //firstPanel.setVisible(false);
        employeeInterface=new JPanel();
        empshow=new CardLayout();
        JPanel ePanel1=new JPanel();
        JPanel ePanel2=new JPanel();
        JPanel ePanel3=new JPanel(empshow);
        JPanel noticeBoard=new JPanel();
JPanel ePanel4=new JPanel();
        JPanel ePanel5=new JPanel();

        JLabel welcome=new JLabel("Welcome to Your Portal "+conn.getloginName());
        logout=new JMenuItem("Signout");
        JButton home=new JButton("Home");
        JButton attendance=new JButton("Attendance");
        JButton vacation=new JButton("Vacation");
        JButton resign=new JButton("Resign");
        JButton task=new JButton("Tasks");
        JButton personaFile= new JButton("Personal File");
        JButton Performance=new JButton("Performance Score");
        JTextArea notice=new JTextArea();
        notice.setFont(new Font("Times New Roman",Font.BOLD,18));
        notice.setText("Notice Board");
       // notice.setFont();

       cardPanel.add(employeeInterface,"employeeInterface");
        //cardPanel.add(employeeInterface);
        employeeAdminBar=new JMenuBar();
       // employeeAdminBar.add(back);
        cardLayout.show(cardPanel,"employeeInterface");
        loggedin=new JLabel("hello Frans");
        employeeInterface.setBackground(Color.YELLOW);
        ePanel2.setLayout(new BorderLayout());
        setJMenuBar(employeeAdminBar);
     employeeInterface.setLayout(new GridLayout());
ePanel4.add(welcome);
     ePanel1.setBackground(Color.red);
ePanel1.setLayout(new FlowLayout());
     ePanel1.add(home);
     ePanel1.add(attendance);
     ePanel1.add(vacation);
     ePanel1.add(resign);
     ePanel1.add(task);
     ePanel1.add(personaFile);
     ePanel1.add(Performance);
     ePanel3.add(notice,"notice");
     empshow.show(ePanel3,"notice");
     JScrollPane p1=new JScrollPane(ePanel3);
     // panel colors
        ePanel1.setBackground(new Color(39,108,245));
        ePanel3.setBackground(new Color(10,200,80));


ePanel5.setLayout(new BorderLayout());
ePanel5.add(ePanel1,BorderLayout.NORTH);
ePanel5.add(p1,BorderLayout.CENTER);
ePanel2.add(ePanel5,BorderLayout.CENTER);
ePanel2.add(ePanel4, BorderLayout.EAST);
ePanel4.setBackground(Color.orange);
//ePanel4.setBounds(300,400,300,400);

     //employeeInterface.add(ePanel1);
     employeeInterface.add(ePanel2);
      //  employeeInterface.setLocation(300,300);
        employeeInterface.revalidate();
        employeeInterface.repaint();
        employeeInterface.setVisible(true);

        // button actionlisteners
        attendance.addActionListener((e1)->{

        });
        home.addActionListener((e)->{
           String name=conn.getloginName();
            notice.setText("Welcome Back   "+name+"\n");
            notice.append("Login Time: "+log.date());
        });
attendance.addActionListener((e1)->{
    JPanel attendancet=new JPanel();
    ePanel3.add(attendancet,"attendancet");
    empshow.show(ePanel3,"attendancet");
    attendancet.setLayout(new FlowLayout(FlowLayout.LEFT));
    JButton startTime=new JButton("Start");
    JButton endTime=new JButton("End");
    attendancet.add(startTime);
    attendancet.add(endTime);
    // button characteristics
    startTime.setBackground(Color.lightGray);
    endTime.setBackground(Color.orange);
    // actionListeners for the buttons
    startTime.addActionListener((e2)->{
        String start=log.date();
        conn.setStartTime(start);
        conn.setTime("Start");
        conn.dtcConnectmethod(bd,"setTime");
    });
    endTime.addActionListener((e3)->{
        String end=log.date();
        conn.setEndTime(end);
        conn.setTime("End");
        conn.dtcConnectmethod(bd,"setTime");
    conn.dtcConnectmethod(bd,"calculate time");});

});





    }

    public void AdminInterface(){
     // firstPanel.setVisible(false);

        //container.removeAll();
        adminInterface=new JPanel();
        cardPanel.add(adminInterface,"adminInterface");
        cardLayout.show(cardPanel,"adminInterface");
adminInterface.setLayout(new GridLayout(1,3,6,6));
back=new JButton("Back");
//file1=new JPanel();
//file1.setLayout(new GridLayout(2,1,5,5));
        File=new JPanel();
        Set=new JPanel();
        Set.setBackground(Color.cyan);
        setRegistration=new JRadioButton("set Max Applications");
        //setRegistration.setLayout(new GridLayout(2,2));
        Registration=new JMenu("Registration");
        reg=new JMenuItem("Open");
        close=new JMenuItem("close");
       File.setBorder(new TitledBorder("Registration settings "));
       //File.setBorder(new TitledBorder(""))
        File.setBackground(new Color(255,153,153));
        Employee=new JPanel();
        Employee.setBackground(new Color(255,153,153));
        Employee.setBorder(new TitledBorder("Employee"));
       // Registration=new JPanel();
        Registration.setBackground(new Color(255,153,153));
       // Registration.setBorder(new TitledBorder("Registration"));
        adminMenuBar=new JMenuBar();

        adminInterface.add(File);
        File.add(setRegistration);


        // setRegistration components







        adminInterface.add(Employee);
        adminInterface.add(Set);
       // adminInterface.add(Registration);
        File.setLayout(new BoxLayout(File,BoxLayout.Y_AXIS));
       // Registration.setLayout(new BoxLayout(Registration,BoxLayout.Y_AXIS));
        Employee.setLayout(new BoxLayout(Employee,BoxLayout.Y_AXIS));
        loggedin=new JLabel();
        setJMenuBar(adminMenuBar);
        //adminInterface.setBackground(Color.GREEN);
       // adminInterface.setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       // adminInterface.add(adminMenuBar);



        sendEmail=new JMenu("send Emails");

        addemployee=new JRadioButton("Add Employee");
        updateEmployee=new JRadioButton("Update Employee Data");
        deleteEmployee=new JRadioButton("Delete Employees");
        AcceptEmployee=new JRadioButton("Accept Employee");
        save=new JRadioButton("Save");
        addNewVacancy=new JRadioButton("Add new job titles");
        deleteVacancy=new JRadioButton("Delete selected Job positions");
        setVacancy=new JRadioButton("Add selected job positions");
        viewEmployees=new JRadioButton("View Employees");
        addManager=new JRadioButton("Add a Manager");
        deleteManager=new JRadioButton("delete Manager");
        logout=new JMenuItem("Sign Out");


        //adminInterface.add(Employee);
        //adminInterface.add(Registration);
       // adminInterface.add(File);
       // adminMenuBar.add(File);
      //  adminMenuBar.add(sendEmail);
      //  adminMenuBar.add(Employee);
        adminMenuBar.add(logout);
        Registration.add(reg);
        Registration.add(close);
        adminMenuBar.add(Registration);
        Employee.add(addemployee);
        Employee.add(updateEmployee);
        Employee.add(deleteEmployee);
        Employee.add(viewEmployees);
        Employee.add(addManager);
        Employee.add(deleteManager);
        File.add(save);
        //File.add(setRegistration);
      //  File.add(viewEmployees);
        File.add(setVacancy);
        File.add(deleteVacancy);
        File.add(addNewVacancy);
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()!=null){
                    conn.setRegistrationstOpen();
                    conn.dtcConnectmethod(bd, conn.getRegistrationst());
                    JOptionPane.showMessageDialog(null, conn.getResult());
                }
            }
        });
      close.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (e.getSource()!=null){
                  conn.setRegistrationstClose();
                  conn.dtcConnectmethod(bd,conn.getRegistrationst());
                 JOptionPane.showMessageDialog(null,conn.getResult());
              }
          }
      });
setRegistration.addActionListener(new EmployeeeManipulate());
        logout.addActionListener(new EmployeeeManipulate());
        viewEmployees.addActionListener(new EmployeeeManipulate());
        addNewVacancy.addActionListener(new EmployeeeManipulate());
        deleteVacancy.addActionListener(new EmployeeeManipulate());
        setVacancy.addActionListener(new EmployeeeManipulate());
        save.addActionListener(new EmployeeeManipulate());
        updateEmployee.addActionListener(new EmployeeeManipulate());
        deleteEmployee.addActionListener(new EmployeeeManipulate());
        addemployee.addActionListener(new EmployeeeManipulate());
        addManager.addActionListener(new EmployeeeManipulate());
        deleteManager.addActionListener(new EmployeeeManipulate());




      adminInterface.setVisible(true);

    }
    class EmployeeeManipulate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent em){
if (em.getSource()==addColumn){
    File.removeAll();
    File.setLayout(new BorderLayout());
    sTChoose=new JLabel("Choose Table");
   // conn.dtcConnectmethod(bd,"retrieve table name");


   //newcol=new JTextField();
    conn.dtcConnectmethod(bd,"retrieve table name");
    String [] tablenames=conn.getChoosetable();

     tables=new JComboBox(tablenames);
   // tables.addActionListener(this);
   // File.add(newcol);// this line should be called from another actionlistener
    File.add(sTChoose,BorderLayout.NORTH);
    File.add(tables,BorderLayout.NORTH);
    tables.addActionListener(new Selector());
    //method  for showing the name of available databases should be isnerted here
    newCol=new JTextField();
File.revalidate();
File.repaint();


}
else if(em.getSource()==setRegistration){
   // Set=new JPanel();
    Set.removeAll();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();

    Set.setLayout(new GridLayout(2,1));
    Set.add(p1);
    Set.add(p2);
    p1.setBackground(new Color(100,200,255));
    p2.setBackground(new Color(255,128,0));
    p1.setLayout(new GridLayout(1,2));
    p2.setLayout(new BorderLayout());

    JLabel set=new JLabel("set Amount");
    JTextField retxt=new JTextField();
    JButton summit=new JButton("Submit");

    Set.setBorder(new TitledBorder("Registration"));
    //Set.setBackground();

    p1.add(set);
   p1.add(retxt);
    p2.add(summit,BorderLayout.SOUTH);
    summit.setBackground(Color.gray);
    summit.addActionListener((e)->{
        String no=retxt.getText().toString();
        boolean c=true;
        try{int n=Integer.parseInt(no);}catch(IllegalArgumentException t){
            c=false;
        }
        if(c==true){
            conn.setMaxApp(Integer.parseInt(no));
            conn.dtcConnectmethod(bd,"setMaxApplications");
            JOptionPane.showMessageDialog(null,conn.getResult());}
        else{
            JOptionPane.showMessageDialog(null,"Invalid");
        }
    });
Set.revalidate();
Set.repaint();
}
else if (em.getSource()==setVacancy){
    Set.removeAll();
    //JPanel vac=new JPanel();
   // cardPanel.add(vac,"vac");
   // cardLayout.show(cardPanel,"vac");
    Set.setLayout(new BorderLayout());

    Set.setBackground(Color.ORANGE);

    conn.dtcConnectmethod(bd,"get all E titles");
    //titls=new String[0];
    titls=conn.getAtitles();
    String[] ta={"Names"};
    Object[][] atitles=new Object[titls.length][1];
    for (int i=0;i<titls.length;i++){
        atitles[i][0]=titls[i];
    }
    JTable titleTable=new JTable(atitles,ta);
    titleTable.getTableHeader().setBounds(0,0,400,30);
    JScrollPane titlePane=new JScrollPane(titleTable);
    Set.add(titlePane,BorderLayout.CENTER);
submit=new JButton("add the selected Titles");
Set.add(submit,BorderLayout.SOUTH);
ListSelectionModel model=titleTable.getSelectionModel();
model.addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!model.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null,"You have selected "+titls[model.getMinSelectionIndex()]);
          //  count+=1;
            for (int i=0;i<titls.length+1;i++){
                int ind=model.getMaxSelectionIndex();
                String temptitle=titls[ind];
                // int start=tempemail.indexOf("E");
              //  String temp2=temptitle;
                String[] tempo=new String[settitles.length+1];
                for (int j=0;j<settitles.length;j++){
                    if(settitles.length==0){
                        break;
                    }
                    else{ tempo[j]=settitles[j];}
                }
                tempo[settitles.length]=temptitle;
                settitles=tempo;
             //   System.out.println(ititls[i]);
            }
        }
    }
});
submit.addActionListener((ec)->{
    for (int i=0;i<settitles.length;i++){
        conn.dtcConnectmethod(bd,"getAdminTitles");
        String[] chc=conn.getEtitles();
        boolean chk=true;
        for(int j=0;j<chc.length;j++){
            if(chc[j].equals(settitles[i])){
                chk=false;
            }
        }
        if(chk==true){    conn.setVacanyadd(settitles[i]);
            conn.dtcConnectmethod(bd,"setAdminTitles");
        JOptionPane.showMessageDialog(null,conn.getResult());
        break;}
        else{
            JOptionPane.showMessageDialog(null,"some of the selected titles have already been added");
            break;
        }
    }

});
Set.repaint();
Set.revalidate();
}
else if (em.getSource()==deleteColumn){

}
else if (em.getSource()==save){

}
else if (em.getSource()==addManager){

}
else if(em.getSource()==deleteManager){

}
else if(em.getSource()==updateEmployee){
CardLayout cdl=new CardLayout();
JPanel changes=new JPanel(cdl);
Set.removeAll();
Set.add(changes);
JPanel update=new JPanel();
update.setBackground(Color.orange);
    changes.add(update,"update");
    cdl.show(changes,"update");
    update.setLayout(new GridLayout());
    conn.setTemp_in("View id, name and email");
conn.dtcConnectmethod(bd,"retriev employee datal");
String[] col0= {"Id","Name","Email"};
String[] allEmail=conn.getEmployeeEml();
String [] names=conn.getViewEmployeeName();
String[] idss=conn.getIds();
Object[][] o1=new Object[allEmail.length][3];
for (int i=0;i<allEmail.length;i++){
    o1[i][0]=idss[i];
    o1[i][1]=names[i];
    o1[i][2]=allEmail[i];
    }
JTable t1=new JTable(o1,col0);
t1.getTableHeader().setBounds(0,0,200,30);
JScrollPane p0=new JScrollPane(t1);
update.add(p0);
p0.getViewport().setBackground(Color.cyan);
ListSelectionModel model=t1.getSelectionModel();
model.addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        String[] dpts=getDepartment();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JPanel p5=new JPanel();
        JButton btn1=new JButton("set salary");
        submit=new JButton("save changes");
        JTextField t1=new JTextField();// start date set
        JTextField t2=new JTextField();// start month set
        JTextField t3=new JTextField();// start year set
        JTextField t4=new JTextField();// end date set
        JTextField t5=new JTextField();//end month set
        JTextField t6= new JTextField();// end year set
        JComboBox d=new JComboBox(dpts); //set department

        JLabel l1=new JLabel("Start Date");
        JLabel l2= new JLabel("Start Month");
        JLabel l3= new JLabel("Start Year");
        JLabel l4= new JLabel("End Date");
        JLabel l5= new JLabel("End Month");
        JLabel l6= new JLabel("End Year");
      JLabel l7= new JLabel("Department");

        p2.setLayout(new GridLayout(3,1,10,10));
        p3.setLayout(new BorderLayout());// table panel
        p4.setLayout(new GridLayout(7,2));
        p5.setLayout(new GridLayout(1,2,20,20));

        p2.setBackground(Color.ORANGE);
        cardPanel.add(p2,"p2");
        cardLayout.show(cardPanel,"p2");


String []ids=conn.getIds();
String id=ids[model.getMinSelectionIndex()];
conn.setId(id);
conn.dtcConnectmethod(bd,"retrieve workDetails");
String[] wData=conn.getEwordData();
String[] wCol=conn.getEcolumnNames();
        System.out.println(wData.length);
        System.out.println(wCol.length);
        int count=0;
    Object[][] wDta=new Object[wData.length/wCol.length][wCol.length];

    for (int i=0;i<(wData.length/wCol.length);i++){
        for (int j=0;j<wCol.length;j++){
            wDta[i][j]=wData[count];
            count++;
        }
        JTable tw=new JTable(wDta,wCol);
        tw.setBackground(Color.cyan);
    JScrollPane s1=new JScrollPane(tw);
    s1.getViewport();
    p3.add(s1,BorderLayout.CENTER);
    p4.add(l1);p4.add(t1);
    p4.add(l2);p4.add(t2);
    p4.add(l3);p4.add(t3);
    p4.add(l4);p4.add(t4);
    p4.add(l5);p4.add(t5);
    p4.add(l6);p4.add(t6);
    p4.add(l7);p4.add(d);

    p5.add(submit);p5.add(btn1);
    // button colors
        btn1.setBackground(Color.ORANGE);
        submit.setBackground(Color.MAGENTA);
        submit.addActionListener((evt)->{

            String dept=String.valueOf(d.getSelectedItem());
            double sal=0;
           /*
           * here the salar actionlistener should be implemented
           * */



EmployeeBasicDetails dt1= new EmployeeBasicDetails(checkInput(t1.getText().toString()),checkInput(t2.getText().toString()),checkInput(t3.getText().toString()),checkInput(t4.getText().toString()),checkInput(t5.getText().toString()),checkInput(t6.getText().toString()),sal,dept);
       conn.dtcConnectmethod(dt1,"setWorkDetails");
        JOptionPane.showMessageDialog(null,conn.getResult());});

  p2.add(p3);p2.add(p4);p2.add(p5);
    p2.repaint();
    p2.revalidate();
}





JLabel salary=new JLabel();
JLabel startDate=new JLabel();
JLabel startMonth=new JLabel();
JLabel endDate=new JLabel();
JLabel endMonth=new JLabel();
JLabel endYear=new JLabel();
JLabel dept=new JLabel();
//conn.setTemp_in("View Specific Employee");
//String[] colmnname=conn.getEcolumnNames();
//String [] empdata=conn.getEmpdatas();


//reslt.result();
    }
});

// the below code is after the employee has been chosen.
String[] updata=conn.getEcolumnNames();
String [] databaseData=conn.getEmpdatas();
Object[][] upd= new Object[updata.length][2];
Set.revalidate();
Set.repaint();

}
else if(em.getSource()==viewEmployees){
   // conn.dtcConnectmethod(bd,"retrieve employee data");
    JPanel view=new JPanel();
   // view.setLayout(new GridLayout());
    cardPanel.add(view,"viewE");
    cardLayout.show(cardPanel,"viewE");
    view.setBackground(Color.green);
   // String firstchoice=conn.getResult();



    //conn.dtcConnectmethod(bd,"hi");
    String[] choices={"View all","View Specific Employee"};

    JComboBox box=new JComboBox(choices);
    view.add(box);
box.addActionListener((e)->{
    JComboBox b= (JComboBox) e.getSource();
    String select=(String) b.getSelectedItem();
    if (select.equals("View Specific Employee")){


        JTextField id=new JTextField();
        JLabel eid=new JLabel("Enter the Id of the employee");

        JPanel spemp=new JPanel();
        spemp.setLayout(null);
        spemp.setBackground(Color.CYAN);
        spemp.add(eid);
        spemp.add(id);
        cardPanel.add(spemp,"spemp");
        cardLayout.show(cardPanel,"spemp");
        eid.setBounds(0,50,200,40);
        id.setBounds(200,50,200,40);
        JButton btn=new JButton("Search");

        Back =new JMenuItem("Back");
        Back.addActionListener((act)->{ adminMenuBar.remove(Back);// if this code is not executed first, the back button will emerge infinite no times
            cardLayout.show(cardPanel,"viewE");
        });
        adminMenuBar.add(Back);
        btn.addActionListener((ac)->{
            conn.setId(id.getText().toString());
            conn.setTemp_in("View Specific Employee");
            conn.dtcConnectmethod(bd, "retriev employee datal");
            String[] columnN=conn.getEcolumnNames();

            String employdata[]=conn.getEmpdatas();
            if (employdata!=null && employdata.length!=0) {
                JPanel spe=new JPanel();
                spe.setLayout(new BorderLayout());
                spe.setBackground(new Color(100,150,200));
                cardPanel.add(spe,"spe");
                cardLayout.show(cardPanel,"spe");

                Object[][] spempdata = new Object[columnN.length][2];
                for (int i = 0; i < employdata.length; i++) {
                    spempdata[i][0] = columnN[i];
                    spempdata[i][1]=employdata[i];
                }
                String[] colname={"Data","Values"};
                JTable viewspemp = new JTable(spempdata, colname);
                viewspemp.getTableHeader().setBounds(0, 0, 400, 30);
                viewspemp.setBounds(0, 50, 400, 200);
                JScrollPane spempane = new JScrollPane(viewspemp);
                spempane.getViewport().setBackground(Color.orange);
                spe.add(spempane);


            }
            else{
                JOptionPane.showMessageDialog(null,"The employee does not exist");
            }
        });
        spemp.add(btn);
        btn.setBounds(500,500,100,50);
        btn.setBackground(Color.red); }
   else if(select.equals("View all")){
        conn.setTemp_in("View id, name and email");
        JPanel viewall=new JPanel();
        viewall.setLayout(new BorderLayout(5,5));
        cardPanel.add(viewall,"viewall");
        cardLayout.show(cardPanel,"viewall");
       // conn.setTemp_in("View id, name and email");
        conn.setTemp_in("View id, name and email");
        conn.dtcConnectmethod(bd,"retriev employee datal");

        String[] names=conn.getViewEmployeeName();
        System.out.println("hello");
        String[] emails=conn.getEmployeeEml();
        String[] ids=conn.getIds();
        String[] columnNmes={"Id","Name","Email"};
        Object[][] edata=new Object[ids.length][3];
        for (int i=0;i<ids.length;i++){
            edata[i][0]=ids[i];
            edata[i][1]=names[i];
            edata[i][2]=emails[i];
        }
        JTable viewtable=new JTable(edata,columnNmes);
        viewtable.getTableHeader().setBounds(0,0,400,30);
        viewtable.setBounds(0,50,400,200);
        JScrollPane viewpane=new JScrollPane(viewtable);
        viewpane.getViewport().setBackground(Color.MAGENTA);
        Back=new JMenuItem("Back");
        Back.addActionListener((ev)->{
            cardLayout.show(cardPanel,"viewE");
        });



        viewall.add(viewpane);



    }
});

    // adding to view

  //  view.setVisible(true);

}
else if (em.getSource()==addemployee){
    Back=new JMenuItem("Back");
    reload=new JMenuItem("Reload");
    reload.setBackground(Color.RED);
    adminMenuBar.add(reload);
    adminMenuBar.add(Back);
    Back.setBackground(Color.GREEN);
    JPanel addemployeeP=new JPanel();
    cardPanel.add(addemployeeP,"addemployeeP");
    cardLayout.show(cardPanel,"addemployeeP");
    addemployeeP.setLayout(new BorderLayout());
    conn.dtcConnectmethod(bd,"retrieve applicant");
    String [] columns={"Name","Email"};


    empName=conn.getApplicantName();
    // System.out.println(addemp[0]);
    empEmail=conn.getApplicantEmail();
    String[] tobeused=new String[empEmail.length];
    Object [][] emdata=new Object[empName.length][2];
    for (int i=0;i<empName.length;i++){
emdata[i][0]=empName[i];
emdata[i][1]=empEmail[i];
        tobeused[i]=empName[i]+"      Email: "+empEmail[i];}

//container.removeAll();
//container.setLayout(new BorderLayout(2,10));
//container.setBackground(Color.CYAN);

//addemployeeP.setLayout(new BorderLayout());
    // employeeTable.getTableHeader().setBounds(0,0,30,30);
    //addemployeeP.add(employeeTable.getTableHeader());
    // addemployeeP.add(employeeTable.getTableHeader());
//addemployeeP.add(pane);
//addemployeeP.add(employeeTable);

    Back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button clicked");
            cardLayout.show(cardPanel,"adminInterface");
            adminMenuBar.remove(Back);
            adminMenuBar.remove(reload);
        }
    });

    employeeTable =new JTable(emdata,columns);
    employeeTable.getTableHeader().setBounds(0,0,400,30);
    employeeTable.setBounds(0,50,400,200);
    JScrollPane pane=new JScrollPane(employeeTable);



  //  JList<String> empl=new JList<>(tobeused);
  //  JList<String> email=new JList<>(empEmail);
   // empl.setBackground(new Color(23,255,133));
   // empl.setFont(new Font("Arial",Font.PLAIN,14));
    submit=new JButton("add all selected employees");

    ListSelectionModel model=employeeTable.getSelectionModel();
    model.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if ( !model.isSelectionEmpty()){

                JOptionPane.showMessageDialog(null,"you have selected  "+empName[model.getMinSelectionIndex()]);


                // empl.getSelectedValuesList();
            }
            for (int i=0;i<inputs.size()+1;i++){
                int ind=model.getMaxSelectionIndex();
                String tempemail=empEmail[ind];
                // int start=tempemail.indexOf("E");
                String temp2=tempemail;
                String[] tempo=new String[inemail.length+1];
                for (int j=0;j<inemail.length;j++){
                    if(inemail.length==0){
                        break;
                    }
                    else{ tempo[j]=inemail[j];}
                }
                tempo[inemail.length]=temp2;
                inemail=tempo;
                System.out.println(inemail[i]);
            }

        }
    });




    //addemployeeP.add(employeeTable,BorderLayout.CENTER);



    pane.setBackground(new Color(23,233,233));
    pane.getViewport().setBackground(new Color(23,255,133));

    //dpane.setBackground(new Color(23,233,233));
    //dpane.getViewport().setBackground(new Color(23,255,133));
    addemployeeP.add(pane, BorderLayout.CENTER);
    addemployeeP.add(submit,BorderLayout.SOUTH);
    //addemployeeP.add(employeeTable);
    //addemployeeP.add(employeeTable.getTableHeader());
    addemployeeP.setVisible(true);
    reload.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            empName=conn.getApplicantName();// this is an employee email, not applicant email here
            empEmail =conn.getEmployeeEml();

        }
    });
/*empl.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {

            if ( !empl.getSelectedValuesList().isEmpty()){

                JOptionPane.showMessageDialog(null,"you have selected  "+empl.getSelectedValue());

            inputs=empl.getSelectedValuesList();
            }
            for (int i=0;i<inputs.size();i++){

                String  temp=inputs.get(i);
                int start=temp.indexOf("E");
                String temp2=temp.substring(start+7);
                String[] tempo=new String[inemail.length+1];
                for (int j=0;j<inemail.length;j++){
                    if(inemail.length==0){
                        break;
                    }
                  else{ tempo[j]=inemail[j];}
                }
                tempo[inemail.length]=temp2;
                inemail=tempo;
            }
        }
    });*/
    submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==submit){
//conn.setAdmintrue(true);
                for(int i=0;i<inemail.length;i++){
                    String takenemail=inemail[i];
                    conn.setTakenemail(takenemail);
                    conn.dtcConnectmethod(bd,"applcnto data");
                    String[] adata=conn.getApplicantdt();
                    System.out.println(adata[1]);
                    System.out.println(adata[2]);
                    System.out.println(adata[3]);
                    System.out.println(adata[4]);
                    System.out.println(adata[5]);
                    System.out.println(adata[6]);
                    System.out.println(adata[7]);
                    System.out.println(adata[8]);
                    System.out.println(adata[9]);
                    System.out.println(adata[10]);
                    System.out.println(adata[11]);
                    System.out.println(adata[12]);
                    System.out.println(adata[13]);
                    System.out.println(adata[14]);
                    System.out.println(adata[15]);
                    System.out.println(adata[16]);
                    System.out.println(adata[17]);
                    System.out.println(adata[18]);

                    EmployeeBasicDetails ad=new EmployeeBasicDetails( adata[1], adata[2],adata[3], Integer.parseInt(adata[4]),
                            Integer.parseInt(adata[5]), Integer.parseInt(adata[6]), adata[7], adata[8], adata[12],adata[13],
                            adata[14], adata[9],adata[10],Integer.parseInt(adata[11]), adata[15],adata[16],adata[17],adata[18]);
                    conn.dtcConnectmethod(ad,"add employee");

                    addWorkD(adata[17]);
                    System.out.println(adata[17]);
                    //conn.dtcConnectmethod(bd,"delete applicant data");
                    JOptionPane.showMessageDialog(null,conn.getResult());

                }


            }
        }
    });


//Employee.setBackground(Color.CYAN);

//Employee.setLayout(BorderLayout.CENTER);

//container.revalidate();
//container.repaint();
//container.setVisible(true);

}
else if (em.getSource()==deleteEmployee){
    Back= new JMenuItem("Back");
    reload=new JMenuItem("Reload");
    JPanel deleteInterface=new JPanel();
    deleteInterface.setLayout(new BorderLayout(5,5));
    cardPanel.add(deleteInterface,"deleteEmp");
    cardLayout.show(cardPanel,"deleteEmp");
    adminMenuBar.add(Back);
    Back.setBackground(Color.GREEN);
    adminMenuBar.add(reload);
    reload.setBackground(new Color(0,128,255));
    conn.dtcConnectmethod(bd,"retrieve employee data for deleting");
    empName=conn.getApplicantName();// change this method name to getName
    // System.out.println(addemp[2]);
    empEmail=conn.getEmployeeEml();
    String[] tobeused=new String[empEmail.length];
    JTable deletetable=new JTable();
    Object [][] delemp=new Object[empEmail.length][2];
    for (int i=0;i<empEmail.length;i++){
        delemp[i][0]=empName[i];
        delemp[i][1]=empEmail[i];}
    String[] Eml={"Name","Email"};
    deletetable=new JTable(delemp,Eml);
  //  deleteInterface.add(deletetable.getTableHeader());
  //  deleteInterface.add(deletetable);

    // for (int i=0;i<addemp.length;i++){
    // tobeused[i]=addemp[i]+"      Email: "+emails[i];}

    // container.removeAll();
    // container.setLayout(new BorderLayout(2,10));
    //  container.setBackground(Color.CYAN);
    // JList<String> empl=new JList<>(tobeused);
    //  JList<String> email=new JList<>(emails);
    deletetable.getTableHeader().setBounds(0,0,700,50);
    deletetable.setBounds(0,50,800,800);
    JScrollPane dpane=new JScrollPane(deletetable);


    //  empl.setBackground(new Color(23,255,133));
    //empl.setFont(new Font("Arial",Font.PLAIN,14));
    submit=new JButton("delete selected employees");

    //  JScrollPane pane=new JScrollPane(empl);
    dpane.setBackground(new Color(23,233,233));
    dpane.getViewport().setBackground(new Color(23,255,133));
   // deleteInterface.add(dpane);
    ListSelectionModel model=deletetable.getSelectionModel();
            model.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {

            if ( !(model.isSelectionEmpty())){

                JOptionPane.showMessageDialog(null,"you have selected  "+empName[model.getMinSelectionIndex()]);
int indexholder=model.getMinSelectionIndex();
indeces=new int[indeces.length+1];
indeces[indeces.length-1]=indexholder;
                System.out.println(indeces[0]);
               // System.out.println(emails[4]);
                //inputs=model.getMinSelectionIndex();
                for (int i=0;i<indeces.length;i++){

                    // System.out.println("check1");
                    String  temp=empEmail[indeces[i]];
                    System.out.println(temp);
                    // int start=temp.indexOf("E");
                    // String temp2=temp.substring(start+7);
                    String[] tempo=new String[inemail.length+1];
                    for (int j=0;j<inemail.length;j++){
                        if(inemail.length==0){
                            break;
                        }
                        else{ tempo[j]=empEmail[j];}
                        System.out.println(inemail[j]);
                        System.out.println(inemail.length);
                    }
                    tempo[inemail.length]=temp;
                    inemail=tempo;

                }
            }

        }
    });
    submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==submit){

                for(int i=0;i<inemail.length;i++){
                    String takenemail=inemail[i];
                    System.out.println(inemail[i]);
                    conn.setEmployeeEmail(takenemail);
                    conn.dtcConnectmethod(bd,"delete applicant/employee data");
                  //  String[] adata=conn.getApplicantdt();

                }
                JOptionPane.showMessageDialog(null,conn.getResult());


            }
        }
    });
    Back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel,"adminInterface");
            adminMenuBar.remove(Back);
            adminMenuBar.remove(reload);
        }
    });
    reload.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           empName=conn.getApplicantName();
           empEmail =conn.getApplicantEmail();

        }
    });
    //container.add(pane,BorderLayout.CENTER);
    //container.add(submit,BorderLayout.SOUTH);
  //  container.revalidate();
  //  container.repaint();
    deleteInterface.add(dpane,BorderLayout.CENTER);
    deleteInterface.add(submit, BorderLayout.SOUTH);
    deleteInterface.setVisible(true);
            } else if (em.getSource() == addTable) {

            } else if (em.getSource() == viewEmployees) {

            } else if (em.getSource() == logout) {
    adminMenuBar.removeAll();

    cardLayout.show(cardPanel,"firstPanel")
;
            }
        }

    }
    private class Selector implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

if (e.getSource()==tables){
    JComboBox cb=(JComboBox) e.getSource();
    conn.setChooseTable((String) cb.getSelectedItem());

    String[] datatypes={"number","long text","brief words"};
    datatype=new JComboBox(datatypes);
//if(e.getActionCommand()=="number"){

//}
// the file panel should be used all in all
    File.removeAll();
    File.setLayout(new BoxLayout(File,BoxLayout.Y_AXIS));
    File.setBackground(Color.CYAN);
    colLen=new JTextField();
    colDType=new JLabel("DataTYpe");//
    columnlen=new JLabel("Length");

    newCol=new JTextField();
    colDataType=new JTextField();
    showResult =new JLabel();
    sTChoose=new JLabel("Name of the new column: ");
    submit=new JButton("Create");
File.revalidate();
File.repaint();
File.add(sTChoose);
File.add(newCol);
File.add(colDType);
File.add(datatype);
File.add(columnlen);
File.add(colLen);
File.add(submit);


    submit.addActionListener(new SecondAction());
File.setVisible(true);


    String selectedTable=(String) tables.getSelectedItem();


    //try catch block expected
    JLabel columnlen=new JLabel("enter the length of the column");



}
        }}

    private class SecondAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ev){
            if (colLen!=null){
                if (ev.getSource()==submit){
                    //JComboBox cb2=.getSource()
                    String selectedDatatype=(String)datatype.getSelectedItem();
                    if(selectedDatatype.equals("number")){
                        conn.setColDatatype("int");
                    }
                    else if(selectedDatatype.equals("long text")){
                        System.out.println("check4");
                        conn.setColDatatype("TEXT");
                    }
                    else if (selectedDatatype.equals("brief words")){
                        System.out.println("cec");
                        conn.setColDatatype("VARCHAR");
                    }
                    conn.setNewCol(newCol.getText().toString());
                    //conn.setColDatatype(colDataType.getText().toString());
                    //colDataType.addActionListener(new );
                    conn.setColumnLength(colLen.getText().toString());
                   // showResult.setText(conn.getResult());
                    conn.dtcConnectmethod(bd,"add column");
                    if (conn.getResult().equals("Successfully added"))
                    {
                        JOptionPane.showMessageDialog(null, conn.getResult());
                    }



                }
                datatype.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });

            }// conn.dtcConnectmethod(bd,"add column data");
            if (ev.getSource()==submit){
                passwordin=password.getText().toString();
                String checkemail=email.getText().toString();
                String value=log.login(checkemail,passwordin);
                String identity=log.getAdminChecker();
               // String value=conn.getLoginvalue();// i am not receving any value
                System.out.println(value);
                System.out.println(identity.equals("Not admin"));
                if(value.equals("Access Granted")){
                    switch(identity){
                        case "Admin":
                            AdminInterface();
                            break;
                        case "Manager":
                            managerInterface();
                            break;
                        default:
                            EmployeeInterface();
                            break;
                    }
                }

                else{
                    error=new JLabel(value);
                    firstPanel.add(error);
                    error.setBounds(100,100,300,100);
                    firstPanel.setVisible(true);
                }

            }}
    }
    public void registr(){
      JPanel RegistrationInterface=new JPanel();
      cardPanel.add(RegistrationInterface,"RegistrationInterface");
      cardLayout.show(cardPanel,"RegistrationInterface");
      RegistrationInterface.setBackground(Color.ORANGE);
        employeeAdminBar =new JMenuBar();
        RegistrationInterface.add(employeeAdminBar);
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
     RegistrationInterface.setLayout(new BoxLayout(RegistrationInterface,1));



     RegistrationInterface.add(Fname);RegistrationInterface.add(fName);RegistrationInterface.add(Mname);
     RegistrationInterface.add(mName);RegistrationInterface.add(Lname);RegistrationInterface.add(lName);
     RegistrationInterface.add(Emal);RegistrationInterface.add(email);RegistrationInterface.add(Bday);
     RegistrationInterface.add(bDay);RegistrationInterface.add(Bmonth);RegistrationInterface.add(bMonth);
        RegistrationInterface.add(Byear);RegistrationInterface.add(bYear);RegistrationInterface.add(Phoneno);
     RegistrationInterface.add(phoneNumber);RegistrationInterface.add(Maritalst);RegistrationInterface.add(maritalStatus);
     RegistrationInterface.add(country);RegistrationInterface.add(AddressCountry);RegistrationInterface.add(city);RegistrationInterface.add(City);
     RegistrationInterface.add(Keble);RegistrationInterface.add(kebele);RegistrationInterface.add(type);RegistrationInterface.add(employeetype);
     JButton nextPage=new JButton("Next Page");
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




     RegistrationInterface.add(nextPage);
     nextPage.setBackground(Color.ORANGE);
     nextPage.addActionListener((eve)->{
         JMenuBar regBar=new JMenuBar();
         JPanel r2=new JPanel();
         r2.setLayout(new BoxLayout(r2,1));
         cardPanel.add(r2,"r2");
         cardLayout.show(cardPanel,"r2");
         JButton subit=new JButton("Submit");
         Back=new JMenuItem("Back");
         r2.add(skill);r2.add(Skills);
         r2.add(postal);r2.add(postal_code);r2.add(gen);r2.add(Gender);
         r2.add(qualification);r2.add(Qualifications);r2.add(passw);r2.add(password);
         r2.setBackground(Color.ORANGE);
         r2.add(confPass);r2.add(confpassw);
         //r2.add(adminMenuBar);
      setJMenuBar(regBar);
      regBar.add(Back);
         Back.addActionListener((e)->{employeeAdminBar.remove(Back);
             cardLayout.show(cardPanel,"RegistrationInterface");});



        r2.add(subit);
         subit.setBackground(Color.ORANGE);
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




        // write the code for calling addemployee down below

     //JTextField employeetype=new JTextField("")

    }
   // public static void ErrorShow(){

 //   }
public static void main(String [] args){
        new LoginGUI();
}}


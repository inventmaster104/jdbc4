package ProjectEMS;

import jdk.jfr.Percentage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.Date;

//
// go to line around 1080 and connect the data gathered with database
public class LoginGUI extends JFrame implements DatabasemethodsInterface, EmployeeMInterface {
    JButton jobTitles;
    private ArrayList<String> titl=new ArrayList<>();
    private ArrayList<String > iD=new ArrayList<>();
    private JPanel rP;
    private JPanel show;
    private CardLayout rC;
    private JPanel rcP;
    private String[] description=new String[0];
    private String[] date=new String[0];
private String[] taskArray=new String[0];
    private String[] titls=new String[0];
    private JPanel Set;
    private String[] settitles=new String[0];
    private JButton addManager;
    private JButton deleteManager;
   private JButton Vacancy;

    private JButton addNewVacancy;
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
    private JPanel m2;
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
    private JButton setRegistration;
    private JTextField newCol;
   private JLabel sTChoose;
    private JPanel Employee;
   // private JPanel File;
    private JMenuItem logout;
    private JButton back;
private JTable employeeTable;
    private JMenu Settings;
    private JMenu Registration;
    private JMenu sendEmail;
    private JMenuBar adminMenuBar;


    private JButton viewEmployees;
    // employee menu variables
    private JButton addemployee;
    private JButton updateEmployee;
    private JButton deleteEmployee;
   // private JRadioButton deleteColumn;
   // private JRadioButton save;
    private JButton AcceptEmployee;
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

            }
        }

    }
public void managerInterface(){
        Manager man=new Manager();
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
    JPanel mhome=new JPanel();// for showing tables and notices

    JPanel m3=new JPanel();//for saying hello to the manager
    JPanel m4=new JPanel(); // to contain both m1 and m2
    mPanel.add(mhome,"home");

    JTextArea tm=new JTextArea();
    tm.setText("Today's News");
    tm.setFont(new Font("Times New Roman",Font.BOLD,20));
    //jmenu items
    setJMenuBar(managerBar);
    logout=new JMenuItem("Signout");
    managerBar.add(logout);
    logout.setBackground(Color.red);
    //panel components
    mhome.setLayout(new BorderLayout());
    m1.setLayout(new FlowLayout());
    m1.setBackground(new Color(23,233,80));
    m1.add(home);
    m1.add(roles);
    m1.add(recommendations);
    m1.add(viewOverallPerformance);
    m4.setLayout(new BorderLayout());
    m4.add(m1,BorderLayout.NORTH);
    m4.add(mPanel,BorderLayout.CENTER);

    mcardLayout.show(mPanel,"home");
    managerInterface.add(m4,BorderLayout.CENTER);
    managerInterface.add(m3,BorderLayout.EAST);
// actionlisteners
   logout.addActionListener((et)->{
       managerBar.removeAll();
       cardLayout.show(cardPanel,"firstPanel");
   });
   roles.addActionListener((es)->{
       JPanel m5=new JPanel();

       conn.setTemp_in("View id, name and email");
       conn.dtcConnectmethod(bd,"retriev employee datal");
       String[] cols= {"Id","Name","Email"};
       String[] emails=conn.getEmployeeEml();
       System.out.println(emails[0]);


        empName=conn.getViewEmployeeName();

       System.out.println(empName[0]);
        String[] ids=conn.getIds();
       System.out.println(ids[0]);
        Object[][] edata=new Object[empName.length][3];
        for (int i=0;i<empName.length;i++){
            edata[i][0]=ids[i];
            edata[i][1]=empName[i];
            edata[i][2]=emails[i];
        }
        JTable showt=new JTable(edata,cols);
        JScrollPane p1=new JScrollPane(showt);



        m5.setLayout(new BorderLayout());
        m5.add(p1,BorderLayout.CENTER);
       p1.getViewport();
       showt.setBackground(Color.black);
       showt.setForeground(Color.white);
       mPanel.add(m5,"m5");
       mcardLayout.show(mPanel,"m5");
       Back=new JMenuItem("Back");
       managerBar.add(Back);
       Back.setBackground(Color.magenta);
       Back.addActionListener((e6)->{
           managerBar.remove(Back);
           mcardLayout.show(mPanel,"mhome");
       });
       ListSelectionModel model=showt.getSelectionModel();
       model.addListSelectionListener(new ListSelectionListener() {
           @Override
           public void valueChanged(ListSelectionEvent e) {
               if(!model.isSelectionEmpty()){
                  // man.setId(String.valueOf(ids[model.getMinSelectionIndex()]));
                   System.out.println("the id is gui is"+String.valueOf(ids[model.getMinSelectionIndex()]));
                  taskArray=new String[0];
                  titles=new String[0];
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
                   managerBar.add(Back);

                   // structure
                   tsk.setLayout(new BorderLayout());
                   tsk.add(po,BorderLayout.CENTER);
                   po.setLayout(new GridLayout(3,2,5,20));
                   po.add(l1);po.add(f1);
                   po.add(l2);po.add(f2);
                   po.add(l3);po.add(f3);
                   bcont.setLayout(new GridLayout(1,2,5,20));
                   bcont.add(addtsk); bcont.add(setTask);
                   tsk.add(bcont,BorderLayout.SOUTH);
                   //home
                   JTextArea t1=new JTextArea();
                   String name=conn.getloginName();
                   t1.setText("Welcome Back   "+name+"\n");
                   t1.append("Notice: ");
                   t1.setFont(new Font("Times New Roman",Font.BOLD,20));
                   JScrollPane p0=new JScrollPane(t1);
                   mhome.add(p0);
                   // colors
                   addtsk.setBackground(Color.cyan);
                   setTask.setBackground(new Color(150,200,250));
                   // actionlisteners
                   Back.addActionListener((e5)->{
                       managerBar.remove(Back);
                       mcardLayout.show(mPanel,"m5");
                   });
                   addtsk.addActionListener((et)->{
                      man.setTaskinfo(f1.getText().toString(),f3.getText().toString(),f2.getText().toString());

//JOptionPane.showMessageDialog(null,man.result);
                       f1.setText("");
                       f2.setText("");
                       f3.setText("");
                   });
                   setTask.addActionListener((e2)->{

    man.setTaskinfo(f1.getText().toString(),f3.getText().toString(),f2.getText().toString());
    date=man.date;taskArray=man.title;description=man.des;
  Manager man0=new Manager(taskArray,description,date,String.valueOf(ids[model.getMinSelectionIndex()]));
 JOptionPane.showMessageDialog(null,man0.result);
f1.setText("");f2.setText("");f3.setText("");
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
        JPanel ePanel1=new JPanel();                  JPanel ePanel2=new JPanel();
        JPanel ePanel3=new JPanel(empshow);
        JPanel ePanel4=new JPanel();                  JPanel ePanel5=new JPanel();

        JLabel welcome=new JLabel("Welcome to Your Portal "+conn.getloginName());
        logout=new JMenuItem("Signout");
        JButton home=new JButton("Home"); home.setBackground(Color.cyan);
        JButton attendance=new JButton("Attendance");attendance.setBackground(Color.cyan);
        JButton vacation=new JButton("Vacation");vacation.setBackground(Color.cyan);
        JButton resign=new JButton("Resign");resign.setBackground(Color.cyan);
        JButton task=new JButton("Tasks");task.setBackground(Color.cyan);
        JButton personaFile= new JButton("Personal File");personaFile.setBackground(Color.cyan);
        JButton Performance=new JButton("Performance Score");Performance.setBackground(Color.cyan);
        JTextArea notice=new JTextArea();
        notice.setFont(new Font("Times New Roman",Font.BOLD,18));
        notice.setText("Notice Board");
       // notice.setFont();

       cardPanel.add(employeeInterface,"employeeInterface");
        //cardPanel.add(employeeInterface);
        employeeAdminBar=new JMenuBar();
       // employeeAdminBar.add(back);
        cardLayout.show(cardPanel,"employeeInterface");

        ePanel2.setLayout(new BorderLayout());
        setJMenuBar(employeeAdminBar);
     employeeInterface.setLayout(new GridLayout());
     ePanel4.setLayout(new GridLayout(7,1,0,10));
//ePanel4.add(welcome);
     ePanel1.setBackground(Color.red);
ePanel1.setLayout(new FlowLayout());
     ePanel4.add(home);              ePanel4.add(attendance);
     ePanel4.add(vacation);          ePanel4.add(resign);
     ePanel4.add(task);              ePanel4.add(personaFile);
     ePanel4.add(Performance);        ePanel3.add(notice,"notice");

     empshow.show(ePanel3,"notice");
     JScrollPane p1=new JScrollPane(ePanel3);
     // panel colors
        ePanel1.setBackground(new Color(39,108,245));
        ePanel3.setBackground(new Color(10,200,80));

ePanel5.setLayout(new BorderLayout());               ePanel5.add(ePanel1,BorderLayout.NORTH);
ePanel5.add(p1,BorderLayout.CENTER);                 ePanel2.add(ePanel5,BorderLayout.CENTER);
ePanel2.add(ePanel4, BorderLayout.WEST);             ePanel4.setBackground(Color.MAGENTA);
//ePanel4.setBounds(300,400,300,400);

     employeeInterface.add(ePanel2);
     employeeInterface.revalidate();
     employeeInterface.repaint();
     employeeInterface.setVisible(true);

        // button actionlisteners
home.addActionListener((eh)->{
    JTextArea tA=new JTextArea();
    conn.dtcConnectmethod(bd,"getNotice");
    tA.setText(conn.getNotice());

});
        Performance.addActionListener((ep)->{
            conn.dtcConnectmethod(bd,"getTasks");
            conn.dtcConnectmethod(bd,"calculate time");
            JPanel performannce=new JPanel();
            performannce.setLayout(new GridLayout(3,1,0,20));

            int daysPresent=conn.getdaysPresent();             int taskC=conn.getTaskComplete();
            JProgressBar prog=new JProgressBar(0,30);          prog.setValue(daysPresent);
            prog.setStringPainted(true);                       prog.setForeground(Color.GREEN);
            performannce.add(new JLabel("Attendance"));   performannce.add(prog);
            int totalTasks=conn.getTaskInfo().length/conn.getTaskCol().length;
            prog=new JProgressBar(0,totalTasks);               prog.setValue(taskC);
            prog.setStringPainted(true);                       prog.setForeground(Color.CYAN);
            performannce.add(new JLabel("Task Progress: "));performannce.add(prog);
            String timeNow=String.valueOf(LocalDateTime.now());
            int dateNow=Integer.parseInt(timeNow.substring(8,10));
            System.out.println(dateNow);
            double overallP= (((double) taskC)/totalTasks)+(((double)daysPresent)/dateNow);
          prog=new JProgressBar(0,100);                       prog.setValue((int)(overallP*50));
          prog.setStringPainted(true);                        prog.setForeground(Color.magenta);
          performannce.add(new JLabel("Overall Performance"));performannce.add(prog);
            ePanel3.add(performannce,"performance");
            empshow.show(ePanel3,"performance");


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
task.addActionListener((e4)->{
    JPanel taskPanel=new JPanel();
    ePanel3.add(taskPanel,"taskPanel");
    conn.dtcConnectmethod(bd,"getTasks");
String[] taskInfo=conn.getTaskInfo();
String[] taskCol=conn.getTaskCol();
    System.out.println("columns: "+taskCol.length);
    System.out.println("tasks: "+taskInfo.length);
Object[][] taskd=new Object[taskInfo.length/taskCol.length][taskCol.length];
int count=0;
for (int i=0;i<taskInfo.length/taskCol.length;i++){
    for (int j=0;j<taskCol.length;j++){
        taskd[i][j]=taskInfo[count];
        count++;
    }
}
JTable table1=new JTable(taskd,taskCol);
JScrollPane ptable=new JScrollPane(table1);
ptable.getViewport();
taskPanel.setLayout(new BorderLayout());
Back=new JMenuItem("Back");
employeeAdminBar.add(Back);
Back.addActionListener((e5)->{
   employeeAdminBar.remove(Back);
   empshow.show(ePanel3,"notice");
});
taskPanel.add(ptable,BorderLayout.CENTER);
empshow.show(ePanel3,"taskPanel");


});




    }

    public void AdminInterface(){
       // JButton Notice=new JButton("Notice settings");
        adminInterface=new JPanel();
        cardPanel.add(adminInterface,"adminInterface");
        cardLayout.show(cardPanel,"adminInterface");
adminInterface.setLayout(new BorderLayout());
        show=new JPanel();                         JPanel buttonP=new JPanel();
       JButton registration=new JButton("Registration Settings");    JButton home=new JButton("Home");
       JButton salary=new JButton("Salary");        JButton employee=new JButton("Employee");
       JButton notice=new JButton("Notice");
     // layout
        buttonP.setLayout(new GridLayout(5,1,5,5));
        buttonP.setBackground(new Color(30,30,40));  buttonP.setForeground(Color.white);
        //add buttons
        buttonP.add(home);                   buttonP.add(registration);
        buttonP.add(employee);               buttonP.add(salary);           buttonP.add(notice);
        // actionListeners
        home.addActionListener((e1)->{
            show.removeAll();
            conn.setTemp_in("View id, name and email");
            JTextArea noticeT=new JTextArea();
            show.setLayout(new GridLayout(1,3,5,5));
            conn.dtcConnectmethod(bd,"retriev employee datal");
            conn.dtcConnectmethod(bd,"getDepartment");
            String[] dept=conn.getAtitles();        int totDep=dept.length;
            String[] email= conn.getEmployeeEml();    int totEmp=email.length;
            System.out.println(email[0]);
            JProgressBar totS=new JProgressBar();
            totS.setString("Employees: "+totEmp);          totS.setStringPainted(true);
                     totS.setValue(totEmp);      totS.setForeground(Color.black);
            show.add(totS);
// department show
             totS=new JProgressBar();   totS.setString("Departments"+totDep);
                       totS.setValue(totDep);      totS.setStringPainted(true);
             show.add(totS);
show.revalidate();
show.repaint();
        });
registration.addActionListener((e3)->{
    show.removeAll();
    JPanel regSetting=new JPanel();
 rP=new JPanel();
    setRegistration=new JButton("set Max Applications");
    Vacancy=new JButton("Add/remove vacancy job titles");
    jobTitles=new JButton("Job Titles");
    addNewVacancy=new JButton("Add new job titles");
    show.setLayout(new BorderLayout());

    setRegistration.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
    Vacancy.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
    addNewVacancy.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
    jobTitles.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
    JLabel regS=new JLabel("Registration Settings");
    regS.setFont(new Font("Arial",Font.ITALIC,50));
    regSetting.add(regS);
    rP.setLayout(new BoxLayout(rP,BoxLayout.Y_AXIS));
    rP.add(setRegistration);
    rP.add(Vacancy);
    rP.add(addNewVacancy);
    rP.add(jobTitles);
    Vacancy.addActionListener(new EmployeeeManipulate());
    setRegistration.addActionListener(new EmployeeeManipulate());
    addNewVacancy.addActionListener(new EmployeeeManipulate());
    jobTitles.addActionListener(new EmployeeeManipulate());
    show.add(rP,BorderLayout.WEST);
    rP.setBackground(new Color(40,50,60));
    show.add(regSetting,BorderLayout.SOUTH);
show.repaint();
show.revalidate();

});




        Registration=new JMenu("Registration");
        reg=new JMenuItem("Open");
        close=new JMenuItem("close");
      // registration.setBorder(new TitledBorder("Registration settings "));
       //File.setBorder(new TitledBorder(""))
        //File.setBackground(new Color(255,153,153));
        Employee=new JPanel();
        Employee.setBackground(new Color(255,153,153));
        Employee.setBorder(new TitledBorder("Employee"));
        adminMenuBar=new JMenuBar();

      //  File.add(setRegistration);


        // setRegistration components







        adminInterface.add(buttonP,BorderLayout.WEST);
        adminInterface.add(show,BorderLayout.CENTER);

        Employee.setLayout(new BoxLayout(Employee,BoxLayout.Y_AXIS));
        loggedin=new JLabel();
        setJMenuBar(adminMenuBar);

        setDefaultCloseOperation(EXIT_ON_CLOSE);





        sendEmail=new JMenu("send Emails");

        addemployee=new JButton("Add Employee");
        updateEmployee=new JButton("Update Employee Data");
        deleteEmployee=new JButton("Delete Employees");
        AcceptEmployee=new JButton("Accept Employee");
       // save=new JButton("Save");


        viewEmployees=new JButton("View Employees");
        addManager=new JButton("Add a Manager");
        deleteManager=new JButton("delete Manager");
        logout=new JMenuItem("Sign Out");


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


        logout.addActionListener(new EmployeeeManipulate());
        viewEmployees.addActionListener(new EmployeeeManipulate());



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
/*if (em.getSource()==addColumn){
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


}*/
 if(em.getSource()==setRegistration){
     BorderLayout layout=(BorderLayout) show.getLayout();
     Component comp1=layout.getLayoutComponent(BorderLayout.CENTER);
     Component comp2=layout.getLayoutComponent(BorderLayout.SOUTH);
     if(comp1!=null){
         show.remove(comp1);
         show.repaint();  show.revalidate();
     }
     if(comp2!=null){
         show.remove(comp2);
         show.repaint();  show.revalidate();
     }
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel submitP=new JPanel();
    rC=new CardLayout();
rcP=new JPanel(rC);
show.add(rcP,BorderLayout.CENTER);
p2.setLayout(new GridLayout(2,1,20,20));
    p1.setBackground(new Color(100,100,255));
    p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
    submitP.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
    JLabel set=new JLabel("set Amount");//flowlayout contents
    JTextField retxt=new JTextField();// flowlaout contents p1
     retxt.setMaximumSize(new Dimension(150,30));
    JButton summit=new JButton("Submit");
    summit.setBackground(Color.gray);
    summit.setPreferredSize(new Dimension(150,30));
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
submitP.add(summit);
     p1.add(set);
     p1.add(retxt);
     p2.add(p1);
     p2.add(submitP);
     rcP.add(p2,"p2");
     rC.show(rcP,"p2");
     rP.revalidate();
     rP.repaint();
}
 else if(em.getSource()==jobTitles){
     titl=new ArrayList<>();
     iD=new ArrayList<>();
     BorderLayout layout=(BorderLayout) show.getLayout();
     Component comp1= layout.getLayoutComponent(BorderLayout.CENTER);
     Component comp2=layout.getLayoutComponent(BorderLayout.SOUTH);
     if(comp1!=null){show.remove(comp1);}
     if(comp2!=null){show.remove(comp2);}
     conn.dtcConnectmethod(bd,"get all E titles");
     JPanel tableP=new JPanel();
     JPanel buttonP=new JPanel();
     JButton delete=new JButton("Remove from list");
     submit=new JButton("Add to Vacancy Jobs");
     tableP.setLayout(new BorderLayout());
     buttonP.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
submit.setPreferredSize(new Dimension(170,50));
delete.setPreferredSize(new Dimension(170,50));
     buttonP.add(submit);buttonP.add(delete);
submit.setBackground(Color.green);   delete.setBackground(Color.red);
     String[] tit=conn.getEtitles();
     String[] ids=conn.getIds();
     String[] col={"Id","Titles"};
     Object[][] data=new Object[tit.length][2];
     for (int i=0;i<tit.length;i++){
         data[i][0]=ids[i];
         data[i][1]=tit[i];
     }
     JTable tabl=new JTable(data,col);
     JScrollPane p0=new JScrollPane(tabl);
tableP.add(p0,BorderLayout.CENTER);
tableP.add(buttonP,BorderLayout.SOUTH);
show.add(tableP,BorderLayout.CENTER);
show.repaint(); show.revalidate();
// actionlisteners
     ListSelectionModel model=tabl.getSelectionModel();
     model.addListSelectionListener((li)->{
int ind=tabl.getSelectedRow();
if (titl.size()==0){
    titl.add(tit[ind]);
    iD.add(ids[ind]);
}
for (int i=0;i<titl.size();i++){
    if(!(titl.get(i).equals(tit[ind]))){
        titl.add(tit[ind]);
        iD.add(ids[ind]);}}
     });
     delete.addActionListener((de)->{
         int input=JOptionPane.showConfirmDialog(null,"Are you sure you want to completely delete the selected job titles?", "Warning",JOptionPane.YES_NO_CANCEL_OPTION);
         if (input==JOptionPane.YES_OPTION){
             for (int i=0;i<iD.size();i++){
                 conn.setId(iD.get(i));
                 System.out.println(iD.get(i));
                 conn.dtcConnectmethod(bd,"delete job title");
             }
         }

         JOptionPane.showMessageDialog(null,conn.getResult());
     });
submit.addActionListener((as)->{
    conn.dtcConnectmethod(bd,"getAdminTitles");
    String[] chc=conn.getEtitles();
    int count=0;
    for (int i=0;i<titl.size();i++){
        boolean chk=true;
        for(int j=0;j<chc.length;j++){
            if(chc[j].equals(titl.get(i))){
                chk=false; break;
            }
        }
        if(chk==true){    conn.setVacanyadd(titl.get(i));
            conn.dtcConnectmethod(bd,"setAdminTitles");
            JOptionPane.showMessageDialog(null,conn.getResult());
            count++;
            break;}
        else{
            JOptionPane.showMessageDialog(null,"some of the selected titles have already been added. Number of titles added: "+count);
            break;}
    }
});
 }
else if (em.getSource()==Vacancy){
     titl=new ArrayList<>();
     iD=new ArrayList<>();
    BorderLayout layout=(BorderLayout) show.getLayout();
    Component comp1=layout.getLayoutComponent(BorderLayout.CENTER);
    Component comp2=layout.getLayoutComponent(BorderLayout.SOUTH);
    if (comp1!=null){show.remove(comp1); }
    if(comp2!=null){show.remove(comp2);}
     show.revalidate();show.repaint();
   JPanel vacancySet=new JPanel();
    JButton delete=new JButton("remove");
     JPanel bP=new JPanel();
    vacancySet.setLayout(new BorderLayout());
  bP.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
    conn.dtcConnectmethod(bd,"getAdminTitles");
    titls=conn.getEtitles();
    String[] ids=conn.getIds();
    String[] ta={"Id","Names"};
    Object[][] atitles=new Object[titls.length][2];
    for (int i=0;i<titls.length;i++){
        atitles[i][0]=ids[i];
        atitles[i][1]=titls[i];
    }
    JTable titleTable=new JTable(atitles,ta);
    titleTable.getTableHeader().setBounds(0,0,400,30);
    JScrollPane titlePane=new JScrollPane(titleTable);
    vacancySet.add(titlePane,BorderLayout.CENTER);
//submit=new JButton("add the selected Titles");
//bP.add(submit);
bP.add(delete);
delete.setPreferredSize(new Dimension(150,70));
submit.setPreferredSize(new Dimension(150,70));
//submit.setBackground(Color.green);
delete.setBackground(Color.red);            delete.setForeground(Color.white);
vacancySet.add(bP,BorderLayout.SOUTH);


ListSelectionModel model=titleTable.getSelectionModel();
model.addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!model.isSelectionEmpty()){
            int ind=titleTable.getSelectedRow();
            JOptionPane.showMessageDialog(null,"You have selected "+titls[ind]);
            if (titl.size()==0){
                titl.add(titls[ind]);
                iD.add(ids[ind]);
            }
            for (int i=0;i<titls.length+1;i++){
if(!(titl.contains(titls[ind]))){
                    iD.add(String.valueOf(ids[ind]));
                    titl.add(titls[ind]);

                }
            }}}});
/*submit.addActionListener((ec)->{
    for (int i=0;i<titl.size();i++){
        conn.dtcConnectmethod(bd,"getAdminTitles");
        String[] chc=conn.getEtitles();
        boolean chk=true;
        for(int j=0;j<chc.length;j++){
            if(chc[j].equals(titl.get(i))){
                chk=false;
            }
        }
        if(chk==true){    conn.setVacanyadd(titl.get(i));
            conn.dtcConnectmethod(bd,"setAdminTitles");
        JOptionPane.showMessageDialog(null,conn.getResult());
        break;}
        else{
            JOptionPane.showMessageDialog(null,"some of the selected titles have already been added");
            break;
        }
    }

});*/
delete.addActionListener((de)->{
    int input=JOptionPane.showConfirmDialog(null,"Are you sure you want to completely delete the selected job titles?", "Warning",JOptionPane.YES_NO_CANCEL_OPTION);
if (input==JOptionPane.YES_OPTION){
    for (int i=0;i<iD.size();i++){
        conn.setId(iD.get(i));
        System.out.println(iD.get(i));
    conn.dtcConnectmethod(bd,"delete vacancy");
}
}

    JOptionPane.showMessageDialog(null,conn.getResult());
});
show.add(vacancySet,BorderLayout.CENTER);
vacancySet.repaint();
vacancySet.revalidate();

}
else if(em.getSource()==addNewVacancy){
    BorderLayout layout=(BorderLayout) show.getLayout();
    Component comp1=layout.getLayoutComponent(BorderLayout.CENTER);
    Component comp2=layout.getLayoutComponent(BorderLayout.SOUTH);
    if(comp1!=null){
        show.remove(comp1);
        show.repaint();  show.revalidate();
    }
     if(comp2!=null){
         show.remove(comp2);
         show.repaint();  show.revalidate();
     }
    JTextField newV=new JTextField();              JLabel vacL=new JLabel("Name");
JPanel fieldP=new JPanel();
JPanel bPcont=new JPanel();                        JPanel bP=new JPanel();
JPanel top=new JPanel();
submit=new JButton("Add");

     // layouts
     fieldP.setLayout(new FlowLayout());
     fieldP.setBackground(new Color(100,100,255));
     bPcont.setLayout(new GridLayout(3,1,10,10));
     bP.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
     fieldP.add(vacL); fieldP.add(newV);
     submit.setBackground(Color.green);
     newV.setPreferredSize(new Dimension(200,30));
     submit.setPreferredSize(new Dimension(150,40));
     bP.add(submit);bPcont.add(top);
     bPcont.add(fieldP);bPcont.add(bP);
     submit.addActionListener((es)->{
         if ((newV.getText().toString())!=null) {
             conn.dtcConnectmethod(bd,"get all E titles");
             String newTitle=newV.getText().toString();
             String [] alltitles=conn.getAtitles();
            for (int i=0;i<alltitles.length;i++){
                if(alltitles[i].equals(newTitle)){
                    JOptionPane.showMessageDialog(null,"The job title already exists");
                    break;}
                else{conn.setTitle(newTitle);
                    conn.dtcConnectmethod(bd,"add new title");
                    JOptionPane.showMessageDialog(null,conn.getResult());
                break;}}
         }else{JOptionPane.showMessageDialog(null,"Invalid entry");}});
     show.add(bPcont,BorderLayout.CENTER);            show.revalidate();show.repaint();}

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
            }  else if (em.getSource() == viewEmployees) {

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

/*if (e.getSource()==tables){
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



}*/
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

    }
public static void main(String [] args){
        new LoginGUI();
}}


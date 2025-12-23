import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LoginGUI extends JFrame implements DatabasemethodsInterface{
 private JMenuItem close;
    private JMenuItem reg;
   private String[] empName=new String[0];
   private String[] empEmail=new String[0];
    int[] indeces=new int[0];
    private JMenuItem reload;
    private JMenuItem Back;
    private JPanel cardPanel;
    private CardLayout cardLayout;
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

    if (conn.getResult().equals("Open")){
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
        //firstPanel.setVisible(false);
        employeeInterface=new JPanel();
       cardPanel.add(employeeInterface,"employeeInterface");
        cardPanel.add(employeeInterface);
        adminMenuBar.add(back);
        cardLayout.show(cardPanel,"employeeInterface");
        loggedin=new JLabel("hello Frans");
        employeeInterface.setBackground(Color.YELLOW);
        employeeInterface.setLayout(null);
        employeeInterface.setLocation(300,300);
       // container.add(employeeInterface);
       // container.revalidate();
       // container.repaint();
        employeeInterface.setVisible(true);
    }

    public void AdminInterface(){
     // firstPanel.setVisible(false);

        //container.removeAll();
        adminInterface=new JPanel();
        cardPanel.add(adminInterface,"adminInterface");
        cardLayout.show(cardPanel,"adminInterface");
adminInterface.setLayout(new GridLayout(1,2,6,6));
back=new JButton("Back");
        File=new JPanel();
        Registration=new JMenu("Registration");
        reg=new JMenuItem("Open");
        close=new JMenuItem("close");
        File.setBorder(new TitledBorder("File"));
        File.setBackground(new Color(255,153,153));
        Employee=new JPanel();
        Employee.setBackground(new Color(255,153,153));
        Employee.setBorder(new TitledBorder("Employee"));
       // Registration=new JPanel();
        Registration.setBackground(new Color(255,153,153));
       // Registration.setBorder(new TitledBorder("Registration"));
        adminMenuBar=new JMenuBar();

        adminInterface.add(File);
        adminInterface.add(Employee);
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
        addColumn=new JRadioButton("Add Feature to the Employees");
        deleteColumn=new JRadioButton("Delete Employees Feature");
        addTable=new JRadioButton("Create new Table");
        viewEmployees=new JRadioButton("View Employees");
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
        File.add(save);
      //  File.add(viewEmployees);
        File.add(addColumn);
        File.add(deleteColumn);
        File.add(addTable);
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
        addColumn.addActionListener(new EmployeeeManipulate());
        deleteColumn.addActionListener(new EmployeeeManipulate());
        addTable.addActionListener(new EmployeeeManipulate());
        save.addActionListener(new EmployeeeManipulate());
        updateEmployee.addActionListener(new EmployeeeManipulate());
        deleteEmployee.addActionListener(new EmployeeeManipulate());
        addemployee.addActionListener(new EmployeeeManipulate());



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
else if (em.getSource()==deleteColumn){

}
else if (em.getSource()==save){

}
//else if (em.getSource()==Registration){

//}
else if (em.getSource()==updateEmployee){

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
   /* for (int i=0;i<empName.length;i++){
emdata[i][0]=empName[i];
emdata[i][1]=empEmail[i];
        tobeused[i]=empName[i]+"      Email: "+empEmail[i];}*/

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



    JList<String> empl=new JList<>(tobeused);
    JList<String> email=new JList<>(empEmail);
    empl.setBackground(new Color(23,255,133));
    empl.setFont(new Font("Arial",Font.PLAIN,14));
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
            empName=conn.getApplicantName();
            empEmail =conn.getApplicantEmail();

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
                for(int i=0;i<inemail.length;i++){
                    String takenemail=inemail[i];
                    conn.setTakenemail(takenemail);
                    conn.dtcConnectmethod(bd,"applcnto data");
                    String[] adata=conn.getApplicantdt();

                    EmployeeBasicDetails ad=new EmployeeBasicDetails( adata[2], adata[3],adata[4], Integer.parseInt(adata[5]),
                            Integer.parseInt(adata[6]), Integer.parseInt(adata[7]), adata[8], adata[9], adata[10],adata[11],
                            adata[12], Integer.parseInt(adata[13]), adata[14].charAt(0),adata[15],adata[16],adata[17]);

                    conn.dtcConnectmethod(ad,"add employee");
                    conn.dtcConnectmethod(bd,"delete employee data");
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
    empEmail=conn.getApplicantEmail();
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
                    conn.dtcConnectmethod(bd,"delete employee data");
                  //  String[] adata=conn.getApplicantdt();
                    JOptionPane.showMessageDialog(null,conn.getResult());
                }


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
                if(value.equals("Access Granted")&& identity.equals("RealAdmin")){
AdminInterface();
                }
                else if(value.equals("Access Granted")&& !(identity.equals("RealAdmin"))){
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
    public void registr(){
      JPanel RegistrationInterface=new JPanel();
      cardPanel.add(RegistrationInterface,"RegistrationInterface");
      cardLayout.show(cardPanel,"RegistrationInterface");
      RegistrationInterface.setBackground(Color.ORANGE);
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
      JTextField maritalStatus=new JTextField();JLabel Maritalst=new JLabel("Marital Status");
      JTextField AddressCountry=new JTextField();JLabel country=new JLabel("Country");
     JTextField City=new JTextField();JLabel city=new JLabel("City");
     JTextField kebele=new JTextField();JLabel Keble=new JLabel("Kebele");
     JComboBox employeetype=new JComboBox();JLabel type=new JLabel("JobTitle");
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
     RegistrationInterface.add(skill);RegistrationInterface.add(Skills);
     RegistrationInterface.add(postal);RegistrationInterface.add(postal_code);RegistrationInterface.add(gen);;RegistrationInterface.add(Gender);
    RegistrationInterface.add(qualification);RegistrationInterface.add(Qualifications);RegistrationInterface.add(passw);RegistrationInterface.add(password);
RegistrationInterface.add(confPass);RegistrationInterface.add(confpassw);

     //JTextField employeetype=new JTextField("")

    }
   // public static void ErrorShow(){

 //   }
public static void main(String [] args){
        new LoginGUI();
}}


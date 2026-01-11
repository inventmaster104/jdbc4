package ProjectEMS;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class ManagerInterface extends JPanel{
    private ArrayList<String> Aname;
   private ArrayList<String> gArray=new ArrayList<>(0);
   private ArrayList<String> tobeUpdate;
   private String[] name;
   private String[] Id;
private ArrayList<String> pending;
    private String paymentType;
    private  int loginid;
    private String dept;
    private String Name;
    private String empType;
    private JTextArea generalInfo;
    private String wFormat;
    private String email;
    String [] description;
    String [] taskArray;
    JMenuItem Back;
    JMenuItem logout;
    private JPanel managerInterface;
    private JMenuBar managerBar;
    private JPanel cardPanel;
    private CardLayout mcardLayout;
    EmployeeBasicDetails bd=new EmployeeBasicDetails();
    DataBaseConnector conn=new DataBaseConnector();
    Manager man=new Manager();
    public ManagerInterface(){
        this.setLayout(new BorderLayout());
        mcardLayout=new CardLayout();
        managerInterface=new JPanel();
        this.add(managerInterface);

        conn.dtcConnectmethod(bd,"calculate time");
        conn.dtcConnectmethod(bd,"getNotice");
        System.out.println("empl");

        email=LoginInterface.checkemail;
        conn.setLoginEmail(email);
        conn.dtcConnectmethod(bd,"get employee general data");
        loginid=conn.getLoginid();
        paymentType=conn.getPaymentType();
        wFormat=conn.getwFormat();
        Name=conn.getloginName();
        dept=conn.getDepartment();
        empType=conn.getEmployeeType();
        generalInfo=new JTextArea();
        System.out.println("this is payment"+paymentType);
        System.out.println("this is anme"+Name);
        System.out.println("this is dept"+dept);
        System.out.println("this is emptype"+empType);


        if(paymentType.equals("Monthly")){
            //  conn.setEmployeeType(empType);
            conn.dtcConnectmethod(bd,"retrieve salary rate");
            double msalary=conn.getSalary();
            System.out.println("this is ssalry"+msalary);
            MonthlyPay monthlyPay=new MonthlyPay(Name,msalary,empType,dept,wFormat);
            generalInfo.setText(monthlyPay.printData());
            System.out.println(monthlyPay.printData());
            generalInfo.setFont(new Font("Arial",Font.BOLD,14));
        }
        else if (paymentType.equals("Hourly")){
            conn.dtcConnectmethod(bd,"retrieve salary rate");
            conn.dtcConnectmethod(bd,"");
            double hsalary=conn.getSalary();
            double hrs=conn.getTotalTime();
            System.out.println(hsalary);
            HourlyPay hpay=new HourlyPay(Name,hsalary,hrs,wFormat,empType,dept);
            System.out.println(hpay.printData());
            generalInfo.setText(hpay.printData());
            generalInfo.setFont(new Font("Arial",Font.BOLD,14));
        }


            cardPanel=new JPanel(mcardLayout);
            managerInterface.setLayout(new BorderLayout());
            managerBar=new JMenuBar();
            JButton roles=new JButton("Assign roles");
            JButton recommendations=new JButton("Give Recommendations");
            JButton leaveR=new JButton("Leave Requests");
            JButton dashBoard=new JButton("DashBoard");
            // panels
            JPanel mbutP=new JPanel();
        JPanel totP=new JPanel();// for the buttons
           // JPanel mhome=new JPanel();// for showing tables and notices

            JPanel showP=new JPanel();//for saying hello to the manager
            JPanel m12=new JPanel(); // to contain both m1 and m2
            JPanel space=new JPanel();
          //  managerInterface.add(mhome,"home");

            JTextArea tm=new JTextArea();
            tm.setText("Today's News"+"Notice\n"+"The US will control sales of sanctioned Venezuelan oil \"indefinitely\" as it prepares to roll back restrictions on the country's crude in global markets, the White House said.\n" +
                    "\n" +
                    "Officials said sales were expected to start with 30 million to 50 million barrels of oil and the revenue would be controlled by the US government in order to maintain clout over the Venezuelan government.\n" +
                    "\n" +
                    "\"We need to have that leverage and control of those oil sales to drive the changes that simply must happen in Venezuela,\" Energy Secretary Chris Wright said.\n" +
                    "\n" +
                    "It is not clear what portion of the revenues from the sale - which analysts expect to raise about $2.8bn (£2.1bn) - would be shared with Venezuela.\n" +
                    "\n" +
                    "While White House press secretary Karoline Leavitt said the two sides had struck a deal, Venezuela's state-run oil company PDVSA said in a statement that negotiations over oil sales were ongoing within the framework that exists between the two countries.\n" +
                    "\n" +
                    "\"This process is based on similar rules to those in force with international companies,\" it said.\n" +
                    "\n" +
                    "The comments came after US President Donald Trump announced on social media on Tuesday that Venezuela would be \"turning over\" up to 50 million barrels of oil to the US, and it would be sold at its market price");
            tm.setFont(new Font("Times New Roman",Font.BOLD,20));
            //jmenu items


        conn.dtcConnectmethod(bd,"retriev employee datal");
        conn.dtcConnectmethod(bd,"get total leave requests");
       String[] email=conn.getEmployeeEml();
        System.out.println("this "+email.length);
        int tote=email.length;
        int totl=0;
        ArrayList<String> leave=conn.getPending();
        for (int i=0;i<leave.size();i++){
            if(leave.get(i).equals("Pending")){
                totl++;
            }
        }


        totP.setLayout(new FlowLayout(0,10,10));
        m12.setLayout(new GridLayout(2,1,10,10));

        JProgressBar totShow=new JProgressBar();
        totShow.setFont(new Font("Arial",Font.BOLD,16));
        totShow.setStringPainted(true);   totShow.setString("Total Employees: ");
        totShow.setValue(tote);totShow.setForeground(new Color(100,150,200));
        totShow.setPreferredSize(new Dimension(300,100));
        totP.add(totShow);
        totShow=new JProgressBar();
        totShow.setFont(new Font("Arial",Font.BOLD,16));
        totShow.setStringPainted(true);   totShow.setString("Resign Requests: "+totl);
        totShow.setValue(totl);totShow.setForeground(new Color(100,150,200));
        totShow.setPreferredSize(new Dimension(300,100));
        totP.add(totShow);




            logout=new JMenuItem("Signout");
            managerBar.add(logout);
            logout.setBackground(Color.red);
            //panel components

            mbutP.setLayout(new BoxLayout(mbutP,BoxLayout.Y_AXIS));
            mbutP.setBackground(new Color(23,150,240));
            showP.setLayout(new GridLayout(2,1,10,10));
            space.setBackground(Color.gray);
            mbutP.add(dashBoard);
            mbutP.add(roles);
            mbutP.add(recommendations);
            mbutP.add(leaveR);


            dashBoard.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
            roles.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
            recommendations.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
           leaveR.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));

            showP.add(totP);
            //showP.add(space);
            showP.add(tm);
            cardPanel.add(showP,"show");
            mcardLayout.show(cardPanel,"show");
           // m4.setLayout(new BorderLayout());
            managerInterface.add(mbutP,BorderLayout.WEST);
            managerInterface.add(cardPanel,BorderLayout.CENTER);

// actionlisteners
            logout.addActionListener((et)->{
                managerBar.removeAll();
               // mcardLayout.show(cardPanel,"firstPanel");
            });
            dashBoard.addActionListener((ds)->{
                cardPanel.add(showP,"show");
                mcardLayout.show(cardPanel,"show");
            });
            leaveR.addActionListener((lr)->{
                JButton approve=new JButton("Approve Request");
                JButton reject=new JButton("Reject Request");
                JPanel bP=new JPanel();
                tobeUpdate=new ArrayList<>(0);
                Aname=new ArrayList<>(0);
                JPanel tableP=new JPanel();
                tableP.setLayout(new BorderLayout());
                bP.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
                bP.add(approve);bP.add(reject);
                approve.setPreferredSize(new Dimension(150,30));
                reject.setPreferredSize(new Dimension(150,30));
                approve.setBackground(Color.green);
                reject.setBackground(Color.red);
                cardPanel.add(tableP,"tablePanel");
                mcardLayout.show(cardPanel,"tablePanel");
                pending=new ArrayList<>(0);
                gArray=new ArrayList<>(0);
                name=new String[0];
                Id=new String[0];
                conn.dtcConnectmethod(bd,"get total leave requests");

                gArray=conn.getReason();
                System.out.println(gArray.get(0));
                Aname=conn.getAname();
                System.out.println("aname");
                System.out.println(Aname.get(0));
                Id=conn.getIds();
                System.out.println("id");
                System.out.println(Id[0]);
                pending=conn.getPending();
                System.out.println("penidn");
                System.out.println(pending.get(0));
                System.out.println(Id.length);
                Object[][] leavedata=new Object[Id.length][4];
                for (int i=0;i<Id.length;i++){
                    leavedata[i][0]=Id[i];
                    leavedata[i][1]=Aname.get(i);
                    leavedata[i][2]=pending.get(i);
                    leavedata[i][3]=gArray.get(i);

                }
                String[] cols={"Employee Id","Name","Status","Reason for resign"};
                JTable ltable=new JTable(leavedata,cols);
                JScrollPane lpane=new JScrollPane(ltable);
                lpane.getViewport();
                tableP.add(lpane,BorderLayout.CENTER);
                tableP.add(bP, BorderLayout.SOUTH);
ListSelectionModel model=ltable.getSelectionModel();
model.addListSelectionListener((ls)->{
   int choice=JOptionPane.showConfirmDialog(null,"you have chosen "+Aname.get(ltable.getSelectedRow()),"Confirm your choice",JOptionPane.YES_NO_OPTION);
if(JOptionPane.YES_OPTION==choice){
    tobeUpdate.add(Id[ltable.getSelectedRow()]);
}
    showP.repaint();
    showP.revalidate();
});
     approve.addActionListener((ap)->{
         for (int i=0;i<tobeUpdate.size();i++){
             conn.dtcConnectmethod(new EmployeeBasicDetails(tobeUpdate.get(i)),"approve resignation");
         }
     });
     reject.addActionListener((re)->{
         for (int i=0;i<tobeUpdate.size();i++){
             conn.dtcConnectmethod(new EmployeeBasicDetails(tobeUpdate.get(i)),"reject resignation");
         }
     });
            });
            roles.addActionListener((es)->{
                JPanel m5=new JPanel();

                conn.setTemp_in("View id, name and email");
                conn.dtcConnectmethod(bd,"retriev employee datal");
                String[] cols= {"Id","Name","Email"};
                String[] emails=conn.getEmployeeEml();
                System.out.println(emails[0]);


               String[] empName=conn.getViewEmployeeName();

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
                cardPanel.add(m5,"m5");
                mcardLayout.show(cardPanel,"m5");
                Back=new JMenuItem("Back");
                managerBar.add(Back);
                Back.setBackground(Color.magenta);
                Back.addActionListener((e6)->{
                    managerBar.remove(Back);
                    mcardLayout.show(cardPanel,"mhome");
                });
                ListSelectionModel model=showt.getSelectionModel();
                model.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if(!model.isSelectionEmpty()){
                            // man.setId(String.valueOf(ids[model.getMinSelectionIndex()]));
                            System.out.println("the id is gui is"+String.valueOf(ids[model.getMinSelectionIndex()]));
                             taskArray=new String[0];
                           String [] titles=new String[0];
                            JPanel tsk=new JPanel();
                            JPanel po=new JPanel();// contain the label and the text field
                            JPanel bcont=new JPanel();// contain the buttons
                            JPanel space=new JPanel();
                            cardPanel.add(tsk,"tsk");
                            mcardLayout.show(cardPanel,"tsk");
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
                            showP.add(p0);
                            // colors
                            addtsk.setBackground(Color.cyan);
                            setTask.setBackground(new Color(150,200,250));
                            // actionlisteners
                            Back.addActionListener((e5)->{
                                managerBar.remove(Back);
                                mcardLayout.show(cardPanel,"m5");
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
                               String[] date=man.date; taskArray=man.title;description=man.des;
                               String chk=man.result;
                               if(chk.equals("good")){
                                   Manager man0=new Manager(taskArray,description,date,String.valueOf(ids[model.getMinSelectionIndex()]));
                                   JOptionPane.showMessageDialog(null,man0.result);
                                   f1.setText("");f2.setText("");f3.setText("");
                               }
                               else{
                                   JOptionPane.showMessageDialog(null,"Invalid entry! Please use the yyyy/mm/dd structure");
                               }

                            });

                        }
                    }
                });
            });}
    public void setEmail(String eml){
        email=eml;
    }
}


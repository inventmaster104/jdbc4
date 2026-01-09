package ProjectEMS;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class ManagerInterface extends JPanel{
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
        totShow.setStringPainted(true);   totShow.setString("Pending leaves: ");
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
            });}}


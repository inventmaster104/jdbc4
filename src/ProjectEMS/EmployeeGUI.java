package ProjectEMS;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EmployeeGUI extends JPanel {
    private JMenuItem Back;
    private JPanel menuPanel;
    private JMenuBar employeeAdminBar;
    private JPanel employeeInterface;
    private CardLayout empshow;
    private JMenuItem logout;
    private Employee_Login log=new Employee_Login();
    private EmployeeBasicDetails bd=new EmployeeBasicDetails();
    private DataBaseConnector conn=new DataBaseConnector();
    public EmployeeGUI(){
        this.setLayout(new BorderLayout());
        employeeInterface=new JPanel();

        this.add(employeeInterface);
        empshow=new CardLayout();
        menuPanel=new JPanel();
        employeeInterface.setLayout(new BorderLayout());

        JPanel ePanel1=new JPanel();                  JPanel ePanel2=new JPanel();
        JPanel ePanel3=new JPanel(empshow);
        JPanel buttonP=new JPanel();                  JPanel ePanel5=new JPanel();

        employeeAdminBar=new JMenuBar();
        menuPanel.add(employeeAdminBar);
       // this.add(menuPanel,BorderLayout.NORTH);



        conn.dtcConnectmethod(bd,"getTasks");
        conn.dtcConnectmethod(bd,"calculate time");
        conn.dtcConnectmethod(bd,"getNotice");
        JPanel performannce=new JPanel();
        JPanel dashBoard=new JPanel();
        JTextArea tA=new JTextArea();
        JScrollPane textP=new JScrollPane(tA);
       dashBoard.setLayout(new GridLayout(2,1,0,20));
       performannce.setLayout(new FlowLayout(0,10,30));
       // tA.setText(conn.getNotice());
        tA.setFont(new Font("Arial",Font.BOLD,16));
        tA.setText("Exactly 31 years ago to the day, two Kenyan pilots, Hussein Mohamed Anshuur and Mohamed Adan, received an unexpected visitor at their office at Wilson Airport near the capital, Nairobi.\n" +
                "\n" +
                "It was a Nigerian diplomat, who drew them into a sensitive and secretive mission to fly the body of Somalia's former ruler Siad Barre back to his homeland for burial following his death in exile in Nigeria at the age of 80.\n" +
                "\n" +
                "Anshuur, previously a captain in the Kenyan Air Force, and Adan are partners in Bluebird Aviation, one of Kenya's largest private airlines that they had set up a few years earlier.\n" +
                "\n" +
                "Speaking to the media for the first time about the mission, Anshuur told the BBC that the Nigerian diplomat came \"straight to the point\", asking him and Hussein \"to charter an aircraft and secretly transport the body\" from Nigeria's main city of Lagos, to Barre's hometown of Garbaharey in southern Somalia for burial, on the other side of Africa, a distance of some 4,300 km (2,700 miles).\n" +
                "\n" +
                "Anshuur said they were stunned at the request: \"We knew immediately this wasn't a normal charter.\"\n" +
                "\n" +
                "Barre had fled Somalia on 28 January 1991 after being overthrown by militia forces, so returning his body was politically fraught, involving multiple governments, fragile regional relations and the risk of a diplomatic fallout. This process is based on similar rules to those in force with international companies,\\\" it said.\\n\" +\n" +
                "                \"\\n\" +\n" +
                                "The comments came after US President Donald Trump announced on social media on Tuesday that Venezuela would be turning over up to 50 million barrels of oil to the US, and it would be sold at its market price");
       tA.setWrapStyleWord(true);tA.setLineWrap(true);

        int daysPresent=conn.getdaysPresent();             int taskC=conn.getTaskComplete();
        JProgressBar prog=new JProgressBar(0,30);          prog.setValue(daysPresent);
        prog.setStringPainted(true);                       prog.setForeground(Color.GREEN);
        performannce.add(new JLabel("Attendance"));   performannce.add(prog);
        prog.setPreferredSize(new Dimension(200,100));
        int totalTasks=conn.getTaskInfo().length/conn.getTaskCol().length;
        prog=new JProgressBar(0,totalTasks);               prog.setValue(taskC);
        prog.setStringPainted(true);                       prog.setForeground(Color.CYAN);
        prog.setPreferredSize(new Dimension(200,100));
        performannce.add(new JLabel("Task Progress: "));performannce.add(prog);
        String timeNow=String.valueOf(LocalDateTime.now());
        int dateNow=Integer.parseInt(timeNow.substring(8,10));
        System.out.println(dateNow);
        double overallP= (((double) taskC)/totalTasks)+(((double)daysPresent)/dateNow);
        prog=new JProgressBar(0,100);                       prog.setValue((int)(overallP*50));
        prog.setStringPainted(true);                        prog.setForeground(Color.magenta);
        prog.setPreferredSize(new Dimension(200,100));
        performannce.add(new JLabel("Overall Performance"));performannce.add(prog);
        dashBoard.add(performannce);dashBoard.add(textP);
        ePanel3.add(dashBoard,"dashBoard");
        empshow.show(ePanel3,"dashBoard");




        JLabel welcome=new JLabel("Hi "+conn.getloginName());
        logout=new JMenuItem("Signout");
        JButton home=new JButton("Home"); home.setBackground(Color.blue);
        JButton attendance=new JButton("Attendance");attendance.setBackground(Color.blue);
        JButton vacation=new JButton("Vacation");vacation.setBackground(Color.blue);
        JButton resign=new JButton("Resign");resign.setBackground(Color.blue);
        JButton task=new JButton("Tasks");task.setBackground(Color.blue);
        JButton personaFile= new JButton("Personal File");personaFile.setBackground(Color.blue);
        JButton leaveR=new JButton("Request Leave");leaveR.setBackground(Color.blue);

        home.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        attendance.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        vacation.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        resign.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        task.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        personaFile.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));


        JTextArea notice=new JTextArea();
        notice.setFont(new Font("Times New Roman",Font.BOLD,18));
        notice.setText("Notice Board");
        employeeAdminBar=new JMenuBar();

        ePanel2.setLayout(new BorderLayout());


        buttonP.setLayout(new BoxLayout(buttonP,BoxLayout.Y_AXIS));
//ePanel4.add(welcome);
        ePanel1.setBackground(Color.red);
        ePanel1.setLayout(new FlowLayout());
        buttonP.add(home);              buttonP.add(attendance);
        buttonP.add(vacation);          buttonP.add(resign);
        buttonP.add(task);              buttonP.add(personaFile);
        buttonP.add(leaveR);        ePanel3.add(notice,"notice");

       // empshow.show(ePanel3,"notice");
        JScrollPane p1=new JScrollPane(ePanel3);
        // panel colors
        ePanel1.setBackground(new Color(39,108,245));
        ePanel3.setBackground(new Color(10,200,80));

        ePanel5.setLayout(new BorderLayout());               ePanel5.add(ePanel1,BorderLayout.NORTH);
        ePanel5.add(p1,BorderLayout.CENTER);                 ePanel2.add(ePanel5,BorderLayout.CENTER);
        employeeInterface.add(buttonP, BorderLayout.WEST);             buttonP.setBackground(Color.cyan);
//ePanel4.setBounds(300,400,300,400);

        employeeInterface.add(ePanel2);
        employeeInterface.revalidate();
        employeeInterface.repaint();


        // button actionlisteners
        home.addActionListener((eh)->{


        });
        leaveR.addActionListener((ep)->{



        });





        home.addActionListener((e)->{
            String name=conn.getloginName();
            empshow.show(ePanel3,"dashBoard");
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
}

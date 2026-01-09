package ProjectEMS;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdminInterface extends JPanel implements EmployeeMInterface {
    JPanel barCont;
    private int indeces[]=new int[0];
    private String[] inemail;
    List<String> inputs= new ArrayList<>(0);
    private String[] empName;
    private String[] empEmail;
    String[] titls;
    private ArrayList<String> titl=new ArrayList<>(0);
    private ArrayList<String> iD=new ArrayList<>(0);

    private JButton addemployee;
    private JButton updateEmployee;
    private JButton deleteEmployee;
    private JButton AcceptEmployee;
    private JButton viewEmployees;
    private JButton promoteEmployee;
    private JButton  demoteEmployee=new JButton("Demote Employee");
    private CardLayout cdl;
    private CardLayout rC;
    private JPanel rcP;
    private JPanel cdP;
    private JPanel rP;
    private JPanel adminInterface;
    private CardLayout cardLayout;
    private JPanel show;
    private JMenuItem Back;
    private JButton submit;
    private JMenuBar adminMenuBar;
    private JMenuItem Registration;
    JMenuItem logout;
    private JButton setRegistration;
    private JButton Vacancy;
    private JButton jobTitles;
    private JButton addNewVacancy;


    DataBaseConnector conn=new DataBaseConnector();
    Employee_Login log=new Employee_Login();
    EmployeeBasicDetails bd=new EmployeeBasicDetails();
    public AdminInterface(){
        // JButton Notice=new JButton("Notice settings");

        cardLayout=new CardLayout();
        adminInterface=new JPanel();
        show=new JPanel(cardLayout);
        this.setLayout(new BorderLayout());
        this.add(adminInterface);
        JPanel buttonP=new JPanel();
        adminInterface.setLayout(new BorderLayout());


        JButton registration=new JButton("Registration Settings");    JButton home=new JButton("Home");
        JButton salary=new JButton("Salary");        JButton employee=new JButton("Employee");
        JButton notice=new JButton("Notice");
        // layout
        buttonP.setLayout(new GridLayout(5,1,5,5));

        buttonP.setBackground(new Color(30,30,40));  buttonP.setForeground(Color.white);
        //add buttons
        buttonP.add(home);                   buttonP.add(registration);
        buttonP.add(employee);               buttonP.add(salary);           buttonP.add(notice);
        home.setBackground(new Color(50,100,250)); employee.setBackground(new Color(50,100,250));
        registration.setBackground(new Color(50,100,250)); notice.setBackground(new Color(50,100,250));
        salary.setBackground(new Color(50,100,250));

        adminInterface.add(show,BorderLayout.CENTER);
        adminInterface.add(buttonP,BorderLayout.WEST);


        conn.setTemp_in("View id, name and email");
        JTextArea noticeT=new JTextArea();
        noticeT.setText("Notice\n"+"The US will control sales of sanctioned Venezuelan oil \"indefinitely\" as it prepares to roll back restrictions on the country's crude in global markets, the White House said.\n" +
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
        noticeT.setFont(new Font("Arial",Font.BOLD,16));
        JScrollPane tP=new JScrollPane(noticeT);
        noticeT.setLineWrap(true);
        noticeT.setWrapStyleWord(true);
        JPanel totP=new JPanel();
        totP.setLayout(new FlowLayout(0,10,10));
        show.setLayout(new GridLayout(2,1,5,5));
        conn.dtcConnectmethod(bd,"retriev employee datal");
        conn.dtcConnectmethod(bd,"getDepartment");
        String[] dept=conn.getAtitles();        int totDep=dept.length;
        String[] email= conn.getEmployeeEml();    int totEmp=email.length;
        JProgressBar totS=new JProgressBar();
        totS.setFont(new Font("Arial",Font.BOLD,16));
        totS.setString("Employees: "+totEmp);          totS.setStringPainted(true);
        totS.setValue(totEmp);      totS.setForeground(new Color(100,150,150));
        totS.setPreferredSize(new Dimension(300,100));
        totP.add(totS);
// department show
        totS=new JProgressBar();   totS.setString("Departments: "+totDep);
        totS.setFont(new Font("Arial",Font.BOLD,16));
        totS.setValue(totDep);      totS.setStringPainted(true);
        totS.setPreferredSize(new Dimension(300,100));
        totS.setForeground(Color.magenta);
        totP.add(totS);totP.setBackground(new Color(80,80,80));
        show.add(totP);
        show.add(tP);
        show.revalidate();
        show.repaint();

        // actionListeners
        home.addActionListener((e1)->{
            show.removeAll();
            show.setLayout(new GridLayout(2,1,5,5));
            show.add(totP);
            show.add(tP);
            show.revalidate();
            show.repaint();


        });

        registration.addActionListener((e3)->{

            show.removeAll();
            show.repaint();show.revalidate();
            show.setLayout(new BorderLayout());
            JPanel regSetting=new JPanel();
             rP=new JPanel();
            setRegistration=new JButton("set Max Applications");
             Vacancy=new JButton("Add/remove vacancy job titles");
             jobTitles=new JButton("Job Titles");
             addNewVacancy=new JButton("Add new job titles");
            //show.removeAll();

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





        employee.addActionListener((em)->{
            show.removeAll();
            show.setLayout(new BorderLayout());
            JLabel employeeL=new JLabel();
            employeeL.setFont(new Font("Arial",Font.BOLD,50));
            show.add(employeeL,BorderLayout.SOUTH);
            JPanel butonP=new JPanel();
            butonP.setLayout(new BoxLayout(butonP,BoxLayout.Y_AXIS));


            addemployee=new JButton("Add Employee");
            updateEmployee=new JButton("Update Employee Data");
             deleteEmployee=new JButton("Delete Employees");
             AcceptEmployee=new JButton("Accept Employee");
             viewEmployees=new JButton("View Employees");
             promoteEmployee=new JButton("Promote Employee");
             demoteEmployee=new JButton("Demote Employee");
            butonP.add(addemployee);
            butonP.add(updateEmployee);
            butonP.add(deleteEmployee);
            butonP.add(viewEmployees);
            butonP.add(promoteEmployee);
            butonP.add(demoteEmployee);

          // upper buttons
           JButton sendEmail=new JButton("send Emails");




            addemployee.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
            updateEmployee.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
            deleteEmployee.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
            viewEmployees.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
            promoteEmployee.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));
            demoteEmployee.setMaximumSize(new Dimension(Integer.MAX_VALUE,80));

            show.add(butonP,BorderLayout.WEST);

            butonP.setBackground(new Color(50,60,70));


            deleteEmployee.addActionListener(new EmployeeeManipulate());
            addemployee.addActionListener(new EmployeeeManipulate());
            promoteEmployee.addActionListener(new EmployeeeManipulate());
            demoteEmployee.addActionListener(new EmployeeeManipulate());


            show.revalidate();show.repaint();

            cdl=new CardLayout();              cdP=new JPanel();
            cdP.setLayout(cdl);

            viewEmployees.addActionListener((ve)->{
                BorderLayout layout=(BorderLayout) show.getLayout();
                Component comp=layout.getLayoutComponent(BorderLayout.CENTER);
                if(comp!=null){show.remove(comp);}
                show.revalidate(); show.repaint();
                JPanel view=new JPanel();
                cdP.add(view,"viewE");
                cdl.show(cdP,"viewE");
                show.add(cdP,BorderLayout.CENTER);
                view.setBackground(Color.green);
                JPanel cont1=new JPanel();
                JButton viewALl=new JButton("View All");
                JButton viewSp=new JButton("View Specific Employee");
                cont1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
                view.setLayout(new GridLayout(2,1));
                viewALl.setPreferredSize(new Dimension(200,40));
                viewSp.setPreferredSize(new  Dimension(200,40));
                cont1.add(viewALl);
                cont1.add(viewSp);
                view.add(cont1);
                viewSp.addActionListener((ep)->{
                    {JPanel cont2=new JPanel();
                        cont2.setLayout(new GridLayout(2,1));
                        JTextField id=new JTextField();
                        JLabel eid=new JLabel("Enter the Id of the employee");
                        JButton btn=new JButton("Search");
                        JPanel spemp=new JPanel();
                        spemp.setLayout(new GridBagLayout());
                        GridBagConstraints gbc=new GridBagConstraints();
                        gbc.insets=new Insets(5,5,5,5);
                        gbc.gridx=0;
                        gbc.gridy=0;

                        spemp.setBackground(Color.CYAN);
                        spemp.add(eid,gbc);

                        gbc.gridx=1;
                        gbc.weightx=1.0;
                        gbc.fill=GridBagConstraints.HORIZONTAL;
                        spemp.add(id,gbc);
                        gbc.gridx=2;
                        gbc.weightx=0.0;
                        gbc.fill=GridBagConstraints.NONE;
                        spemp.add(btn,gbc);
                        cont2.add(spemp);
                        cdP.add(cont2,"cont2");
                        cdl.show(cdP,"cont2");
                        id.setMaximumSize(new Dimension(150,30));
                        btn.setMaximumSize(new Dimension(150,30));
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
                                cdP.add(spe,"spe");
                                cdl.show(cdP,"spe");
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
                        });}
                });
                viewALl.addActionListener((all)->{
                    conn.setTemp_in("View id, name and email");
                    conn.dtcConnectmethod(bd,"retriev employee datal");
                    JPanel viewall=new JPanel();
                    viewall.setLayout(new BorderLayout(5,5));
                    cdP.add(viewall,"viewall");
                    cdl.show(cdP,"viewall");



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
                    JScrollPane viewpane=new JScrollPane(viewtable);
                    viewpane.getViewport().setBackground(Color.MAGENTA);

                    viewall.add(viewpane);



                });
            });


            updateEmployee.addActionListener((up)->{


                show.add(cdP,BorderLayout.CENTER);
                show.revalidate();show.repaint();
                JPanel update=new JPanel();
                update.setBackground(Color.orange);
                cdP.add(update,"update");
                cdl.show(cdP,"update");
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
                        cdP.add(p2,"p2");
                        cdl.show(cdP,"p2");
                        JButton btn1=new JButton("set salary");
                        submit=new JButton("save changes");
                        JTextField t0=new JTextField();// start date set
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


                        String []ids=conn.getIds();
                        String id=ids[t1.getSelectedRow()];
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
                            p3.add(s1,BorderLayout.CENTER);      p4.add(l1);p4.add(t0);
                            p4.add(l2);p4.add(t2);               p4.add(l3);p4.add(t3);
                            p4.add(l4);p4.add(t4);               p4.add(l5);p4.add(t5);
                            p4.add(l6);p4.add(t6);               p4.add(l7);p4.add(d);

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



                                EmployeeBasicDetails dt1= new EmployeeBasicDetails(checkInput(t0.getText().toString()),checkInput(t2.getText().toString()),checkInput(t3.getText().toString()),checkInput(t4.getText().toString()),checkInput(t5.getText().toString()),checkInput(t6.getText().toString()),sal,dept);
                                conn.dtcConnectmethod(dt1,"setWorkDetails");
                                JOptionPane.showMessageDialog(null,conn.getResult());});

                            p2.add(p3);p2.add(p4);p2.add(p5);
                            p2.repaint();
                            p2.revalidate();
                        }
                    }
                });

            });




        });









        adminMenuBar=new JMenuBar();
        Registration=new JMenu("Registration");
       JMenuItem reg=new JMenuItem("Open");
       JMenuItem close=new JMenuItem("close");


        adminInterface.add(buttonP,BorderLayout.WEST);
        adminInterface.add(show,BorderLayout.CENTER);

        //loggedin=new JLabel();
        barCont=new JPanel();
        barCont.add(adminMenuBar);






        logout=new JMenuItem("Sign Out");


        adminMenuBar.add(logout);
        Registration.add(reg);
        Registration.add(close);
        adminMenuBar.add(Registration);


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



        adminInterface.setVisible(true);

      }


    class EmployeeeManipulate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent em){
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
                    if(c==true && no.length()!=0){
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
                String[] tit=conn.getAtitles();
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
                    if(titl.size()==0){
                        JOptionPane.showMessageDialog(null,"Nothing has been selected");}
                    else{ int input=JOptionPane.showConfirmDialog(null,"Are you sure you want to completely delete the selected job titles?", "Warning",JOptionPane.YES_NO_CANCEL_OPTION);
                        if (input==JOptionPane.YES_OPTION){
                            for (int i=0;i<iD.size();i++){
                                conn.setId(iD.get(i));
                                System.out.println(iD.get(i));
                                conn.dtcConnectmethod(bd,"delete job title");
                            }
                        }

                        JOptionPane.showMessageDialog(null,conn.getResult());}

                });
                submit.addActionListener((as)->{
                    conn.dtcConnectmethod(bd,"getAdminTitles");
                    String[] chc=conn.getEtitles();
                    int count=0;
                    if(titl.size()==0){
                        JOptionPane.showMessageDialog(null,"Nothing has been selected");}
                    else{
                        for (int i=0;i<titl.size();i++){
                            boolean chk=true;
                            for(int j=0;j<chc.length;j++){
                                if(chc[j].equals(titl.get(i))){
                                    chk=false; break;
                                }
                            }


                            if(chk==true){

                                conn.setVacanyadd(titl.get(i));
                                conn.dtcConnectmethod(bd,"setAdminTitles");
                                JOptionPane.showMessageDialog(null,conn.getResult());
                                count++;
                                break;}
                            else{
                                JOptionPane.showMessageDialog(null,"some of the selected titles have already been added. Number of titles added: "+count);
                                break;}
                        }}


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
submit=new JButton("add the selected Titles");
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

                delete.addActionListener((de)->{
                    if(iD.size()==0){
                        JOptionPane.showMessageDialog(null,"Nothing has been selected");}
                    else{   int input=JOptionPane.showConfirmDialog(null,"Are you sure you want to completely delete the selected job titles?", "Warning",JOptionPane.YES_NO_CANCEL_OPTION);
                        if (input==JOptionPane.YES_OPTION){
                            for (int i=0;i<iD.size();i++){
                                conn.setId(iD.get(i));
                                System.out.println(iD.get(i));
                                conn.dtcConnectmethod(bd,"delete vacancy");
                            }
                        }

                        JOptionPane.showMessageDialog(null,conn.getResult());}
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
                fieldP.setLayout(new BoxLayout(fieldP,BoxLayout.X_AXIS));
                fieldP.setBackground(new Color(100,100,255));
                bPcont.setLayout(new GridLayout(2,1,10,10));
                bP.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
                fieldP.add(vacL); fieldP.add(newV);
                submit.setBackground(Color.green);
                newV.setMaximumSize(new Dimension(150,30));
                submit.setPreferredSize(new Dimension(150,40));
                bP.add(submit);
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


            else if (em.getSource()==addemployee){
                cdP=new JPanel();
                cdl=new CardLayout();
                cdP.setLayout(cdl);
                BorderLayout layout=(BorderLayout) show.getLayout();
                Component comp=layout.getLayoutComponent(BorderLayout.CENTER);
                if(comp!=null){show.remove(comp);}
                show.repaint(); show.revalidate();
                show.add(cdP,BorderLayout.CENTER);
                JPanel addemployeeP=new JPanel();
                addemployeeP.setLayout(new BorderLayout());
                cdP.add(addemployeeP,"addemployeeP");
                cdl.show(cdP,"addemployeeP");

                conn.dtcConnectmethod(bd,"retrieve applicant");
                String [] columns={"Name","Email"};
                empName=conn.getApplicantName();
                empEmail=conn.getApplicantEmail();
                String[] tobeused=new String[empEmail.length];
                Object [][] emdata=new Object[empName.length][2];
                for (int i=0;i<empName.length;i++){
                    emdata[i][0]=empName[i];
                    emdata[i][1]=empEmail[i];
                    tobeused[i]=empName[i]+"      Email: "+empEmail[i];}

                JTable employeeTable =new JTable(emdata,columns);
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


            }
            else if (em.getSource()==deleteEmployee){
                BorderLayout layout=(BorderLayout) show.getLayout();
                Component comp1=layout.getLayoutComponent(BorderLayout.CENTER);
                Component comp2=layout.getLayoutComponent(BorderLayout.SOUTH);
                if (comp1!=null){show.remove(comp1); }
                if(comp2!=null){show.remove(comp2);}
                show.revalidate();show.repaint();
                Back= new JMenuItem("Back");
                JPanel deleteInterface=new JPanel();
                deleteInterface.setLayout(new BorderLayout(5,5));
                cdP.add(deleteInterface,"deleteEmp");
                cdl.show(cdP,"deleteEmp");
                Back.setBackground(Color.GREEN);
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
                deletetable.getTableHeader().setBounds(0,0,700,50);
                deletetable.setBounds(0,50,800,800);
                JScrollPane dpane=new JScrollPane(deletetable);


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
                deleteInterface.add(dpane,BorderLayout.CENTER);
                deleteInterface.add(submit, BorderLayout.SOUTH);
                deleteInterface.setVisible(true);
            }  else if (em.getSource() == viewEmployees) {

            } else if (em.getSource() == logout) {
                adminMenuBar.removeAll();


                ;
            }
        }

    }
}

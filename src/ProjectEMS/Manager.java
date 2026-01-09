package ProjectEMS;

import javax.swing.*;
import java.sql.Date;

public class Manager {

    String[] date=new String[0];
    String[] des=new String[0];
    String[] title=new String[0];
    String result="not set";
    EmployeeBasicDetails dt1=new EmployeeBasicDetails();
    DataBaseConnector connect=new DataBaseConnector();
    public Manager(){}
    public Manager(String[] tasks,String[] des,String[] date,String id0){
        for (int i=0;i<tasks.length;i++){
            connect.setId(id0);

          connect.setTitle(tasks[i]);
            connect.setDescription(des[i]);
            connect.setDate(date[i]);
            connect.dtcConnectmethod(dt1,"add task");
            result=connect.getResult();
        }
    }
    public void setTaskinfo(String titles, String desc, String dt){
        if (titles!=null && (titles).length()!=0 && desc!=null && (desc).length()!=0 && dt!=null && (dt).length()!=0){

            String temp[]=new String[title.length+1];
            for(int i=0;i<title.length;i++){
                temp[i]=title[i];
            }
            temp[title.length]=titles;
            title=temp;
            String temp2[]=new String[des.length+1];
            for (int j=0;j<des.length;j++){
                temp2[j]=des[j];
            }temp2[des.length]=desc;
            des=temp2;

            try{
                Date sqlDate=java.sql.Date.valueOf(dt);
                String temp3[]=new String[date.length+1];
                for (int k=0;k<date.length;k++){
                    temp3[k]=date[k];}
                temp3[date.length]=dt;
                date=temp3;
            }catch(IllegalArgumentException exc){
                result="Invalid! Please use year-month-day structure";

            }


        }else{
            result="Invalid! Please use year-month-day structure";
        }
    }

}

package ProjectEMS;

public interface EmployeeMInterface {
    EmployeeBasicDetails det= new EmployeeBasicDetails();
    DataBaseConnector conn= new DataBaseConnector();
    default public String checkName(String name){
        String result="pass";
        if(name==null || name.length()==0){
            System.out.println("has zero");
            result="Invalid Name Entry";
        }
        char[] ch={'/','!','$','#','^','&','(',')','0','1','2','3','4','5','6','7','8','9','|'};
       for (int i=0;i<name.length();i++){
           char temp=name.charAt(i);
           for(int j=0;j<ch.length;j++){

               if(temp==ch[j]) {
                   System.out.println("invalid char");
                   return "Invalid Name Entry";}}}
    return result;}
    default public String checkEmail(String email){
        String result="pass";
        if(email==null || email.length()==0){
            result="Invalid Email Address!";
        }

        // System.out.print("Enter your email: ");
        //email.scanner.nextLine();
        if ( email.length()<11 ||  (!email.substring(email.length()-10).equals("@yahoo.com") && !email.substring(email.length()-10).equals("@gmail.com"))
                || email.contains(" ")){


            result="Invalid Email Address!";

        }
       return result;}
default String checkBDay(String bday){
    String result="pass";
    if(bday==null || bday.length()==0){
        result="invalid Birth Date Entry";
    }

        try{int n=Integer.parseInt(bday);}
        catch(IllegalArgumentException e){
            result="invalid Birth Date Entry";
            return result;
        }
        if (bday.length()>2){
            result="invalid Birth Date Entry";return result;
        }
        for(int i=0;i<3;i++){if(bday.charAt(i)=='+' || bday.charAt(i)=='-'){result="invalid Brith Date Entry";}
        return result;}return result;}
default String chckmonth(String month){
        String result="pass";
    if(month==null || month.length()==0){
        result="invalid Birth Month Entry";
    }
    try{int n=Integer.parseInt(month);}
    catch(IllegalArgumentException e){
        result="invalid Birth Month Entry";
        return result;
    }  if (month.length()>2){
        result="invalid Birth Month Entry";return result;

    }
    if(Integer.parseInt(month)>12){result="invalid Birth Motnh Entry";return result;}
    for(int i=0;i<3;i++){if(month.charAt(i)=='+' || month.charAt(i)=='-'){result="invalid Month Date Entry";}
        return result;}return result;}
default String checkBYear(String year){
    String result="pass";
    if(year==null || year.length()==0){
        System.out.println("has zero yer");
        result="invalid Birth Year Entry";
    }
    try{int n=Integer.parseInt(year);}
    catch(IllegalArgumentException e){
        result="invalid Birth Year Entry";
        return result;
    }  if (year.length()!=4){
        result="invalid Birth Year Entry";return result;
    }
    conn.dtcConnectmethod(det,"get maxYear");
    if(Integer.parseInt(year)>conn.getAdminsetMaxYear() || Integer.parseInt(year)<conn.getMinYear()){result="invalid Birth Year Entry";return result;}
    for(int i=0;i<3;i++){
        if(year.charAt(i)=='+' || year.charAt(i)=='-'){
            result="invalid Birth Year Entry";}
        return result;}return result;}
    default String checkPhone(String phone){
        if(phone==null || phone.length()==0){
            phone="invalid Phone number";
        }
        String result="pass";
        try{int n=Integer.parseInt(phone);}
        catch(IllegalArgumentException e){
            result="invalid Phone number";
            return result;
        }
        if (phone.length()<10 || phone.length()>13){
            result="invalid Phone number";
        }
    return result;}
    default String chckCity(String city){

        String result="pass";
        if(city==null || city.length()==0){
            result="invalid city name";
        }
        for (int i=0;i<city.length();i++){

            for(int j=0;j<9;j++){
                if (city.charAt(i)==j){
                    result="invalid city name";
                    return result;}}}
        return result;
    }
    default String chckPostalCode(String postal){
        String result="pass";
        if(postal==null || postal.length()==0){
            result="invalid postal code";
        }
        try{int n=Integer.parseInt(postal);}
        catch(IllegalArgumentException e){
            result="invalid postal code";
            return result;
        }

  return result; }
    default String chckPassword(String p1, String p2){
        String result="pass";
        if(p1==null || p1.length()==0){
            result="password cannot be null";
        }

      if(p1.equals(p2)==false){
          result="passwords don't match";
      }return result;
    }
    default boolean checkMaxApplications(String result){
        boolean value=false;
if(result.equals("Open")){
    conn.dtcConnectmethod(det,"getMaxApplications");
    String totalAp=conn.gettotalA();
    conn.dtcConnectmethod(det,"getsetMaxApplications");
   int max= conn.getMaxData();
    if(Integer.parseInt(totalAp)<=max){
        value=true;
    }
}
    return value;}
    class Result{
        public String[] data=new String[0];
        public String[] columnName=new String[0];
        public void result(int id){
            conn.setTemp_in("View Specific Employee");

        }
    }
default String[] getDepartment(){
        conn.setTempAdmin("getDepartment");
      conn.dtcConnectmethod(det,"adminSetDt");
    String r[]= conn.getAsetData();
    return r;
}
default int checkInput(String s){
    if (s.length()==0){
        return 0;}
    return Integer.parseInt(s);}
    default void addWorkD(String email){
        det.setEmail_address(email);
        conn.dtcConnectmethod(det,"getEid");
        conn.dtcConnectmethod(det,"addWorkDetails");
    }

        }






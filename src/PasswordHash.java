import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.nio.charset.StandardCharsets;

public class PasswordHash {
   // EmployeeBasicDetails passwordCatch=new EmployeeBasicDetails();// have a look at whether this object can accept the needed data
public String encode(String passw){
    Encoder encode=Base64.getEncoder();
    String encodedpassw=encode.encodeToString(passw.getBytes(StandardCharsets.UTF_8));
  //  System.out.println("the encoded password is: "+encodedpassw);
return encodedpassw;
}
public String decode(String dtbpassw){
    Decoder decode=Base64.getDecoder();
    byte[] decodedpassw=decode.decode(dtbpassw);
    return new String(decodedpassw,StandardCharsets.UTF_8);//StandardCharsets.UTF_8 is used to avoid platform dependencyo f the encoding-decoding
}
}

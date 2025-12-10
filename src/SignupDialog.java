import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SignupDialog{
    /**
     * Signup dialog for creating new user accounts.
     */

        //private static final logger = LoggerFactory.getLogger(SignupDialog.class);

        private JTextField usernameField;
        private JPasswordField passwordField;
        private JPasswordField confirmPasswordField;
        private JComboBox<String> roleComboBox;
        private JButton signinButton;
        private JButton cancelButton;
       // private UserDao userDao;
        private boolean signupSuccessful = false;
   /* public SignupDialog(JFrame parent) {
        super(parent, "Sign in", true);
        this.userDao = new UserDao();
        initializeUI();
    }*/
}

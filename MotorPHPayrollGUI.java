
import javax.swing.*;
import java.awt.*;

public class MotorPHPayrollGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen());
    }
}

class LoginScreen extends JFrame {
    public LoginScreen() {
        setTitle("MotorPH Payroll System - Login");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"Employee", "HR Admin", "System Admin"};
        JComboBox<String> roleCombo = new JComboBox<>(roles);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> {
            String role = (String) roleCombo.getSelectedItem();
            dispose();
            if (role.equals("Employee")) new EmployeeDashboard();
            else new HRDashboard();
        });

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(userLabel); panel.add(userField);
        panel.add(passLabel); panel.add(passField);
        panel.add(roleLabel); panel.add(roleCombo);
        panel.add(new JLabel()); panel.add(loginBtn);

        add(panel);
        setVisible(true);
    }
}

class EmployeeDashboard extends JFrame {
    public EmployeeDashboard() {
        setTitle("Employee Dashboard");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel welcome = new JLabel("Welcome, Employee!", JLabel.CENTER);
        JButton viewPayslipBtn = new JButton("View Payslip");
        JButton attendanceBtn = new JButton("Scan QR (Clock In/Out)");
        JButton leaveBtn = new JButton("Apply for Leave");

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(welcome);
        panel.add(viewPayslipBtn);
        panel.add(attendanceBtn);
        panel.add(leaveBtn);

        add(panel);
        setVisible(true);
    }
}

class HRDashboard extends JFrame {
    public HRDashboard() {
        setTitle("HR Admin Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("Welcome, HR Admin!", JLabel.CENTER);
        JButton manageEmpBtn = new JButton("Employee Management");
        JButton processPayrollBtn = new JButton("Process Payroll");
        JButton reportsBtn = new JButton("View Reports");

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(title);
        panel.add(manageEmpBtn);
        panel.add(processPayrollBtn);
        panel.add(reportsBtn);

        add(panel);
        setVisible(true);
    }
}

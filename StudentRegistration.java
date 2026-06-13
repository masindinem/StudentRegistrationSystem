/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication448;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author DELL
 */
public class StudentRegistration  extends JFrame {
 
    private JTextField txtName;
    private JPasswordField txtPassword;

    private JRadioButton rdoMale, rdoFemale;
    private ButtonGroup genderGroup;

    private JCheckBox chkSoccer, chkReading,chkSinging,chkDancing;

    private JComboBox<String> cmbProvince;

    private JTextArea txtComments;
    private JScrollPane scrollPane;

    private JButton btnChooseFile, btnRegister;

    private JFileChooser fileChooser;

    private JSpinner spnAge;
    private JSlider sldSatisfaction;

    private JProgressBar progressBar;

    private JMenuBar menuBar;
    private JMenu menuFile, menuHelp;
    private JMenuItem mnuExit, mnuAbout;

    public StudentRegistration() {

        setTitle("Student Registration System");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== MENU =====
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuHelp = new JMenu("Help");

        mnuExit = new JMenuItem("Exit");
        mnuAbout = new JMenuItem("About");

        menuFile.add(mnuExit);
        menuHelp.add(mnuAbout);

        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        // ===== FORM =====
        JPanel panel = new JPanel(new GridLayout(10, 2));

        txtName = new JTextField();
        txtPassword = new JPasswordField();

        rdoMale = new JRadioButton("Male");
        rdoFemale = new JRadioButton("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(rdoMale);
        genderGroup.add(rdoFemale);

        JPanel genderPanel = new JPanel();
        genderPanel.add(rdoMale);
        genderPanel.add(rdoFemale);

        chkSoccer = new JCheckBox("Soccer");
        chkReading = new JCheckBox("Reading");
        chkSinging = new JCheckBox("Singing");
        chkDancing = new JCheckBox("Dancing");


        JPanel hobbyPanel = new JPanel();
        hobbyPanel.add(chkSoccer);
        hobbyPanel.add(chkReading);
        hobbyPanel.add(chkSinging);
        hobbyPanel.add(chkDancing);

        cmbProvince = new JComboBox<>(new String[]{
                "Eastern Cape", "Free State", "Gauteng", "KwaZulu-Natal", "Limpopo", "Mpumalanga", "Northern Cape", "North West", "Western Cape"
        });

        spnAge = new JSpinner(new SpinnerNumberModel(18, 10, 100, 1));

        sldSatisfaction = new JSlider(0, 100, 50);
        sldSatisfaction.setPaintTicks(true);
        sldSatisfaction.setPaintLabels(true);

        txtComments = new JTextArea(3, 20);
        scrollPane = new JScrollPane(txtComments);

        btnChooseFile = new JButton("Choose File");
        btnRegister = new JButton("Register");

        fileChooser = new JFileChooser();

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        panel.add(new JLabel("Name:"));
        panel.add(txtName);

        panel.add(new JLabel("Password:"));
        panel.add(txtPassword);

        panel.add(new JLabel("Gender:"));
        panel.add(genderPanel);

        panel.add(new JLabel("Hobbies:"));
        panel.add(hobbyPanel);

        panel.add(new JLabel("Province:"));
        panel.add(cmbProvince);

        panel.add(new JLabel("Age:"));
        panel.add(spnAge);

        panel.add(new JLabel("Satisfaction:"));
        panel.add(sldSatisfaction);

        panel.add(new JLabel("Comments:"));
        panel.add(scrollPane);

        panel.add(btnChooseFile);
        panel.add(btnRegister);

        add(panel, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);

        // ===== EVENTS =====

        btnRegister.addActionListener(e -> {

            String name = txtName.getText();
            String password = new String(txtPassword.getPassword());

            String gender = rdoMale.isSelected() ? "Male" : "Female";

            String hobbies = "";
            if (chkSoccer.isSelected()) hobbies += "Soccer ";
            if (chkReading.isSelected()) hobbies += "Reading ";
            if (chkSinging.isSelected()) hobbies += "Singing ";
            if (chkDancing.isSelected()) hobbies += "Dancing ";

            


            String province = cmbProvince.getSelectedItem().toString();
            int age = (int) spnAge.getValue();
            int satisfaction = sldSatisfaction.getValue();

            progressBar.setValue(100);

            JOptionPane.showMessageDialog(this,
                    "Name: " + name +
                    "\nPassword: " + password +
                    "\nGender: " + gender +
                    "\nHobbies: " + hobbies +
                    "\nProvince: " + province +
                    "\nAge: " + age +
                    "\nSatisfaction: " + satisfaction +
                    "\nComments: " + txtComments.getText()
            );
        });

        btnChooseFile.addActionListener(e -> {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this,
                        fileChooser.getSelectedFile().getName());
            }
        });

        mnuExit.addActionListener(e -> System.exit(0));

        mnuAbout.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Student Registration System v1.0"));

        sldSatisfaction.addChangeListener(e ->
                progressBar.setValue(sldSatisfaction.getValue())
        );

        setVisible(true);
    }
}
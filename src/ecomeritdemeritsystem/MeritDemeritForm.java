/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomeritdemeritsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class MeritDemeritForm {
    private MeritDemeritManager manager;
    private HashMap<String, Employee> employeeDirectory = new HashMap<>();

    public MeritDemeritForm() {
        manager = new MeritDemeritManager();
        seedEmployees();

        JFrame frame = new JFrame("Eco Hotels - Merit & Demerit Logger");
        frame.setSize(460, 500);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(102, 139, 47), 2));

        int y = 30;
        Color textColor = new Color(60, 90, 60);
        Color placeholderColor = new Color(180, 180, 180);
        Font placeholderFont = new Font("SansSerif", Font.ITALIC, 11);
        Font standardFont = new Font("SansSerif", Font.PLAIN, 12);

        JLabel labelId = new JLabel("Employee ID:");
        JComboBox<String> comboID = new JComboBox<>();
        comboID.addItem("Select ID...");
        comboID.setForeground(placeholderColor);
        comboID.setFont(placeholderFont);
        labelId.setForeground(textColor);
        labelId.setFont(standardFont);

        JLabel labelName = new JLabel("Name:");
        JComboBox<String> comboName = new JComboBox<>();
        comboName.addItem("Select Name...");
        comboName.setForeground(placeholderColor);
        comboName.setFont(placeholderFont);
        labelName.setForeground(textColor);
        labelName.setFont(standardFont);

        JLabel labelType = new JLabel("Type:");
        String[] types = {"Merit", "Demerit"};
        JComboBox<String> comboType = new JComboBox<>(types);
        labelType.setForeground(textColor);
        labelType.setFont(standardFont);
        comboType.setFont(standardFont);

        JLabel labelDesc = new JLabel("Description:");
        JTextField fieldDesc = new JTextField();
        labelDesc.setForeground(textColor);
        labelDesc.setFont(standardFont);
        fieldDesc.setFont(standardFont);

        JLabel labelPoints = new JLabel("Points:");
        JTextField fieldPoints = new JTextField();
        labelPoints.setForeground(textColor);
        labelPoints.setFont(standardFont);
        fieldPoints.setFont(standardFont);

        JLabel labelLoggedBy = new JLabel("Logged By:");
        JTextField fieldLoggedBy = new JTextField();
        fieldLoggedBy.setText("");
        labelLoggedBy.setForeground(textColor);
        labelLoggedBy.setFont(standardFont);
        fieldLoggedBy.setFont(standardFont);

        JLabel labelBranch = new JLabel("Branch:");
        JTextField fieldBranch = new JTextField();
        labelBranch.setForeground(textColor);
        labelBranch.setFont(standardFont);
        fieldBranch.setFont(standardFont);

        JLabel labelRemarks = new JLabel("Remarks:");
        JTextField fieldRemarks = new JTextField();
        labelRemarks.setForeground(textColor);
        labelRemarks.setFont(standardFont);
        fieldRemarks.setFont(standardFont);

        JButton buttonSubmit = new JButton("Submit Entry");
        buttonSubmit.setBackground(new Color(18, 69, 89));
        buttonSubmit.setForeground(Color.WHITE);
        buttonSubmit.setFont(standardFont);

        JButton buttonSummary = new JButton("View Summary");
        buttonSummary.setBackground(new Color(102, 139, 47));
        buttonSummary.setForeground(Color.WHITE);
        buttonSummary.setFont(standardFont);

        labelId.setBounds(30, y, 100, 25); comboID.setBounds(150, y, 250, 25); y += 35;
        labelName.setBounds(30, y, 100, 25); comboName.setBounds(150, y, 250, 25); y += 35;
        labelType.setBounds(30, y, 100, 25); comboType.setBounds(150, y, 250, 25); y += 35;
        labelDesc.setBounds(30, y, 100, 25); fieldDesc.setBounds(150, y, 250, 25); y += 35;
        labelPoints.setBounds(30, y, 100, 25); fieldPoints.setBounds(150, y, 250, 25); y += 35;
        labelLoggedBy.setBounds(30, y, 100, 25); fieldLoggedBy.setBounds(150, y, 250, 25); y += 35;
        labelBranch.setBounds(30, y, 100, 25); fieldBranch.setBounds(150, y, 250, 25); y += 35;
        labelRemarks.setBounds(30, y, 100, 25); fieldRemarks.setBounds(150, y, 250, 25); y += 40;

        buttonSubmit.setBounds(150, y, 120, 30);
        buttonSummary.setBounds(280, y, 120, 30);

        frame.add(labelId); frame.add(comboID);
        frame.add(labelName); frame.add(comboName);
        frame.add(labelType); frame.add(comboType);
        frame.add(labelDesc); frame.add(fieldDesc);
        frame.add(labelPoints); frame.add(fieldPoints);
        frame.add(labelLoggedBy); frame.add(fieldLoggedBy);
        frame.add(labelBranch); frame.add(fieldBranch);
        frame.add(labelRemarks); frame.add(fieldRemarks);
        frame.add(buttonSubmit);
        frame.add(buttonSummary);
        
        comboID.addItem("Select ID...");
        comboName.addItem("Select Name...");

        for (Employee emp : employeeDirectory.values()) {
            comboID.addItem(emp.getId());
            comboName.addItem(emp.getName());
        }

        comboID.setSelectedIndex(0);
        comboName.setSelectedIndex(0);

        comboID.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0 && !isSelected) {
                    setForeground(Color.GRAY);
                }
                return c;
            }
        });

        comboName.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0 && !isSelected) {
                    setForeground(Color.GRAY);
                }
                return c;
            }
        });

        comboID.addActionListener(e -> {
            String selectedId = (String) comboID.getSelectedItem();
            Employee emp = employeeDirectory.get(selectedId);
            if (emp != null) {
                comboName.setSelectedItem(emp.getName());
                fieldBranch.setText(emp.getBranch());
                fieldLoggedBy.setText("");
            }
        });

        comboName.setEditable(true);
        JTextField editor = (JTextField) comboName.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String input = editor.getText();
                comboName.removeAllItems();
                comboName.addItem("Select Name...");
                for (Employee emp : employeeDirectory.values()) {
                    if (emp.getName().toLowerCase().contains(input.toLowerCase())) {
                        comboName.addItem(emp.getName());
                    }
                }
                comboName.setPopupVisible(true);
                editor.setText(input);
            }
        });

        comboName.addActionListener(e -> {
            String selectedName = (String) comboName.getSelectedItem();
            for (Employee emp : employeeDirectory.values()) {
                if (emp.getName().equals(selectedName)) {
                    comboID.setSelectedItem(emp.getId());
                    fieldBranch.setText(emp.getBranch());
                    fieldLoggedBy.setText("");
                    break;
                }
            }
        });

        buttonSubmit.addActionListener(e -> {
            String id = (String) comboID.getSelectedItem();
            String type = (String) comboType.getSelectedItem();
            String desc = fieldDesc.getText();
            int points = Integer.parseInt(fieldPoints.getText());
            String loggedBy = fieldLoggedBy.getText();
            String branch = fieldBranch.getText();
            String remarks = fieldRemarks.getText();

            manager.addEmployee(id, id);
            manager.addEntry(id, desc, points, type, loggedBy, branch, remarks);
            JOptionPane.showMessageDialog(frame, "✅ Entry added for " + id);
        });

        buttonSummary.addActionListener(e -> {
            String id = (String) comboID.getSelectedItem();
            manager.showEmployeeSummary(id);
        });

        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(58, 44, 32));
        footerPanel.setBounds(0, y + 50, 460, 110);
        footerPanel.setLayout(null);
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(102, 139, 47)));

        JLabel footerNote = new JLabel("");
        footerNote.setFont(new Font("SansSerif", Font.ITALIC, 8));
        footerNote.setForeground(new Color(204, 204, 204));
        footerNote.setBounds(10, 5, 440, 15);

        JTextArea footerDetails = new JTextArea();
                footerDetails.setText(
                        "➤ Select or search employee from dropdown. Auto-fill logic applies.\n" +
                        "\n• Logic: ID and Name sync to auto-fill the employee's branch. Data is stored in-memory.\n" +
                        "• Structure: A HashMap holds employee records. Summary fetches logs using employee ID.\n" +
                        "• Usage: Log requires values for ID, type, description, points, logger name, and remarks."
        );;        
        footerDetails.setFont(new Font("SansSerif", Font.PLAIN, 9));
        footerDetails.setForeground(new Color(204, 204, 204));
        footerDetails.setBackground(new Color(58, 44, 32));
        footerDetails.setBounds(10, 5, 440, 110);
        footerDetails.setMargin(new Insets(6, 20, 6, 10));
        footerDetails.setEditable(false);
        footerDetails.setLineWrap(true);
        footerDetails.setWrapStyleWord(true);


        footerPanel.add(footerNote);
        footerPanel.add(footerDetails);
        frame.add(footerPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void seedEmployees() {
        employeeDirectory.put("EMP001", new Employee("EMP001", "Phil", "Spaces Hotel Makati"));
        employeeDirectory.put("EMP002", new Employee("EMP002", "Lorie", "Cabins by Eco Hotel"));
        employeeDirectory.put("EMP003", new Employee("EMP003", "Marjun", "Suites by Eco El Nido"));
    }

    public static void main(String[] args) {
        new MeritDemeritForm();
    }
}

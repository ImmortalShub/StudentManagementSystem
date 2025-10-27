import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class StudentData {
    int roll;
    String name;
    double marks;

    StudentData(int r, String n, double m) {
        roll = r;
        name = n;
        marks = m;
    }

    public String toString() {
        return roll + " - " + name + "\nMarks: " + marks;
    }
}

public class StudentGUI extends JFrame implements ActionListener {
    JTextField rollField, nameField, marksField, searchField;
    JTextArea displayArea;
    ArrayList<StudentData> students = new ArrayList<>();

    public StudentGUI() {
        setTitle("Student Management System");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Roll:"));
        rollField = new JTextField(10);
        add(rollField);

        add(new JLabel("Name:"));
        nameField = new JTextField(10);
        add(nameField);

        // Move marks to next line by adding a dummy label (for spacing)
        add(new JLabel("")); // creates a line break effect
        add(new JLabel("Marks:"));
        marksField = new JTextField(10);
        add(marksField);

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        add(addBtn);

        add(new JLabel("Search Roll:"));
        searchField = new JTextField(10);
        add(searchField);

        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(this);
        add(searchBtn);

        JButton showBtn = new JButton("Show All");
        showBtn.addActionListener(this);
        add(showBtn);

        displayArea = new JTextArea(10, 30);
        add(new JScrollPane(displayArea));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Add")) {
            try {
                int roll = Integer.parseInt(rollField.getText());
                String name = nameField.getText();
                double marks = Double.parseDouble(marksField.getText());
                students.add(new StudentData(roll, name, marks));
                displayArea.setText("Student Added!\n");
                rollField.setText("");
                nameField.setText("");
                marksField.setText("");
            } catch (Exception ex) {
                displayArea.setText("Error: Please enter valid data!");
            }
        } 
        else if (cmd.equals("Search")) {
            try {
                int roll = Integer.parseInt(searchField.getText());
                StringBuilder result = new StringBuilder();
                for (StudentData s : students) {
                    if (s.roll == roll)
                        result.append("Found:\n").append(s).append("\n\n");
                }
                if (result.length() == 0)
                    result.append("No student found!");
                displayArea.setText(result.toString());
            } catch (Exception ex) {
                displayArea.setText("Error: Please enter a valid roll number!");
            }
        } 
        else if (cmd.equals("Show All")) {
            displayArea.setText("All Students:\n\n");
            for (StudentData s : students)
                displayArea.append(s + "\n\n");
        }
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}

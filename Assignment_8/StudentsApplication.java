import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentsApplication extends JFrame {

    public JTable studentsTable;
    public Students students;
    public StudentsTableModel model;
    public AddStudentInfo addStudentInfo;
    public StudentsApplication(Students students) {
        this.students = students;
        model = new StudentsTableModel(this.students);
        studentsTable = new JTable(model);
        JScrollPane jScrollPane = new JScrollPane(studentsTable);
        jScrollPane.setSize(400, 400);
        Container container = getContentPane();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add New Student - Click Here!");
        addButton.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        addButton.addActionListener(e -> addStudentInfo = new AddStudentInfo());
        panel.add(addButton);
        panel.add(jScrollPane);
        container.add(panel);
        setSize(500, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        Students s = new Students();
        s.addStudent(new Student(100, "Divya", "Sharma", true));
        s.addStudent(new Student(101, "Mihir", "Salunke", false));
        new StudentsApplication(s);

    }

    class AddStudentInfo extends JFrame {
        String[] genderList = new String[] {"---Select Gender---", "Male", "Female"};

        JLabel studentId = new JLabel("Student ID:");
        JLabel studentFirstName = new JLabel("Student First Name:");
        JLabel studentLastName = new JLabel("Student Last Name:");
        JLabel studentGender = new JLabel("Student Gender:");
        JTextField studentIdText = new JTextField(20);
        JTextField studentFirstNameText = new JTextField(20);
        JTextField studentLastNameText = new JTextField(20);
        JComboBox<String> studentGenderBox = new JComboBox(genderList);

        public AddStudentInfo() {

            super("Adding Student Information...");
            setLocation(100,50);
            setSize(600,300);
            setVisible(true);

            Container container = getContentPane();
            container.setLayout(new GridLayout(4, 2));
            Font font = new Font("TimesRoman", Font.PLAIN, 20);

            //Id
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            studentId.setFont(font);
            studentIdText.setFont(font);
            panel.add(studentId);
            panel.add(studentIdText);
            container.add(panel);

            //Name
            panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            studentFirstName.setFont(font);
            studentFirstNameText.setFont(font);

            studentLastName.setFont(font);
            studentLastNameText.setFont(font);
            panel.add(studentFirstName);
            panel.add(studentFirstNameText);
            panel.add(studentLastName);
            panel.add(studentLastNameText);
            container.add(panel);

            //Gender
            panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            studentGender.setFont(font);
            panel.add(studentGender);
            panel.add(studentGenderBox);
            container.add(panel);

            //Add
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton add = new JButton("Add to Database - Click Here");
            Boolean gender;
            add.addActionListener(e -> {
                StudentsApplication.this.students.addStudent(
                        new Student(Integer.parseInt(
                                AddStudentInfo.this.studentIdText.getText()),
                                AddStudentInfo.this.studentFirstNameText.getText(),
                                AddStudentInfo.this.studentLastNameText.getText(),
                                AddStudentInfo.this.studentGenderBox.getSelectedItem().toString().equals("Male")
                        )
                );
                StudentsApplication.this.studentsTable.updateUI();
                dispose();
            });
            add.setFont(font);
            panel.add(add);
            container.add(panel);
            //setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }
}


class Students {
    private Collection<Student> students = new ArrayList<Student>();

    public Collection<Student> getStudents() {
        return students;

    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public int getNumberOfStudents() {
        return getStudents().size();
    }

}

class Student {
    int roll;
    String first;
    String last;
    boolean gender = false;

    public Student(int roll, String first, String last, boolean gender) {
        this.roll = roll;
        this.first = first;
        this.last = last;
        this.gender = gender;
    }
}

class StudentsTableModel implements TableModel {

    private Students students;

    public StudentsTableModel(Students students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.getNumberOfStudents();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ROLL";
        }
        if (columnIndex == 1) {
            return "First";
        }
        if (columnIndex == 2)
            return "Last";
        if (columnIndex == 3)
            return "Gender";
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Collection<Student> s = students.getStudents();
        int row = -1;
        for (Student student : s) {
            row++;
            if (row == rowIndex) {
                if (columnIndex == 0) {
                    return student.roll + "";
                }
                if (columnIndex == 1) {
                    return student.first;
                }
                if (columnIndex == 2) {
                    return student.last;
                }
                if (columnIndex == 3) {
                    return student.gender? "Male": "Female";
                }
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub
    }

}

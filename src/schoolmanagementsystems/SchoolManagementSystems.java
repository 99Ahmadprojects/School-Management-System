

package schoolmanagementsystems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.*;
import java.nio.file.*;

// Data Classes
class User {
    String username, password, role;
    int id;

    public User(String username, String password, String role, int id) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = id;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("username", username);
        obj.put("password", password);
        obj.put("role", role);
        obj.put("id", id);
        return obj;
    }

    public static User fromJSON(JSONObject obj) {
        return new User(
            obj.getString("username"),
            obj.getString("password"),
            obj.getString("role"),
            obj.getInt("id")
        );
    }
}

class Student {
    String name, department, grade;
    int age, id;

    public Student(String name, int age, String department, String grade, int id) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.grade = grade;
        this.id = id;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("age", age);
        obj.put("department", department);
        obj.put("grade", grade);
        obj.put("id", id);
        return obj;
    }

    public static Student fromJSON(JSONObject obj) {
        return new Student(
            obj.getString("name"),
            obj.getInt("age"),
            obj.getString("department"),
            obj.getString("grade"),
            obj.getInt("id")
        );
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Age: " + age + ", Dept: " + department + ", Grade: " + grade + ", ID: " + id;
    }
}

class Teacher {
    String name, subject;
    int age, id;

    public Teacher(String name, int age, String subject, int id) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.id = id;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("age", age);
        obj.put("subject", subject);
        obj.put("id", id);
        return obj;
    }

    public static Teacher fromJSON(JSONObject obj) {
        return new Teacher(
            obj.getString("name"),
            obj.getInt("age"),
            obj.getString("subject"),
            obj.getInt("id")
        );
    }

    @Override
    public String toString() {
        return "Teacher: " + name + ", Age: " + age + ", Subject: " + subject + ", ID: " + id;
    }
}

class Exam {
    String name, type, hall;
    int date, teacherId;

    public Exam(String name, int date, String type, String hall, int teacherId) {
        this.name = name;
        this.date = date;
        this.type = type;
        this.hall = hall;
        this.teacherId = teacherId;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("date", date);
        obj.put("type", type);
        obj.put("hall", hall);
        obj.put("teacherId", teacherId);
        return obj;
    }

    public static Exam fromJSON(JSONObject obj) {
        return new Exam(
            obj.getString("name"),
            obj.getInt("date"),
            obj.getString("type"),
            obj.getString("hall"),
            obj.getInt("teacherId")
        );
    }

    @Override
    public String toString() {
        return "Exam: " + name + ", Date: " + date + ", Type: " + type + ", Hall: " + hall + ", Teacher ID: " + teacherId;
    }
}

class Classroom {
    int number, capacity;

    public Classroom(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("number", number);
        obj.put("capacity", capacity);
        return obj;
    }

    public static Classroom fromJSON(JSONObject obj) {
        return new Classroom(
            obj.getInt("number"),
            obj.getInt("capacity")
        );
    }

    @Override
    public String toString() {
        return "Classroom: Room #" + number + ", Capacity: " + capacity;
    }
}

class Course {
    String name;
    int code;

    public Course(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("code", code);
        return obj;
    }

    public static Course fromJSON(JSONObject obj) {
        return new Course(
            obj.getString("name"),
            obj.getInt("code")
        );
    }

    @Override
    public String toString() {
        return "Course: " + name + ", Code: " + code;
    }
}

class Schedule {
    String day, start, end;
    int courseCode;

    public Schedule(String day, String start, String end, int courseCode) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.courseCode = courseCode;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("day", day);
        obj.put("start", start);
        obj.put("end", end);
        obj.put("courseCode", courseCode);
        return obj;
    }

    public static Schedule fromJSON(JSONObject obj) {
        return new Schedule(
            obj.getString("day"),
            obj.getString("start"),
            obj.getString("end"),
            obj.getInt("courseCode")
        );
    }

    @Override
    public String toString() {
        return "Schedule: " + day + ", From: " + start + " to " + end + ", Course Code: " + courseCode;
    }
}

class Assignment {
    String title, description;
    int courseCode, studentId;
    String submission;

    public Assignment(String title, String description, int courseCode, int studentId, String submission) {
        this.title = title;
        this.description = description;
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.submission = submission;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("title", title);
        obj.put("description", description);
        obj.put("courseCode", courseCode);
        obj.put("studentId", studentId);
        obj.put("submission", submission);
        return obj;
    }

    public static Assignment fromJSON(JSONObject obj) {
        return new Assignment(
            obj.getString("title"),
            obj.getString("description"),
            obj.getInt("courseCode"),
            obj.getInt("studentId"),
            obj.getString("submission")
        );
    }

    @Override
    public String toString() {
        return "Assignment: " + title + ", Description: " + description + ", Course Code: " + courseCode +
               ", Student ID: " + studentId + ", Submission: " + submission;
    }
}

class Quiz {
    String title, description;
    int courseCode, studentId;
    String submission;

    public Quiz(String title, String description, int courseCode, int studentId, String submission) {
        this.title = title;
        this.description = description;
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.submission = submission;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("title", title);
        obj.put("description", description);
        obj.put("courseCode", courseCode);
        obj.put("studentId", studentId);
        obj.put("submission", submission);
        return obj;
    }

    public static Quiz fromJSON(JSONObject obj) {
        return new Quiz(
            obj.getString("title"),
            obj.getString("description"),
            obj.getInt("courseCode"),
            obj.getInt("studentId"),
            obj.getString("submission")
        );
    }

    @Override
    public String toString() {
        return "Quiz: " + title + ", Description: " + description + ", Course Code: " + courseCode +
               ", Student ID: " + studentId + ", Submission: " + submission;
    }
}

// Main GUI Class
public class SchoolManagementSystems extends JFrame {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Exam> exams = new ArrayList<>();
    private ArrayList<Classroom> classrooms = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private ArrayList<Quiz> quizzes = new ArrayList<>();
    private User currentUser;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public SchoolManagementSystems() {
        loadData(); // Load data from JSON files
        initLoginUI();
    }

    private void initLoginUI() {
        setTitle("School Management System - Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(245, 245, 245));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("School Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(33, 150, 243));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        loginPanel.add(new JLabel("Username:"), gbc);

        JTextField usernameField = new JTextField(15);
        usernameField.setToolTipText("Enter your username");
        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(new JLabel("Password:"), gbc);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setToolTipText("Enter your password");
        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(33, 150, 243));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            if (authenticate(username, password)) {
                initMainUI();
                dispose(); // Close login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
        loginPanel.add(loginButton, gbc);

        add(loginPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            currentUser = new User("admin", "admin123", "Administrator", 0);
            return true;
        }
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    private void initMainUI() {
        JFrame mainFrame = new JFrame("School Management System");
        mainFrame.setSize(1000, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout(10, 10));

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(33, 150, 243));
        JLabel headerLabel = new JLabel("School Management System", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        JLabel userLabel = new JLabel("Logged in as: " + currentUser.username + " (" + currentUser.role + ")");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setForeground(Color.WHITE);
        userLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        headerPanel.add(userLabel, BorderLayout.EAST);
        mainFrame.add(headerPanel, BorderLayout.NORTH);

        // Sidebar
        JPanel sidebarPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        sidebarPanel.setBackground(new Color(240, 240, 240));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Map<String, String> buttonActions = new HashMap<>();
        if (currentUser.role.equals("Administrator")) {
            buttonActions.put("Add Student", "Add Student");
            buttonActions.put("Add Teacher", "Add Teacher");
            buttonActions.put("Add Classroom", "Add Classroom");
            buttonActions.put("Add Course", "Add Course");
            buttonActions.put("Add Schedule", "Add Schedule");
            buttonActions.put("Show All Data", "Show All");
        } else if (currentUser.role.equals("Teacher")) {
            buttonActions.put("Add Assignment", "Add Assignment");
            buttonActions.put("Add Quiz", "Add Quiz");
            buttonActions.put("Add Exam", "Add Exam");
            buttonActions.put("View Student Grades", "View Student Grades");
        } else if (currentUser.role.equals("Student")) {
            buttonActions.put("Submit Assignment", "Submit Assignment");
            buttonActions.put("Submit Quiz", "Submit Quiz");
            buttonActions.put("View Schedule", "View Schedule");
            buttonActions.put("View Grades", "View Grades");
        }

        for (Map.Entry<String, String> entry : buttonActions.entrySet()) {
            JButton btn = new JButton(entry.getKey());
            btn.setBackground(new Color(33, 150, 243));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setToolTipText(entry.getKey());
            btn.addActionListener(e -> handleButtonClick(entry.getValue()));
            sidebarPanel.add(btn);
        }

        mainFrame.add(sidebarPanel, BorderLayout.WEST);

        // Main Content
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(createDataPanel(), "Data");
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveData();
            }
        });

        mainFrame.setVisible(true);
    }

    private JPanel createDataPanel() {
        JPanel dataPanel = new JPanel(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));

        if (currentUser.role.equals("Administrator")) {
            tabbedPane.addTab("Students", createTablePanel(students, new String[]{"Name", "Age", "Department", "Grade", "ID"}));
            tabbedPane.addTab("Teachers", createTablePanel(teachers, new String[]{"Name", "Age", "Subject", "ID"}));
            tabbedPane.addTab("Exams", createTablePanel(exams, new String[]{"Name", "Date", "Type", "Hall", "Teacher ID"}));
            tabbedPane.addTab("Classrooms", createTablePanel(classrooms, new String[]{"Room Number", "Capacity"}));
            tabbedPane.addTab("Courses", createTablePanel(courses, new String[]{"Name", "Code"}));
            tabbedPane.addTab("Schedules", createTablePanel(schedules, new String[]{"Day", "Start", "End", "Course Code"}));
            tabbedPane.addTab("Assignments", createTablePanel(assignments, new String[]{"Title", "Description", "Course Code", "Student ID", "Submission"}));
            tabbedPane.addTab("Quizzes", createTablePanel(quizzes, new String[]{"Title", "Description", "Course Code", "Student ID", "Submission"}));
        } else if (currentUser.role.equals("Teacher")) {
            ArrayList<Exam> teacherExams = new ArrayList<>();
            for (Exam exam : exams) {
                if (exam.teacherId == currentUser.id) {
                    teacherExams.add(exam);
                }
            }
            tabbedPane.addTab("Exams", createTablePanel(teacherExams, new String[]{"Name", "Date", "Type", "Hall", "Teacher ID"}));
            tabbedPane.addTab("Assignments", createTablePanel(assignments, new String[]{"Title", "Description", "Course Code", "Student ID", "Submission"}));
            tabbedPane.addTab("Quizzes", createTablePanel(quizzes, new String[]{"Title", "Description", "Course Code", "Student ID", "Submission"}));
            // Add Grades tab for teacher
            ArrayList<Student> teacherStudents = new ArrayList<>();
            for (Assignment assignment : assignments) {
                for (Student student : students) {
                    if (assignment.studentId == student.id) {
                        boolean alreadyAdded = false;
                        for (Student s : teacherStudents) {
                            if (s.id == student.id) {
                                alreadyAdded = true;
                                break;
                            }
                        }
                        if (!alreadyAdded) {
                            teacherStudents.add(student);
                        }
                    }
                }
            }
            for (Quiz quiz : quizzes) {
                for (Student student : students) {
                    if (quiz.studentId == student.id) {
                        boolean alreadyAdded = false;
                        for (Student s : teacherStudents) {
                            if (s.id == student.id) {
                                alreadyAdded = true;
                                break;
                            }
                        }
                        if (!alreadyAdded) {
                            teacherStudents.add(student);
                        }
                    }
                }
            }
            tabbedPane.addTab("Student Grades", createTablePanel(teacherStudents, new String[]{"Name", "Age", "Department", "Grade", "ID"}));
        } else if (currentUser.role.equals("Student")) {
            ArrayList<Schedule> studentSchedules = new ArrayList<>();
            for (Schedule schedule : schedules) {
                studentSchedules.add(schedule);
            }
            tabbedPane.addTab("Schedules", createTablePanel(studentSchedules, new String[]{"Day", "Start", "End", "Course Code"}));
            ArrayList<Student> studentData = new ArrayList<>();
            for (Student student : students) {
                if (student.id == currentUser.id) {
                    studentData.add(student);
                }
            }
            tabbedPane.addTab("Grades", createTablePanel(studentData, new String[]{"Name", "Age", "Department", "Grade", "ID"}));
            tabbedPane.addTab("Assignments", createTablePanel(assignments, new String[]{"Title", "Description", "Course Code", "Student ID", "Submission"}));
            tabbedPane.addTab("Quizzes", createTablePanel(quizzes, new String[]{"Title", "Description", "Course Code", "Student ID", "Submission"}));
        }

        dataPanel.add(tabbedPane, BorderLayout.CENTER);
        return dataPanel;
    }

    private JPanel createTablePanel(ArrayList<?> data, String[] columns) {
        JPanel panel = new JPanel(new BorderLayout());
        Object[][] tableData = new Object[data.size()][columns.length];
        for (int i = 0; i < data.size(); i++) {
            Object obj = data.get(i);
            if (obj instanceof Student) {
                Student s = (Student) obj;
                tableData[i] = new Object[]{s.name, s.age, s.department, s.grade, s.id};
            } else if (obj instanceof Teacher) {
                Teacher t = (Teacher) obj;
                tableData[i] = new Object[]{t.name, t.age, t.subject, t.id};
            } else if (obj instanceof Exam) {
                Exam e = (Exam) obj;
                tableData[i] = new Object[]{e.name, e.date, e.type, e.hall, e.teacherId};
            } else if (obj instanceof Classroom) {
                Classroom c = (Classroom) obj;
                tableData[i] = new Object[]{c.number, c.capacity};
            } else if (obj instanceof Course) {
                Course c = (Course) obj;
                tableData[i] = new Object[]{c.name, c.code};
            } else if (obj instanceof Schedule) {
                Schedule s = (Schedule) obj;
                tableData[i] = new Object[]{s.day, s.start, s.end, s.courseCode};
            } else if (obj instanceof Assignment) {
                Assignment a = (Assignment) obj;
                tableData[i] = new Object[]{a.title, a.description, a.courseCode, a.studentId, a.submission};
            } else if (obj instanceof Quiz) {
                Quiz q = (Quiz) obj;
                tableData[i] = new Object[]{q.title, q.description, q.courseCode, q.studentId, q.submission};
            }
        }
        JTable table = new JTable(tableData, columns);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void handleButtonClick(String action) {
        switch (action) {
            case "Add Student" -> addStudent();
            case "Add Teacher" -> addTeacher();
            case "Add Exam" -> addExam();
            case "Add Classroom" -> addClassroom();
            case "Add Course" -> addCourse();
            case "Add Schedule" -> addSchedule();
            case "Add Assignment" -> addAssignment();
            case "Add Quiz" -> addQuiz();
            case "Submit Assignment" -> submitAssignment();
            case "Submit Quiz" -> submitQuiz();
            case "View Schedule" -> viewSchedule();
            case "View Grades" -> viewGrades();
            case "View Student Grades" -> viewStudentGrades();
            case "Show All" -> showAllData();
        }
        saveData();
        cardLayout.show(mainPanel, "Data");
    }

    private void addStudent() {
        try {
            String name = input("Student Name");
            if (name == null || name.trim().isEmpty()) {
                showMessage("Name cannot be empty.");
                return;
            }
            int age = intInput("Age");
            if (age <= 0) {
                showMessage("Age must be positive.");
                return;
            }
            String dept = input("Department");
            if (dept == null || dept.trim().isEmpty()) {
                showMessage("Department cannot be empty.");
                return;
            }
            String grade = input("Grade");
            if (grade == null || grade.trim().isEmpty()) {
                showMessage("Grade cannot be empty.");
                return;
            }
            int id = intInput("ID Card Number");
            if (id <= 0) {
                showMessage("ID must be positive.");
                return;
            }
            String username = input("Username");
            if (username == null || username.trim().isEmpty()) {
                showMessage("Username cannot be empty.");
                return;
            }
            String password = input("Password");
            if (password == null || password.trim().isEmpty()) {
                showMessage("Password cannot be empty.");
                return;
            }

            students.add(new Student(name, age, dept, grade, id));
            users.add(new User(username, password, "Student", id));
            showMessage("Student added.");
            mainPanel.removeAll();
            mainPanel.add(createDataPanel(), "Data");
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter valid numbers for Age and ID.");
        }
    }

    private void addTeacher() {
        try {
            String name = input("Teacher Name");
            if (name == null || name.trim().isEmpty()) {
                showMessage("Name cannot be empty.");
                return;
            }
            int age = intInput("Age");
            if (age <= 0) {
                showMessage("Age must be positive.");
                return;
            }
            String subject = input("Subject");
            if (subject == null || subject.trim().isEmpty()) {
                showMessage("Subject cannot be empty.");
                return;
            }
            int id = intInput("ID Number");
            if (id <= 0) {
                showMessage("ID must be positive.");
                return;
            }
            String username = input("Username");
            if (username == null || username.trim().isEmpty()) {
                showMessage("Username cannot be empty.");
                return;
            }
            String password = input("Password");
            if (password == null || password.trim().isEmpty()) {
                showMessage("Password cannot be empty.");
                return;
            }

            teachers.add(new Teacher(name, age, subject, id));
            users.add(new User(username, password, "Teacher", id));
            showMessage("Teacher added.");
            mainPanel.removeAll();
            mainPanel.add(createDataPanel(), "Data");
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter valid numbers for Age and ID.");
        }
    }

    private void addExam() {
        try {
            String name = input("Exam Paper Name");
            if (name == null || name.trim().isEmpty()) {
                showMessage("Exam name cannot be empty.");
                return;
            }
            int date = intInput("Exam Date (e.g., 20240523)");
            if (date <= 0) {
                showMessage("Date must be a valid number.");
                return;
            }
            String type = input("Exam Type");
            if (type == null || type.trim().isEmpty()) {
                showMessage("Exam type cannot be empty.");
                return;
            }
            String hall = input("Hall Name");
            if (hall == null || hall.trim().isEmpty()) {
                showMessage("Hall name cannot be empty.");
                return;
            }
            int teacherId = currentUser.role.equals("Teacher") ? currentUser.id : intInput("Teacher ID");
            if (teacherId <= 0) {
                showMessage("Teacher ID must be positive.");
                return;
            }

            exams.add(new Exam(name, date, type, hall, teacherId));
            showMessage("Exam added.");
            mainPanel.removeAll();
            mainPanel.add(createDataPanel(), "Data");
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter a valid number for Date or Teacher ID.");
        }
    }

    private void addClassroom() {
        try {
            int number = intInput("Room Number");
            if (number <= 0) {
                showMessage("Room number must be positive.");
                return;
            }
            int capacity = intInput("Room Capacity");
            if (capacity <= 0) {
                showMessage("Capacity must be positive.");
                return;
            }

            classrooms.add(new Classroom(number, capacity));
            showMessage("Classroom added.");
            mainPanel.removeAll();
            mainPanel.add(createDataPanel(), "Data");
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter valid numbers for Room Number and Capacity.");
        }
    }

    private void addCourse() {
        try {
            String name = input("Course Name");
            if (name == null || name.trim().isEmpty()) {
                showMessage("Course name cannot be empty.");
                return;
            }
            int code = intInput("Course Code");
            if (code <= 0) {
                showMessage("Course code must be positive.");
                return;
            }

            courses.add(new Course(name, code));
            showMessage("Course added.");
            mainPanel.removeAll();
            mainPanel.add(createDataPanel(), "Data");
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter a valid number for Course Code.");
        }
    }

    private void addSchedule() {
        try {
            String day = input("Day of Week");
            if (day == null || day.trim().isEmpty()) {
                showMessage("Day cannot be empty.");
                return;
            }
            String start = input("Start Time");
            if (start == null || start.trim().isEmpty()) {
                showMessage("Start time cannot be empty.");
                return;
            }
            String end = input("End Time");
            if (end == null || end.trim().isEmpty()) {
                showMessage("End time cannot be empty.");
                return;
            }
            int courseCode = intInput("Course Code");
            if (courseCode <= 0) {
                showMessage("Course code must be positive.");
                return;
            }

            schedules.add(new Schedule(day, start, end, courseCode));
            showMessage("Schedule added.");
            mainPanel.removeAll();
            mainPanel.add(createDataPanel(), "Data");
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter a valid number for Course Code.");
        }
    }

    private void addAssignment() {
        try {
            String title = input("Assignment Title");
            if (title == null || title.trim().isEmpty()) {
                showMessage("Title cannot be empty.");
                return;
            }
            String description = input("Description");
            if (description == null || description.trim().isEmpty()) {
                showMessage("Description cannot be empty.");
                return;
            }
            int courseCode = intInput("Course Code");
            if (courseCode <= 0) {
                showMessage("Course code must be positive.");
                return;
            }
            int studentId = intInput("Student ID");
            if (studentId <= 0) {
                showMessage("Student ID must be positive.");
                return;
            }

            assignments.add(new Assignment(title, description, courseCode, studentId, "Pending"));
            showMessage("Assignment added.");
            mainPanel.removeAll();
            mainPanel.add(createDataPanel(), "Data");
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter valid numbers for Course Code and Student ID.");
        }
    }

    private void addQuiz() {
        try {
            String title = input("Quiz Title");
            if (title == null || title.trim().isEmpty()) {
                showMessage("Title cannot be empty.");
                return;
            }
            String description = input("Description");
            if (description == null || description.trim().isEmpty()) {
                showMessage("Description cannot be empty.");
                return;
            }
            int courseCode = intInput("Course Code");
            if (courseCode <= 0) {
                showMessage("Course code must be positive.");
                return;
            }
            int studentId = intInput("Student ID");
            if (studentId <= 0) {
                showMessage("Student ID must be positive.");
                return;
            }

            quizzes.add(new Quiz(title, description, courseCode, studentId, "Pending"));
            showMessage("Quiz added.");
            mainPanel.removeAll();
            mainPanel.add(createDataPanel(), "Data");
            mainPanel.revalidate();
            mainPanel.repaint();
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter valid numbers for Course Code and Student ID.");
        }
    }

    private void submitAssignment() {
        try {
            String title = input("Assignment Title");
            if (title == null || title.trim().isEmpty()) {
                showMessage("Title cannot be empty.");
                return;
            }
            String submission = input("Submission Details");
            if (submission == null || submission.trim().isEmpty()) {
                showMessage("Submission details cannot be empty.");
                return;
            }
            int courseCode = intInput("Course Code");
            if (courseCode <= 0) {
                showMessage("Course code must be positive.");
                return;
            }

            for (Assignment assignment : assignments) {
                if (assignment.title.equals(title) && assignment.courseCode == courseCode && assignment.studentId == currentUser.id) {
                    assignment.submission = submission;
                    showMessage("Assignment submitted.");
                    mainPanel.removeAll();
                    mainPanel.add(createDataPanel(), "Data");
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    return;
                }
            }
            showMessage("Assignment not found.");
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter a valid number for Course Code.");
        }
    }

    private void submitQuiz() {
        try {
            String title = input("Quiz Title");
            if (title == null || title.trim().isEmpty()) {
                showMessage("Title cannot be empty.");
                return;
            }
            String submission = input("Submission Details");
            if (submission == null || submission.trim().isEmpty()) {
                showMessage("Submission details cannot be empty.");
                return;
            }
            int courseCode = intInput("Course Code");
            if (courseCode <= 0) {
                showMessage("Course code must be positive.");
                return;
            }

            for (Quiz quiz : quizzes) {
                if (quiz.title.equals(title) && quiz.courseCode == courseCode && quiz.studentId == currentUser.id) {
                    quiz.submission = submission;
                    showMessage("Quiz submitted.");
                    mainPanel.removeAll();
                    mainPanel.add(createDataPanel(), "Data");
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    return;
                }
            }
            showMessage("Quiz not found.");
        } catch (NumberFormatException e) {
            showMessage("Invalid number format. Please enter a valid number for Course Code.");
        }
    }

    private void viewSchedule() {
        mainPanel.removeAll();
        mainPanel.add(createDataPanel(), "Data");
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void viewGrades() {
        mainPanel.removeAll();
        mainPanel.add(createDataPanel(), "Data");
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void viewStudentGrades() {
        mainPanel.removeAll();
        mainPanel.add(createDataPanel(), "Data");
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showAllData() {
        mainPanel.removeAll();
        mainPanel.add(createDataPanel(), "Data");
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private String input(String msg) {
        return JOptionPane.showInputDialog(this, msg);
    }

    private int intInput(String msg) throws NumberFormatException {
        String input = JOptionPane.showInputDialog(this, msg);
        if (input == null || input.trim().isEmpty()) {
            throw new NumberFormatException("Input cannot be empty.");
        }
        return Integer.parseInt(input.trim());
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    private void saveData() {
        try {
            // Save Users
            JSONArray usersArray = new JSONArray();
            for (User user : users) {
                usersArray.put(user.toJSON());
            }
            writeJSONToFile("users.json", usersArray);

            // Save Students
            JSONArray studentsArray = new JSONArray();
            for (Student student : students) {
                studentsArray.put(student.toJSON());
            }
            writeJSONToFile("students.json", studentsArray);

            // Save Teachers
            JSONArray teachersArray = new JSONArray();
            for (Teacher teacher : teachers) {
                teachersArray.put(teacher.toJSON());
            }
            writeJSONToFile("teachers.json", teachersArray);

            // Save Exams
            JSONArray examsArray = new JSONArray();
            for (Exam exam : exams) {
                examsArray.put(exam.toJSON());
            }
            writeJSONToFile("exams.json", examsArray);

            // Save Classrooms
            JSONArray classroomsArray = new JSONArray();
            for (Classroom classroom : classrooms) {
                classroomsArray.put(classroom.toJSON());
            }
            writeJSONToFile("classrooms.json", classroomsArray);

            // Save Courses
            JSONArray coursesArray = new JSONArray();
            for (Course course : courses) {
                coursesArray.put(course.toJSON());
            }
            writeJSONToFile("courses.json", coursesArray);

            // Save Schedules
            JSONArray schedulesArray = new JSONArray();
            for (Schedule schedule : schedules) {
                schedulesArray.put(schedule.toJSON());
            }
            writeJSONToFile("schedules.json", schedulesArray);

            // Save Assignments
            JSONArray assignmentsArray = new JSONArray();
            for (Assignment assignment : assignments) {
                assignmentsArray.put(assignment.toJSON());
            }
            writeJSONToFile("assignments.json", assignmentsArray);

            // Save Quizzes
            JSONArray quizzesArray = new JSONArray();
            for (Quiz quiz : quizzes) {
                quizzesArray.put(quiz.toJSON());
            }
            writeJSONToFile("quizzes.json", quizzesArray);
        } catch (Exception e) {
            showMessage("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try {
            // Load Users
            File usersFile = new File("users.json");
            if (usersFile.exists()) {
                JSONArray usersArray = new JSONArray(new String(Files.readAllBytes(usersFile.toPath())));
                for (int i = 0; i < usersArray.length(); i++) {
                    users.add(User.fromJSON(usersArray.getJSONObject(i)));
                }
            }

            // Load Students
            File studentsFile = new File("students.json");
            if (studentsFile.exists()) {
                JSONArray studentsArray = new JSONArray(new String(Files.readAllBytes(studentsFile.toPath())));
                for (int i = 0; i < studentsArray.length(); i++) {
                    students.add(Student.fromJSON(studentsArray.getJSONObject(i)));
                }
            }

            // Load Teachers
            File teachersFile = new File("teachers.json");
            if (teachersFile.exists()) {
                JSONArray teachersArray = new JSONArray(new String(Files.readAllBytes(teachersFile.toPath())));
                for (int i = 0; i < teachersArray.length(); i++) {
                    teachers.add(Teacher.fromJSON(teachersArray.getJSONObject(i)));
                }
            }

            // Load Exams
            File examsFile = new File("exams.json");
            if (examsFile.exists()) {
                JSONArray examsArray = new JSONArray(new String(Files.readAllBytes(examsFile.toPath())));
                for (int i = 0; i < examsArray.length(); i++) {
                    exams.add(Exam.fromJSON(examsArray.getJSONObject(i)));
                }
            }

            // Load Classrooms
            File classroomsFile = new File("classrooms.json");
            if (classroomsFile.exists()) {
                JSONArray classroomsArray = new JSONArray(new String(Files.readAllBytes(classroomsFile.toPath())));
                for (int i = 0; i < classroomsArray.length(); i++) {
                    classrooms.add(Classroom.fromJSON(classroomsArray.getJSONObject(i)));
                }
            }

            // Load Courses
            File coursesFile = new File("courses.json");
            if (coursesFile.exists()) {
                JSONArray coursesArray = new JSONArray(new String(Files.readAllBytes(coursesFile.toPath())));
                for (int i = 0; i < coursesArray.length(); i++) {
                    courses.add(Course.fromJSON(coursesArray.getJSONObject(i)));
                }
            }

            // Load Schedules
            File schedulesFile = new File("schedules.json");
            if (schedulesFile.exists()) {
                JSONArray schedulesArray = new JSONArray(new String(Files.readAllBytes(schedulesFile.toPath())));
                for (int i = 0; i < schedulesArray.length(); i++) {
                    schedules.add(Schedule.fromJSON(schedulesArray.getJSONObject(i)));
                }
            }

            // Load Assignments
            File assignmentsFile = new File("assignments.json");
            if (assignmentsFile.exists()) {
                JSONArray assignmentsArray = new JSONArray(new String(Files.readAllBytes(assignmentsFile.toPath())));
                for (int i = 0; i < assignmentsArray.length(); i++) {
                    assignments.add(Assignment.fromJSON(assignmentsArray.getJSONObject(i)));
                }
            }

            // Load Quizzes
            File quizzesFile = new File("quizzes.json");
            if (quizzesFile.exists()) {
                JSONArray quizzesArray = new JSONArray(new String(Files.readAllBytes(quizzesFile.toPath())));
                for (int i = 0; i < quizzesArray.length(); i++) {
                    quizzes.add(Quiz.fromJSON(quizzesArray.getJSONObject(i)));
                }
            }
        } catch (Exception e) {
            showMessage("Error loading data: " + e.getMessage());
        }
    }

    private void writeJSONToFile(String filename, JSONArray array) throws IOException {
        try (FileWriter file = new FileWriter(filename)) {
            file.write(array.toString(2));
            file.flush();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SchoolManagementSystems());
    }
}
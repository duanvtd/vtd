// CleanSchoolProgram.java
// Phiên bản refactor: Code sạch, OOP
// Điểm chính: 
// - Tách class Student/Teacher/Course thay vì lưu chuỗi "id|field1|..."
// - Sử dụng List<T> thay cho ArrayList<String>
// - Tách riêng từng chức năng quản lý bằng hàm -> dễ đọc, dễ bảo trì

import java.util.*;

// ===== Class Sinh viên =====
class Student {
    private String id;
    private String name;
    private int age;
    private double gpa;

    // Constructor khởi tạo sinh viên
    public Student(String id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Getter & Setter
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    // Hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | GPA: %.2f", id, name, age, gpa);
    }
}
// ===== Class Giáo viên =====
class Teacher {
    private String id;
    private String name;
    private String major;

    public Teacher(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Major: %s", id, name, major);
    }
}
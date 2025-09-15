// CleanSchoolProgram.java
// Phiên bản refactor: Code sạch, OOP
// Điểm chính: 
// - Tách class Student/Teacher/Course thay vì lưu chuỗi "id|field1|..."
// - Sử dụng List<T> thay cho ArrayList<String>
// - Tách riêng từng chức năng quản lý bằng hàm -> dễ đọc, dễ bảo trì
//GD
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


// ===== Chương trình chính =====
public class CleanSchoolProgram {
    // Danh sách quản lý riêng cho từng đối tượng
    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu = 0;

        while (menu != 99) {
            // Menu chính
            System.out.println("===== MENU CHINH (CLEAN CODE) =====");
            System.out.println("1. Quan ly Sinh vien");
            System.out.println("2. Quan ly Giao vien");
            System.out.println("3. Quan ly Mon hoc");
            System.out.println("99. Thoat");
            System.out.print("Nhap lua chon: ");
            menu = Integer.parseInt(sc.nextLine());

            // Chia nhỏ chức năng bằng switch-case
            switch (menu) {
                case 1 -> manageStudents(sc);
                case 2 -> manageTeachers(sc);
                case 3 -> manageCourses(sc);
            }
        }
    }

    // ===== Quản lý Sinh viên =====
    private static void manageStudents(Scanner sc) {
        System.out.println("--- QUAN LY SINH VIEN ---");
        System.out.println("1. Them SV");
        System.out.println("2. Hien thi tat ca SV");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            // Nhập thông tin sinh viên
            System.out.print("Nhap id: ");
            String id = sc.nextLine();
            System.out.print("Nhap ten: ");
            String name = sc.nextLine();
            System.out.print("Nhap tuoi: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            // Thêm vào danh sách
            students.add(new Student(id, name, age, gpa));
        } else if (choice == 2) {
            // In toàn bộ sinh viên
            students.forEach(System.out::println);
        }
    }

    // ===== Quản lý Giáo viên =====
    private static void manageTeachers(Scanner sc) {
        System.out.println("--- QUAN LY GIAO VIEN ---");
        System.out.print("Nhap id: ");
        String id = sc.nextLine();
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap chuyen mon: ");
        String major = sc.nextLine();

        teachers.add(new Teacher(id, name, major));
        teachers.forEach(System.out::println);
    }

    // ===== Quản lý Môn học =====
    private static void manageCourses(Scanner sc) {
        System.out.println("--- QUAN LY MON HOC ---");
        System.out.print("Nhap id: ");
        String id = sc.nextLine();
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap tin chi: ");
        int credits = Integer.parseInt(sc.nextLine());

        courses.add(new Course(id, name, credits));
        courses.forEach(System.out::println);
    }
}
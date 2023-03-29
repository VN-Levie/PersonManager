package data;

import java.util.Scanner;

/**
 * Bài tập về nhà:
 * - Tạo lớp ProfileManager để quản lý danh sách các Profile, chức năng:
 * Thêm sinh viên
 * Thêm nhân viên
 * Hiển thị danh sách sinh viên + nhân viên
 * Chỉ hiển thị danh sách nhân viên
 * Tìm kiếm nhân viên theo tên
 * Tìm kiếm sinh viên theo tên
 * Xoá nhân viên theo id
 */
public class ProfileManager {

    Student[] students;
    Employee[] employees;
    int countStudent = 0;
    int countEmployee = 0;
    int nStudent = 0;
    int nEmployee = 0;
    int nTotal = 0;

    public ProfileManager(int nStudent, int nEmployee) {
        this.nStudent = nStudent;
        this.nEmployee = nEmployee;
        this.nTotal = nStudent + nEmployee;
        students = new Student[nStudent];
        employees = new Employee[nEmployee];
    }

    public ProfileManager() {
    }

    public void addStudent(Student student) {
        if (!checkFullStudent()) {
            students[countStudent] = student;
            countStudent++;
        }

    }

    public void addEmployee(Employee employee) {
        if (!checkFullEmployee()) {
            employees[countEmployee] = employee;
            countEmployee++;
        }

    }

    public void showAll() {
        if (!checkEmptyStudent()) {
            for (int i = 0; i < countStudent; i++) {
                if (students[i] == null)
                    continue;
                System.out.printf("\n%d. %s - Student", i + 1, students[i]);

            }
        }
        if (!checkEmptyEmployee()) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i] == null)
                    continue;
                System.out.printf("\n%d. %s - Employee", i + 1 + countStudent, employees[i]);
            }
        }
    }

    public void showEmployee() {
        if (!checkEmptyEmployee()) {
            for (int i = 0; i < countEmployee; i++) {
                if (employees[i] == null)
                    continue;
                System.out.printf("\n%d. %s", i + 1, employees[i]);
            }
        }
    }

    public void searchStudent(String name) {
        if (!checkEmptyStudent()) {
            boolean found = false;
            for (int i = 0; i < nStudent; i++) {
                if (students[i].name.equals(name)) {
                    System.out.println(students[i]);
                    found = true;
                }
                if (students[i] == null)
                    break;
            }
            if (!found)
                System.out.println(">> Khong tim thay sinh vien co ten " + name);
        }
    }

    public void searchEmployee(String name) {
        if (!checkEmptyEmployee()) {
            boolean found = false;
            for (int i = 0; i < nEmployee; i++) {
                if (employees[i].name.equals(name)) {
                    System.out.println(employees[i]);
                    found = true;
                }
                if (employees[i] == null)
                    break;
            }
            if (!found)
                System.out.println(">> Khong tim thay nhan vien co ten " + name);
        }
    }

    public void deleteEmployee(String id) {

        if (!checkEmptyEmployee()) {
            boolean found = false;
            for (int i = 0; i < nEmployee; i++) {
                if (employees[i].id.equals(id)) {
                    employees[i] = null;
                    found = true;
                    countEmployee--;
                    System.out.println(">> Xoa thanh cong");
                }
                if (employees[i] == null)
                    break;
            }
            if (!found)
                System.out.println(">> Khong tim thay nhan vien co id " + id);
        }

    }

    public void deleteAllStudent() {
        if (!checkEmptyStudent()) {
            for (int i = 0; i < nStudent; i++) {
                students[i] = null;
            }
            countStudent = 0;
            System.out.println(">> Xoa thanh cong");
        }

    }

    public void deleteAllEmployee() {
        if (!checkEmptyEmployee()) {
            for (int i = 0; i < nEmployee; i++) {
                employees[i] = null;
            }
            countEmployee = 0;
            System.out.println(">> Xoa thanh cong");
        }
    }

    public void deleteAll() {
        deleteAllStudent();
        deleteAllEmployee();
    }

    public boolean checkEmptyStudent() {
        if (students[0] == null) {
            System.out.println("\n>> Danh sach sinh vien trong");
            return true;
        }
        return false;
    }

    public boolean checkEmptyEmployee() {
        if (employees[0] == null) {
            System.out.println("\n>> Danh sach nhan vien trong");
            return true;
        }
        return false;

    }

    public boolean checkFullStudent() {
        if (countStudent == nStudent) {
            System.out.println("\n>> Danh sach sinh vien day");
            return true;
        }
        return false;
    }

    public boolean checkFullEmployee() {
        if (countEmployee == nEmployee) {
            System.out.println("\n>> Danh sach nhan vien day");
            return true;
        }
        return false;
    }

    public void menu() {
        System.out.println("\n//---MENU---//");
        System.out.println("1. Them sinh vien");
        System.out.println("2. Them nhan vien");
        System.out.println("3. Hien thi danh sach sinh vien + nhan vien");
        System.out.println("4. Hien thi danh sach nhan vien");
        System.out.println("5. Tim kiem nhan vien theo ten");
        System.out.println("6. Tim kiem sinh vien theo ten");
        System.out.println("7. Xoa nhan vien theo id");
        System.out.println("8. Xoa toan bo sinh vien");
        System.out.println("9. Xoa toan bo nhan vien");
        System.out.println("10. Xoa toan bo sinh vien + nhan vien");
        System.out.println("11. Thoat");
        System.out.println("//----------//");
    }

    public static void main(String[] args) {
        ProfileManager pm = new ProfileManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nNhap so luong sinh vien: ");
            int nStudent = Integer.parseInt(sc.nextLine().trim());
            System.out.print("\nNhap so luong nhan vien: ");
            int nEmployee = Integer.parseInt(sc.nextLine().trim());
            if (nStudent <= 0 || nEmployee <= 0) {
                System.out.print(">> LOI: So luong sinh vien hoac nhan vien khong hop le");
            } else {
                pm = new ProfileManager(nStudent, nEmployee);
                System.out.printf("So luong sinh vien: %d, so luong nhan vien: %d, tong so luong: %d", nStudent,
                        nEmployee, nStudent + nEmployee);
                break;
            }

        }
        while (true) {
            pm.menu();
            System.out.print("Nhap lua chon: ");
            int choice = Integer.parseInt(sc.nextLine().trim());
            switch (choice) {
                case 1:
                    if (pm.countStudent == pm.nStudent) {
                        System.out.println(">> LOI: Danh sach sinh vien da day");
                        break;
                    }
                    Student student = new Student();
                    student.input();
                    pm.addStudent(student);
                    break;
                case 2:
                    if (!pm.checkFullEmployee()) {
                        Employee employee = new Employee();
                        employee.input();
                        pm.addEmployee(employee);
                    }
                    break;
                case 3:
                    pm.showAll();
                    break;
                case 4:
                    pm.showEmployee();
                    break;
                case 5:
                    if (!pm.checkEmptyEmployee()) {
                        System.out.print("Nhap ten nhan vien can tim: ");
                        String eName = sc.nextLine().trim();
                        pm.searchEmployee(eName);
                    }
                    break;
                case 6:
                    if (!pm.checkEmptyStudent()) {
                        System.out.print("Nhap ten sinh vien can tim: ");
                        String sName = sc.nextLine().trim();
                        pm.searchStudent(sName);
                    }
                    break;
                case 7:
                    if (!pm.checkEmptyEmployee()) {
                        System.out.print("Nhap id nhan vien can xoa: ");
                        String id = sc.nextLine().trim();
                        pm.deleteEmployee(id);
                    }
                    break;
                case 8:
                    pm.deleteAllStudent();
                    break;
                case 9:
                    pm.deleteAllEmployee();
                    break;
                case 10:
                    pm.deleteAll();
                    break;
                case 11:
                    System.out.println(">> KET THUC CHUONG TRINH");
                    System.exit(0);
                    break;
                default:
                    System.out.println(">> LOI: Lua chon khong hop le");
                    break;
            }
        }

    }

}

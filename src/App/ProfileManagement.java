package App;

import java.util.Scanner;

/**
 * Chương trình quản lý hồ sơ cá nhân
 * 1. Them nhan vien
 * 2. Them sinh vien
 * 3. In toan bo nhan vien + sinh vien
 * 4. In danh sach nhan vien
 * 5. Tim nhan vien theo ten
 * 6. xoa nhan vien theo ID
 * 7. Thoat chuong trinh
 */
import data.*;

public class ProfileManagement {

    public static void main(String[] args) {
        ProfileManagement p = new ProfileManagement();
        p.menu();
    }

    int max = 10;
    int index = 0;
    Person[] ds = new Person[max];

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Them sinh vien");
            System.out.println("3. In toan bo nhan vien + sinh vien");
            System.out.println("4. In danh sach nhan vien");
            System.out.println("5. Tim nhan vien theo ten");
            System.out.println("6. Xoa nhan vien theo ID");
            System.out.println("7. Thoat chuong trinh");
            System.out.print("Nhap lua chon[1-7]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    addEmployee();
                    break;
                case "2":
                    addStudent();
                    break;
                case "3":
                    printAll();
                    break;
                case "4":
                    displayEmp();
                    break;
                case "5":
                    System.out.print("\n Nhap ten nhan vien can tim:");
                    String name = sc.nextLine().trim();
                    displayEmp(name);
                    break;
                case "6":
                    System.out.print("\n Nhap ID nhan vien can xoa:");
                    String id = sc.nextLine().trim();
                    removeEmployee(id);
                    break;
                case "7":
                    System.out.println("Thoat chuong trinh");
                    return;
                default:
                    System.out.println(">> LOI: Nhap sai, vui long nhap lai");
            }
        }

    }

    private void displayEmp(String name) {
        System.out.println("\n>> Danh sach nhan vien");
        // check danh sach rong
        if (index == 0) {
            System.out.println(">> LOI: Danh sach rong");
            return;
        }
        boolean found = false;
        name = name.toLowerCase();
        for (int i = 0; i < index; i++) {
            if (ds[i] instanceof Employee) {
                if (ds[i].getName().toLowerCase().contains(name)) {
                    System.out.println(ds[i]);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println(">> LOI: Khong tim thay nhan vien nao");
        }
    }

    private void removeEmployee(String id) {
        System.out.println("\n>> Danh sach nhan vien");
        // check danh sach rong
        if (index == 0) {
            System.out.println(">> LOI: Danh sach rong");
            return;
        }
        id = id.toLowerCase();
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (ds[i] instanceof Employee) {
                if (ds[i].getId().toLowerCase().equals(id)) {
                    for (int j = i; j < index - 1; j++) {
                        ds[j] = ds[j + 1]; // dich chuyen phan tu
                    }
                    index--;
                    found = true;
                    System.out.println(">> Xoa thanh cong");
                    break;
                }
            }
        }
        if (!found) {
            System.out.println(">> LOI: Khong tim thay nhan vien nao");
        }
    }

    private void displayEmp() {
        System.out.println("\n>> Danh sach nhan vien");
        // check danh sach rong
        if (index == 0) {
            System.out.println(">> LOI: Danh sach rong");
            return;
        }
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (ds[i] instanceof Employee) {
                System.out.println(ds[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println(">> LOI: Khong tim thay nhan vien nao");
        }
    }

    private void printAll() {
        System.out.println("\n>> Danh sach nhan vien + sinh vien");
        // check danh sach rong
        if (index == 0) {
            System.out.println(">> LOI: Danh sach rong");
            return;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(ds[i]);
        }
    }

    private void addStudent() {
        // kiem tra danh sach sinh vien da day chua
        if (index == max) {
            System.out.println(">> LOI: Danh sach sinh vien da day");
            return;
        }
        // tao doi tuong sinh vien
        Student s = new Student();
        s.input();
        // them doi tuong vao danh sach
        ds[index] = s;
        index++;
        // thong bao them thanh cong
        System.out.println(">> Them sinh vien thanh cong");
    }

    private void addEmployee() {
        // kiem tra danh sach nhan vien da day chua
        if (index == max) {
            System.out.println(">> LOI: Danh sach nhan vien da day");
            return;
        }
        // tao doi tuong nhan vien
        Employee e = new Employee();
        e.input();
        // them doi tuong vao danh sach
        ds[index] = e;
        index++;
        // thong bao them thanh cong
        System.out.println(">> Them nhan vien thanh cong");
    }

}

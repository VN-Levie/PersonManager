package data;

import java.util.Scanner;

/**
 * Bao gồm các thuộc tính của một người:
 * - id, name, gender, email
 * Phương thức:
 * input()
 */
public class Person {
    // Lớp con chỉ có thể kế thừa các thuộc tính public và protected. Không kế thừa
    // private
    protected String id;
    protected String name;    
    protected String email;
    protected boolean gender;

    // hàm khởi tạo không tham số

    public Person() {
    }

    // hàm khởi tạo có tham số

    public Person(String id, String name, String email, boolean gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;

    }

    // hàm nhập thông tin
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin ca nhan:");
        System.out.print("Nhap id: ");
        id = sc.nextLine();
        System.out.print("Nhap ten: ");
        name = sc.nextLine();
        System.out.print("Nhap email: ");
        email = sc.nextLine();
        System.out.print("Nhap goi tinh [nam/nu]: ");
        var gt = "";
        while (true) {
            gt = sc.nextLine();
            if (!gt.equalsIgnoreCase("nam") && !gt.equalsIgnoreCase("nu")) {
                System.out.println(">> Nhap sai, vui long nhap lai [nam/nu]: ");
            } else {
                gender = gt.equalsIgnoreCase("nam") ? true : false;
                break;
            }
        }
        // System.out.println("Thong tin ca nhan vua nhap: " + this);

    }
    public static void main(String[] args) {
        Person p = new Person();
        p.input();
    }
    @Override
    public String toString() {        
        return id + ", " + name + ", " + email + ", " + (gender ? "nam" : "nu");
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

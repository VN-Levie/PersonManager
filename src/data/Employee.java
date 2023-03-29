package data;

/**
 * Mô tả thông tin của một nhân viên - kế thừa từ lớp Person
 * Thêm các thuộc tính:
 * - salary: lương
 * - position: chức vụ
 * Lập trình lại hàm input() và toString()
 */

public class Employee extends Person {
    public String position;
    public int salary;

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, email: %s, gender: %s, position: %s, salary: %d", id, name, email,
                gender ? "Nam" : "Nu", position, salary);
    }

    // hàm nhập thông tin
    @Override
    public void input() {
        super.input(); // gọi hàm input() của lớp cha (Person)
        var sc = new java.util.Scanner(System.in);
        System.out.print("Nhap chuc vu: ");
        position = sc.nextLine().trim();
        System.out.print("Nhap luong [>0]: ");
        while (true) {
            salary = Integer.parseInt(sc.nextLine().trim());
            if (salary < 0) {
                System.out.println(">> Nhap sai, vui long nhap lai [>0]: ");
            } else {
                break;
            }
        }

    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.input();
        System.out.println(e);
    }

}

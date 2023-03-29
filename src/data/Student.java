package data;

/**
 * Thông tin sinh viên - kế thừa từ lớp Person. Dùng từ khóa extends để kế thừa
 * Thêm các thuộc tính:
 * - certificate: chứng chỉ
 * - mark: điểm cuối khoá
 * Lập trình lại hàm input() và toString()
 */
public class Student extends Person {
    public boolean certificate;
    public int mark;

    @Override
    public String toString() {

        return String.format("id: %s, name: %s, email: %s, gender: %s, certificate: %s, mark: %d", id, name, email, gender ? "Nam" : "Nu",
                certificate ? "Co" : "Khong", mark);
    }

    // hàm nhập thông tin
    @Override
    public void input() {
        super.input(); // gọi hàm input() của lớp cha (Person)
        var sc = new java.util.Scanner(System.in);
        System.out.print("Nhap chung chi [co/khong]: ");
        var cc = "";
        while (true) {
            cc = sc.nextLine();
            if (!cc.equalsIgnoreCase("co") && !cc.equalsIgnoreCase("khong")) {
                System.out.println(">> Nhap sai, vui long nhap lai [co/khong]: ");
            } else {
                certificate = cc.equalsIgnoreCase("co") ? true : false;
                break;
            }
        }
        System.out.print("Nhap diem (0-100): ");
        while (true) {

            mark = Integer.parseInt(sc.nextLine().trim());
            if (mark < 0 || mark > 100) {
                System.out.println(">> Nhap sai, vui long nhap lai [0-100]: ");
            } else {
                break;
            }

        }

    }

    public static void main(String[] args) {
        Student s = new Student();
        s.input();
        System.out.println(s);
    }

}

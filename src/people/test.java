package people;


public class test {
    public static void main(String[] args) {
        Person person = new Person ("Name","Address");
        Student student = new Student ("Name","Address","Program",3,230.5);
        Staff staff = new Staff ("Name","Address","School",300.4);

        System.out.println(person);
        System.out.println(student);
        System.out.println(staff);
    }
}

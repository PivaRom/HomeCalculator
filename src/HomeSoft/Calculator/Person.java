package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.
 */
public class Person extends EntityEx implements ConsolePrintable {
    private String FirstName;
    private String SecondName;
    private String LastName;

    private void init(){
        this.FirstName = "";
        this.SecondName = "";
        this.LastName = "";
    }

    public Person(Integer id, String code, String name, String firstName, String secondName, String lastName) {
        super(id, code, name);
        this.init();
        this.FirstName = firstName;
        this.SecondName = secondName;
        this.LastName = lastName;
    }

    public Person(Integer id, String code, String firstName, String secondName, String lastName) {
        super(id, code);
        this.init();
        this.FirstName = firstName;
        this.SecondName = secondName;
        this.LastName = lastName;
    }

    public Person(String firstName, String secondName, String lastName) {
        super();
        this.init();
        this.FirstName = firstName;
        this.SecondName = secondName;
        this.LastName = lastName;
    }

    public Person() {
        super();
        this.init();
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        if (!super.equals(o)) return false;

        Person person = (Person) o;

        if (getFirstName() != null ? !getFirstName().equals(person.getFirstName()) : person.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(person.getSecondName()) : person.getSecondName() != null)
            return false;
        return getLastName() != null ? getLastName().equals(person.getLastName()) : person.getLastName() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    public void print() {
        System.out.print(this.toString());
    }

    public void println() {
        System.out.println(this.toString());
    }


}

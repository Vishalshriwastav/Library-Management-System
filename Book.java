import java.util.*;

public class Book
{
    private String name;
    private String author;
    private String publisher;
    private int numberOfPages;
    private int edition;
    private Student std=null;
    
    public void takeInput()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("What is Name ?");
        name=sc.nextLine();
        System.out.println("What is Author ?");
        author=sc.nextLine();
        System.out.println("What is Publisher ?");
        publisher=sc.nextLine();
        System.out.println("What is Number Of Pages ?");
        numberOfPages=sc.nextInt();
        System.out.println("What is Edition ?");
        edition=sc.nextInt();
    }
    
    public String getName()
    {
        return name;
    }
    public Student getStudent()
    {
        return std;
    }
    public void setStudent(Student std)
    {
        this.std=std;
    }
    public void printDetails()
    {
        System.out.println("The Details are:");
        System.out.println("Name :"+name);
        System.out.println("Author :"+author);
        System.out.println("Publisher :"+publisher);
        System.out.println("Number Of Pages :"+numberOfPages);
        System.out.println("Edition :"+edition);
    }
    public void editDetails()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("What is new Name ? [Previous: "+name+"]");
        name=sc.nextLine();
        System.out.println("What is new Author ? [Previous: "+author+"]");
        author=sc.nextLine();
        System.out.println("What is new Publisher ? [Previous: "+publisher+"]");
        publisher=sc.nextLine();
        System.out.println("What is new Number Of Pages ? [Previous: "+numberOfPages+"]");
        numberOfPages=sc.nextInt();
        System.out.println("What is new Edition ? [Previous: "+edition+"]");
        edition=sc.nextInt();
    }
}
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Student {
    private String name;
    private int roll;
    private int fine=0;
    private String lastIssuedOn="";

    public void takeInput()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("What is Your Name ?");
        name=sc.nextLine();
        System.out.println("What is Your Roll No. ?");
        roll=sc.nextInt();
    }

    public int getRoll()
    {
        return roll;
    }

    public String getName()
    {
        return name;
    }

    public boolean isIssued()
    {
        return !lastIssuedOn.isEmpty();
    }

    public void issueBook()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("What is todays date? [DD/MM/YYYY]");
        lastIssuedOn=sc.nextLine();
    }

    public void returnBook()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("What is todays date? [DD/MM/YYYY]");
        String rd=sc.nextLine();
        System.out.println("Thanks For Returning The Book");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d1 = LocalDate.parse(lastIssuedOn, dtf);
        LocalDate d2 = LocalDate.parse(rd, dtf);
        long days = ChronoUnit.DAYS.between(d1, d2);
        if(days>15)
        {
            System.out.println("You have to pay a fine of Rs "+((days-15)*5));
            fine+=((days-15)*5);
        } 
        lastIssuedOn="";
    }

    public void payFine()
    {
        if(fine==0)
        {
            System.out.println("You Have No Fine To Pay");
        }
        else
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Your Due Amount Is Rs"+fine);
            System.out.println("Do You want to pay? [y-yes/n-no]");
            char ch=sc.next().charAt(0);
            if(ch=='y')
            {
                fine=0;
                System.out.println("You Have Paid Your Fine");
            }
        }
    }
}

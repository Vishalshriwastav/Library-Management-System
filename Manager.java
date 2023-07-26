import java.util.*;

public class Manager {

    static Book bk[]=new Book[5];
    static int bookCounter=0;
    static Student sd[]=new Student[5];
    static int studentCounter=0;
    
    public static void insertBook()
    {
        if(bookCounter<5)
        {
            Book b=new Book();
            b.takeInput();
            bk[bookCounter]=b;
            bookCounter++;
        }
        else
        {
            System.out.println("Maximum Limit Reached");
        }
    }
    
    public static void searchBook()
    {
        Scanner sc=new Scanner(System.in);
        int flag=0;
        System.out.println("Enter name of the book you want to find");
        String n=sc.nextLine();
        for(int i=0;i<bookCounter;i++)
        {
            if(bk[i].getName().equals(n))
            {
                bk[i].printDetails();
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("No Book Found");
        }
    }
    
    public static void updateBook()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter index which you want to edit");
        for(int i=0;i<bookCounter;i++)
        {
            System.out.println((i+1)+". "+bk[i].getName());
        }
        int c=sc.nextInt();
        if(c-1<bookCounter)
        {
            bk[c-1].editDetails();
        }
        else
        {
            System.out.println("Invalid Index Entered");
        }
    }

    public static void issueBook()
    {
        int flag=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Have You Registered? [y-yes/n-no]");
        char ch=sc.next().charAt(0);
        if(ch=='y')
        {
            System.out.println("Enter Your Roll Number");
            int r=sc.nextInt();
            for(int i=0;i<studentCounter;i++)
            {
                if(sd[i].getRoll()==r)
                {
                    System.out.println("Hello "+sd[i].getName());
                    if(sd[i].isIssued())
                    {
                        System.out.println("Sorry! You can issue only one book at a time");
                    }
                    else
                    {
                        System.out.println("Enter Index Of the Book You want to Issue");
                        for(int j=0;j<bookCounter;j++)
                        {
                            if(bk[j].getStudent()==null)
                            {
                                System.out.println((j+1)+". "+bk[j].getName());
                            }
                        }
                        int index=sc.nextInt();
                        bk[index-1].setStudent(sd[i]);
                        sd[i].issueBook();
                        System.out.println("Your Book is Issued");
                    }
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Roll Number Not Found");
            }
        }
        else
        {
            if(studentCounter<5)
            {
                System.out.println("First Register Yourself");
                Student newStd=new Student();
                newStd.takeInput();
                System.out.println("Enter Index Of the Book You want to Issue");
                for(int j=0;j<bookCounter;j++)
                {
                    if(bk[j].getStudent()==null)
                    {
                        System.out.println((j+1)+". "+bk[j].getName());
                    }
                }
                int index=sc.nextInt();
                bk[index-1].setStudent(newStd);
                newStd.issueBook();
                System.out.println("Your Book is Issued");
                sd[studentCounter]=newStd;
                studentCounter++;
            }
            else
            {
                System.out.println("Maximum Student Limit Reached...");
            }
        }
    }

    public static void returnBook()
    {
        int flag=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Roll Number");
        int r=sc.nextInt();
        for(int i=0;i<studentCounter;i++)
        {
            if(sd[i].getRoll()==r)
            {
                System.out.println("Hello "+sd[i].getName());
                if(sd[i].isIssued())
                {
                    sd[i].returnBook();
                    for(int j=0;j<bookCounter;j++)
                    {
                        if(bk[j].getStudent().getRoll()==sd[j].getRoll())
                        {
                            bk[j].setStudent(null);
                            break;
                        }
                    }
                }
                else
                {
                    System.out.println("You Have not issued any book. Issue a Book First!");     
                }
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("Roll Number Not Found");
        }
    }

    public static void payFine()
    {
        int flag=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Roll Number");
        int r=sc.nextInt();
        for(int i=0;i<studentCounter;i++)
        {
            if(sd[i].getRoll()==r)
            {
                sd[i].payFine();
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("Roll Number Not Found");
        }
    }   
}

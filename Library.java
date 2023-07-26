import java.util.*;

public class Library
{
    public static void main(String[] args)
    {
       
        Scanner sc=new Scanner(System.in);
        char ch='y';
        do{
            System.out.println("Enter 1 - Insert new Book");
            System.out.println("Enter 2 - Search Book");
            System.out.println("Enter 3 - Update Book"); 
            System.out.println("Enter 4 - Issue new Book"); 
            System.out.println("Enter 5 - Return a Book"); 
            System.out.println("Enter 6 - Pay Fine");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    Manager.insertBook();
                    break;
                case 2:
                    Manager.searchBook();
                    break;
                case 3:
                    if(Manager.bookCounter==0)
                    {
                        System.out.println("There Are Currently No Books");
                    }
                    else
                    {
                        Manager.updateBook();
                    }
                    break;
                case 4:
                    if(Manager.bookCounter==0)
                    {
                        System.out.println("There Are Currently No Books");
                    }
                    else
                    {
                        Manager.issueBook();
                    }
                    break;
                case 5:
                    Manager.returnBook();
                    break;
                case 6:
                    Manager.payFine();
                    break;
                default:
                    System.out.println("Wrong Option");
                    break;
            }
            System.out.println("Do you want to go again? [y-yes/n-no]");
            ch=sc.next().charAt(0);
        }while(ch!='n');
        System.out.println("Thank You For Visiting The Library");
    }
}
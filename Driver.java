import java.util.*;
import java.io.*;

public class Driver
{
    //Using static-ed BufferedReader makes it accessible to every method of the class
    public static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    //HashMap made global so that it is made accessible to every method in the class
    public static HashMap<Integer, BankDetails> bankAccount = new HashMap<>();
    
    //What this function does is returning age and acts as what I call as a filter function
    //This is because there are no 1000 year old people in the planet
    public int agePrompt()
    {
        int age = 0;
        while(age < 19 || age > 100)
        {
            try
            {
                System.out.print("What is your age: ");
                age = Integer.parseInt(read.readLine());
                if (age < 19 || age > 100)
                {
                    System.out.println("Error: Invalid Input! \nMust be between 19 and 100");
                }
            }
            catch(Exception e)
            {
                System.out.println("Error: Must be numerical values only");
            }
        }
        return age;
    }
    
    //This function is responsible for catching any non numerical value. It is also a filter function
    public Integer bankIDPrompt()
    {
        Integer bankID = 0;
        
        //We are only searching for a number but not negative numbers
        while(bankID <= 0)
        {
            try
            {
                System.out.print("What is your bank number: ");
                bankID = Integer.parseInt(read.readLine());
                break;
            }
            catch (Exception e)
            {
                System.out.println("Error: Numerical Values Only!");
                continue;
            }    
        }

        return bankID;
    }
    
    //Filter function: make sure user doesn't enter any non numerical values or negative numbers or zero
    public int phoneNumberPrompt()
    {
        int phoneNumber = 0;

        while(phoneNumber <= 0)
        {
            try
            {
                System.out.print("Enter phone number: ");
                phoneNumber = Integer.parseInt(read.readLine()); 
                if (phoneNumber <= 0)
                {
                    System.out.println("No negative numbers or zero!");
                }
            }
            catch(Exception e)
            {
                System.out.println("Error: Invalid Input!");
            }
    
        }

        return phoneNumber;
    }
    //What this function is to filter any negative numbers or non numerics
    public static double addSavingsPrompt()
    {
        double amount = 0;
        while(amount <= 0)
        {
            try
            {
                System.out.print("Enter amount: ");
                amount = Double.parseDouble(read.readLine());
                if (amount <= 0)
                {
                    System.out.println("Error: No negative numbers"); 
                }
                
            }
            catch(Exception e)
            {
                System.out.println("Error: Numerical Inputs only!");
            }
        }
        return amount;
    }
    
    //What this function does is to input details on the user
    public void inputDetails()
    {
        String name = " ";
        String address = " ";
        int prompt = 0;
        int age = 0;
        int phoneNumber = 0;
        //int pin = 0;
        Integer bankID = 0;

        try
        {
            System.out.print("Enter name: ");
            name = read.readLine();
            System.out.print("Enter Address: ");
            address = read.readLine();
            age = agePrompt();
            phoneNumber = phoneNumberPrompt();
            bankID = bankIDPrompt();
        }
        //Did not fill this up because it is already being caught
        catch(Exception e)
        {

        }
        
        //This is where the details where the details are implemented for later
        //as it will be inputed (if thats a word) into the hash map bankAccount
        BankDetails bd = new BankDetails(name, address, age, phoneNumber, 0);

        bankAccount.put(bankID, bd);

    }
    
    //What this function is to just present the menu
    public static void menu()
    {
        System.out.println("====================================================");
        System.out.println("<1> Enter Bank Details                              ");
        System.out.println("<2> Search for Account                              ");
        System.out.println("<3> Print all accounts                              ");
        System.out.println("<4> Add amount to an account                        ");
        System.out.println("<5> Recall Transaction                              ");
        System.out.println("<6> Show transaction history                        ");
        System.out.println("<7> Quit                                            ");
        System.out.println("====================================================");
    }
    
    //This prints all accounts
    public void PrintAllAccounts()
    {
        for (Map.Entry<Integer, BankDetails> mapEntry : bankAccount.entrySet())
        {
            System.out.println("Available Bank Accounts: " + mapEntry.getKey());
        }
    }
    
    //This is app running which can be considered as where the code goes to
    public static void AppRunning()
    {
        //I really tried to implement stack but I need more research on it
        Stack<BankDetails> bd = new Stack<>();
        int input = 0;
        boolean isRunning = true;
        double amount = 0;
        Integer bankID = 0;
        Driver driver = new Driver();
        while(isRunning)
        {
            menu();
            try
            {
                System.out.print("Input: ");
                input = Integer.parseInt(read.readLine());

                //One self criticism I will make here is that the code, admittedly looks ugly, but I was running out of time
                //Someday I will clean this but for now, and I do apologize for it being messy
                switch(input)
                {
                    case 1:
                        driver.inputDetails();
                    case 2:
                        break;
                    case 3:
                        driver.PrintAllAccounts(); 
                        break;
                    case 4:
                        System.out.print("Input Account Number: ");
                        bankID = Integer.parseInt(read.readLine());
                        for (Map.Entry<Integer, BankDetails> mapEntry : bankAccount.entrySet())
                        { 
                            if (bankID.equals(mapEntry.getKey()))
                            {
                                System.out.print("Enter Amount: ");
                                amount = Double.parseDouble(read.readLine());
                                mapEntry.getValue().setSavings(amount + mapEntry.getValue().getSavings()); 
                            }
                        } 
                        break;
                    case 5:
                        System.out.print("Input Account Number: ");
                        bankID = Integer.parseInt(read.readLine());
                        for (Map.Entry<Integer, BankDetails> mapEntry : bankAccount.entrySet())
                        {
                            if (bankID.equals(mapEntry.getKey()))
                            {
                                System.out.println(mapEntry.getKey() + "\n" + mapEntry.getValue());
                                System.out.println("Current savings: " + mapEntry.getValue().getSavings());  
                            }
                        }
                        break;
                    case 6:
                        //Attempted to stack it but I dont know how to yet
                        //Further research is needed
                        System.out.println(bd);
                        break;
                    case 7:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Error: Invalid Input!");
                        break;

                }
            }
            catch(Exception e)
            {
                System.out.println("Error: Invalid Input!");
            }
        }


    }



    public static void main(String[] param)
    {
        AppRunning();
    }


    //OH MY GOD THIS WAS A DOOOZIEEEE HAHAHAHAHA
    //
    //Before submitting will try to implement stack currently its 11:23 pm
    //And the deadline for this is 11:59 but I need to sleep
    //Worked on this at 8 pm since my house is far away
    //However I will work on it even after the exam is done because I want to learn
    //Yeah sure, it is doozie but you know, beauty of learning haha
    //But it works just not without stack
    //Will submit by 11:50 pm
    //
    //Final thoughts and assessment
    //
    //I need more research on frameworks, hashmap I got used to since they are similar or equivalent to dictionaries in Python
    //What I am lacking here is the knowledge for Stacks especially in Java
    //Mayhaps in the future after this exam, I will implement self exercise in regards to Stacks
    //I am currently devoting my time in programming every day, example exercises on Deque, queue, Generics, Abstract Classes etc I took from the internet.
    //Though admittedly did not have any exercises in regards to Stacks, now is the time
    //
    //THANK YOU FOR READING MY CODE, SIR!
    //
    //BELLA CIAO 

}

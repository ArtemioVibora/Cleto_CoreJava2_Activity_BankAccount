public class BankDetails
{
    //String name and address
    private String name;
    private String address;
    //Money in the bank
    private double savings;
    //Integers!! hoho
    private int age;
    private int phoneNumber;
    
    //Constructor of class BankDetails will be used in the driver class
    public BankDetails(String name, String address, int age, int phoneNumber, double savings)
    {
        this.name = name;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.savings = savings;    
    }
    //Since we have a constructor, all we need to do is to make some getter functions
    //Except for money in the bank variable
    public void setSavings(double savings)
    {
        this.savings = savings;
    }
    //Getters
    //Name
    public String getName()
    {
        return name;
    }
    //Address
    public String getAddress()
    {
        return address;
    }
    //Age
    public int getAge()
    {
        return age;
    }
    //Phone Number
    public int getPhoneNumber()
    {
        return phoneNumber;
    }
    //Savings
    public double getSavings()
    {
        return savings;
    }
    
    //THANK YOU INDIAN GUY ON YOUTUBE HAHAHAHA
    public String toString()
    {
        return "\nName " + name + "\nAge: " + age + "\nAddress: " + address + "\nPhone Number: " + phoneNumber;
    }

}

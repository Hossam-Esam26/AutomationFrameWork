package Data;

public class DataClass {

    public static String userName = ReadFromJson.dataClass("Name");
    public static String emailOne = ReadFromJson.randomEmail();
    public static String emailTwo = ReadFromJson.randomEmail();
    public static String emailThree = ReadFromJson.randomEmail();
    public static String password = ReadFromJson.dataClass("Password");
    public static String day = ReadFromJson.dataClass("Day");
    public static String month = ReadFromJson.dataClass("Month");
    public static String year = ReadFromJson.dataClass("Year");
    public static String firstName = ReadFromJson.dataClass("FirstName");
    public static String lastName = ReadFromJson.dataClass("LastName");
    public static String address = ReadFromJson.dataClass("Address");
    public static String country = ReadFromJson.dataClass("Country");
    public static String state = ReadFromJson.dataClass("State");
    public static String city = ReadFromJson.dataClass("City");
    public static String zipCode = ReadFromJson.dataClass("ZipCode");
    public static String mobileNumber = ReadFromJson.dataClass("MobileNumber");
    public static String inValidEmail = ReadFromJson.dataClass("inValidEmail");
    public static String subject = ReadFromJson.dataClass("Subject");
    public static String userMessage = ReadFromJson.dataClass("Message");
    public static String productName = ReadFromJson.dataClass("ProductName");
    public static String productQuantity = ReadFromJson.dataClass("ProductQuantity");
}

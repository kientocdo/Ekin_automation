package javaSDET;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class Topic_01_DataType {
    // 2 nhóm kiểu dữ liệu

    // cách khai báo:
    // Access modifier: phạm vi truy cập (private/ public/ protected/ default)
    // 1 - Access Modifier - Tên biến - Giá trị của biến (Trong hàm ngoài hàm đều được)
    public char cName = 'b'; // Value chỉ 1 ký tự. Nhiều ký tự thì dùng String

    // 2.1 - Access Modifier - Tên biến
    private char cAddress;

    // 2.2 - Tên biến - Giá trị gán sau (Trong hàm)
    public void clickToElement(){
        cAddress = 'c';
        char cCity = 'd';
    }

    // Nhóm 1 - Kiểu dữ liệu nguyên thuỷ

    // char: kí tự - Khi gán giá trị thì nằm trong dấu nháy đơn (')
    // byte/ short/ int/ long: số nguyên (ko có thập phân)
    byte bNumber = 127; // -128 to 127
    //hay dùng int hoặc float
    int iNumber = 123123;

    // float/ double: số thực
    float fNumber = 123.1245F; // thêm chữ F để nhận biết float
    double dNumber = 123.1245; // ko cần thêm D cũng được

    // boolean: logic
    boolean gender = true; // true or false


    // Nhóm 2 - Kiểu dữ liệu tham chiếu
    // String: Chuỗi - Khi gán giá trị thì nằm trong dấu nháy đôi (")
    String fullName = "Automation FC";

    // Class
    FirefoxDriver fDriver = new FirefoxDriver();
    Actions actions = new Actions(fDriver);
    Topic_01_DataType topic01 = new Topic_01_DataType();

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExcutor;

    // Array
    String[] studentName = {"Kien","Nghi","Thinh"};
    Integer[] studentPhone = {9232,2321,123213};

    // List/ Set/ Queue
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<>();

    // Map
    Map<String, Integer> zip = new HashMap<String, Integer>();

    // Object
    Object name = "Nam";
    Object phone = 1234;
    Object isDisplayed = true;



    // Convention: Quy ước khi lập trình
    // Tên biến tên hàm: viết dưới dạng camel case
    // name/ address/ city/ phone/ zipCode
    // clickToElement/ getUserName/ getPhoneNumber/ selectItemInDropdown


}

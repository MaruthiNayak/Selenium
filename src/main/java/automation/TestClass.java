package automation;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        PageClass.launch();
        PageClass.login();
        PageClass.navigateToMyInfo();
        PageClass.enterPersonalDetails();
    }
}

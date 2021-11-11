import com.github.javafaker.Faker;
import com.makersacademy.acebook.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import org.openqa.selenium.WebElement;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LikesTest {

  WebDriver driver;
  Faker faker;
  public String name;


  @Before 
  public void setup(){
    System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
    driver = new ChromeDriver();
    faker = new Faker();

    name = faker.name().firstName();
    signup(name, "password");
    login(name, "password"); 
    post("Hello");
  }

  

  private void signup(String username, String password){
    driver.get("http://localhost:8080/users/new");
    driver.findElement(By.id("username")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.id("submit")).click();
  }
  private void login(String username, String password){
    driver.get("http://localhost:8080/login.html");
    driver.findElement(By.id("username")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.cssSelector("input[type='submit'][value='Log in']")).click();
  }
  private void post(String content){
    driver.findElement(By.id("content")).sendKeys(content);
    driver.findElement(By.cssSelector("input[type='submit'][value='Post']")).click();
  }

  @After
  public void teardown(){
    driver.close();
  }
 @Test
 public void userlikespost(){
  driver.findElement(By.cssSelector("input[type='submit'][value='Like']")).click();
  Assert.assertEquals("1",driver.findElement(By.id("displaylikes")).getText());
 }

 @Test 
 public void usercantliketwice(){
  driver.findElement(By.cssSelector("input[type='submit'][value='Like']")).click();
  driver.findElement(By.cssSelector("input[type='submit'][value='Like']")).click();
  Assert.assertEquals("1",driver.findElement(By.id("displaylikes")).getText());
 }

 }

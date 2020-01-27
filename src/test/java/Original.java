import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Original {

	WebDriver driver;
	WebElement btnAbrirConta;
	WebElement cpoNome;
	WebElement cpoCelular;
	WebElement cpoEmail;
	WebElement cpoCpf;
	WebElement btnEnviar;
	String msgAbertura;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.original.com.br");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}

	@Test
	public void test() {
		btnAbrirConta = driver.findElement(By.xpath("/html/body/div[3]/main/section[1]/div[2]/a"));
		btnAbrirConta.click();
		cpoNome = driver.findElement(By.id("nome"));
		cpoNome.sendKeys("Anderson Barbosa");
		cpoCelular = driver.findElement(By.id("telefone"));
		cpoCelular.sendKeys("(11)940053248");
		cpoEmail = driver.findElement(By.id("email"));
		cpoEmail.sendKeys("anderson.barbosa@e2etreinamentos.com.br");
		cpoCpf = driver.findElement(By.name("cliente.cpf"));
		cpoCpf.sendKeys("229.990.158-28");
		btnEnviar = driver.findElement(By.id("btnEnviar"));
		btnEnviar.click();
		msgAbertura = driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div[2]/div[1]/label")).getText();
		System.out.println(msgAbertura);
		assertEquals(
				"Agora você receberá um SMS para baixar o app Seja Original e concluir sua solicitação de abertura de conta!",
				msgAbertura);

	}

}

package br.com.e2etreinamentos.AulaFinal;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AbrirContaTest {

	
	WebDriver driver;
	WebElement btnAbrirConta;
	WebElement cpoNome;
	WebElement cpoCelular;
	WebElement cpoEmail;
	WebElement cpoCpf;
	WebElement btnEnviar;
	String msgAbertura;

	@Given("^que eu acesse o site$")
	public void que_eu_acesse_o_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.original.com.br");
	}

	@Given("^acesse abertura de conta$")
	public void acesse_abertura_de_conta() throws Throwable {
		btnAbrirConta = driver.findElement(By.xpath("/html/body/div[3]/main/section[1]/div[2]/a"));
		btnAbrirConta.click();
	}

	@When("^informar o nome$")
	public void informar_o_nome() throws Throwable {
		cpoNome = driver.findElement(By.id("nome"));
		cpoNome.sendKeys("Anderson Barbosa");
	}

	@When("^informar o celular$")
	public void informar_o_celular() throws Throwable {
		cpoCelular = driver.findElement(By.id("telefone"));
		cpoCelular.sendKeys("(11)940053248");
	}

	@When("^informar o email$")
	public void informar_o_email() throws Throwable {
		cpoEmail = driver.findElement(By.id("email"));
		cpoEmail.sendKeys("anderson.barbosa@e2etreinamentos.com.br");
	}

	@When("^informar o cpf$")
	public void informar_o_cpf() throws Throwable {
		cpoCpf = driver.findElement(By.name("cliente.cpf"));
		cpoCpf.sendKeys("229.990.158-28");
	}

	@When("^enviar os dados$")
	public void enviar_os_dados() throws Throwable {
		btnEnviar = driver.findElement(By.id("btnEnviar"));
		btnEnviar.click();
	}

	@Then("^eu recebo confirmaçao$")
	public void eu_recebo_confirmaçao() throws Throwable {
		msgAbertura = driver.findElement(By.xpath("/html/body/div[1]/main/section/div/div[2]/div[1]/label")).getText();
		System.out.println(msgAbertura);
		assertEquals(
				"Agora você receberá um SMS para baixar o app Seja Original e concluir sua solicitação de abertura de conta!",
				msgAbertura);
	}

}
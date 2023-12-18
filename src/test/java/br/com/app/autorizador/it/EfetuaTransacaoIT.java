package br.com.app.autorizador.it;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_TRANSACOES;
import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.CARTAO_INEXISTENTE;
import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.OK;
import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.SALDO_INSUFICIENTE;
import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.SENHA_INVALIDA;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import br.com.app.autorizador.adapters.out.persistence.repository.CartaoRepository;
import br.com.app.autorizador.it.util.DatabaseCleaner;
import br.com.app.autorizador.testdata.CartaoEntityTestData;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class EfetuaTransacaoIT {
	
	@LocalServerPort
	private int localServerPort;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;

	@Autowired
	private CartaoRepository cartaoRepository;

	private void preparaDados() {
		cartaoRepository.save(CartaoEntityTestData.getCartaoEntity());
	}
	
	@BeforeEach
	public void setUp() {
		enableLoggingOfRequestAndResponseIfValidationFails();
		basePath = ROTA_TRANSACOES;
		port = localServerPort;
		
		databaseCleaner.clearTables();
		preparaDados();
		
	}
	
	@Test
	public void deveRetornarStatus201_QuandoEfetuaTransacao() {
		String response = given()
			.contentType(ContentType.JSON)
			.and()
			.body(getTransacaoSucesso())
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value())
		.extract().response().asString();

		assertEquals(OK.name(), response);
	}
	
	private String getTransacaoSucesso() {
		return """
				{
					"numeroCartao": "1111222233334444",
					"senhaCartao": "1234",
					"valor": 10.00
				} 
				""";
	}
	
	@Test
	public void deveRetornarStatus422_CartaoInexistente_QuandoEfetuaTransacao() {
		String response = given()
			.contentType(ContentType.JSON)
			.and()
			.body(getTransacaoCartaoInexistente())
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
		.extract().response().asString();

		assertEquals(CARTAO_INEXISTENTE.name(), response);
	}
	
	private String getTransacaoCartaoInexistente() {
		return """
				{
					"numeroCartao": "6549873025634501",
					"senhaCartao": "1234",
					"valor": 10.00
				} 
				""";
	}
	
	@Test
	public void deveRetornarStatus422_SenhaInvalida_QuandoEfetuaTransacao() {
		String response = given()
			.contentType(ContentType.JSON)
			.and()
			.body(getTransacaoSenhaInvalida())
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
		.extract().response().asString();

		assertEquals(SENHA_INVALIDA.name(), response);
	}
	
	
	private String getTransacaoSenhaInvalida() {
		return """
				{
					"numeroCartao": "1111222233334444",
					"senhaCartao": "9999",
					"valor": 10.00
				} 
				""";
	}
	
	@Test
	public void deveRetornarStatus422_SaldoInsuficiente_QuandoEfetuaTransacao() {
		String response = given()
			.contentType(ContentType.JSON)
			.and()
			.body(getTransacaoSaldoInsuficiente())
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
		.extract().response().asString();

		assertEquals(SALDO_INSUFICIENTE.name(), response);
	}
	
	
	private String getTransacaoSaldoInsuficiente() {
		return """
				{
					"numeroCartao": "1111222233334444",
					"senhaCartao": "1234",
					"valor": 1000.00
				} 
				""";
	}

}

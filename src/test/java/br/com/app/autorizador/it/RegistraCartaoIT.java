package br.com.app.autorizador.it;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_CARTOES;
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
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class RegistraCartaoIT {


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
		basePath = ROTA_CARTOES;
		port = localServerPort;
		
		databaseCleaner.clearTables();
		preparaDados();
		
	}
	
	@Test
	public void deveRetornarStatus201_QuandoRegistraCartao() {
		Response response = given()
			.contentType(ContentType.JSON)
			.and()
			.body(getCartaoNovo())
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value())
		.extract().response();

		assertEquals("5555666677778888", response.jsonPath().getString("numeroCartao"));
		assertEquals("1234", response.jsonPath().getString("senha"));
		
	}
	
	private String getCartaoNovo() {
		return """
				{
			      "senha": "1234",
			      "numeroCartao": "5555666677778888"
				} 
				""";
	}
	
	@Test
	public void deveRetornarStatus422_QuandoRegistraCartao() {
		given()
			.contentType(ContentType.JSON)
			.and()
			.body(getCartaoExistente())
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		
		
	}
	
	private String getCartaoExistente() {
		return """
				{
			      "senha": "1234",
			      "numeroCartao": "1111222233334444"
				} 
				""";
	}
}

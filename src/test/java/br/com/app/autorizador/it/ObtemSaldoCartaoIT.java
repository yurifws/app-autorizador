package br.com.app.autorizador.it;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.CARTOES_POR_NUMERO_CARTAO;
import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.NUMERO_CARTAO;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class ObtemSaldoCartaoIT {
		
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
		public void deveRetornarStatus200_QuandoObtemSaldoCartao() {
			String response = given()
				.pathParam(NUMERO_CARTAO, 1111222233334444l)
			.when()
				.get(CARTOES_POR_NUMERO_CARTAO)
			.then()
				.statusCode(HttpStatus.OK.value())
			.extract().response().asString();
			
			assertEquals("500.00", response);
			
		}
		
		@Test
		public void deveRetornarStatus404_QuandoObtemSaldoCartao() {
			given()
				.pathParam(NUMERO_CARTAO, 9999999999999999l)
			.when()
				.get(CARTOES_POR_NUMERO_CARTAO)
			.then()
				.statusCode(HttpStatus.NOT_FOUND.value());
			
			
		}

	}

package br.com.app.autorizador.adapters.out.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.adapters.out.persistence.service.ICartaoService;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.testdata.CartaoEntityTestData;
import br.com.app.autorizador.testdata.CartaoTestData;

@ExtendWith(SpringExtension.class)
class RegistraCartaoPersistenceAdapterTest {
	

	@InjectMocks
	private RegistraCartaoPersistenceAdapter registraCartaoPersistenceAdapter;

	@Mock
	private ICartaoService service;
	
	@Captor
	private ArgumentCaptor<CartaoEntity> argumentCaptorCartaoEntity;

	@Test
	void testRegistrar() {

		when(service.salvar(argumentCaptorCartaoEntity.capture())).thenReturn(CartaoEntityTestData.getCartaoEntity());

		Cartao cartao = CartaoTestData.getCartaoNovoRegistrar();
		
		Cartao response = registraCartaoPersistenceAdapter.registrar(cartao);
		
		verify(service).salvar(argumentCaptorCartaoEntity.getValue());
		
		assertNotNull(response);
		
	}

}

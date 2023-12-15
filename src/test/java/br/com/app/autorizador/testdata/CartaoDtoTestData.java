package br.com.app.autorizador.testdata;

import br.com.app.autorizador.adapters.in.web.cartoes.dto.CartaoDto;

public class CartaoDtoTestData {
	
	public static CartaoDto getCartaoDto() {
		return new CartaoDto(1111222233334444l, "1234");
	}

}

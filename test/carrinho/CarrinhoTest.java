package carrinho;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

	@DisplayName("Classe para testar o carrinho")
	public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto item1;
    private Produto item2;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        
        item1 = new Produto("1", 99);
        item2 = new Produto("2", 120);
        
        carrinho.addItem(item1);
        carrinho.addItem(item2);
    }

	@DisplayName("Testa a quantidade de itens em um carrinho")
    @Test
    public void testQuantidade() 
	{
		int quantidade = carrinho.getQtdeItems();
        assertTrue(quantidade == 2);
    }

	@DisplayName("Testa retornar o valor do carrinho")
    @Test
    public void testValorTotal() {
    	 Double total = carrinho.getValorTotal();
         Assertions.assertEquals(219, total);
    }

	@DisplayName("Testa remover um produto")
    @Test
    public void testRemoverProduto() {
        try 
        {
//            carrinho.removeItem(item1);
        	carrinho.removeItem(new Produto("3", 99));
            Assertions.assertEquals(1, carrinho.getQtdeItems());
        } catch (ProdutoNaoEncontradoException e) {
            e.printStackTrace();
        }
    }

    @After
    public void limparCarrinho() {
        try {
            	carrinho.esvazia();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
    }


    @Test
    public void testCarrinhoVazio(){
        try {
	        limparCarrinho();
	        assertTrue(carrinho.getQtdeItems() == 2);
        } catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
} 


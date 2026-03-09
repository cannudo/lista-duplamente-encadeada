import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaDuplamenteEncadeadaTest {
    private ListaDuplamenteEncadeada mandamentos;

    private No instanciarNovoNo(String conteudo) {
        return new No(conteudo);
    }

    private ListaDuplamenteEncadeada instanciarNovaLista() {
        return new ListaDuplamenteEncadeada();
    }

    private String[] popularArrayDeMandamentos() {
        return new String[] {
                "Não escreverás métodos nem classes grandes",
                "Não colocarás a lógica de negócio em Controllers",
                "Não chamarás o banco de dados dentro de loops",
                "Não ignorarás testes automatizados",
                "Não acreditarás em tudo que o ChatGPT falar",
                "Evitarás executar atualizações direto no banco de produção",
                "Não prometerá prazos que não conseguirás cumprir",
                "Validarás todos os dados de entradaa externos",
                "Não dupçlicarás código por pressa ou preguiça",
                "Entenderás bem o negócio antes de codificar,0"
        };
    }

    @BeforeEach
    public void prepararAListaDeMandamentos() {
        this.mandamentos = instanciarNovaLista();
        String[] array = popularArrayDeMandamentos();
        for(int i = 0; i < array.length; i++) {
            No novoNo = instanciarNovoNo(array[i]);
            mandamentos.inserirEmSequencia(novoNo);
        }
    }

    @Test
    public void testAListaTemTamanhoDez() {
        assertEquals(mandamentos.tamanho(), 10, "A lista deve ter tamanho 10");
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaDuplamenteEncadeadaTest {
    private ListaDuplamenteEncadeada lista;

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

    private String[] popularArrayDoAlfabeto() {
        return new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"
        };
    }

    @BeforeEach
    public void prepararALista() {
        this.lista = instanciarNovaLista();
        String[] array = popularArrayDoAlfabeto();
        for(int i = 0; i < array.length; i++) {
            No novoNo = instanciarNovoNo(array[i]);
            lista.inserirEmSequencia(novoNo);
        }
    }

    @Disabled
    @Test
    public void testAListaDeMandamentosTemTamanhoDez() {
        assertEquals(lista.tamanho(), 10, "A lista deve ter tamanho 10");
    }

    @Test
    public void testAListaDoAlfabetoTemTamanhoVinteESeis() {
        assertEquals(lista.tamanho(), 26, "O alfabeto, dado em um array de Strings, deveria deixar a lista com um tamanho de 26 nós. O que aconteceu, latino?");
    }
}
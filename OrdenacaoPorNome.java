package aplicativos;

import java.util.Comparator;

public class OrdenacaoPorNome implements Comparator<Pessoa> {
    @Override
    public int compare(Pessoa pessoa1, Pessoa pessoa2) {
        return pessoa1.getNome().compareTo(pessoa2.getNome());
    }
}

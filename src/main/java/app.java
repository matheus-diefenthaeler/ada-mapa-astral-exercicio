import pessoa.Pessoa;
import signo.Signo;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.SignoUtils.lerCadaLinha;
import static utils.SignoUtils.escrever;

public class app {
    private static String HOME_DIR = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {

        String mapas = HOME_DIR.concat("/mapas");

        final Path mapaAstral = Path.of(mapas, "pessoas.txt");

        List<Pessoa> pessoaModelList = new ArrayList<>();

        List<String> pessoas = lerCadaLinha(mapaAstral);

        pessoas.stream().parallel().forEach(pessoa -> {
            List<String> list = Arrays.asList(pessoa.split(";"));
            pessoaModelList.add(
                    new Pessoa(list.get(0)
                            , LocalDateTime.parse(list.get(2), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                            , list.get(1)));

        });

        pessoaModelList.stream().parallel().forEach(pessoa -> {

            String nome = pessoa.getNome();
            Integer idade = pessoa.getIdade();
            String geracao = pessoa.getGeracao();
            Signo signo = pessoa.getSigno();
            String cidadeNascimento = pessoa.getCidadeNascimento();
            String dataNascimento = pessoa.getDataNascimento();

            Path caminhoPessoa = Path.of(HOME_DIR, "mapas", nome.replaceAll(" ", "-") + ".txt");
            StringBuilder sb = new StringBuilder();
            String dadosDaPessoa = sb.append("Nome: ")
                    .append(nome)
                    .append("\nCidade de nascimento: ")
                    .append(cidadeNascimento)
                    .append("\nData de nascimento: ")
                    .append(dataNascimento)
                    .append("\nSigno: ")
                    .append(signo)
                    .append("\nIdade: ")
                    .append(idade)
                    .append("\nGeracao: ")
                    .append(geracao)
                    .append("\n---------------------\n")
                    .toString();

            escrever(caminhoPessoa, dadosDaPessoa);

        });
    }
}

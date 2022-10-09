import pessoa.Pessoa;
import signo.Signo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class app {
    private static String HOME = System.getProperty("user.home");
    private static String HOME_DIR = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {

        System.out.println(HOME);
        System.out.println(HOME_DIR);
        String mapas = HOME_DIR.concat("/mapas");
        String caminhoMapa = HOME_DIR.concat("/mapas/mapa.txt");
        final File file = new File(caminhoMapa);
        final Path path = Paths.get(caminhoMapa);
        final Path mapaAstral = Path.of(mapas, "pessoas.txt");

        List<Pessoa> pessoaList = new ArrayList<>();

        List<String> readLines = readLines(mapaAstral);
        readLines.forEach(s -> {
            List<String> list = Arrays.asList(s.split(";"));
            pessoaList
                    .add(
                            new Pessoa(list.get(0)
                                    , LocalDateTime.parse(list.get(2), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                                    , list.get(1)));

        });

        pessoaList.forEach( pessoa -> {

            String nome = pessoa.getNome();
            Integer idade = pessoa.getIdade();
            String geracao = pessoa.getGeracao();
            Signo signo = pessoa.getSigno();
            String cidadeNascimento = pessoa.getCidadeNascimento();
            String dataNascimento = pessoa.getDataNascimento();

            Path caminhoPessoa = Path.of(HOME_DIR,"mapas", nome.replaceAll(" ","-")+".txt");
            StringBuilder sb = new StringBuilder();
            String informacoes = sb.append("Nome: ")
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

            write(caminhoPessoa, informacoes);

        });
    }

    static void write(Path path, String participants) {
        try {
            Files.write(path, participants.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<String> readLines(Path path) {
        Stream<String> lines;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> list = lines.collect(Collectors.toList());
        lines.close();

        return list;
    }
}


// Criar arqujivo com Files
//        Path caminhoASerCriado = Paths.get(mapas, System.currentTimeMillis() + ".txt");
//        Files.createFile(caminhoASerCriado);


// Ler arquivo com File
//    Scanner sc = new Scanner(file);
//        while (sc.hasNext()) {
//                System.out.println(sc.nextLine());
//                }
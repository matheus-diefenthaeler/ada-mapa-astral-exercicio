import pessoa.Pessoa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class app {
    public static void main(String[] args) {

//        LocalDateTime localDateMatheus = LocalDateTime.of(1991,9,19,19,22);

//        mapaAstral(localDateMatheus,"America/Sao_Paulo");

        Pessoa p1 = new Pessoa("Matheus", LocalDateTime.of(1975, 9, 19, 20, 20), "America/Sao_Paulo");
        Pessoa p2 = new Pessoa("Lucas", LocalDateTime.of(2010, 5, 19, 20, 20), "America/Sao_Paulo");
        Pessoa p3 = new Pessoa("Fernando", LocalDateTime.of(1990, 9, 10, 20, 20), "America/Sao_Paulo");
        Pessoa p4 = new Pessoa("Julia", LocalDateTime.of(2012, 8, 10, 20, 20), "America/Sao_Paulo");
        Pessoa p5 = new Pessoa("Mariana", LocalDateTime.of(2007, 9, 10, 20, 20), "America/Sao_Paulo");

        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(p1);
        pessoaList.add(p2);
        pessoaList.add(p3);
        pessoaList.add(p4);
        pessoaList.add(p5);

        //Filtro de pessoas do signo Virgem e que sao maiores de 18 anos
        List<Pessoa> ListaDeSinosVirgemMaiorDe18 = pessoaList.stream()
                .filter(pessoa -> pessoa.getSigno().toString().equals("Virgem"))
                .filter(pessoa -> pessoa.getIdade() > 18)
                .collect(Collectors.toList());

//        ListaDeSinosVirgemMaiorDe18.forEach(System.out::println);

        //Filtro de pessoas menores de 18
        List<Pessoa> menorDe18 = pessoaList.stream().
                filter(pessoa -> pessoa.getIdade() < 18)
                .collect(Collectors.toList());

        //Filtro de pessoas da geracao Y
        List<Pessoa> geracaoZ = pessoaList.stream()
                .filter(pessoa -> pessoa.getGeracao().toString().equals("Y"))
                .collect(Collectors.toList());

//        geracaoZ.forEach(System.out::println);

        //Metodo para para trazer todas as pessoas e as idades delas na proxima copa
        List<String> pessoasEIdades = pessoaList.stream().map(pessoa -> {
            return "Nome: " + pessoa.getNome() + " terá " + (pessoa.getIdade() + 4) + " anos na proxima Copa";
        }).collect(Collectors.toList());

//        pessoasEIdades.forEach(System.out::println);

        //Filtro para obter a pessoa mais velha ordenando e pegando o ultimo item da lista
        List<Pessoa> collect = pessoaList.stream().sorted(Comparator.comparing(Pessoa::getIdade)).collect(Collectors.toList());
//        System.out.println(collect.get(collect.size() - 1));

        //Filtro para obter a maior e menor idade
        int menorIdade = pessoaList.stream().mapToInt(Pessoa::getIdade).min().orElse(-1);
        int maiorIdade = pessoaList.stream().mapToInt(Pessoa::getIdade).max().orElse(-1);

//        System.out.println(menorIdade);
//        System.out.println(maiorIdade);

        //Filtro para calcular media das idades
        double mediaIdade = pessoaList.stream().mapToInt(Pessoa::getIdade).average().orElse(-1);
        System.out.println(mediaIdade);
    }
}

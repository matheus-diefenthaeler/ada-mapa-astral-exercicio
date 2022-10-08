package pessoa;

import factory.SignoFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import signo.Signo;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class Pessoa {

    private String nome;
    private String cidadeNascimento;
    private String dataNascimento;
    private Signo signo;
    private Integer idade;
    private String geracao;

    public Pessoa(String nome, LocalDateTime localDateTime, String zoneId) {
        SignoFactory sf = new SignoFactory();
        this.nome = nome;
        this.cidadeNascimento = ZoneId.of(zoneId).getId();
        this.dataNascimento = formatar(localDateTime);
        this.signo = sf.create(MonthDay.of(localDateTime.getMonth(), localDateTime.getDayOfMonth()));
        this.idade = idade(localDateTime);
        this.geracao = geracao(localDateTime.getYear());
    }

    public static Integer idade(LocalDateTime localDateTime) {
        return Period.between(localDateTime.toLocalDate(), LocalDate.now()).getYears();
    }

    public static String formatar(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public static String geracao(Integer year) {
        if (year < 1965) {
            return "Boomer";
        }
        if (year < 1985) {
            return "X";
        }
        if (year < 2000) {
            return "Y";
        }
        return "Z";
    }

    StringBuilder sb = new StringBuilder();

    @Override
    public String toString() {
        return sb.append("Nome: ")
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

    }
}

package signo;

import factory.SignoFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

public abstract class Signo {

    public abstract MonthDay getInicio();

    public abstract MonthDay getFim();

    protected abstract Map<Integer, String> getAscendente();

    public static void mapaAstral(LocalDateTime localDateTime, String zone) {
        System.out.println("Idade: " + idade(localDateTime));
        System.out.println("Data de nascimento: " + formatar(localDateTime));
        System.out.println("Zoneoffset do local de nascimento: " + timeZone(localDateTime, zone));
        System.out.println("Ano bissexto: " + isAnoBissexto(localDateTime));
        Signo signo = getSigno(localDateTime);
        System.out.println("Signo: " + signo);
        System.out.println("Ascendente: " + getAscendente(signo, localDateTime.toLocalTime()));
        System.out.println("Signo Lunar: " + signo.getLunar(localDateTime.toLocalTime(), zone));
    }

    public String getAscendente(LocalTime hora) {
        Map<Integer, String> signosAscendentes = this.getAscendente();

        for (Map.Entry<Integer, String> ascendente : signosAscendentes.entrySet()) {
            int horaAtual = ascendente.getKey();
            int novaHora = horaAtual + 2;

            if (novaHora == 24) {
                novaHora = 0;
            }

            if (!(hora.isBefore(LocalTime.of(horaAtual, 0, 0)) || hora.isAfter(LocalTime.of(novaHora, 0, 0)))) {
                return ascendente.getValue();
            }
        }
        throw new IllegalArgumentException("Nao tem Ascendente");
    }

    public String getLunar(LocalTime hora, String localNascimento) {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        for (String s : zones) {
            if (s.contains(localNascimento)) {
                ZoneId zoneId = ZoneId.of(s);

                if (zoneId.toString().equals("America/Recife") && hora.isAfter(LocalTime.NOON)) {
                    return "Casimiro";
                }

                if (zoneId.toString().equals("America/Cuiaba") && hora.isBefore(LocalTime.NOON)) {
                    return "Odin";
                }

                if (zoneId.toString().equals("America/Sao_Paulo")) {
                    return "Gandalf";
                }
            }
        }
        return "Dinossauro";
    }

    public static Integer idade(LocalDateTime localDateTime) {
        return Period.between(localDateTime.toLocalDate(), LocalDate.now()).getYears();
    }

    public static boolean isAnoBissexto(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate().isLeapYear();
    }

    public static String formatar(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public static ZoneOffset timeZone(LocalDateTime localDateTime, String zone) {
        return ZoneId.of(zone).getRules().getOffset(localDateTime);
    }

    private static Signo getSigno(LocalDateTime localDateTime) {
        return SignoFactory.create(MonthDay.of(localDateTime.getMonth(), localDateTime.getDayOfMonth()));
    }

    private static String getAscendente(Signo signo, LocalTime localTime) {
        return signo.getAscendente(localTime);
    }
}

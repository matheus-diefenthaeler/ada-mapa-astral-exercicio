package factory;

import signo.Signo;
import signo.signoImpl.*;

import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;

public class SignoFactory {
    private final static List<Signo> signos = Arrays.asList(
            new Aquario(),
            new Aries(),
            new Cancer(),
            new Capricornio(),
            new Escorpiao(),
            new Gemeos(),
            new Leao(),
            new Libra(),
            new Peixes(),
            new Sagitario(),
            new Touro(),
            new Virgem()
    );

    public static Signo create(MonthDay date) {
        for (Signo signo : signos) {
            if (!(date.isBefore(signo.getInicio()) || date.isAfter(signo.getFim()))) {
                return signo;
            }
        }
        throw new IllegalArgumentException("Nao tem Signo");
    }
}

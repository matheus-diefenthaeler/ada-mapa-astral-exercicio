package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Aquario extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.JANUARY, 21);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.FEBRUARY, 18);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Sagitário");
            put(2, "Capricórnio");
            put(4, "Aquário");
            put(6, "Peixes");
            put(8, "Áries");
            put(10, "Touro");
            put(12, "Gêmeos");
            put(14, "Câncer");
            put(16, "Leão");
            put(18, "Virgem");
            put(20, "Libra");
            put(22, "Escorpião");
        }};
    }

    @Override
    public String toString() {
        return "Aquário";
    }
}

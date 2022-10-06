package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Virgem extends Signo {

    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.AUGUST, 23);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.SEPTEMBER, 22);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Câncer");
            put(2, "Leão");
            put(4, "Virgem");
            put(6, "Libra");
            put(8, "Escorpião");
            put(10, "Sagitário");
            put(12, "Capricórnio");
            put(14, "Aquário");
            put(16, "Peixes");
            put(18, "Áries");
            put(20, "Touro");
            put(22, "Gêmeos");
        }};
    }

    @Override
    public String toString() {
        return "Virgem";
    }
}

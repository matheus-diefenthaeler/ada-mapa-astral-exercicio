package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Capricornio extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.DECEMBER, 22);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.JANUARY, 20);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Escorpião");
            put(2, "Sagitário");
            put(4, "Capricórnio");
            put(6, "Aquário");
            put(8, "Peixes");
            put(10, "Áries");
            put(12, "Touro");
            put(14, "Gêmeos");
            put(16, "Câncer");
            put(18, "Leão");
            put(20, "Virgem");
            put(22, "Libra");
        }};
    }

    @Override
    public String toString() {
        return "Capricórnio";
    }
}

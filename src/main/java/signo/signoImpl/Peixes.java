package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Peixes extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.FEBRUARY, 19);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.MARCH, 20);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Capricórnio");
            put(2, "Aquário");
            put(4, "Peixes");
            put(6, "Áries");
            put(8, "Touro");
            put(10, "Gêmeos");
            put(12, "Câncer");
            put(14, "Leão");
            put(16, "Virgem");
            put(18, "Libra");
            put(20, "Escorpião");
            put(22, "Sagitário");
        }};
    }

    @Override
    public String toString() {
        return "Peixes";
    }
}

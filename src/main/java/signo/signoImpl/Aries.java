package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Aries extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.MARCH, 21);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.APRIL, 20);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Aquário");
            put(2, "Peixes");
            put(4, "Áries");
            put(6, "Touro");
            put(8, "Gêmeos");
            put(10, "Câncer");
            put(12, "Leão");
            put(14, "Virgem");
            put(16, "Libra");
            put(18, "Escorpião");
            put(20, "Sagitário");
            put(22, "Capricórnio");
        }};
    }

    @Override
    public String toString() {
        return "Áries";
    }
}

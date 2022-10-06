package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Leao extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.JULY, 23);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.AUGUST, 22);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Gêmeos");
            put(2, "Câncer");
            put(4, "Leão");
            put(6, "Virgem");
            put(8, "Libra");
            put(10, "Escorpião");
            put(12, "Sagitário");
            put(14, "Capricórnio");
            put(16, "Aquário");
            put(18, "Peixes");
            put(20, "Áries");
            put(22, "Touro");
        }};
    }

    @Override
    public String toString() {
        return "Leão";
    }
}

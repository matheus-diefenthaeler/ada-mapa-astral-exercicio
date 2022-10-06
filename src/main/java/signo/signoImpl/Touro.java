package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Touro extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.APRIL, 21);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.MAY, 20);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Peixes");
            put(2, "Áries");
            put(4, "Touro");
            put(6, "Gêmeos");
            put(8, "Câncer");
            put(10, "Leão");
            put(12, "Virgem");
            put(14, "Libra");
            put(16, "Escorpião");
            put(18, "Sagitário");
            put(20, "Capricórnio");
            put(22, "Aquário");
        }};
    }

    @Override
    public String toString() {
        return "Touro";
    }
}

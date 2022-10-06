package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Sagitario extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.NOVEMBER, 22);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.DECEMBER, 21);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Libra");
            put(2, "Escorpião");
            put(4, "Sagitário");
            put(6, "Capricórnio");
            put(8, "Aquário");
            put(10, "Peixes");
            put(12, "Áries");
            put(14, "Touro");
            put(16, "Gêmeos");
            put(18, "Câncer");
            put(20, "Leão");
            put(22, "Virgem");
        }};
    }

    @Override
    public String toString() {
        return "Sagitário";
    }
}

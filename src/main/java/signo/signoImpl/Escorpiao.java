package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Escorpiao extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.OCTOBER, 23);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.NOVEMBER, 21);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Virgem");
            put(2, "Libra");
            put(4, "Escorpião");
            put(6, "Sagitário");
            put(8, "Capricórnio");
            put(10, "Aquário");
            put(12, "Peixes");
            put(14, "Áries");
            put(16, "Touro");
            put(18, "Gêmeos");
            put(20, "Câncer");
            put(22, "Leão");
        }};
    }

    @Override
    public String toString() {
        return "Escorpião";
    }
}

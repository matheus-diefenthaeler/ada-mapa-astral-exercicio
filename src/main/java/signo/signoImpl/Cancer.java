package signo.signoImpl;

import signo.Signo;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Cancer extends Signo {
    @Override
    public MonthDay getInicio() {
        return MonthDay.of(Month.JUNE, 21);
    }

    @Override
    public MonthDay getFim() {
        return MonthDay.of(Month.JULY, 22);
    }

    @Override
    protected Map<Integer, String> getAscendente() {
        return new HashMap<>() {{
            put(0, "Touro");
            put(2, "Gêmeos");
            put(4, "Câncer");
            put(6, "Leão");
            put(8, "Virgem");
            put(10, "Libra");
            put(12, "Escorpião");
            put(14, "Sagitário");
            put(16, "Capricórnio");
            put(18, "Aquário");
            put(20, "Peixes");
            put(22, "Áries");
        }};
    }

    @Override
    public String toString() {
        return "Câncer";
    }

}

import signo.Signo;

import java.time.LocalDateTime;

import static signo.Signo.mapaAstral;

public class app {
    public static void main(String[] args) {

        LocalDateTime localDateMatheus = LocalDateTime.of(1991,9,19,19,22);

        mapaAstral(localDateMatheus,"America/Sao_Paulo");
    }
}

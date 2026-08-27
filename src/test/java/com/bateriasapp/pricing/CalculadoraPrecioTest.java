package com.bateriasapp.pricing;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraPrecioTest {

    @Test
    void efectivoSinBateriaUsada() {
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        BigDecimal resultado = calculadora.calcularPrecioFinal(
                BigDecimal.valueOf(250000),
                MetodoPago.EFECTIVO,
                false);
        assertEquals(BigDecimal.valueOf(250000), resultado);

    }

    @Test
    void tarjetaSinBateriaUsada(){

    }
}

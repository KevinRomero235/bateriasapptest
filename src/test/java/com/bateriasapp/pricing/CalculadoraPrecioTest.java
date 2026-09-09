package com.bateriasapp.pricing;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        BigDecimal resultado = calculadora.calcularPrecioFinal(
                BigDecimal.valueOf(250000),
                MetodoPago.TARJETA,
                false);
        assertEquals(BigDecimal.valueOf(265000), resultado);
    }

    @Test
    void tarjetaConBateriaUsada(){
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        BigDecimal resultado = calculadora.calcularPrecioFinal(
                BigDecimal.valueOf(250000),
                MetodoPago.TARJETA,
                true);
        assertEquals(BigDecimal.valueOf(233200), resultado);
    }

    @Test

    void addiConBateriaUsada(){
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        BigDecimal resultado = calculadora.calcularPrecioFinal(
                BigDecimal.valueOf(250000),
                MetodoPago.ADDI,
                true
        );
        assertEquals(BigDecimal.valueOf(248600), resultado);
    }

    @Test
    void transferenciaSinAjustes(){
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        BigDecimal resultado = calculadora.calcularPrecioFinal(
                BigDecimal.valueOf(300000),
                MetodoPago.TRANSFERENCIA,
                false
        );
        assertEquals(BigDecimal.valueOf(300000), resultado);
    }

    @Test
    void subTotalNoQuedaNegativo(){
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        BigDecimal resultado = calculadora.calcularPrecioFinal(
                BigDecimal.valueOf(20000),
                MetodoPago.EFECTIVO,
                true
        );
        assertEquals(BigDecimal.ZERO, resultado);
    }

    @Test
    void precioBaseNuloLanzaExcepcion(){
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularPrecioFinal(
                    null,
                    MetodoPago.TRANSFERENCIA,
                    true
            );
        });
    }

    @Test
    void metodoPagoNuloLanzaExcepcion(){
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        assertThrows(IllegalArgumentException.class, () ->{
           calculadora.calcularPrecioFinal(
             BigDecimal.valueOf(250000),
             null,
             false
           );
        });
    }

}

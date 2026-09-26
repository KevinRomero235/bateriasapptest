package com.bateriasapp.pricing;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
@Service
public class CalculadoraPrecio {

    public static final BigDecimal DESCUENTO_BATERIA_USADA = BigDecimal.valueOf(30_000);

    public BigDecimal calcularPrecioFinal(BigDecimal precioBase, MetodoPago metodoPago, boolean entregaBateriaUsada) {

        if (precioBase == null || precioBase.signum() < 0){
            throw new IllegalArgumentException("El precio base no puede ser 0, tampoco estar vacio");
        }
        if (metodoPago == null){
            throw new IllegalArgumentException("El metodo de pago es obligatorio");
        }

        BigDecimal subTotal = entregaBateriaUsada
                ? precioBase.subtract(DESCUENTO_BATERIA_USADA)
                : precioBase;

        if (subTotal.signum() <0){
            subTotal = BigDecimal.ZERO;
        }

        BigDecimal recargo = subTotal.multiply(BigDecimal.valueOf(metodoPago.getPorcentajeRecargo()));

        BigDecimal total = subTotal.add(recargo);
        return total.setScale(0, RoundingMode.HALF_UP);



    }


}

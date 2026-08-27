package com.bateriasapp.pricing;

public enum MetodoPago {
    EFECTIVO(0.00),
    TRANSFERENCIA(0.00),
    TARJETA(0.06),
    ADDI(0.13);

    private final double porcentajeRecargo;

    MetodoPago(double porcentajeRecargo) {
        this.porcentajeRecargo = porcentajeRecargo;
    }

    public double getPorcentajeRecargo() {
        return porcentajeRecargo;
    }
}

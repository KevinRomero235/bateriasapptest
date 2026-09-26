package com.bateriasapp.dto;

public class PedidoRequest {
    private Integer clienteId;
    private Integer productoId;
    private String metodoPago;
    private Boolean entregaBateriaUsada;

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Boolean getEntregaBateriaUsada() {
        return entregaBateriaUsada;
    }

    public void setEntregaBateriaUsada(Boolean entregaBateriaUsada) {
        this.entregaBateriaUsada = entregaBateriaUsada;
    }
}

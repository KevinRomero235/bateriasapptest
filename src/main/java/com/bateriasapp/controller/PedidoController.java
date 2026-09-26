//package com.bateriasapp.controller;
//
//import com.bateriasapp.dto.PedidoRequest;
//import com.bateriasapp.model.Cliente;
//import com.bateriasapp.model.Pedido;
//import com.bateriasapp.model.Producto;
//import com.bateriasapp.pricing.CalculadoraPrecio;
//import com.bateriasapp.pricing.MetodoPago;
//import com.bateriasapp.repository.ClienteRepository;
//import com.bateriasapp.repository.PedidoRepository;
//import com.bateriasapp.repository.ProductoRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Locale;
//
//@RestController
//@RequestMapping("/api/pedidos")
//
//public class PedidoController {
//    private final PedidoRepository pedidoRepository;
//    private final ClienteRepository clienteRepository;
//    private final ProductoRepository productoRepository;
//    private final CalculadoraPrecio calculadoraPrecio;
//
//    public PedidoController(PedidoRepository pedidoRepository,
//                            ClienteRepository clienteRepository,
//                            ProductoRepository productoRepository,
//                            CalculadoraPrecio calculadoraPrecio) {
//        this.pedidoRepository = pedidoRepository;
//        this.clienteRepository = clienteRepository;
//        this.productoRepository = productoRepository;
//        this.calculadoraPrecio = calculadoraPrecio;
//    }
//
//    @GetMapping
//    public List<Pedido> listarTodos(){
//        return pedidoRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Pedido obtenerPorId(@PathVariable Integer id){
//        return pedidoRepository.findById(id).orElseThrow();
//    }
//
//    @PostMapping
//    public ResponseEntity<Pedido> crearPedido(@RequestBody PedidoRequest request){
//        Cliente cliente = clienteRepository.findById(request.getClienteId()).orElseThrow();
//        Producto producto = productoRepository.findById(request.getProductoId()).orElseThrow();
//        MetodoPago metodoPago = MetodoPago.valueOf(request.getMetodoPago().toUpperCase());
//        BigDecimal precioFinal = calculadoraPrecio.calcularPrecioFinal(
//                producto.getPrecioBase(), metodoPago, request.getEntregaBateriaUsada()
//        );
//
//        Pedido nuevoPedido = new Pedido();
//        nuevoPedido.setCliente(cliente);
//        nuevoPedido.setProducto(producto);
//        nuevoPedido.setMetodoPago(request.getMetodoPago());
//        nuevoPedido.setEntregaBateriaUsada(request.getEntregaBateriaUsada());
//        nuevoPedido.setPrecioFinal(precioFinal);
//        nuevoPedido.setEstado("cotizado");
//        nuevoPedido.setFechaCreacion(LocalDateTime.now());
//
//        Pedido pedidoGuardado = pedidoRepository.save(nuevoPedido);
//        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoGuardado);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarPorId(@PathVariable Integer id){
//        pedidoRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Integer id, @RequestBody Pedido dto){
//        Pedido actualizarPedido = pedidoRepository.findById(id).orElseThrow();
//
//
//
//    }
//
//
//}
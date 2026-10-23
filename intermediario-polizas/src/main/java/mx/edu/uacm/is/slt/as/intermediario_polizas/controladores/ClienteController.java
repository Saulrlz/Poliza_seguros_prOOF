package mx.edu.uacm.is.slt.as.intermediario_polizas.controladores;

import mx.edu.uacm.is.slt.as.intermediario_polizas.modelos.Cliente;
import mx.edu.uacm.is.slt.as.intermediario_polizas.servicios.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de clientes asegurados.
 * Expone endpoints HTTP para consultar, dar de alta y modificar clientes.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    /**
     * Constructor para inyectar el servicio de clientes.
     * @param service El servicio de lógica de negocio.
     */
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    /**
     * Consulta un cliente en el Sistema Dueño por su CURP.
     * @param curp El identificador único del cliente.
     * @return El JSON del cliente o un error 503.
     */
    @GetMapping("/{curp}")
    public ResponseEntity<String> consultar(@PathVariable String curp) {
        try {
            return ResponseEntity.ok(service.consultarCliente(curp));
        } catch (Exception e) {
            return ResponseEntity.status(503)
                    .body("{\"error\":\"Sistema Dueno no disponible\"}");
        }
    }

    /**
     * Registra un nuevo cliente (simulado).
     * @param cliente El objeto cliente a registrar.
     * @return Mensaje simulado.
     */
    @PostMapping
    public ResponseEntity<String> alta(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(
            "{\"status\":\"simulado\",\"mensaje\":\"Alta de cliente pendiente\"}"
        );
    }

    /**
     * Modifica un cliente existente (simulado).
     * @param curp CURP del cliente a modificar.
     * @param cliente Nuevos datos.
     * @return Mensaje simulado.
     */
    @PutMapping("/{curp}")
    public ResponseEntity<String> modificar(@PathVariable String curp,
                                             @RequestBody Cliente cliente) {
        return ResponseEntity.ok(
            "{\"status\":\"simulado\",\"mensaje\":\"Modificacion de cliente pendiente\"}"
        );
    }
}
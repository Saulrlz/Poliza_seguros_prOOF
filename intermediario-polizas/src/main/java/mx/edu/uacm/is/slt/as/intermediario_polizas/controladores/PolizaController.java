package mx.edu.uacm.is.slt.as.intermediario_polizas.controladores;

import mx.edu.uacm.is.slt.as.intermediario_polizas.modelos.Poliza;
import mx.edu.uacm.is.slt.as.intermediario_polizas.servicios.PolizaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de Pólizas de seguro.
 * Expone endpoints para consultar, registrar, modificar y dar de baja pólizas.
 * Delega la lógica de negocio a {@link PolizaService}.
 */
@RestController
@RequestMapping("/api/polizas")
public class PolizaController {

    private final PolizaService service;

    /**
     * Constructor para inyectar el servicio de pólizas.
     * @param service El servicio de lógica de negocio.
     */
    public PolizaController(PolizaService service) {
        this.service = service;
    }

    /**
     * Consulta una póliza específica por su clave UUID.
     * @param clave El identificador de la póliza.
     * @return El JSON de la póliza o error 503.
     */
    @GetMapping("/{clave}")
    public ResponseEntity<String> consultarPorClave(@PathVariable String clave) {
        try {
            return ResponseEntity.ok(service.consultarPoliza(clave));
        } catch (Exception e) {
            return ResponseEntity.status(503)
                    .body("{\"error\":\"Sistema Dueno no disponible\"}");
        }
    }

    /**
     * Lista todas las pólizas registradas en el Sistema Dueño.
     * @return JSON con la lista de pólizas.
     */
    @GetMapping
    public ResponseEntity<String> listarTodas() {
        try {
            return ResponseEntity.ok(service.listarTodas());
        } catch (Exception e) {
            return ResponseEntity.status(503)
                    .body("{\"error\":\"Sistema Dueno no disponible\"}");
        }
    }

    /**
     * Lista las pólizas pertenecientes a un cliente específico.
     * @param curp La CURP del cliente.
     * @return JSON con las pólizas del cliente.
     */
    @GetMapping("/cliente/{curp}")
    public ResponseEntity<String> listarPorCliente(@PathVariable String curp) {
        try {
            return ResponseEntity.ok(service.listarPorCliente(curp));
        } catch (Exception e) {
            return ResponseEntity.status(503)
                    .body("{\"error\":\"Sistema Dueno no disponible\"}");
        }
    }

    /**
     * Lista las pólizas filtradas por su tipo (0, 1 o 2).
     * @param tipo El tipo de póliza.
     * @return JSON con las pólizas del tipo especificado.
     */
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<String> listarPorTipo(@PathVariable int tipo) {
        try {
            return ResponseEntity.ok(service.listarPorTipo(tipo));
        } catch (Exception e) {
            return ResponseEntity.status(503)
                    .body("{\"error\":\"Sistema Dueno no disponible\"}");
        }
    }

    /**
     * Registra una nueva póliza (simulado).
     * @param poliza El objeto póliza a registrar.
     * @return Mensaje simulado.
     */
    @PostMapping
    public ResponseEntity<String> altaPoliza(@RequestBody Poliza poliza) {
        return ResponseEntity.ok(
            "{\"status\":\"simulado\",\"mensaje\":\"Alta de poliza pendiente\"}"
        );
    }

    /**
     * Modifica una póliza existente (simulado).
     * @param clave Clave de la póliza a modificar.
     * @param poliza Nuevos datos.
     * @return Mensaje simulado.
     */
    @PutMapping("/{clave}")
    public ResponseEntity<String> modificarPoliza(@PathVariable String clave,
                                                   @RequestBody Poliza poliza) {
        return ResponseEntity.ok(
            "{\"status\":\"simulado\",\"mensaje\":\"Modificacion de poliza pendiente\"}"
        );
    }

    /**
     * Da de baja una póliza (simulado).
     * @param clave Clave de la póliza a eliminar.
     * @return Mensaje simulado.
     */
    @DeleteMapping("/{clave}")
    public ResponseEntity<String> bajaPoliza(@PathVariable String clave) {
        return ResponseEntity.ok(
            "{\"status\":\"simulado\",\"mensaje\":\"Baja de poliza pendiente\"}"
        );
    }
}
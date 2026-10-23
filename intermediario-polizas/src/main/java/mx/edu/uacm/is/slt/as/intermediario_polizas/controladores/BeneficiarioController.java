package mx.edu.uacm.is.slt.as.intermediario_polizas.controladores;

import mx.edu.uacm.is.slt.as.intermediario_polizas.modelos.Beneficiario;
import mx.edu.uacm.is.slt.as.intermediario_polizas.servicios.BeneficiarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de Beneficiarios.
 * Expone endpoints para consultar y registrar beneficiarios.
 */
@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {

    private final BeneficiarioService service;

    /**
     * Constructor para inyectar el servicio de beneficiarios.
     * @param service El servicio de lógica de negocio.
     */
    public BeneficiarioController(BeneficiarioService service) {
        this.service = service;
    }

    /**
     * Consulta un beneficiario en el Sistema Dueño.
     * @param fecha Fecha de nacimiento.
     * @param clave Clave de la póliza.
     * @param nombres Nombres del beneficiario.
     * @param apellido Apellido del beneficiario.
     * @return JSON del beneficiario o error 503.
     */
    @GetMapping("/{fecha}/{clave}/{nombres}/{apellido}")
    public ResponseEntity<String> consultar(@PathVariable String fecha,
                                             @PathVariable String clave,
                                             @PathVariable String nombres,
                                             @PathVariable String apellido) {
        try {
            return ResponseEntity.ok(
                service.consultarBeneficiario(fecha, clave, nombres, apellido)
            );
        } catch (Exception e) {
            return ResponseEntity.status(503)
                    .body("{\"error\":\"Sistema Dueno no disponible\"}");
        }
    }

    /**
     * Registra un nuevo beneficiario (simulado).
     * @param beneficiario El objeto beneficiario a registrar.
     * @return Mensaje simulado.
     */
    @PostMapping
    public ResponseEntity<String> alta(@RequestBody Beneficiario beneficiario) {
        return ResponseEntity.ok(
            "{\"status\":\"simulado\",\"mensaje\":\"Alta de beneficiario pendiente\"}"
        );
    }
}
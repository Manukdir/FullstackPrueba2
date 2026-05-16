package cl.duoc.fullstack.msenvios.controller;

import cl.duoc.fullstack.msenvios.dto.EnvioDTO;
import cl.duoc.fullstack.msenvios.dto.EnvioRequestDTO;
import cl.duoc.fullstack.msenvios.service.EnvioService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public ResponseEntity<List<EnvioDTO>> findAll() {
        return ResponseEntity.ok(envioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(envioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnvioDTO> save(@Valid @RequestBody EnvioRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(envioService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvioDTO> update(@PathVariable Integer id, @Valid @RequestBody EnvioRequestDTO request) {
        return ResponseEntity.ok(envioService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        envioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/no-entregados")
    public ResponseEntity<List<EnvioDTO>> buscarNoEntregadosPorRango(@RequestParam LocalDate desde, @RequestParam LocalDate hasta) {
        return ResponseEntity.ok(envioService.buscarNoEntregadosPorRango(desde, hasta));
    }

}

package br.com.postodomanoel.postodomanoel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.postodomanoel.postodomanoel.Entity.FrentistaEntity;
import br.com.postodomanoel.postodomanoel.Repository.FrentistaRepository;

@RestController
@RequestMapping("/frentista")
public class FrentistaController {

    @Autowired
    FrentistaRepository frentistaRepository;

    @GetMapping
    @RequestMapping("/listar")
    public List<FrentistaEntity> listar() {
        return frentistaRepository.findAll();

    }

    @GetMapping
    @RequestMapping("/buscar")
    public ResponseEntity<Object> buscarPorId(@RequestParam Integer id) {
        try {
            FrentistaEntity frentistaEntity = frentistaRepository.findById(id).get();
            return ResponseEntity.ok().body(frentistaEntity);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());

        }
    }

    @PostMapping
    @RequestMapping("/salvar")
    public ResponseEntity<Object> salvar(@RequestBody FrentistaEntity frentistaEntity) {
        frentistaRepository.save(frentistaEntity);
        return ResponseEntity.ok().body(frentistaEntity);

    }

    @RequestMapping("/apagar")
    public ResponseEntity<String> apagar(@RequestParam Integer id) {
        String resp;
        try {
            frentistaRepository.deleteById(id);
            resp = "Apagado com sucesso!";
        } catch (Exception erro) {
            System.out.println("------------------------> ERROR" + erro);
            resp = "Erro ao apagar";
        }
        return ResponseEntity.ok().body(resp);

    }

}

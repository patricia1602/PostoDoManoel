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

import br.com.postodomanoel.postodomanoel.Entity.CombustivelEntity;
import br.com.postodomanoel.postodomanoel.Repository.CombustivelRepository;

@RestController
@RequestMapping("/combustivel")
public class CombustivelController {

    @Autowired
    CombustivelRepository combustivelRepository;

    @GetMapping
    @RequestMapping("/listar")
    public List<CombustivelEntity> listar() {
        return combustivelRepository.findAll();

    }

    @GetMapping
    @RequestMapping("/buscar")
    public ResponseEntity<Object> buscarPorId(@RequestParam Integer id) {
        try {
            CombustivelEntity combustivelEntity = combustivelRepository.findById(id).get();
            return ResponseEntity.ok().body(combustivelEntity);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());

        }
    }

    @PostMapping
    @RequestMapping("/salvar")
    public ResponseEntity<Object> salvar(@RequestBody CombustivelEntity combustivelEntity) {
        combustivelRepository.save(combustivelEntity);
        return ResponseEntity.ok().body(combustivelEntity);

    }

    @RequestMapping("/apagar")
    public ResponseEntity<String> apagar(@RequestParam Integer id) {
        String resp;
        try {
            combustivelRepository.deleteById(id);
            resp = "Apagado com sucesso!";
        } catch (Exception erro) {
            System.out.println("------------------------> ERROR" + erro);
            resp = "Erro ao apagar";
        }
        return ResponseEntity.ok().body(resp);

    }

}

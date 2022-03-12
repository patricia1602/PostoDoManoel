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

import br.com.postodomanoel.postodomanoel.Entity.AbastecimentoEntity;
import br.com.postodomanoel.postodomanoel.Repository.AbastecimentoRepository;

@RestController
@RequestMapping("abastecimento")
public class AbastecimentoController {

    @Autowired
    AbastecimentoRepository abastecimentoRepository;

    @GetMapping
    @RequestMapping("/listar")
    public List<AbastecimentoEntity> listar() {
        return abastecimentoRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/buscar")
    public ResponseEntity<Object> buscarPorId(@RequestParam Integer id) {
        try {
            AbastecimentoEntity abastecimentoEntity = abastecimentoRepository.findById(id).get();
            return ResponseEntity.ok().body(abastecimentoEntity);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping
    @RequestMapping("/salvar")
    public ResponseEntity<Object> salvar(@RequestBody AbastecimentoEntity abastecimentoEntity) {
        abastecimentoRepository.save(abastecimentoEntity);
        return ResponseEntity.ok().body(abastecimentoEntity);
    }

    @RequestMapping("/apagar")
    public ResponseEntity<String> apagar (@RequestParam Integer id){
        String resp;
        try{
            abastecimentoRepository.deleteById(id);
                resp = "Apagado com sucesso!";
        }catch(Exception erro){
            System.out.println("------------------------> ERROR" + erro);
            resp = "Erro ao apagar";
        }
        return ResponseEntity.ok().body(resp);

    }

}

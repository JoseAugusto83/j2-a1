package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Aluno;
import application.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepo;

    @GetMapping
    public Iterable<Aluno> list(){
        return alunoRepo.findAll();
    }

    @PostMapping
    public Aluno postAluno(@RequestBody Aluno aluno){
        return alunoRepo.save(aluno);
    }

    @GetMapping("/{id}")
    public Optional<Aluno> details(@PathVariable long id){
        return alunoRepo.findById(id);
    }

    @PutMapping("/{id}")
    public Aluno put(@PathVariable long id, @RequestBody Aluno body){
        Optional<Aluno> resultado = alunoRepo.findById(id);
        resultado.get().setNome(body.getNome());
        return alunoRepo.save(resultado.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        alunoRepo.deleteById(id);
    }
}

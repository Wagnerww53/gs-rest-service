package com.prova.prefeitura.fila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prova.prefeitura.fila.dao.PessoaDAO;
import com.prova.prefeitura.fila.entidades.Pessoa;

public class PessoasController {
	@Autowired
    private PessoaDAO pessoaDAO;

    //Na URL "/pessoas/create" o método "postMapping" irá cadastrar nova pessoa
    @PostMapping("/pessoas/create")
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return pessoaDAO.salvar(pessoa);
    }
    
    //Na URL "/pessoas/{id}" o método "getMapping" irá buscar apessoa pelo id
    @GetMapping("/pessoas/{id}")
    public Pessoa getPessoaById(@PathVariable long id) {
        return pessoaDAO.buscarPeloId(id);
    }
  
    //Na URL "/pessoas" o método "getMapping" irá listar todas as pessoas cadastradas
    @GetMapping("/pessoas")
    public List<Pessoa> getAllPessoas() {
        return pessoaDAO.buscarTodas();
    }
  
    //Na URL "/pessoas/{id}" o método "putMapping" irá atualizar a pessoa pelo id
    @PutMapping("/pessoas/{id}")
    public Pessoa updatePessoa(@PathVariable long id, 
                                   @RequestBody Pessoa pessoaUpdated) {
        return pessoaDAO.atualizarPeloId(id, pessoaUpdated);
    }
  
    //Na URL "/pessoas/{id}" o método "deleteMapping" irá deletar a pessoa pelo id
    @DeleteMapping("/pessoas/{id}")
    public Pessoa deletePessoa(@PathVariable long id) {
        return pessoaDAO.removerPeloId(id);
    }
}

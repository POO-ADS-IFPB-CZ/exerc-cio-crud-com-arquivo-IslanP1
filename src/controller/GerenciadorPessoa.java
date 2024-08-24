package src.controller;

import src.model.Pessoa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GerenciadorPessoa implements Serializable {
    private Set<Pessoa> pessoas;

    public GerenciadorPessoa() {
        this.pessoas = new HashSet<>();
    }

    public boolean addPessoa(Pessoa pessoa) {
        return this.pessoas.add(pessoa);
    }

    public boolean removePessoa(String email) {
        for (Pessoa p : this.pessoas) {
            if (p.getEmail().equals(email)) {
                return this.pessoas.remove(p);
            }
        }
        return false;
    }

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    @Override
    public String toString() {
        return "GerenciadorPessoa{" +
                "pessoas=" + pessoas +
                '}';
    }
}

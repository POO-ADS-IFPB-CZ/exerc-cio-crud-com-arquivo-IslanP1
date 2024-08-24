package src.model;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {
    private String email;
    private String nome;

    public Pessoa(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(email, pessoa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}

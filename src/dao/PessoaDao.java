package src.dao;

import src.controller.GerenciadorPessoa;
import src.model.Pessoa;

import java.io.*;

public class PessoaDao {
    private File arquivo;

    public PessoaDao() {
        arquivo = new File("pessoas.ser");

        try {
            arquivo.createNewFile();
        } catch (IOException e) {
            System.out.println("Falha ao criar o arquivo");
        }
    }

    public GerenciadorPessoa getGerenciadorPessoa() {
        if (arquivo.length() > 0) {
            try {
                FileInputStream inputStreamStream = new FileInputStream(arquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStreamStream);
                return (GerenciadorPessoa) objectInputStream.readObject()   ;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return new GerenciadorPessoa();
    }

    public boolean salvar(Pessoa pessoa) {
        GerenciadorPessoa gerenciadorPessoa = getGerenciadorPessoa();

        if (gerenciadorPessoa.addPessoa(pessoa)) {
            try{
                FileOutputStream outputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(gerenciadorPessoa);
                return true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return false;
    }

    public boolean deletar(Pessoa pessoa) {
        GerenciadorPessoa gerenciadorPessoa = getGerenciadorPessoa();

        if (gerenciadorPessoa.removePessoa(pessoa.getEmail())) {
            try{
                FileOutputStream outputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(gerenciadorPessoa);
                return true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return false;
    }
}

package src.view;

import src.dao.PessoaDao;
import src.model.Pessoa;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PessoaDao pessoaDao = new PessoaDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Salvar uma pessoa");
            System.out.println("2. Listar todas as pessoas");
            System.out.println("3. Deletar uma pessoa pelo e-mail");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o e-mail: ");
                    String email = scanner.nextLine();
                    Pessoa novaPessoa = new Pessoa(email, nome);
                    if (pessoaDao.salvar(novaPessoa)) {
                        System.out.println("Pessoa salva com sucesso!");
                    } else {
                        System.out.println("Falha ao salvar a pessoa. O e-mail já existe.");
                    }
                    break;

                case 2:
                    Set<Pessoa> pessoas = pessoaDao.getGerenciadorPessoa().getPessoas();
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa encontrada.");
                    } else {
                        for (Pessoa pessoa : pessoas) {
                            System.out.println(pessoa.getNome() + " - " + pessoa.getEmail());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o e-mail da pessoa a ser deletada: ");
                    String emailParaDeletar = scanner.nextLine();
                    Pessoa pessoaParaDeletar = new Pessoa(emailParaDeletar, "");
                    if (pessoaDao.deletar(pessoaParaDeletar)) {
                        System.out.println("Pessoa deletada com sucesso!");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}

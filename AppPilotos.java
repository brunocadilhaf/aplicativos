package aplicativos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao, qtdCadastrados = 0;
        List<Pessoa> listaPessoas = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto");
            System.out.println("4 - Excluir piloto");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                System.out.println("Digite seu nome e cpf: ");
                Pessoa p = new Pessoa(in.nextLine(), in.nextLine());
                listaPessoas.add(p);

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (listaPessoas.isEmpty()) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("1 - Ordenador por CPF");
                System.out.println("2 - Ordenador por Nome");
                System.out.print("Opção: ");
                opcao = in.nextInt();

                if (opcao == 1) {
                    listaPessoas.sort(new OrdenacaoPorCPF());
                } else {
                    listaPessoas.sort(new OrdenacaoPorNome());
                }
                
                System.out.println("Lista cadastrada:");
                for (Pessoa p: listaPessoas) {
                    System.out.printf("Nome: %s - CPF: %s\n", p.getNome(), p.getCpf());
                }
                in.nextLine();
                voltarMenu(in);
            } else if (opcao == 3) {
    
                opcao = in.nextInt();
            } else if (opcao == 4) {
                System.out.println("1 - Excluir por CPF");
                System.out.println("2 - Excluir por Nome");
                System.out.print("Opção: ");
                opcao = in.nextInt();

                if (opcao == 1) {
                    System.out.println("Informe o CPF:");
                    String cpf = in.next();
                    listaPessoas.removeIf(p -> p.getCpf().equals(cpf));
                } else {
                    System.out.println("Informe o nome:");
                    String nome = in.next();
                    listaPessoas.removeIf(p -> p.getNome().equals(nome));
                }
    
                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
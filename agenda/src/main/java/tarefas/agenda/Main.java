package tarefas.agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        while (true) {
            // MENU
            System.out.println("MENU - Agenda");
            System.out.println("[C] para inserir, [R] para ler, [U] para atualizar e [D] para apagar.");

            Scanner input = new Scanner(System.in);
            String resposta = input.nextLine();

            switch (resposta.toUpperCase().charAt(0)) {
                case 'C':
                    limparTerminal();
                    System.out.println("[Q] para manter.");
                    System.out.print("Insira tarefa > ");
                    
                    Tarefa tarefa = new Tarefa();

                    String tarefaNome = input.nextLine();

                    if (tarefaNome.toLowerCase().charAt(0) != 'q') {
                        tarefa.setTarefa(tarefaNome.trim());
                    } else {
                        break;
                    }

                    limparTerminal();
                    System.out.println("[Q] para null.");
                    System.out.println("Descrição da tarefa > ");

                    String desc = input.nextLine();
                    if (desc.toLowerCase().charAt(0) != 'q') {
                        tarefa.setDescricao(desc.trim());
                    }
                    agenda.adicionarTarefa(tarefa);
                    
                    limparTerminal();
                    agenda.lerTarefas();

                    input.close();
                    break;
                case 'R':
                    limparTerminal();
                    agenda.lerTarefas();
                    
                    input.close();
                    break;
                case 'U':
                    limparTerminal();
                    agenda.lerTarefas();
                    System.out.println("[0] para sair.");
                    System.out.println("[ID] Qual tarefa deseja atualizar? ");
                    int id = input.nextInt();

                    if (id == 0) {
                        limparTerminal();
                        break;
                    }

                    agenda.atualizarTarefa(id);
                    limparTerminal();

                    
                    input.close();
                    break;
                case 'D':
                    limparTerminal();
                    agenda.lerTarefas();

                    System.out.println("[0] para sair.");
                    System.out.println("[ID] Qual item deseja remover? ");

                    int respostaDel = input.nextInt();

                    limparTerminal(); 
                    agenda.removerTarefa(respostaDel);
                    
                    input.close();
                    break;
                default:
                    break;
            }
        }
    }
    public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
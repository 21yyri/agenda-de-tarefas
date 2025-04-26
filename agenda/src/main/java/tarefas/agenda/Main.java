package tarefas.agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        while (true) {
            // MENU
            System.out.println("MENU - Agenda");
            System.out.println("[C] para criar, [L] para ler, [A] para atualizar, [D] para deletar e [M] para marcar concluído.");

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
                    break;
                case 'L':
                    limparTerminal();
                    agenda.lerTarefas();
                    
                    break;
                case 'A':
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

                    break;
                case 'D':
                    limparTerminal();
                    agenda.lerTarefas();

                    System.out.println("[0] para sair.");
                    System.out.println("[ID] Qual item deseja remover? ");

                    int respostaDel = input.nextInt();

                    limparTerminal(); 
                    agenda.removerTarefa(respostaDel);
                    
                    break;
                case 'M':
                    limparTerminal();

                    System.out.println("[0] para sair.");
                    System.out.println("[ID] Qual item deseja marcar como concluído? ");

                    int respostaConcluido = input.nextInt();
                    if (respostaConcluido < 1) {
                        System.out.println("Índice inválido.");
                        break;
                    }

                    agenda.marcarConcluido(respostaConcluido);
                    limparTerminal();
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
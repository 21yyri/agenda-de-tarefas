package tarefas.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Agenda {
    private static final String filePath = "agenda/tarefas.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public static List<Tarefa> listarTarefas() {
        try {
            return mapper.readValue(new File(filePath), new TypeReference<List<Tarefa>>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public static void salvarTarefas(List<Tarefa> tarefas) {
        try {
            mapper.writeValue(new File(filePath), tarefas);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void adicionarTarefa(Tarefa tarefa) {

        List<Tarefa> tarefas = listarTarefas();
        System.out.println(tarefas.size());
        tarefa.setId(tarefas.size() + 1);
        tarefas.add(tarefa);

        salvarTarefas(tarefas);
    }

    public static void lerTarefas() {
        List<Tarefa> tarefas = listarTarefas();

        if (tarefas.size() == 0) {
            return;
        }
        
        for (Tarefa tarefa: tarefas) {
            if (tarefa.getDescricao() != null) {
                System.out.println(String.format("%d. %s - %s > %s", tarefa.getId(), tarefa.getTarefa(), tarefa.getDescricao(), tarefa.getFeito()? "feito" : "não feito"));
            } else {
                System.out.println(String.format("%d. %s > %s", tarefa.getId(), tarefa.getTarefa(), tarefa.getFeito()? "feito" : "não feito"));
            }
        }
    }
    public static void removerTarefa(int id) {
        List<Tarefa> tarefas = listarTarefas();
        if (id < 0 || id > tarefas.size()) {
            System.out.println("Índice inválido.");
            return;
        }
        
        ArrayList<Tarefa> novasTarefas = new ArrayList<Tarefa>();

        int counter = 1;
        for (Tarefa tarefa: tarefas) {
            if (tarefa.getId() != id) {
                tarefa.setId(counter);
                novasTarefas.add(tarefa);
                counter++;
            }
        }

        salvarTarefas(novasTarefas);
    }
    public static void atualizarTarefa(int id) {
        List<Tarefa> tarefas = listarTarefas();
        if (id <= 0 || id > tarefas.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        for (Tarefa tarefa: tarefas) {
            if (tarefa.getId() == id) {
                Scanner input = new Scanner(System.in);
                System.out.println("[Q] para manter.");
                System.out.println("Qual o novo nome da tarefa?  ");
                String respostaTarefa = input.nextLine();

                if (respostaTarefa.toLowerCase().charAt(0) != 'q') {
                    tarefa.setTarefa(respostaTarefa.trim());
                }

                System.out.println("[Q] para null.");
                System.out.println("Qual a nova descrição da tarefa? ");
                String respostaDesc = input.nextLine();

                if (respostaDesc.toLowerCase().charAt(0) != 'q') {
                    tarefa.setDescricao(respostaDesc.trim());
                } else {
                    tarefa.setDescricao(null);
                }
                
                salvarTarefas(tarefas);
            }
        }
    }
    public static void alterarEstado(int id) {
        List<Tarefa> tarefas = listarTarefas();

        lerTarefas();

        for (Tarefa tarefa: tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setFeito(!tarefa.getFeito());
                break;
            }
        }
        salvarTarefas(tarefas);
    }
}

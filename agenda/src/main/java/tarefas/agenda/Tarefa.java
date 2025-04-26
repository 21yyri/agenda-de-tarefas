package tarefas.agenda;

public class Tarefa {
    private int id;
    private String tarefa;
    private String descricao = null;
    private boolean feito = false;

    public Tarefa(String tarefa) {
        this.id = Agenda.listarTarefas().size() + 1;
        this.tarefa = tarefa;
        this.descricao = null;
    }

    public Tarefa(String tarefa, String descricao) {
        this.id = Agenda.listarTarefas().size() + 1;
        this.tarefa = tarefa;
        this.descricao = descricao;
    }
    public Tarefa() {}
    
    public void setId(int id) {
        this.id = id;
    }
    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setFeito(boolean feito) {
        this.feito = feito;
    }

    public String getTarefa() {
        return tarefa;
    }
    public String getDescricao() {
        return descricao;
    }
    public boolean getFeito() {
        return feito;
    }
    public int getId() {
        return id;
    }
}

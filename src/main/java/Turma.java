public class Turma {
    private Aluno[] alunos;
    private int qtdAlunos = 0;

    public Turma(int capacidade) {
        this.alunos = new Aluno[capacidade];
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (qtdAlunos >= alunos.length) {
            return false; // turma cheia
        }
        alunos[qtdAlunos] = aluno;
        qtdAlunos++;
        return true;
    }

    public void listarAprovados() {
        System.out.println("=== Aprovados ===");
        boolean achou = false;
        for (int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].isAprovado()) {
                System.out.println(alunos[i]);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum aluno aprovado.");
        }
    }

    public void listarReprovados() {
        System.out.println("=== Reprovados ===");
        boolean achou = false;
        for (int i = 0; i < qtdAlunos; i++) {
            if (!alunos[i].isAprovado()) {
                System.out.println(alunos[i]);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum aluno reprovado.");
        }
    }
}

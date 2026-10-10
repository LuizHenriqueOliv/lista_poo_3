public class Exercicio1 {
    public static void main(String[] args) {
        Turma turma = new Turma(5);

        Aluno a1 = new Aluno("Ana", "2024001");
        a1.cadastrarNota(8.0);
        a1.cadastrarNota(7.5);
        a1.cadastrarNota(9.0);
        a1.cadastrarNota(6.5);

        Aluno a2 = new Aluno("Bruno", "2024002");
        a2.cadastrarNota(5.0);
        a2.cadastrarNota(6.0);
        a2.cadastrarNota(4.5);
        a2.cadastrarNota(7.0);

        Aluno a3 = new Aluno("Carla", "2024003");
        a3.cadastrarNota(10.0);
        a3.cadastrarNota(9.5);
        a3.cadastrarNota(8.0);
        a3.cadastrarNota(7.0);

        // Testando o limite de 4 notas
        boolean ok = a3.cadastrarNota(5.0);
        System.out.println("Quinta nota cadastrada? " + ok);

        turma.adicionarAluno(a1);
        turma.adicionarAluno(a2);
        turma.adicionarAluno(a3);

        turma.listarAprovados();
        System.out.println();
        turma.listarReprovados();
    }
}

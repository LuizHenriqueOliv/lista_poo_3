public class Aluno {
    private static final int MAX_NOTAS = 4;

    private String nome;
    private String matricula;
    private double[] notas = new double[MAX_NOTAS];
    private int qtdNotas = 0;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    // Retorna false se já tiver 4 notas ou se a nota for inválida
    public boolean cadastrarNota(double nota) {
        if (qtdNotas >= MAX_NOTAS || nota < 0 || nota > 10) {
            return false;
        }
        notas[qtdNotas] = nota;
        qtdNotas++;
        return true;
    }

    public double calcularMedia() {
        if (qtdNotas == 0) {
            return 0.0;
        }
        double soma = 0;
        for (int i = 0; i < qtdNotas; i++) {
            soma += notas[i];
        }
        return soma / qtdNotas;
    }

    public boolean isAprovado() {
        return calcularMedia() >= 7.0;
    }

    @Override
    public String toString() {
        return String.format("%s (matrícula %s) - média: %.2f", nome, matricula, calcularMedia());
    }
}

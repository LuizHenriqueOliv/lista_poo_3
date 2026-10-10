import java.util.Arrays;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[6];
        int qtd = 0;

        while (qtd < 6) {
            System.out.print("Digite o número " + (qtd + 1) + " (1 a 60): ");
            int n = sc.nextInt();

            if (n < 1 || n > 60) {
                System.out.println("Número fora do intervalo! Digite entre 1 e 60.");
                continue;
            }

            if (jaExiste(numeros, qtd, n)) {
                System.out.println("Número repetido! Digite outro.");
                continue;
            }

            numeros[qtd] = n;
            qtd++;
        }

        Arrays.sort(numeros);
        System.out.println("Números em ordem crescente: " + Arrays.toString(numeros));
        sc.close();
    }

    // Procura o número apenas nas posições já preenchidas
    private static boolean jaExiste(int[] array, int qtd, int valor) {
        for (int i = 0; i < qtd; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }
}

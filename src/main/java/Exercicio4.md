# Exercício 4 – Array de primitivos vs. array de objetos

## Diferença principal

- **`int[]`, `double[]` (primitivos):** o array guarda diretamente os **valores**.
  Ex.: `int[] v = new int[3];` → `[0, 0, 0]`.
- **`Aluno[]`, `Produto[]` (objetos):** o array guarda **referências** (endereços) para objetos,
  não os objetos em si. Ex.: `Aluno[] a = new Aluno[3];` → `[null, null, null]`.

## a) Como a memória é alocada?

**Array de primitivos**
- O array em si é um objeto alocado no **heap**.
- Os valores ficam armazenados **dentro** do próprio array, de forma contígua.
- Ao criar, cada posição recebe o valor padrão (`0`, `0.0`, `false`...).
- A variável (`int[] v`) fica na pilha (stack) e guarda a referência ao array no heap.

**Array de objetos**
- O array também é alocado no **heap**, mas contém apenas **referências**.
- Ao criar com `new Aluno[3]`, nenhum objeto `Aluno` é criado: todas as posições são `null`.
- Cada objeto precisa ser criado separadamente (`a[0] = new Aluno(...)`) e ocupa
  seu próprio espaço no heap, em qualquer lugar da memória (não contíguo).
- Ou seja: são duas camadas (array de referências → objetos).

## b) Cuidados ao acessar elementos de um array de objetos

1. **`NullPointerException`:** posições não inicializadas são `null`. Chamar `a[0].getNome()`
   sem ter feito `a[0] = new Aluno(...)` lança exceção. Verifique `if (a[i] != null)`
   ou preencha antes de usar.
2. **`ArrayIndexOutOfBoundsException`:** assim como nos primitivos, acessar índice
   fora de `0` até `length - 1` gera erro.
3. **Cópia de referência (aliasing):** `b[0] = a[0]` copia a referência, não o objeto;
   alterar um afeta o outro. Para duplicar de verdade é preciso criar um novo objeto
   (ou implementar clonagem).
4. **Cópia do array:** `Arrays.copyOf` / `clone()` fazem cópia *rasa* (shallow): o novo array
   aponta para os mesmos objetos.
5. **Comparação:** `==` compara referências; para comparar o conteúdo use `equals()`.
6. **Percorrer só o que foi preenchido:** se o array tem posições vazias, controle a
   quantidade de elementos usados (como em `Turma`) para não cair em `null`.

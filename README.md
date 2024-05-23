# Projeto-Da-Faculdade

Equipe: 
    Luciano Sena Ribeiro,
    Caio,
    Allan Lucas De Jesus Nascimento,
    Lucas,
    Lucas,

# Documentação da Classe Principal

## Descrição

Essa é a classe principal do  nosso sistema de gerenciamento de pacientes. Ela contém o método `main` que inicializa o programa e apresenta o menu de opções ao usuário. O sistema permite cadastrar, listar e buscar pacientes através do atributo cpf.

## Atributos

- **pacientes**: `ArrayList<Paciente>` - Lista que armazena os Pacientes.

## Métodos

### `main`

Inicia o programa, apresenta o menu e executa as opções escolhidas pelo usuário.

### `exibirMenu`

Exibe o menu de opções para o usuário.

### `cadastrarPaciente`

Permite cadastrar um novo paciente.

- **Parâmetros**: 
  - `scanner`: `Scanner` - Scanner para leitura dos dados do paciente.

### `buscarPaciente`

Permite buscar um paciente pelo CPF.

- **Parâmetros**: 
  - `scanner`: `Scanner` - Scanner para leitura do CPF do paciente.

### `cadastrarObjetosIniciais`

Cadastra automaticamente 7 pacientes iniciais para os testes.

### `listarPacientes`

Lista os pacientes cadastrados exibindo nome, idade e CPF.

## Código

```java

// Importações necessárias para o funcionamento do projeto
package Projeto.Faculdade;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe Principal
 * 
 * Esta é a classe principal do sistema de gerenciamento de pacientes. Ela contém o método main
 * que inicializa o programa e apresenta o menu de opções ao usuário. O sistema permite cadastrar,
 * listar e buscar pacientes.
 * 
 * Atributos:
 * - pacientes: ArrayList<Paciente> - lista que armazena os objetos Paciente
 * 
 * Métodos:
 * - main: inicializa o programa, apresenta o menu e executa as opções escolhidas pelo usuário
 * - exibirMenu: exibe o menu de opções para o usuário
 * - cadastrarPaciente: permite cadastrar um novo paciente
 * - buscarPaciente: permite buscar um paciente pelo CPF e exibir seus detalhes
 * - cadastrarObjetosIniciais: cadastra automaticamente pacientes iniciais para testes
 * - listarPacientes: lista os pacientes cadastrados exibindo nome, idade e CPF
 * 
 * Autor: Luciano
 */
public class Principal {
    
    // Criação da lista que armazena os objetos Paciente
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    /**
     * Método principal que inicializa o programa e apresenta o menu de opções ao usuário
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcao;
        cadastrarObjetosIniciais(); // Cadastra automaticamente pacientes iniciais
         
        // Laço de repetição, o laço do while vai fazer pelo menos uma execução e só depois ele vai verificar a condição
        do { 
            exibirMenu(); // Exibe o menu
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            // O switch case vai executar a funcionalidade escolhida pelo usuário no menu
            switch(opcao){
                case 1: {
                    cadastrarPaciente(scanner);
                    break;
                }
                case 2: {
                    listarPacientes();
                    break;
                }
                case 3: {
                    buscarPaciente(scanner);
                    break;
                }
                case 4: {
                    System.out.println("Operação encerrada");
                    break;
                }
                default: {
                    System.out.println("Opção inválida");
                }
        }   
        } while(opcao != 4);
    }

    /**
     * Método para exibir o menu de opções para o usuário
     */
    public static void exibirMenu(){
        System.out.println("Sistema de Gerenciamento de Pacientes");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastrar Paciente");
        System.out.println("2. Listar Pacientes");
        System.out.println("3. Buscar Paciente por CPF");
        System.out.println("4. Sair");    
    }
   
    /**
     * Método para cadastrar um novo paciente
     * 
     * @param scanner Scanner para leitura dos dados do paciente
     */
    public static void cadastrarPaciente(Scanner scanner){
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Sintomas: ");
        String sintomas = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        
        // Cria um novo objeto Paciente e adiciona à lista de pacientes
        Paciente paciente = new Paciente(nome, telefone, sintomas, cpf, idade);
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }
   
    /**
     * Método para buscar um paciente pelo CPF
     * 
     * @param scanner Scanner para leitura do CPF do paciente
     */
    public static void buscarPaciente(Scanner scanner){
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        
        // Busca o paciente na lista pelo CPF
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                System.out.println("Paciente encontrado:");
                System.out.println("Nome: " + paciente.getNome());
                System.out.println("Telefone: " + paciente.getTelefone());
                System.out.println("Sintomas: " + paciente.getSintomas());
                System.out.println("CPF: " + paciente.getCpf());
                System.out.println("Idade: " + paciente.getIdade());
                return;
            }
        }
        System.out.println("Paciente não encontrado");
    }
   
    /**
     * Método para cadastrar automaticamente pacientes iniciais
     */
    private static void cadastrarObjetosIniciais() {
        pacientes.add(new Paciente("Joao Silva", "123456789", "Dor de cabeça", "11111111111", 30));
        pacientes.add(new Paciente("Maria Souza", "987654321", "Febre", "22222222222", 25));
        pacientes.add(new Paciente("Pedro Santos", "555555555", "Tosse", "33333333333", 40));
        pacientes.add(new Paciente("Ana Lima", "444444444", "Dor de barriga", "44444444444", 20));
        pacientes.add(new Paciente("Paulo Costa", "333333333", "Cansaço", "55555555555", 50));
        pacientes.add(new Paciente("Carla Rocha", "222222222", "Dificuldade de respirar", "66666666666", 35));
        pacientes.add(new Paciente("Bruno Almeida", "111111111", "Dores no corpo", "77777777777", 45));
    }
   
    /**
     * Método para listar os pacientes cadastrados
     */
    public static void listarPacientes(){
        // Exibe os detalhes de cada paciente
        for(Paciente paciente : pacientes){
            System.out.println("Nome do paciente: " + paciente.getNome() + 
                               "       Idade do Paciente: " + paciente.getIdade() + 
                               "       CPF do paciente: " + paciente.getCpf());
        }
    }
}


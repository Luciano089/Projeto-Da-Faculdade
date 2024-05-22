/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Importações necessárias para o funcionamento do projeto
package Projeto.Faculdade;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Luciano
 */
public class Principal {
    
    private static ArrayList<Paciente> pacientes = new ArrayList<>(); // Criação do array List
    public static void main(String[] args){
    
        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        cadastrarObjetosIniciais(); // cadastrando os objetos inicianos
         
        
        do { // Laço de repetição, o laço do while vai fazer pelo menos uma execução e só depois ele vai verificar a condição
           
            exibirMenu(); // exibindo o menu
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            // O Switch case vai dar a funcionalidade que o usuario escolheu quando o menu foi mostrado
            switch(opcao){
                case 1: {
                    cadastrarPaciente(scanner);
                    break;
                }
                case 2: {
                    ListarPacientes();
                    break;
                }
                
                case 3: {;
                    buscarPaciente(scanner);
                    break;
                }
                
                case 4: {
                    System.out.println("Operação encerrada");
                    break;
                }
                
                default: {
                    System.out.println("Opção invalida");
                }
                
        }
                    
        } while(opcao != 4);
        
    };
    
    // Função de exibir menu
   public static void exibirMenu(){
        System.out.print("Escolha uma opção: ");
        System.out.println("Sistema de Gerenciamento de Pacientes");
        System.out.println("1. Cadastrar Paciente");
        System.out.println("2. Listar Pacientes");
        System.out.println("3. Buscar Paciente por CPF");
        System.out.println("4. Sair");    
   }
   
   // essa função pede os dados do paciente ao usuario e cadastra, paciente e adiciona no array 'paciente' que foi declarada na linha 17
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
        
        Paciente paciente = new Paciente(nome, telefone, sintomas, cpf, idade);
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
   }
   
   // essa função vai buscar um paciente pelo atributo cpf
   public static void buscarPaciente(Scanner scanner){
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        
        
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                System.out.println("Paciente encontrado:");
                System.out.println("Nome: " + paciente.getNome());
                System.out.println("Telefone: " + paciente.getTelefone());
                System.out.println("Sintomas: " + paciente.getSintomas());
                System.out.println("CPF: " + paciente.getCpf());
                System.out.println("Idade: " + paciente.getIdade());
                break;
            } else {
                System.out.println("Paciente não encontrado");
            }
        } 
        
    }
   
   // essa função cadastra os objetos iniciais
   private static void cadastrarObjetosIniciais() {
        pacientes.add(new Paciente("Joao Silva", "123456789", "Dor de cabeça", "11111111111", 30));
        pacientes.add(new Paciente("Maria Souza", "987654321", "Febre", "22222222222", 25));
        pacientes.add(new Paciente("Pedro Santos", "555555555", "Tosse", "33333333333", 40));
        pacientes.add(new Paciente("Ana Lima", "444444444", "Dor de barriga", "44444444444", 20));
        pacientes.add(new Paciente("Paulo Costa", "333333333", "Cansaço", "55555555555", 50));
        pacientes.add(new Paciente("Carla Rocha", "222222222", "Dificuldade de respirar", "66666666666", 35));
        pacientes.add(new Paciente("Bruno Almeida", "111111111", "Dores no corpo", "77777777777", 45));
    }
   
   // essa função está listando os pacientes
   public static void ListarPacientes(){
       for(Paciente paciente : pacientes){
         System.out.println("Nome do paciente: " + paciente.getNome() + "       Idade do Paciente: " + paciente.getIdade() + "       Cpf do paciente: " + paciente.getCpf());
       }
   };
   
}

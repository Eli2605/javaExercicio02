package principal;

import java.util.Scanner;

import controllers.AlunoController;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n Sistema de controle de Alunos:\n");

		System.out.println("(1) Cadastrar Aluno");
		System.out.println("(2) Alterar Aluno");
		System.out.println("(3) Excluir Aluno");
		System.out.println("(4) Consultar Aluno");

		System.out.println("\nInforme a opçao desejada:");
		var opcao = scanner.nextLine();

		var alunoController = new AlunoController();

		switch (opcao) {
		case "1":
			alunoController.cadastrarAluno();
			break;
		case "2":
			alunoController.alterarAluno();
			break;
		case "3":
			alunoController.excluirAluno();
			break;
		case "4":
			alunoController.consultarAluno();
			break;
		}
		
		System.out.println("\nDESEJA CONTINUAR? (S,N):");
		var continuar = scanner.nextLine();
		
		if(continuar.equalsIgnoreCase("S")){
			
			main(args);
			
		}
		else {
			System.out.println("\nFim do Programa!");
		}

	}

}

package controllers;

import java.util.Scanner;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {

	private Scanner scanner = new Scanner(System.in);

	public void cadastrarAluno() {

		try {

			System.out.println("\nCADASTRO DE ALUNO:\n");

			System.out.println("ID do Aluno..........:");
			var id = Integer.parseInt(scanner.nextLine());

			System.out.println("NOME DO ALUNO.......:");
			var nome = scanner.nextLine();

			System.out.println("MATRICULA...........:");
			var matricula = scanner.nextLine();

			System.out.println("CPF.................:");
			var cpf = scanner.nextLine();

			var aluno = new Aluno(id, nome, matricula, cpf);

			var alunoRepository = new AlunoRepository();
			alunoRepository.inserir(aluno);

		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar o aluno!");
			System.out.println(e.getMessage());

		}
	}

	public void alterarAluno() {

		try {

			System.out.println("Alterar Aluno:\n");

			System.out.println("Informe o Id do Aluno.:");
			var id = Integer.parseInt(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorId(id);

			if (aluno != null) {

				System.out.println("\nDados do Aluno:");
				System.out.println("ID...........:" + aluno.getId());
				System.out.println("NOME.........:" + aluno.getNome());
				System.out.println("MATRICULA....:" + aluno.getMatricula());
				System.out.println("CPF..........:" + aluno.getCpf());

				System.out.println("");

				//System.out.println("ID do Aluno..........:");
				//aluno.setId(Integer.parseInt(scanner.nextLine()));
				System.out.println("ALTERE o NOME.....:");
				aluno.setNome(scanner.nextLine());
				System.out.println("ALTERE a MATRICULA:");
				aluno.setMatricula(scanner.nextLine());
				System.out.println("ALTERE o CPF......:");
				aluno.setCpf(scanner.nextLine());

				alunoRepository.alterar(aluno);
				
			} else {
				System.out.println("\nAluno não encontrado. Verifique o ID informado.");
			}

		} catch (Exception e) {
			System.out.println("\nFalha ao alterar Aluno!");
			System.out.println(e.getMessage());

		}

	}

	public void excluirAluno() {

		try {

			System.out.println("Excluir Aluno:\n");

			System.out.println("Informe o Id do Aluno.:");
			var id = Integer.parseInt(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorId(id);

			if (aluno != null) {

				System.out.println("\nDados do Aluno:");
				System.out.println("ID...........:" + aluno.getId());
				System.out.println("NOME.........:" + aluno.getNome());
				System.out.println("MATRICULA....:" + aluno.getMatricula());
				System.out.println("CPF..........:" + aluno.getCpf());

				System.out.println("");

				alunoRepository.excluir(aluno.getId());
				
				
			} else {
				
				System.out.println("\nAluno não encontrado. Verifique o ID informado.");
			}

		} catch (Exception e) {
			System.out.println("\nFalha ao excluir Aluno!");
			System.out.println(e.getMessage());

		}

	}

	public void consultarAluno() {

		try {

			System.out.println("Consultar Alunos:\n");

			//System.out.println("Digite o ID do Aluno:");
			//var id = Integer.parseInt(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var lista = alunoRepository.consultar();

			for (Aluno aluno : lista) { // foreach (para cada item,leia....)

				System.out.println("\nDados do Aluno:");
				System.out.println("ID...........:" + aluno.getId());
				System.out.println("NOME.........:" + aluno.getNome());
				System.out.println("MATRICULA....:" + aluno.getMatricula());
				System.out.println("CPF..........:" + aluno.getCpf());

				System.out.println("");

			}

		} catch (Exception e) {
			System.out.println("\nFalha ao consultar Aluno!");
			System.out.println(e.getMessage());

		}

	}

}

package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	public void inserir(Aluno aluno) {

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection
					.prepareStatement("INSERT INTO tb_aluno(id, nome, matricula, cpf) VALUES( ?, ?, ?, ?)");

			statement.setInt(1, aluno.getId());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getMatricula());
			statement.setString(4, aluno.getCpf());
			statement.execute();

			connection.close();

			System.out.println("\nAluno Cadastrado com Sucesso!");
		} catch (Exception e) {
			System.out.println("\nFallha ao Inserir Aluno.");
			System.out.println(e.getMessage());

		}
	}

	public void alterar(Aluno aluno) {

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection.prepareStatement("UPDATE tb_aluno SET nome=?, matricula=?, cpf=? WHERE id=?");

			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getMatricula());
			statement.setString(3, aluno.getCpf());
			statement.setInt(4, aluno.getId());
			statement.execute();

			connection.close();

			System.out.println("\nAluno Alterado com Sucesso!");
			
		} catch (Exception e) {
			System.out.println("\nFallha ao Alterar Aluno.");
			System.out.println(e.getMessage());

		}
	}

	public void excluir(Integer id) {

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection.prepareStatement("DELETE FROM tb_aluno WHERE id=?");

			statement.setInt(1, id);

			statement.execute();

			connection.close();

			System.out.println("\nAluno Excluir com Sucesso!");
		} catch (Exception e) {
			System.out.println("\nFallha ao Excluir Aluno.");
			System.out.println(e.getMessage());

		}
	}

	public List<Aluno> consultar() {

		var lista = new ArrayList<Aluno>();

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection.prepareStatement("SELECT  id, nome, matricula, cpf FROM tb_aluno ORDER BY nome");

			var result = statement.executeQuery();

			while (result.next()) {

				var aluno = new Aluno();
				aluno.setId(Integer.parseInt(result.getString("id")));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));

				lista.add(aluno);

			}

			connection.close();

		} catch (Exception e) {
			System.out.println("\nFallha ao Consultar Aluno.");
			System.out.println(e.getMessage());

		}

		return lista;
	}
	
	public Aluno obterPorId(Integer id) {
	    
	    Aluno aluno = null;
	    
	    try (var connection = ConnectionFactory.getConnection();
	         var statement = connection.prepareStatement("SELECT id, nome, matricula, cpf FROM tb_aluno WHERE id=?")) {

	        // Define o ID no statement
	        statement.setInt(1, id);

	        // Executa a consulta
	        var result = statement.executeQuery();

	        // Verifica se algum registro foi encontrado
	        if (result.next()) {
	            aluno = new Aluno();
	            
	            // Popula o objeto aluno com os dados retornados pelo banco
	            aluno.setId(result.getInt("id"));
	            aluno.setNome(result.getString("nome"));
	            aluno.setMatricula(result.getString("matricula"));
	            aluno.setCpf(result.getString("cpf"));
	        }

	    } catch (Exception e) {
	        System.out.println("\nFalha ao consultar aluno por ID");
	        System.out.println(e.getMessage());
	    }
	    
	    return aluno;
	}
}

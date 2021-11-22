import java.sql.ResultSet;
import java.util.ArrayList;

public class Repositorio {
	
	private BDados banco;
	
	public Repositorio(BDados banco) {
		this.banco = banco;
	}
	
	public void cadastrar(Medico medico){
		
		String query = "INSERT INTO " 
				
				+ "cadastro "
				+ "(nome, idade, especializacao, hospital, crm) "
				+ "VALUES "
				+ "('" + medico.getNome() + "', "
			    + "'" + medico.getIdade() + "', "
			    + "'" + medico.getEspecializacao() + "', "
			    + "'" + medico.getHospital() + "', "
			    + "'" + medico.getCrm() + "'); ";
			
		this.banco.executeUpdate(query);
				
	}
	
	public Medico selecionar(int id) {
		String query = "SELECT * FROM cadastro WHERE id = " + id +";";
		ResultSet dados = this.banco.executeQuery(query);
		
		Medico medico = new Medico();
		
		try {
			dados.next();
			medico.setId(dados.getInt("id"));
			medico.setNome(dados.getString("nome"));
			medico.setIdade(dados.getString("idade"));
			medico.setEspecializacao(dados.getString("especializacao"));
			medico.setHospital(dados.getString("hospital"));
			medico.setCrm(dados.getString("crm"));
		} catch(Exception e){
			System.err.println(e.getMessage());
		}
		return medico;
	}
	
	public ArrayList<Medico> listar() {
		String query = "SELECT * FROM cadastro;";
		ResultSet dados = this.banco.executeQuery(query);
		ArrayList<Medico> medicos = new ArrayList<> ();
		
		try {
			while(dados.next()) {
				Medico medico = new Medico();
				medico.setId(dados.getInt("id"));
				medico.setNome(dados.getString("nome"));
				medico.setIdade(dados.getString("idade"));
				medico.setEspecializacao(dados.getString("especializacao"));
				medico.setHospital(dados.getString("hospital"));
				medico.setCrm(dados.getString("crm"));
				medicos.add(medico);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return medicos;
	}
	
	public void excluir(int id) {
		String query = "DELETE FROM cadastro WHERE id = " + id + ";";
		this.banco.executeUpdate(query);
	}
	
	public void editar(Medico medico) {
		String query = "UPDATE cadastro SET "
				+ "nome = '" + medico.getNome() + "',"
				+ "idade = '" + medico.getIdade() + "',"
				+ "especializacao = '" + medico.getEspecializacao() + "',"
				+ "hospital = '" + medico.getHospital() + "',"
				+ "crm = '" + medico.getCrm() + "'"
				+ "WHERE id = " + medico.getId() + ";";
		this.banco.executeUpdate(query);
				
	}
}
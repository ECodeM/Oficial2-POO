/*Uni�o Metropolitana de Educa��o e Cultura
Disciplina- Programa��o Orientada a Objetos 2
Professor - Pablo Roxo
Aluno - Emanuel Medeiros da Cunha
*/

public class Hospital {
	
	public static void main(String[] args) {
		
		BDados banco = new BDados();
		banco.conectar();
		
		
		Repositorio medicoRepo = new Repositorio(banco);
		
		TelaLista telaLista = new TelaLista(medicoRepo);
		telaLista.setVisible(true);
	
	}

	

}

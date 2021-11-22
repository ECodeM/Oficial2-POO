
public class Hospital {
	
	public static void main(String[] args) {
		
		BDados banco = new BDados();
		banco.conectar();
		
		
		Repositorio medicoRepo = new Repositorio(banco);
		
		TelaLista telaLista = new TelaLista(medicoRepo);
		telaLista.setVisible(true);
	
	}

	

}

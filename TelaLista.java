import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class TelaLista extends JFrame {

	private JPanel contentPane;
	private Repositorio medicoRepo;
	private JTable table;

	public TelaLista(Repositorio medicoRepo) {
		this.medicoRepo = medicoRepo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 361);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBackground(SystemColor.controlShadow);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCadastro = new TelaCadastro(medicoRepo);
				
				telaCadastro.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						listarMedicos();
					}
				});
				telaCadastro.setVisible(true);
				
			}
		});
		btnCadastro.setBounds(555, 32, 106, 36);
		contentPane.add(btnCadastro);
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(SystemColor.controlShadow);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int i = table.getSelectedRow();
						if(i >=0) {
							
							int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
							TelaEditar telaEdicao = new TelaEditar(medicoRepo, id);
							telaEdicao.addWindowListener(new WindowAdapter() {
								@Override
								public void windowClosed(WindowEvent e) {
									listarMedicos();
								}
							});
							telaEdicao.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Selecione");
						}

						
					}
				});
			}
		});
		btnEditar.setBounds(555, 79, 106, 36);
		contentPane.add(btnEditar);
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(SystemColor.controlShadow);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				if(i >= 0) {
					
					if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
						
						
						int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
						medicoRepo.excluir(id);
						listarMedicos();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Primeiro selecione");
				}
				
			}
		});
		btnExcluir.setBounds(555, 126, 106, 36);
		contentPane.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.desktop);
		scrollPane.setBounds(10, 0, 542, 322);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Idade", "Especialização", "Hospital", "CRM"
			}
			
		));
		scrollPane.setViewportView(table);
		
		this.listarMedicos();

		
	}
	

		
		public void listarMedicos () {
			
			ArrayList <Medico> medicos = this.medicoRepo.listar();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for(Medico medico : medicos) {
				model.addRow(new Object[] {
						medico.getId(), 
						medico.getNome(), 
						medico.getIdade(), 
						medico.getEspecializacao(), 
						medico.getHospital(), 
						medico.getCrm()
						
				});
			}
		
		
		
	}
}

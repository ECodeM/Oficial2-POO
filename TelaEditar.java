import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditar extends JFrame {

	private JPanel contentPane;
	private Repositorio medicoRepo;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField textEspec;
	private JTextField textHosp;
	private JTextField textCrm;
	private int id;
	private Medico medico;

	
	

		public TelaEditar(Repositorio medicoRepo, int id) {
		this.medicoRepo = medicoRepo;
		this.id = id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditar = new JLabel("Editar");
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setBounds(10, 11, 308, 20);
		contentPane.add(lblEditar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 69, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdade.setBounds(10, 93, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblEspecializacao = new JLabel("Especializa\u00E7\u00E3o:");
		lblEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecializacao.setBounds(10, 120, 88, 14);
		contentPane.add(lblEspecializacao);
		
		JLabel lblHospital = new JLabel("Hospital:");
		lblHospital.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHospital.setBounds(10, 145, 46, 14);
		contentPane.add(lblHospital);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCrm.setBounds(10, 170, 46, 14);
		contentPane.add(lblCrm);
		
		textNome = new JTextField();
		textNome.setBounds(93, 67, 177, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setBounds(93, 91, 177, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		textEspec = new JTextField();
		textEspec.setBounds(93, 118, 177, 20);
		contentPane.add(textEspec);
		textEspec.setColumns(10);
		
		textHosp = new JTextField();
		textHosp.setBounds(93, 143, 177, 20);
		contentPane.add(textHosp);
		textHosp.setColumns(10);
		
		textCrm = new JTextField();
		textCrm.setBounds(93, 168, 177, 20);
		contentPane.add(textCrm);
		textCrm.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				medico.setNome(textNome.getText());
				medico.setIdade(textIdade.getText());
				medico.setEspecializacao(textEspec.getText());
				medico.setHospital(textHosp.getText());
				medico.setCrm(textCrm.getText());	
				
				if(textNome.getText()== null || textNome.getText().isEmpty()||
						(textIdade.getText()== null || textIdade.getText().isEmpty()) ||
						(textEspec.getText()== null || textEspec.getText().isEmpty()) ||
						(textHosp.getText()== null || textHosp.getText().isEmpty()) ||
					    (textCrm.getText()== null || textCrm.getText().isEmpty())
						
						) {
					JOptionPane.showMessageDialog(btnEditar, "Todos os campos devem ser preenchidos");
				} else {
					medicoRepo.editar(medico);
					JOptionPane.showMessageDialog(btnEditar, "Edição realizada com sucesso");

				}
				
			    dispose();
				
			}
		});
		btnEditar.setBounds(74, 199, 101, 23);
		contentPane.add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText("");
				textIdade.setText("");
				textEspec.setText("");
				textHosp.setText("");
				textCrm.setText("");
			}
		});
		btnLimpar.setBounds(185, 199, 101, 23);
		contentPane.add(btnLimpar);
		
		this.medico = this.medicoRepo.selecionar(id);
		
		textNome.setText(medico.getNome());
		textIdade.setText(medico.getIdade());
		textEspec.setText(medico.getEspecializacao());
		textHosp.setText(medico.getHospital());
		textCrm.setText(medico.getCrm());
	}
}

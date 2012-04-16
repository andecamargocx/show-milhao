package pckClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pckCommon.Pergunta;

public class OLD_frmClient extends JFrame {
	
	ImageIcon imgPrincipal;
	JPanel pnlNorth;
	JPanel pnlCenter;
	JPanel pnlSouth;
	JPanel pnlToolbar;
	JPanel pnlPergunta;
	
	JButton btnResponde;
	JButton btnPula;
	
	JLabel lblMsg;
	JTextArea texPergunta;

	public OLD_frmClient(){
		ajustaFrame(); //configura layout, posi��o, caption e etc...
		criaObjetos(); //cria objetos que ser�o utilizados
		montaFrame();  //monta o frame, colocando os objetos em seus devidos lugares
		this.setVisible(true);
	}
	
	private void criaObjetos(){
		imgPrincipal = new ImageIcon("Resources/img/1000.jpg");
		pnlNorth   = new JPanel(new GridLayout(3,0));
		pnlCenter  = new JPanel(new GridLayout(4,0));
		pnlSouth   = new JPanel();
		pnlToolbar = new JPanel(new GridLayout(0,4));//vai ficar dentro do pnlNorth
		((GridLayout)pnlToolbar.getLayout()).setHgap(1); //margem horizontal entre objetos	
		pnlPergunta = new JPanel();
		pnlPergunta.setBounds(0, 0, 600, 200);
		
		btnResponde = new JButton("Responder");
		btnPula = new JButton("Pular");
		btnPula.setEnabled(false);
		
		lblMsg = new JLabel("Ol�! O Jogo est� iniciando! BOA SORTE!!!!");
		
		texPergunta = new JTextArea();
		texPergunta.setText("OLA");
		texPergunta.setForeground(Color.BLUE);
		texPergunta.setEditable(false);		
	}
	
	private void ajustaFrame(){
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 600, 400);
		this.setTitle("Show do Milh�o - Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
		this.setResizable(false);		
	}
	
	private void montaFrame(){
		pnlToolbar.add(btnResponde);
		pnlToolbar.add(btnPula);
		pnlToolbar.add(new JPanel());
		pnlToolbar.add(new JPanel());		
		//pnlPergunta.add(texPerunta);
		texPergunta.setBounds(0, 0, 600, 500);
		
		pnlNorth.add(lblMsg);
		JScrollPane scroll = new JScrollPane(texPergunta);
		//scroll.setBounds(0, 0, 600, 600);
		//scroll.setAutoscrolls(true);
		scroll.setAutoscrolls(false);
		pnlNorth.add(scroll);
		pnlNorth.add(pnlToolbar);
		
		pnlCenter.add(new JRadioButton("O��o A"));
		pnlCenter.add(new JRadioButton("O��o B"));
		pnlCenter.add(new JRadioButton("O��o C"));
		pnlCenter.add(new JRadioButton("O��o D"));
		
		imgPrincipal.getIconHeight();
		JLabel pnl = new JLabel(imgPrincipal);
		pnl.setBounds(0,0,20,30);
		this.add(pnlNorth, BorderLayout.NORTH);		
		this.add(pnl, BorderLayout.WEST); //para os radiobuttons n�o ficarem colados a esquerda
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void setEventosObjetos(){
		
		
	}
	
	private void limpaFrame(){
		this.lblMsg.setText("");
		this.texPergunta.setText("");
	}

	private void loadPergunta(Pergunta pergunta){
		lblMsg.setText(pergunta.getMensagem());
		texPergunta.setText(pergunta.getDescricao());
	}
	
	public static void main(String args[]){
		JFrame.setDefaultLookAndFeelDecorated(true);
		OLD_frmClient frm = new OLD_frmClient();		
	}

}

package es.studium.practicaTema1;

import java.awt.Color;
import java.awt.TextArea;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class vistaPracticaTema1 extends JFrame{

	private static final long serialVersionUID = 1L;
	JFrame frame;
	private JButton btnBloc;
	private JButton btnPaint;
	private JButton btnJuego;
	private  JButton btnPractica;
	private JTextField txComandos;
	private TextArea textAreaCmd;
	private JLabel lblCmd;
	private JButton btnEliminar;
	private  JLabel LblProcesosEjecucion;
	DefaultListModel<String> modeloLista = new DefaultListModel<String>();

	private JButton btnEjecutarCmd;
	private JList<String> listProcesos = new JList<String>();

	public vistaPracticaTema1() {
		setBounds(100, 100, 429, 688);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnBloc = new JButton("BLOC DE NOTAS");
		btnBloc.setBounds(10, 11, 141, 48);
		getContentPane().add(btnBloc);

		btnPaint = new JButton("PAINT");
		btnPaint.setBounds(10, 70, 141, 48);
		getContentPane().add(btnPaint);

		btnPractica = new JButton("CRUD");
		btnPractica.setBounds(10, 133, 141, 48);
		getContentPane().add(btnPractica);

		btnJuego = new JButton("JUEGO");
		btnJuego.setBounds(10, 192, 141, 48);
		getContentPane().add(btnJuego);

		LblProcesosEjecucion = new JLabel("LISTA DE PROCESOS");
		LblProcesosEjecucion.setFont(new Font("Arial Black", Font.PLAIN, 11));
		LblProcesosEjecucion.setBounds(225, 0, 189, 31);
		getContentPane().add(LblProcesosEjecucion);

		btnEliminar = new JButton("ELIMINAR PROCESO");
		btnEliminar.setBounds(259, 242, 154, 23);
		btnEliminar.setEnabled(true);
		getContentPane().add(btnEliminar);

		txComandos = new JTextField();
		txComandos.setBounds(10, 318, 245, 20);
		getContentPane().add(txComandos);
		txComandos.setColumns(10);

		lblCmd = new JLabel("INTRODUZCA UN COMANDO PARA EJECUTAR EN EL CMD");
		lblCmd.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblCmd.setBounds(24, 276, 364, 31);
		getContentPane().add(lblCmd);

		textAreaCmd = new TextArea();
		textAreaCmd.setForeground(Color.GREEN);
		textAreaCmd.setBackground(Color.BLACK);
		textAreaCmd.setBounds(0, 349, 414, 298);
		getContentPane().add(textAreaCmd);
		listProcesos.setBounds(171, 26, 243, 213);
		getContentPane().add(listProcesos);		
		listProcesos.setBorder(new LineBorder(Color.GREEN));
		listProcesos.setModel(modeloLista);
		listProcesos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		btnEjecutarCmd = new JButton("Ejecutar");
		btnEjecutarCmd.setBounds(265, 317, 149, 23);
		getContentPane().add(btnEjecutarCmd);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public JButton getBtnBloc() {
		return btnBloc;
	}
	public JButton getBtnPaint() {
		return btnPaint;
	}
	public JButton getBtnJuego() {
		return btnJuego;
	}
	public JButton getBtnPractica() {
		return btnPractica;
	}
	public TextArea getTextAreaCmd() {
		return textAreaCmd;
	}
	public JLabel getLblCmd() {
		return lblCmd;
	}
	public JTextField getTxComandos() {
		return txComandos;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public JLabel getLblProcesosEjecucion() {
		return LblProcesosEjecucion;
	}
	public JFrame getFrame() {
		return frame;
	}
	public JList<String> getListProcesos() {
		return listProcesos;
	}
	public JButton getBtnEjecutarCmd() {
		return btnEjecutarCmd;
	}
	public DefaultListModel<String> getModeloLista()
	{
		return modeloLista;
	}
}

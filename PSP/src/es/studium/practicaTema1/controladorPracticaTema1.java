package es.studium.practicaTema1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.xml.ws.Service.Mode;

public class controladorPracticaTema1 implements ActionListener,WindowListener {
	modeloPracticaTema1 modelo = null;
	vistaPracticaTema1 vista = null;

	public controladorPracticaTema1 (modeloPracticaTema1 modelo, vistaPracticaTema1 vista)
	{
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtnBloc().addActionListener(this);		
		this.vista.getBtnEliminar().addActionListener(this);
		this.vista.getBtnJuego().addActionListener(this);
		this.vista.getBtnPaint().addActionListener(this);
		this.vista.getBtnPractica().addActionListener(this);
		this.vista.getBtnEjecutarCmd().addActionListener(this);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();

		if (a.equals(vista.getBtnBloc()))
		{
			modelo.ejecutarProceso("notepad", vista.getBtnBloc(), vista.getModeloLista());
			modelo.processBloc = modelo.p;
		}
		else if (a.equals(vista.getBtnPaint()))
		{
			modelo.ejecutarProceso("mspaint", vista.getBtnPaint(), vista.getModeloLista());
			modelo.processPaint = modelo.p;
		}
		else if (a.equals(vista.getBtnJuego()))
		{
			modelo.ejecutarProceso("java -jar juegoAhorcado_JAR.jar",vista.getBtnJuego(), vista.getModeloLista());
			modelo.processJuego = modelo.p;
		}
		else if (a.equals(vista.getBtnPractica()))
		{
			modelo.ejecutarProceso("java -jar programaDeGestion_JAR.jar",vista.getBtnPractica(), vista.getModeloLista());
			modelo.processCrud = modelo.p;
		}
		else if (a.equals(vista.getBtnEliminar()))
		{
			if (vista.getListProcesos().getSelectedValue() == null)
			{
				JOptionPane.showMessageDialog(vista, "Por favor, seleccione un proceso.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				modelo.finalizarProceso(vista.getListProcesos(), modelo.p, vista.getBtnBloc(), vista.getBtnPaint(), vista.getBtnPractica(), vista.getBtnJuego());
				vista.modeloLista.remove(vista.getListProcesos().getSelectedIndex());
			}	
		}
		else if (a.equals(vista.getBtnEjecutarCmd()))
		{
			modelo.ejecutarCmd(vista.getTxComandos().getText(), vista.getTextAreaCmd());
			vista.getTxComandos().setText("");

		}
	}
}

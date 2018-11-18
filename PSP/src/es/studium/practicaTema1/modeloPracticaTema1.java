package es.studium.practicaTema1;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class modeloPracticaTema1 {
	Runtime rt;
	Process p;
	Process processBloc;
	Process processPaint;
	Process processJuego;
	Process processCrud;
	public void ejecutarProceso (String n, JButton btn, DefaultListModel<String> jl)
	{
		btn.setEnabled(false);
		rt = Runtime.getRuntime();
		try {
			p = rt.exec(n);
			jl.addElement(n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void finalizarProceso (JList<String> jl, Process p1, JButton btnBloc, JButton btnPaint, JButton btnCrud, JButton btnJuego)
	{ 
		String n=jl.getSelectedValue();	
		if (n == "notepad")
		{
			processBloc.destroy();
			btnBloc.setEnabled(true);
		}
		else if (n == "mspaint")
		{
			processPaint.destroy();
			btnPaint.setEnabled(true);
		}
		else if (n =="java -jar juegoAhorcado_JAR.jar")
		{
			processJuego.destroy();
			btnJuego.setEnabled(true);
		}
		else if (n== "java -jar programaDeGestion_JAR.jar")
		{
			processCrud.destroy();
			btnCrud.setEnabled(true);
		}
	}
	public void ejecutarCmd (String comando, TextArea jta)
	{
		try {
			p = Runtime.getRuntime().exec("cmd /C"+comando);
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String res="" ;
			String test;
			while ((test=in.readLine()) != null) {
				res+=test+"\n";
			}
			jta.setText(res);
			if (res=="")
			{
				jta.setText("Introduce un comando válido");
			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
package es.studium.practicaTema1;

public class inicio {

	public static void main(String[] args) {
		modeloPracticaTema1 modelo = new modeloPracticaTema1();
		vistaPracticaTema1 vista = new vistaPracticaTema1();
		new controladorPracticaTema1(modelo, vista);

	}

}

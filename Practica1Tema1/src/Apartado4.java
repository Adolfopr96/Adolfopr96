import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class Apartado4 {
	static DocumentBuilderFactory factory;
	static DocumentBuilder builder;
	static Document doc;
	static Node nodenAlumno;
	static Node nodenAlumnoText;
	static Node nodeapAlumno;
	static Node nodeapAlumnoText;
	static Node nodeAlumno;
	static Node nodeRaiz;
	static String nombre="";
	static String apellido="";
	static String fin="FIN";

	public static int añadirDom(Document d) {

		Scanner entradaEscaner = new Scanner (System.in);
		try
		{
			factory=DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			d = builder.parse(new File("alumno.xml"));	//Inicializamos el documento para parsearlo a .xml
			System.out.println ("Por favor introduzca su nombre o FIN para finalizar.");
			nombre = entradaEscaner.nextLine ();
			if(nombre.equals(fin))//Si el nombre es igual a fin("FIN")
			{
				System.out.println("El programa se ha cerrado correctamente.");
				System.exit(0);//se cierra el programa
			}
			else
			{
				nodenAlumno = d.createElement("nombre");//Creamos un elemento nombre.
				nodenAlumnoText = d.createTextNode(nombre);//Creamos el texto contenido.
				nodenAlumno.appendChild(nodenAlumnoText);//Al elemento, le añadimos el texto.

			}

			System.out.println ("Por favor introduzca sus apellidos o FIN para finalizar.");
			apellido = entradaEscaner.nextLine ();
			if (apellido.equals(fin))//Si apellido es igual a fin("FIN")
			{
				System.out.println("El programa se ha cerrado correctamente.");
				System.exit(0);

			}
			else
			{
				nodeapAlumno = d.createElement("apellidos");//creamos un elemento apellido.
				nodeapAlumnoText = d.createTextNode(apellido);//Creamos su texto contenido.
				nodeapAlumno.appendChild(nodeapAlumnoText);//al elemento le agregamos el texto.
				nodeAlumno = d.createElement("alumno");//Creamos un elemento alumno.
				nodeAlumno.appendChild(nodenAlumno);//A este elemento e añadimos el nombre del alumno.
				nodeAlumno.appendChild(nodeapAlumno);//Y su apellido.

				nodeRaiz = d.getFirstChild();//Obtenemos el primer nodo del documento.
				nodeRaiz.appendChild(nodeAlumno);//Se agrega un nuevo alumno.
			}	
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Result output = new StreamResult(new File("alumno.xml"));//Con estas 4 lineas, guardamos los datos en un fichero .xml físico,
			//para así lograr persistencia de la información
			Source input = new DOMSource(d);
			transformer.transform(input, output);
			return 0;
		}	

		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static void main(String[] args) {
		while (nombre.equals(fin)!=true  || apellido.equals(fin)!=true)//Mientra que el nombre o apellido no se igual a fin("FIN),
																		//se seguirán pidiendo nombres y apellidos.
			añadirDom(doc);
	}
	
}

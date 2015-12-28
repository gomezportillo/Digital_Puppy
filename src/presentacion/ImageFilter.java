package presentacion;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Esta clase sirve para añadir a lso JFileChooser un filtro de 
 * archivos.  Por ejemplo, este solo dejara seleccionar archivos 
 * con extension png, jpeg o jpg (imagenes) 
 */
public class ImageFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		boolean aceptar = f.isDirectory();
		if (!aceptar){
			String extension= getExtension(f);
		if(extension!= null)
			aceptar = extension.equals("png") || extension.equals("jpeg")|| extension.equals("jpg");
		}
		return aceptar;
	}

	private String getExtension(File f) {
		String s = f.getPath();
		String extension= null;
		int i = s.lastIndexOf ('.');
		if (i>0 && i< s.length()-1) extension = s.substring(i+1).toLowerCase();
		return extension;
	}

	@Override
	public String getDescription() {
		return "Fichero de imagen (*.jpg | *.jpeg | *.png)";
	}

}

package presentacion;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "presentacion.messages"; //$NON-NLS-1$

	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	private static Locale getLocale(String appIdioma){
		Locale locale=new Locale("es");
		if (appIdioma.equals("inglés"))
			locale = new Locale("en");
		return locale;
	}
	public static void setIdioma(String idioma){
		RESOURCE_BUNDLE= ResourceBundle.getBundle(BUNDLE_NAME, getLocale(idioma));
	}
}

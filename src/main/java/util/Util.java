package util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class Util {
	
	public static String getMimeType(byte[] image) {
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(image));
		try {
			String mimeType = URLConnection.guessContentTypeFromStream(is);
			return mimeType;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}

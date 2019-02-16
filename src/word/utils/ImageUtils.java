package word.utils;

import java.io.ByteArrayOutputStream;
import android.graphics.Bitmap;
import com.thoughtworks.xstream.core.util.Base64Encoder;

public class ImageUtils {
	
	public static String getImageHexaBase64(Bitmap bitmap, String imageformat) {
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] resultImageAsRawBytes = stream.toByteArray();
		String encodedString = new Base64Encoder().encode(resultImageAsRawBytes);
		return encodedString;
	}
	
}

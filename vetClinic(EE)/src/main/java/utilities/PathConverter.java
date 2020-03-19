package utilities;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class PathConverter {
    public static String getAbsolutePathOfResource(String resourcePath){
        URL res = PathConverter.class.getClassLoader().getResource(resourcePath);
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();

    }
}

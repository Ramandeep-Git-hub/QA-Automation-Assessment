package stepdefinitions;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class BaseStepDef {

    public static Properties properties;

    public void setupPropConfig() throws Exception {
        String path = "src/config/";
        properties = new Properties();
        File testDataFile = new File(path+"config.properties");
        FileInputStream fileInput = new FileInputStream(testDataFile);
        properties.load(fileInput);
        fileInput.close();
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }

    public String getAuthor(){
        return properties.getProperty("author");
    }


}

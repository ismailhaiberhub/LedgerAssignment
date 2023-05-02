package Utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderProperties {

    Properties properties;

    public Properties init_props(){
        properties=new Properties();
        try{
            FileInputStream propertiesFile=new FileInputStream("src/main/resources/PropertiesData/BowserPoperties.properties");
            properties.load(propertiesFile);
        } catch (FileNotFoundException exception) {
            exception.fillInStackTrace();
            exception.printStackTrace();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return properties;
    }
}

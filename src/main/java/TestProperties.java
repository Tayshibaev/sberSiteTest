import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class TestProperties
{
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE;


    private TestProperties() {

        if(System.getProperty("environment")==null)
        {
            System.setProperty("environment","environment");
        }
        try {
            properties.load(new FileInputStream(new File("./"+System.getProperty("environment")
            +".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getINSTANCE() {
        if(INSTANCE==null)
        {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties()
    {
        return properties;
    }
}
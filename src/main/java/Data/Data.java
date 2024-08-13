package Data;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Data {
    static String path = "src/test/java/DataForTest/Data.json";
    public static String randomEmail = generateEmail();


 /*   public static <T> T dataClass(Class<T> data) {
        T instance = null;
        try {
            instance = data.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.readerForUpdating(instance);
        File file = new File(path);
        try {
            reader.readValue(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }*/


    public static String dataClass (String KeyName) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(KeyName);
    }

    public static String generateEmail()
    {
        String numbers = "123456789123456789";
        int userName_Length = 7;

        StringBuilder userName = new StringBuilder();
        Random random = new Random();
        for (int i = 0 ; i<userName_Length ; i++)
        {
            int index = random.nextInt(numbers.length());
            userName.append(numbers.charAt(index));
        }
        String email = "test" + userName + "@test.com";
        return email;
    }
}

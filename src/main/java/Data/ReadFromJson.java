package Data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ReadFromJson {
    static String path = "src/test/java/DataForTest/Data.json";
    static String cardDataPath = "src/test/java/DataForTest/CardData.json";


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

    public static String cardData (String KeyName) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(cardDataPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(KeyName);
    }

    public static String randomEmail()
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

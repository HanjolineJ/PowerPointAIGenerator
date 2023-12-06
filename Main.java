import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> data = mapper.readValue(new File("C:\\Users\\Acer Customer\\IdeaProjects\\PowerpointCreater\\src\\data.json"), Map.class);
            PPTG pptGenerator = new PPTG();

            pptGenerator.createPresentation(data);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


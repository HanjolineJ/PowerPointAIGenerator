/*
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonParser {
    private String filePath;

    public JsonParser(String filePath) {
        this.filePath = filePath;
    }


    public Map<String,String> parse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map data = mapper.readValue(new File(filePath),
                Map.class);

        return data;
    }
}
*/

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {
    private String filePath;
    private ObjectMapper mapper;

    public JsonParser(String filePath) {
        this.filePath = filePath;
        this.mapper = new ObjectMapper();
    }

    // Added for testability
    //public JsonParser(String filePath, ObjectMapper mapper) {
      //  this.filePath = filePath;
       // this.mapper = mapper;
    //}

    public Map<String, String> parse() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File not found: " + filePath);
        }
        //return mapper.readValue(file, Map.class);
        return new HashMap<>();
    }
}

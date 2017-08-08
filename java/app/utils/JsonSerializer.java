package app.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component(value = "JsonSerializer")
public class JsonSerializer implements Serializer {
    private Gson gson;

    @Autowired
    private FileIO fileIO;

    public JsonSerializer() {
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public <T> void serialize(T obj, String fileName) {
        File file = new File(fileName);
        String json = gson.toJson(obj);

        try {
            if(!file.exists()){
                //create all directories if not exists
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            this.fileIO.write(json, fileName);
        } catch (IOException e) {
            throw new SerializeException(json + " was not serialized to " + fileName, e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> clazz, String fileName) {
        String jsonInput = this.fileIO.read(fileName);

        return gson.fromJson(jsonInput, clazz);
    }
}

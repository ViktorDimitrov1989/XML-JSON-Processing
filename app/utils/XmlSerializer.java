package app.utils;

import org.springframework.stereotype.Component;

@Component(value = "XmlSerializer")
public class XmlSerializer implements Serializer {
    @Override
    public <T> void serialize(T obj, String fileName) {
        //TODO
    }

    @Override
    public <T> T deserialize(Class<T> clazz, String fileName) {
        //TODO
        return null;
    }
}

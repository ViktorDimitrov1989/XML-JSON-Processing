package app.utils;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component(value = "XmlSerializer")
public class XmlSerializer implements Serializer {
    @Override
    public <T> void serialize(T obj, String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            String path = System.getProperty("user.dir") + File.separator + fileName;
            File file = new File(path);
            if(!file.exists()){
                //create all directories if not exists
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            try(OutputStream os = new FileOutputStream(fileName);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))){
                marshaller.marshal(obj, bw);
            }

        } catch (JAXBException e) {
            //log
            throw new SerializeException("Could not serialize " + obj, e);
        } catch (IOException e) {
            //log
            throw new SerializeException("Could not serialize. Unable to write to file " + fileName, e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> clazz, String fileName) {

        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            try(InputStream is = clazz.getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
                T t = (T)unmarshaller.unmarshal(reader);
                return t;
            }

        } catch (JAXBException e) {
            //log
            throw new SerializeException("Could not deserialize to class " + clazz, e);
        }catch (IOException e) {
            //log
            throw new SerializeException("Could not deserialize to class "
                    + clazz + ". Unable to read from file " + fileName, e);
        }
    }
}

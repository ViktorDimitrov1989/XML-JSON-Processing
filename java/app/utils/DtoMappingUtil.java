package app.utils;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DtoMappingUtil {
    private static ModelMapper mapper = new ModelMapper();

    private DtoMappingUtil() {
    }

    //generic convert
    public static <S,D> D convert(S source, Class<D> destinationClass){
        return mapper.map(source, destinationClass);
    }

    //generic convert for collections
    public static <S,D> List<D> convert(Iterable<S> sources, Class<D> destClass){
        List<D> resultList = new ArrayList<D>();

        for (S s : sources) {
            resultList.add(convert(s, destClass));
        }

        return resultList;
    }
}

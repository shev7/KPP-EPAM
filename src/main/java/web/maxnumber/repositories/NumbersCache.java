package web.maxnumber.repositories;

import org.springframework.stereotype.Repository;
import java.util.LinkedHashMap;
import java.util.Map;

import web.maxnumber.entities.CustomNumber;
import web.maxnumber.entities.Numbers;

@Repository
public class NumbersCache {
    Map<Numbers, CustomNumber> numbersCache = new LinkedHashMap<>();

    public boolean hasKey(Numbers key) {
        return numbersCache.containsKey(key);
    }

    public void create(Numbers triangle, CustomNumber triangleIdentification) {
        numbersCache.put(triangle, triangleIdentification);
    }

    public CustomNumber getValueByKey(Numbers key) {
        return numbersCache.get(key);
    }

    public Map<Numbers, CustomNumber> getNumbersCache() {
        return numbersCache;
    }
}
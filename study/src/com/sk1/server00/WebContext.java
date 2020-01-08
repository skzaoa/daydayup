package com.sk1.server00;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sk
 * create on  2020/1/6:21:10
 */
class WebContext {
    //key=servlet-name value=servlet-class
    private Map<String,String> entityMap = new HashMap<>();
    //key=url-pattern value=servlet-name
    private Map<String,String> mappingMap = new HashMap<>();


    WebContext(List<Entity> entities, List<Mapping> mappings) {
        //将entity的list转成对应map
        for(Entity entity:entities){
            entityMap.put(entity.getName(),entity.getClz());
        }
        //将mapping的list转成对应map
        for(Mapping mapping:mappings){
            for(String pattern:mapping.getPatterns()){
                mappingMap.put(pattern,mapping.getName());
            }
        }
    }

    /**
     * 通过url路径找到对应class
     * @param pattern 路径
     * @return class
     */
     String getClz(String pattern){
        String name = mappingMap.get(pattern);
        return entityMap.get(name);
    }
}

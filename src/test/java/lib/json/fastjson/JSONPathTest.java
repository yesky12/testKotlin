package lib.json.fastjson;

import com.alibaba.fastjson.JSONPath;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------
 * JSONPath · alibaba/fastjson Wiki
 * https://github.com/alibaba/fastjson/wiki/JSONPath
 */
public class JSONPathTest {
    public static class Entity {
        private Integer id;
        private String name;
        private Object value;

        public Entity() {}
        public Entity(Integer id, Object value) { this.id = id; this.value = value; }
        public Entity(Integer id, String name) { this.id = id; this.name = name; }
        public Entity(String name) { this.name = name; }

        public Integer getId() { return id; }
        public Object getValue() { return value; }
        public String getName() { return name; }

        public void setId(Integer id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setValue(Object value) { this.value = value; }
    }

    public static void main(String[] args) {
        Entity entity = new Entity(123, new Object());
        int length = args.length;

        Assert.assertSame(entity.getValue(), JSONPath.eval(entity, "$.value"));
        Assert.assertTrue(JSONPath.contains(entity, "$.value"));
        Assert.assertTrue(JSONPath.containsValue(entity, "$.id", 123));
        Assert.assertTrue(JSONPath.containsValue(entity, "$.value", entity.getValue()));
        Assert.assertEquals(2, JSONPath.size(entity, "$"));
//        Assert.assertEquals(0, JSONPath.size(new Object[], "$"));


        //5.2 例2：读取集合多个元素的某个属性
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity("wenshao"));
        entities.add(new Entity("ljw2083"));

        List<String> names = (List<String>)JSONPath.eval(entities, "$.name"); // 返回enties的所有名称//[wenshao,ljw2083]
        Assert.assertSame(entities.get(0).getName(), names.get(0));
        Assert.assertSame(entities.get(1).getName(), names.get(1));

    }
}

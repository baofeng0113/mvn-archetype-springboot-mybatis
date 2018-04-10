package ${package}.${artifactId}.domain;

import java.util.List;
import java.util.Map;

public interface BasicMyBatisMapper<T> {

    List<T> selectAll(Map<String, Object> params);

    T selectOne(long id);

    int insert(T object);

    int update(Map<String, Object> params);

    int delete(long id);
}

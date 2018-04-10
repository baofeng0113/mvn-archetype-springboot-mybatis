package ${package}.${artifactId}.domain;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import ${package}.${artifactId}.framework.entry.page.PageResult;

public abstract class AbstractBasicService<T> implements InitializingBean {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected T mapper;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Autowired private SqlSession sqlSession;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.mapper = sqlSession.getMapper(getMapperClass());
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getMapperClass() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<T>) params[0];
    }

    protected <E> PageResult<E> convertToPageResult(List<E> result) {
        List<E> list = new LinkedList<>();
        Page<E> page = (Page<E>) result;
        if (page.getTotal() > 0) {
            list.addAll(((Page<E>) result).getResult());
        }
        return new PageResult<>(page.getTotal(), list, page.getPageNum(), page.getPageSize());
    }

    @SuppressWarnings("unchecked")
    protected Map<String, Object> convertBeanToMap(Object object) {
        return objectMapper.convertValue(object, Map.class);
    }
}

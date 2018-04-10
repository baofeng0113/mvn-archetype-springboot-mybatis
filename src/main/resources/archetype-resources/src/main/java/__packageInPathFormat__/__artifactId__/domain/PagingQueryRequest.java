package ${package}.${artifactId}.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class PagingQueryRequest implements Serializable {

    @Getter @Setter protected int page;

    @Getter @Setter protected int size;

    public PagingQueryRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }
}

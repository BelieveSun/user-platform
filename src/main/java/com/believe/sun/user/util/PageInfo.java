package com.believe.sun.user.util;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by sungj on 17-8-11.
 */
@ApiModel("页面信息")
public class PageInfo<T> {
    @ApiModelProperty("列表")
    private List<T> list;
    @ApiModelProperty("分页信息")
    private Page page;

    public PageInfo(List<T> list, Integer index,Integer size,Integer total) {
        this.list = list;
        this.page = new Page(index,size,total);
    }

    public PageInfo(Integer index,Integer size,Integer total) {
        this.page = new Page(index,size,total);
    }

    public PageInfo(PageList<T> pageList) {
        this.list = pageList;
        Paginator paginator = pageList.getPaginator();
        this.page = new Page(paginator.getPage(),paginator.getLimit(),paginator.getTotalPages());
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    @ApiModel("分页信息")
    private class Page{
        @ApiModelProperty("当前页")
        private Integer index;
        @ApiModelProperty("页面大小")
        private Integer size;
        @ApiModelProperty("总页数")
        private Integer total;

        public Page(Integer index, Integer size, Integer total) {
            this.index = index;
            this.size = size;
            this.total = total;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }
    }
}

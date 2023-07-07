package com.bks.taskfortara.Model;

import java.util.ArrayList;
import java.util.List;

public class ProductAll {

    private List<products> products;
    private int total;
    private String skip;
    private String limit;

    public List<com.bks.taskfortara.Model.products> getProducts() {
        return products;
    }

    public void setProducts(List<com.bks.taskfortara.Model.products> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}

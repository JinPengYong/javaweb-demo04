package com.cheer.model;

public class QueryVo {
    private Emp emp;

    public QueryVo() {
    }
    public QueryVo(Emp emp) {
        this.emp = emp;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "emp=" + emp +
                '}';
    }
}

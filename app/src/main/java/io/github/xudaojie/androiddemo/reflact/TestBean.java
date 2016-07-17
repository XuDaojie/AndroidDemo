package io.github.xudaojie.androiddemo.reflact;

/**
 * Created by xdj on 16/1/4.
 */
public class TestBean {
    private String name = "testbean";
    private String passowrd;
    protected Object obj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}

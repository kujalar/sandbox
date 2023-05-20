package org.ari.controller.rmi;

import java.io.Serializable;
import java.math.BigDecimal;

public class TestTask implements Task<String>, Serializable {
    private static final long serialVersionUID = 227L;
    private String result = null;
    public void setResult(String result) {
        this.result = result;
    }
    public String execute() {
        return result;
    }
}

package com.terremotospr.beans;

/*
 * @author Wilfredo Aponte Pomales
 */
public class PaypalAccountBean extends PaymentMethodBean {
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

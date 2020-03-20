package com.terremotospr.beans;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */
public class ConsumerBean extends UserBean{
    private ConsumerType type;

    public ConsumerType getType() { return type; }

    public void setType(ConsumerType type) { this.type = type; }

}
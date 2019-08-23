package com.gwg.spring.instantiation.instancefactorymethod.test;

public class DefaultServiceLocator {

    //private static ClientService clientService = new ClientService();
    private DefaultServiceLocator() {}

    public ClientService createClientServiceInstance() {
        return new ClientService();
    }
}
package com.example.projecttest.decorator;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.ejb.Asynchronous;
import javax.enterprise.context.NormalScope;
import javax.inject.Inject;

@Decorator
public abstract class DataAccessAuthorizationDecorator<T, V> implements DataAccess<T, V> {
    @Inject
    @Delegate
    DataAccess<T, V> delegate;

    public V getId(T object) {
        System.out.println("Hello decorator");
        return delegate.getId(object);
    }
}

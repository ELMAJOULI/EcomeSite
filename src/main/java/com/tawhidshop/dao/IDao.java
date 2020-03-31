package com.tawhidshop.dao;

import java.util.Set;

public interface IDao<T> {

    public int add(T entity);

    public int removeById(int id);

    public int update(T entity);

    public Set<T> get(String keyWord);

    public T get(int id);

}

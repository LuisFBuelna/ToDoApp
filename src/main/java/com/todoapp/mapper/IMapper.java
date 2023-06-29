package com.todoapp.mapper;

/**
 *
 * @author luis.buelna
 */
public interface IMapper <I, O> {
    public O map(I in);
}

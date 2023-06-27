package com.emergentes.dao;

import com.emergentes.modelo.Editorial;
import java.util.List;

public interface EditorialDAO {
    public void insert(Editorial editorial) throws Exception;
    public void update(Editorial editorial) throws Exception;
    public void delete(int id) throws Exception;
    public Editorial getById(int id) throws Exception;
    public List<Editorial> getll()  throws Exception;
}

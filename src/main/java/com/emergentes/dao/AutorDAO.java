package com.emergentes.dao;

import com.emergentes.modelo.Autor;
import java.util.List;

public interface AutorDAO {
    public void insert(Autor autor) throws Exception;
    public void update(Autor autor) throws Exception;
    public void delete(int id) throws Exception;
    public Autor getById(int id) throws Exception;
    public List<Autor> getll()  throws Exception;
}

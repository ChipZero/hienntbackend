package com.hiennt.pizza.service;

import com.hiennt.pizza.entity.TblProtype;
import com.hiennt.pizza.repository.IProtypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProtypeService implements IProtypeService {
    @Autowired
    private IProtypeRepository protypeRepository;
    @Override
    public List<TblProtype> getAll() {
        return protypeRepository.findAll();
    }

    @Override
    public TblProtype getById(int id) {
        return protypeRepository.findOne(id);
    }

    @Override
    public TblProtype add(TblProtype tblProtype) throws Exception {
        return protypeRepository.save(tblProtype);
    }

    @Override
    public TblProtype update(TblProtype tblProtype) throws Exception {
        return protypeRepository.save(tblProtype);
    }

    @Override
    public TblProtype delete(int id) throws Exception {
        TblProtype protype = getById(id);
        protypeRepository.delete(protype.getPrtId());
        return protype;
    }
}

package com.hiennt.pizza.repository;

import com.hiennt.pizza.entity.TblProtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IProtypeRepository extends JpaRepository<TblProtype, Integer>{

}

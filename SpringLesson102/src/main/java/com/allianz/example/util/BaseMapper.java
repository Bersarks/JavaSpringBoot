package com.allianz.example.util;

import com.allianz.example.database.entity.BaseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseMapper<DTO extends BaseDTO, ENTITY extends BaseEntity, REQUESTDTO extends BaseDTO> extends Object{

    public ENTITY dtoToEntity(DTO dto) {
        ENTITY entity = (ENTITY) new Object();
        BeanUtils.copyProperties(entity, dto);
        return entity;
    }

    public DTO entityToDTO(ENTITY entity) {
        DTO dto = (DTO) new Object();
        BeanUtils.copyProperties(dto, entity);
        return dto;
    }

    public List<DTO> entityListToDTOList(List<ENTITY> personEntities) {
        List<DTO> dtoList = (List<DTO>) new Object();
        for (ENTITY entity : personEntities) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    public List<ENTITY> dtoListToEntityList(List<DTO> dtos) {
        List<ENTITY> entityList = (List<ENTITY>) new Object();
        for (DTO dto : dtos) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    // How?? WHY???
    public ENTITY requestDTOToEntity(REQUESTDTO dto) {

        ENTITY entity = (ENTITY) new Object();
        BeanUtils.copyProperties(entity, dto);
        return entity;
    }
}

/*abstract class GenericAbstractClass<T> {
    protected T genericField;

    public GenericAbstractClass(T genericField) {
        this.genericField = genericField;
    }

    public abstract void genericMethod(T param);
}

// Generic abstract sınıftan türeyen alt sınıf
class ChildClass extends GenericAbstractClass<String> {
    public ChildClass(String genericField) {
        super(genericField);
    }

    @Override
    public void genericMethod(String param) {
        System.out.println("Generic method with parameter: " + param);
    }
}

public class Main {
    public static void main(String[] args) {
        ChildClass childObject = new ChildClass("Hello, Generic!");
        childObject.genericMethod(childObject.genericField);
    }
}*/

package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.BaseMapper;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper extends BaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {

    //    @Override
//    public AddressDTO entityToDTO(AddressEntity entity) {
//        AddressDTO addressDTO = new AddressDTO();
//
//        addressDTO.setTitle(entity.getTitle());
//        addressDTO.setAddress(entity.getAddress());
//        addressDTO.setUuid(entity.getUuid());
//        addressDTO.setId(entity.getId());
//        addressDTO.setUpdateDate(entity.getUpdateDate());
//        addressDTO.setCreationDate(entity.getCreationDate());
//
//        return addressDTO;
//    }
//
//    @Override
//    public AddressEntity dtoToEntity(AddressDTO dto) {
//        AddressEntity addressEntity = new AddressEntity();
//        addressEntity.setAddress(dto.getAddress());
//        addressEntity.setUuid(dto.getUuid());
//        addressEntity.setId(dto.getId());
//        addressEntity.setTitle(dto.getTitle());
//        addressEntity.setCreationDate(dto.getCreationDate());
//        addressEntity.setUpdateDate(dto.getUpdateDate());
//
//        return addressEntity;
//    }
//
//    @Override
//    public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
//        List<AddressDTO> addressDTOList = new ArrayList<>();
//        for (AddressEntity address : addressEntities) {
//            addressDTOList.add(entityToDTO(address));
//        }
//
//        return addressDTOList;
//    }
//
//    @Override
//    public List<AddressEntity> dtoListToEntityList(List<AddressDTO> addressDTOS) {
//        List<AddressEntity> addressEntityList = new ArrayList<>();
//
//        for (AddressDTO addressDTO : addressDTOS) {
//            addressEntityList.add(dtoToEntity(addressDTO));
//        }
//
//        return addressEntityList;
//    }
//
//    @Override
//    public AddressEntity requestDTOToEntity(AddressRequestDTO dto) {
//        AddressEntity addressEntity = new AddressEntity();
//        addressEntity.setCreationDate(dto.getCreationDate());
//        addressEntity.setUpdateDate(dto.getUpdateDate());
//        addressEntity.setId(dto.getId());
//        addressEntity.setUuid(dto.getUuid());
//        addressEntity.setTitle(dto.getTitle());
//        addressEntity.setAddress(dto.getAddress());
//
//        return addressEntity;
//    }
}

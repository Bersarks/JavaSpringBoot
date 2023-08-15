package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<AddressEntity,
         AddressRequestDTO, AddressDTO> {

//    @Autowired
//    AddressEntityRepository addressEntityRepository;
//
//    @Autowired
//    AddressMapper addressMapper;
//
//    public AddressDTO save(AddressRequestDTO addressRequestDTO) {
//        AddressEntity addressEntity = addressMapper.requestDTOToEntity(addressRequestDTO);
//        addressEntityRepository.save(addressEntity);
//
//        return addressMapper.entityToDTO(addressEntity);
//    }
//
//    public List<AddressDTO> getAll() {
//        List<AddressEntity> addressEntityList = addressEntityRepository.findAll();
//        return addressMapper.entityListToDTOList(addressEntityList);
//    }
//
//    public AddressDTO getAddressByUUID(UUID uuid) {
//        Optional<AddressEntity> address = addressEntityRepository.findByUuid(uuid);
//        if (address.isPresent()) {
//            return addressMapper.entityToDTO(address.get());
//        } else {
//            return null;
//        }
//    }
//
//    public List<AddressEntity> getAddressesContains(String key) {
//        return addressEntityRepository.getAddressEntitiesByAddressIsContaining(key);
//    }
//
//    public AddressDTO updateAddressByUUID(UUID uuid, AddressRequestDTO addressRequestDTO) {
//        AddressEntity addressEntity = addressEntityRepository.findByUuid(uuid).orElse(null);
//        if (addressEntity != null) {
//            return addressMapper.entityToDTO(addressEntity);
//        }
//        return null;
//    }
//
//    public AddressDTO deleteAddressByUUID(UUID uuid) {
//        AddressEntity addressEntity = addressEntityRepository.findByUuid(uuid).orElse(null);
//        if (addressEntity != null) {
//            addressEntityRepository.deleteByUuid(uuid);
//            return addressMapper.entityToDTO(addressEntity);
//        } else {
//            return null;
//        }
//    }


}

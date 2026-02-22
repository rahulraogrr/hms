package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.hotel.HotelObjectDto;
import com.hotel.dto.admin.hotel.HotelRequestDto;
import com.hotel.dto.admin.hotel.HotelResponseDto;
import com.hotel.dto.portal.AddressDto;
import com.hotel.entites.admin.Address;
import com.hotel.entites.admin.Hotel;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.GroupRepository;
import com.hotel.repositories.admin.HotelRepository;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import com.hotel.util.CommonCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelHelper implements CrudServiceHelperGeneric<HotelRequestDto, HotelResponseDto, Integer> {

    private final GroupRepository groupRepository;
    private final HotelRepository hotelRepository;

    HotelHelper(GroupRepository groupRepository, HotelRepository hotelRepository){
        this.groupRepository = groupRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelResponseDto create(HotelRequestDto hotelRequestDto) {

        return getHotelResponse(hotelRepository.save(Hotel.builder()
                .address(CommonCode.getAddress(hotelRequestDto.getHotel().getAddress()))
                .noOfFloors(hotelRequestDto.getHotel().getNoOfFloors())
                .founded(hotelRequestDto.getHotel().getFounded())
                .name(hotelRequestDto.getHotel().getName())
                .status(hotelRequestDto.getHotel().getStatus())
                .group(groupRepository.getReferenceById(hotelRequestDto.getHotel().getGroupId()))
                .build()));
    }

    @Override
    public List<HotelResponseDto> findAll() {
        return hotelRepository.findAll().stream().map(HotelHelper::getHotelResponse).collect(Collectors.toList());
    }

    private static HotelResponseDto getHotelResponse(Hotel hotel) {
        return HotelResponseDto.builder()
                .hotel(HotelObjectDto.builder()
                        .address(CommonCode.getAddressDto(hotel.getAddress()))
                        .id(hotel.getId())
                        .name(hotel.getName())
                        .noOfFloors(hotel.getNoOfFloors())
                        .founded(hotel.getFounded())
                        .status(hotel.getStatus())
                        .groupId(hotel.getGroup().getId())
                        .build())
                .build();
    }

    @Override
    public HotelResponseDto findById(Integer id) {
        return getHotelResponse(hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", id)));
    }

    @Override
    public boolean deleteById(Integer id) {
        hotelRepository.deleteById(id);
        return true;
    }

    @Override
    public HotelResponseDto modify(Integer id, HotelRequestDto requestDto) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", id));

        HotelObjectDto dto = requestDto.getHotel();
        hotel.setName(dto.getName());
        hotel.setStatus(dto.getStatus());
        hotel.setNoOfFloors(dto.getNoOfFloors());
        hotel.setFounded(dto.getFounded());

        if (dto.getAddress() != null) {
            if (hotel.getAddress() != null) {
                updateAddressInPlace(hotel.getAddress(), dto.getAddress());
            } else {
                hotel.setAddress(CommonCode.getAddress(dto.getAddress()));
            }
        }

        if (dto.getGroupId() != hotel.getGroup().getId()) {
            hotel.setGroup(groupRepository.findById(dto.getGroupId())
                    .orElseThrow(() -> new ResourceNotFoundException("Group", dto.getGroupId())));
        }

        return getHotelResponse(hotelRepository.save(hotel));
    }

    private static void updateAddressInPlace(Address address, AddressDto dto) {
        address.setAddress1(dto.getAddress1());
        address.setAddress2(dto.getAddress2());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPinCode(dto.getPinCode());
        address.setType(dto.getType());
    }
}
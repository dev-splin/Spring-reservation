package kr.or.connect.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.ReservationInfoDTO;
import kr.or.connect.reservation.dto.ResponseRegisterReservationInfoDTO;

@Mapper
public interface ReservationInfoMapper extends GenericMapper<RequestReservationInfoDTO, ReservationInfoDTO> {
	ReservationInfoMapper INSTANCE = Mappers.getMapper(ReservationInfoMapper.class);

	@Override
	@Mapping(source = "reservationYearMonthDay", target = "reservationDate")
	ReservationInfoDTO DTOToEntity(RequestReservationInfoDTO DTO);
	
	ResponseRegisterReservationInfoDTO DTOToResponse(ReservationInfoDTO entity);
	
}

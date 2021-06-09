package kr.or.connect.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import kr.or.connect.reservation.dto.RequestReservationInfoPriceDTO;
import kr.or.connect.reservation.dto.ReservationInfoPriceDTO;

@Mapper
public interface ReservationInfoPriceMapper extends GenericMapper<RequestReservationInfoPriceDTO, ReservationInfoPriceDTO> {
	ReservationInfoPriceMapper INSTANCE = Mappers.getMapper(ReservationInfoPriceMapper.class);

}

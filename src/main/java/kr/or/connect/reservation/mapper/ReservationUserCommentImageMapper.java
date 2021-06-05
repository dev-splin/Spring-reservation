package kr.or.connect.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationUserCommentImageDTO;
import kr.or.connect.reservation.entity.ReservationUserCommentImageEntity;

@Mapper
public interface ReservationUserCommentImageMapper extends GenericMapper<ReservationUserCommentImageDTO, ReservationUserCommentImageEntity>{
	ReservationUserCommentImageMapper INSTANCE = Mappers.getMapper(ReservationUserCommentImageMapper.class);
}

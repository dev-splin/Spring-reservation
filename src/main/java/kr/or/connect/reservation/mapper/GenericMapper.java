package kr.or.connect.reservation.mapper;

public interface GenericMapper<D, E> {
	D EntityToDTO(E entity);
	E DTOToEntity(D DTO);
}

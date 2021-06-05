package kr.or.connect.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import kr.or.connect.reservation.dto.ProductPriceDTO;
import kr.or.connect.reservation.entity.ProductPriceEntity;

@Mapper
public interface ProductPriceMapper extends GenericMapper<ProductPriceDTO, ProductPriceEntity>{
	ProductPriceMapper INSTANCE = Mappers.getMapper(ProductPriceMapper.class);
}

package kr.or.connect.reservation.MapperTest;

import java.util.Date;

import org.apache.tomcat.jni.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductPriceDTO;
import kr.or.connect.reservation.entity.ProductPriceEntity;
import kr.or.connect.reservation.mapper.ProductPriceMapper;
import kr.or.connect.reservation.security.UserLoginInfoDTO;
import springfox.documentation.swagger2.mappers.ModelMapper;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ModelMapperTest {

	
	@Test
	public void ProductPriceMapperTest() throws Exception {
//		
//		ProductPriceEntity entity = ProductPriceEntity.builder()
//				.id(1L).productId(1L)
//				.priceTypeName("test")
//				.price(100)
//				.discountRate(100)
//				.createDate(new Date())
//				.modifyDate(new Date())
//				.build();
//		
//		// Entity -> DTO
//		ProductPriceDTO DTO = ProductPriceMapper.INSTANCE.EntityToDTO(entity);
//		// DTO -> Entity, Setter가 없을 시 변환할 수 없음
//		System.out.println(DTO);
	}
}

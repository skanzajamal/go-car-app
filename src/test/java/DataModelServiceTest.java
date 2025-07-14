import com.entity.DriverEntity;
import com.repository.DriverRepository;
import com.service.DataModelService;
import com.specification.SearchRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional  // <-- keeps session open
public class DataModelServiceTest extends MainApplicationTest{

    @Autowired
    private DataModelService dataModelService;

    @Autowired
    private DriverRepository driverRepository;

    @Test
    void testSearchByCriteria() {

        // when status is online and longitude and latitude are not provided in search field
        SearchRequest criteria1 = new SearchRequest("ONLINE", null, null);
        List<DriverEntity> result1 = dataModelService.driverList(criteria1);
        assertEquals(6, result1.size());

        // when status is online and longitude and latitude are provided in search field
        SearchRequest criteria2 = new SearchRequest("ONLINE", 55.7558, 37.6173);
        List<DriverEntity> result2 = dataModelService.driverList(criteria2);
        assertEquals(1, result2.size());
        assertThat(result2.get(0).getUserName()).isEqualTo("driver05");
    }

    @Test
    void testSelectAndDeSelectCar() throws Exception {

        //select car
        dataModelService.selectCar(6, 8);
        var test = driverRepository.findById(6);

        //check if the car has been selected
        driverRepository.findById(8).ifPresent(record -> Assertions.assertThat(record.getCar().getId()).isEqualTo(6));

        //deselect car
        dataModelService.deselectCar(8, 6);

        //check if the car has been deselected
        driverRepository.findById(6).ifPresent(record -> Assertions.assertThat(record.getCar()).isNull());
    }

} //ENDCLASS

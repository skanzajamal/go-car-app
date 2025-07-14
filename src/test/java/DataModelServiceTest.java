import com.entity.DriverEntity;
import com.repository.DriverRepository;
import com.service.DataModelService;
import com.specification.SearchRequest;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataModelServiceTest extends MainApplicationTest{

    @Autowired
    private DataModelService dataModelService;

    @Autowired
    private DriverRepository driverRepository;

    @Test
    void testSearchByCriteria() {

        // when status is online
        SearchRequest criteria1 = new SearchRequest("ONLINE", null, null);
        List<DriverEntity> result1 = dataModelService.driverList(criteria1);
        assertEquals(6, result1.size());

        // when status is online and longitude and latitude is not null
        SearchRequest criteria2 = new SearchRequest("ONLINE", 55.7558, 37.6173);
        List<DriverEntity> result2 = dataModelService.driverList(criteria2);
        assertEquals(1, result2.size());
        assertThat(result2.get(0).getUserName()).isEqualTo("driver05");
    }

} //ENDCLASS

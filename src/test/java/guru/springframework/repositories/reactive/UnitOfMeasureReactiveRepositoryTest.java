package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryTest extends TestCase {

    @Autowired
    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    @Test
    public void testUomSave() throws Exception {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription("Teaspoon");

        unitOfMeasureReactiveRepository.save(uom).block();

        Long count = unitOfMeasureReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);

    }

    @Test
    public void testAddDocumentObject() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription("Teaspoon");

        unitOfMeasureReactiveRepository.save(uom);

        Flux<UnitOfMeasure> uomFlux = unitOfMeasureReactiveRepository.findAll();

        uomFlux.subscribe(cUom -> log.info(cUom.getDescription()));
    }

    @Test
    public void testFindByDescription() throws Exception {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription("Teaspoon");

        unitOfMeasureReactiveRepository.save(uom).block();

        UnitOfMeasure fetchedUom = unitOfMeasureReactiveRepository.findByDescription("Teaspoon").block();

        assertNotNull(fetchedUom.getDescription());
        assertNotNull(fetchedUom.getId());
    }

}
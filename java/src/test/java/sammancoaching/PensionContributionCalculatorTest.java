package sammancoaching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PensionContributionCalculatorTest {

    DatabaseAccessLayer databaseAccess;

    // system under test
    PensionContributionCalculator pensionContributionCalculator;

    @BeforeEach
    void setUp() {
        databaseAccess = new InMemoryDatabaseAccessLayer();
    }

    // TEST LIST
    // [] - should create a new instance of the PensionContributionCalculator

    @Test
    @DisplayName("should create a new instance of the PensionContributionCalculator")
    void should_create_a_new_instance_of_the_PensionContributionCalculator() {

        //when
        pensionContributionCalculator = new PensionContributionCalculator(databaseAccess);

        //then
        Assertions.assertNotNull(pensionContributionCalculator);
    }





}
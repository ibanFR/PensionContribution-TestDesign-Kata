package sammancoaching;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PensionContributionCalculatorTest {

    DatabaseAccessLayer databaseAccess;

    // system under test
    PensionContributionCalculator pensionContributionCalculator;

    @BeforeEach
    void setUp() {

        databaseAccess = new InMemoryDatabaseAccessLayer();

        //given
        databaseAccess.saveValue("BASE_CONTRIBUTION_RATE", 0);
    }

    // TEST LIST
    // [X] - should create a new instance of the PensionContributionCalculator
    // [X] - should throw an IllegalArgumentException if baseContributionPercentage is below zero
    // [X] - Should throw an IllegalArgumentException if annualSalary is below zero

    @Test
    @DisplayName("should create a new instance of the PensionContributionCalculator")
    void should_create_a_new_instance_of_the_PensionContributionCalculator() {

        //when
        pensionContributionCalculator = new PensionContributionCalculator(databaseAccess);

        //then
        assertNotNull(pensionContributionCalculator);
    }

    @Nested
    @DisplayName("Calculate pension contribution")
    class CalculatePensionContribution {

        public static final int EMPLOYEE_ID = 1;

        Employee juniorEmployee;

        @BeforeEach
        void setUp() {
            juniorEmployee = new Employee(BigDecimal.valueOf(-1000), 100_000, new JuniorEmployee());
            databaseAccess.saveEmployee(EMPLOYEE_ID, juniorEmployee);
        }

        @Test
        @DisplayName("should throw an IllegalArgumentException if baseContributionPercentage is below zero")
        void should_throw_an_IllegalArgumentException_if_baseContributionPercentage_is_below_zero() {

            //given
            databaseAccess.saveValue("BASE_CONTRIBUTION_RATE", -1);

            //when
            pensionContributionCalculator = new PensionContributionCalculator(databaseAccess);

            //then
            assertThrows(IllegalArgumentException.class,
                         () -> pensionContributionCalculator.calculatePensionContribution(EMPLOYEE_ID),
                         "Base contribution percentage must be greater than or equal to zero");

        }

        @Test
        @DisplayName("should throw an IllegalArgumentException if the employee annualSalary is below zero")
        void should_throw_an_IllegalArgumentException_if_annualSalary_is_below_zero() {

            //when
            pensionContributionCalculator = new PensionContributionCalculator(databaseAccess);

            //then
            assertThrows(IllegalArgumentException.class,
                         () -> pensionContributionCalculator.calculatePensionContribution(EMPLOYEE_ID),
                         "The employee annual salary must be greater than or equal to zero");

        }

    }





}
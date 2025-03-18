package sammancoaching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeadershipTeamTest {

    // system under test
    LeadershipTeam leadershipTeam;

    @Test
    @DisplayName("pension contribution bonus should be 2.5 for leadership team level employees")
    void pension_contribution_bonus_should_be_2_5_for_leadership_team_level_employees() {

        //given
        leadershipTeam = new LeadershipTeam();

        //when
        double pensionContributionBonus = leadershipTeam.getPensionContributionBonus();

        //then
        assertEquals(2.5,
                     pensionContributionBonus,
                     "pension contribution bonus should be 2.5 for leadership team employees");

    }

}
package com.training.sportsbetting.service.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.sportsbetting.domain.Outcome;
import com.training.sportsbetting.domain.Wager;
import com.training.sportsbetting.service.event.repository.OutcomeRepository;
import com.training.sportsbetting.service.wager.WagerService;

@SpringBootTest
class OutcomeServiceTest {

    @Mock
    private OutcomeRepository outcomeRepository;
    @Mock
    private WagerService wagerService;
    @InjectMocks
    private OutcomeService underTest;

    @ParameterizedTest
    @MethodSource(value = "findMostPopularOutcomePredictableOrderParameters")
    void testFindMostPopularOutcomesWhenOrderIsPredictable(int topN, List<Outcome> expected, List<Wager> wagers) {
        // Given
        // When
        when(wagerService.findAll()).thenReturn(wagers);
        List<Outcome> result = underTest.findMostPopularOutcomes(topN);
        // Then
        assertEquals(expected, result);
    }

    static Stream<Arguments> findMostPopularOutcomePredictableOrderParameters() {
        Outcome firstOutcome = new Outcome("first", null, null);
        Outcome secondOutcome = new Outcome("second", null, null);
        Outcome thirthOutcome = new Outcome("thirth", null, null);
        Outcome fourthOutcome = new Outcome("fourth", null, null);

        Wager firstWager = new Wager(null, null, null, firstOutcome, null, null);
        Wager secondWager = new Wager(null, null, null, secondOutcome, null, null);
        Wager thirthWager = new Wager(null, null, null, thirthOutcome, null, null);
        Wager fourthWager = new Wager(null, null, null, fourthOutcome, null, null);

        Arguments topThreeFromDiferentOutcomeOccurenceNumber = Arguments.of(3,
                Arrays.asList(firstOutcome, secondOutcome, thirthOutcome),
                Arrays.asList(secondWager, secondWager, secondWager, firstWager, firstWager, firstWager, firstWager, thirthWager, thirthWager, fourthWager));

        Arguments emptyWager = Arguments.of(3,
                Arrays.asList(),
                Arrays.asList());

        Arguments topZero = Arguments.of(0,
                Arrays.asList(),
                Arrays.asList(secondWager, secondWager, secondWager, firstWager, firstWager, firstWager, firstWager, thirthWager, thirthWager, fourthWager));

        return Stream.of(topThreeFromDiferentOutcomeOccurenceNumber, emptyWager, topZero);
    }

    @ParameterizedTest
    @MethodSource(value = "findMostPopularOutcomeNotPredictableOrderParameters")
    void testFindMostPopularOutcomesWhenOrderIsNotPredictable(int topN, List<Outcome> expected, List<Wager> wagers) {
        // Given
        // When
        when(wagerService.findAll()).thenReturn(wagers);
        List<Outcome> result = underTest.findMostPopularOutcomes(topN);
        // Then
        assertThat(result).containsAnyElementsOf(expected);
    }

    static Stream<Arguments> findMostPopularOutcomeNotPredictableOrderParameters() {
        Outcome firstOutcome = new Outcome("first", null, null);
        Outcome secondOutcome = new Outcome("second", null, null);
        Outcome thirthOutcome = new Outcome("thirth", null, null);
        Outcome fourthOutcome = new Outcome("fourth", null, null);

        Wager firstWager = new Wager(null, null, null, firstOutcome, null, null);
        Wager secondWager = new Wager(null, null, null, secondOutcome, null, null);
        Wager thirthWager = new Wager(null, null, null, thirthOutcome, null, null);
        Wager fourthWager = new Wager(null, null, null, fourthOutcome, null, null);

        Arguments equaleOccuranceNumber = Arguments.of(2,
                Arrays.asList(firstOutcome, secondOutcome),
                Arrays.asList(secondWager, secondWager, firstWager, firstWager, thirthWager));
        Arguments everyOccuranceIsEqual = Arguments.of(2,
                Arrays.asList(firstOutcome, secondOutcome, thirthWager, fourthWager),
                Arrays.asList(secondWager, firstWager, fourthWager, thirthWager));
        return Stream.of(equaleOccuranceNumber, everyOccuranceIsEqual);
    }
}

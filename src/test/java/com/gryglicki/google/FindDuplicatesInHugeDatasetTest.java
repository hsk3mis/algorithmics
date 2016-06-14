package com.gryglicki.google;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.*;

/**
 * Created by Michał Gryglicki, PL on 10.06.2016.
 */
public class FindDuplicatesInHugeDatasetTest {

    @Test
    public void test_without_duplicates() {
        assertNull(FindDuplicatesInHugeDataset.findDuplicatesInDataset(Arrays.asList("Alamakota", "Alamakota123", "Alamakota456", "asdfasdf", "asdfasdfgh")));
    }

    @Test
    public void test_with_duplicates() {
        assertEquals("Alamakota", FindDuplicatesInHugeDataset.findDuplicatesInDataset(Arrays.asList("Alamakota", "Alamakota123", "Alamakota456", "asdfasdf", "asdfasdfgh", "Alamakota")));
    }


}

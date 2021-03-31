package com.wenmq.leetcode;

import com.wenmq.tools.ArrayTools;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Solution830UnitTest {

    private static final String TAG = "com.wenmq.leetcode.Solution830";
    private Solution830 mTestSolution;


    @Before
    public void setUp() throws Exception {
        mTestSolution = new Solution830();
    }

    @Test
    public void testLargeGroupPositions_Case1() {
        String s = "abbxxxxzzy";
        Integer[][] result = {{3, 6}};
        String expect = ArrayTools.array2ListString(result);
        List<List<Integer>> lists = mTestSolution.largeGroupPositions(s);
        Assert.assertEquals(expect, lists.toString());
    }

    @Test
    public void testLargeGroupPositions_Case2() {
        String s = "abc";
        Integer[][] result = {};
        String expect = ArrayTools.array2ListString(result);
        List<List<Integer>> lists = mTestSolution.largeGroupPositions(s);
        Assert.assertEquals(expect, lists.toString());
    }

    @Test
    public void testLargeGroupPositions_Case3() {
        String s = "abcdddeeeeaabbbcd";
        Integer[][] result = {{3, 5}, {6, 9}, {12, 14}};
        String expect = ArrayTools.array2ListString(result);
        List<List<Integer>> lists = mTestSolution.largeGroupPositions(s);
        Assert.assertEquals(expect, lists.toString());
    }

    @Test
    public void testLargeGroupPositions_Case4() {
        String s = "aba";
        Integer[][] result = {};
        String expect = ArrayTools.array2ListString(result);
        List<List<Integer>> lists = mTestSolution.largeGroupPositions(s);
        Assert.assertEquals(expect, lists.toString());
    }

    @Test
    public void testLargeGroupPositions_Case5() {
        String s = "abbxxxx";
        Integer[][] result = {{3, 6}};
        String expect = ArrayTools.array2ListString(result);
        List<List<Integer>> lists = mTestSolution.largeGroupPositions(s);
        Assert.assertEquals(expect, lists.toString());
    }
}
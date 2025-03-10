package sortpom.sort;

import org.junit.jupiter.api.*;
import sortpom.util.*;

public class SortDependencyManagementTests {

  @Test
  final void scopeInSortDependencyManagementShouldSortByScope() throws Exception {
    SortPomImplUtil.create()
        .customSortOrderFile("custom_1.xml")
        .sortDependencyManagement("scope,GROUPID,artifactId")
        .lineSeparator("\r\n")
        .testFiles(
            "/SortDepManagement_input_simpleWithScope.xml",
            "/SortDepManagement_expected_simpleWithScope2.xml");
  }

  @Test
  final void defaultDependencyManagementShouldWork() throws Exception {
    SortPomImplUtil.create()
        .customSortOrderFile("custom_1.xml")
        .sortDependencies("scope,GROUPID,artifactId")
        .lineSeparator("\r\n")
        .testFiles(
            "/SortDepManagement_input_simpleWithScope.xml",
            "/SortDepManagement_expected_simpleWithScope2.xml");
  }

  @Test
  final void differentOrderBetweenDepAndDepManagement() throws Exception {
    SortPomImplUtil.create()
        .customSortOrderFile("custom_1.xml")
        .sortDependencies("scope,GROUPID,artifactId")
        .sortDependencyManagement("GROUPID,artifactId")
        .lineSeparator("\r\n")
        .testFiles(
            "/SortDepManagement_input_withDependencies.xml",
            "/SortDepManagement_expected_withDependencies.xml");
  }
}

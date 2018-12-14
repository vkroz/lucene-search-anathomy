/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.lucene.demo.facet;


import org.apache.lucene.demo.BaseTestCase;
import org.apache.lucene.facet.FacetResult;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestSimpleFacetsExample extends BaseTestCase {

  @Test
  public void testFacetOnly() throws Exception {
    List<FacetResult> results = new SimpleFacetsExample().runFacetOnly();
    assertEquals(2, results.size());
    assertEquals("dim=Author path=[] value=5 childCount=4\n  Lisa (2)\n  Bob (1)\n  Susan (1)\n  Frank (1)\n", results.get(0).toString());
    assertEquals("dim=Publish Date path=[] value=5 childCount=3\n  2010 (2)\n  2012 (2)\n  1999 (1)\n", results.get(1).toString());
  }
  
  
  @Test
  public void testSimple() throws Exception {
    List<FacetResult> results = new SimpleFacetsExample().runSearch();
    assertEquals(2, results.size());
    assertEquals("dim=Author path=[] value=5 childCount=4\n  Lisa (2)\n  Bob (1)\n  Susan (1)\n  Frank (1)\n", results.get(0).toString());
    assertEquals("dim=Publish Date path=[] value=5 childCount=3\n  2010 (2)\n  2012 (2)\n  1999 (1)\n", results.get(1).toString());
  }

  @Test
  public void testDrillDown() throws Exception {
    FacetResult result = new SimpleFacetsExample().runDrillDown();
    assertEquals("dim=Author path=[] value=2 childCount=2\n  Bob (1)\n  Lisa (1)\n", result.toString());
  }

  @Test
  public void testDrillSideways() throws Exception {
    List<FacetResult> result = new SimpleFacetsExample().runDrillSideways();
    assertEquals("dim=Publish Date path=[] value=5 childCount=3\n  2010 (2)\n  2012 (2)\n  1999 (1)\n", result.get(0).toString());
    assertEquals("dim=Author path=[] value=2 childCount=2\n  Bob (1)\n  Lisa (1)\n", result.get(1).toString());
  }

}

/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.client.ml.inference.trainedmodel.langident;

import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.test.AbstractXContentTestCase;
import org.elasticsearch.test.ESTestCase;

import java.io.IOException;
import java.util.stream.Stream;


public class LangNetLayerTests extends AbstractXContentTestCase<LangNetLayer> {

    @Override
    protected LangNetLayer doParseInstance(XContentParser parser) throws IOException {
        return LangNetLayer.PARSER.apply(parser, null);
    }

    @Override
    protected boolean supportsUnknownFields() {
        return true;
    }

    @Override
    protected LangNetLayer createTestInstance() {
        return createRandom();
    }

    public static LangNetLayer createRandom() {
        int numWeights = randomIntBetween(1, 1000);
        return new LangNetLayer(
            Stream.generate(ESTestCase::randomDouble).limit(numWeights).mapToDouble(Double::doubleValue).toArray(),
            numWeights,
            1,
            Stream.generate(ESTestCase::randomDouble).limit(numWeights).mapToDouble(Double::doubleValue).toArray());
    }

}

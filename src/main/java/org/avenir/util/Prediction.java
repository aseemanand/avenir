/*
 * avenir: Predictive analytic based on Hadoop Map Reduce
 * Author: Pranab Ghosh
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.avenir.util;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author pranab
 *
 */
public class Prediction {
	private String[] predictions;
	
	public Prediction() {
	}

	public String[] getPredictions() {
		return predictions;
	}

	public void setPredictions(String[] predictions) {
		this.predictions = predictions;
	}
	
	public static Prediction decodeJson(String json)  {
		Prediction prediction = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			prediction = mapper.readValue(json, Prediction.class);
		} catch (Exception e) {
			throw new IllegalArgumentException("failed to decode prediction resp[onse json " + e.getMessage());	
		}
		return prediction;
	}
}

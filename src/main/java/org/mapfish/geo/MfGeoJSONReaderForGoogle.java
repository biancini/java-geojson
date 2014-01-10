package org.mapfish.geo;

import org.json.JSONArray;
import org.json.JSONException;

import com.vividsolutions.jts.geom.Coordinate;

public class MfGeoJSONReaderForGoogle extends MfGeoJSONReader {

	public MfGeoJSONReaderForGoogle(MfGeoFactory mfFactory) {
		super(mfFactory);
	}

	protected Coordinate[] decodeCoordinates(JSONArray coordinates) throws JSONException {
		int numCoordinates = coordinates.length();
		Coordinate[] result = new Coordinate[numCoordinates + 1];
		for (int i = 0; i < numCoordinates; ++i) {
			JSONArray arrCoords = coordinates.getJSONArray(i);
			switch (arrCoords.length()) {
			case 3:
				arrCoords = new JSONArray(new Object[] { arrCoords.get(2), arrCoords.get(1) });
				break;
			case 2:
				arrCoords = new JSONArray(new Object[] { arrCoords.get(1), arrCoords.get(0) });
				break;
			}
			result[i] = decodeCoordinate(arrCoords);
		}
		result[numCoordinates] = result[0];
		return result;
	}
}

import {
  ComposableMap,
  Geographies,
  Geography,
  Marker,
} from 'react-simple-maps';
import { useState, React } from 'react';
import axios from 'axios';

const geoUrl = 'https://raw.githubusercontent.com/zcreativelabs/react-simple-maps/master/topojson-maps/world-110m.json';

const markers = (longitude, latitude, name) => [

  { markerOffset: -15, name, coordinates: [longitude, latitude] },

];

const Whereabouts = () => {
  const [findWhereabouts, setFindWhereabouts] = useState([]);

  function findCitizenWhereabouts() {
    axios.post('http://54.74.6.120:5001/getWhereabouts/')
      .then((response) => {
        setFindWhereabouts(response.data);
      })
      .catch((err) => console.log(err));
  }
  return (
    <>
      {findCitizenWhereabouts}
      {findWhereabouts}
      <ComposableMap
        projection="geoAzimuthalEqualArea"
        projectionConfig={{
          rotate: [58, 20, 0],
          scale: 400,
        }}
      >
        <Geographies geography={geoUrl}>
          {({ geographies }) => geographies
            .filter((d) => d.properties.REGION_UN === 'England')
            .map((geo) => (
              <Geography
                key={geo.rsmKey}
                geography={geo}
                fill="#EAEAEC"
                stroke="#D6D6DA"
              />
            ))}
        </Geographies>
        {markers().map(({ name, coordinates, markerOffset }) => (
          <Marker key={name} coordinates={coordinates}>
            <circle r={10} fill="#F00" stroke="#fff" strokeWidth={2} />
            <text
              textAnchor="middle"
              y={markerOffset}
              style={{ fontFamily: 'system-ui', fill: '#5D5A6D' }}
            >
              {name}
            </text>
          </Marker>
        ))}
      </ComposableMap>
      ;
    </>
  );
};

export default Whereabouts;

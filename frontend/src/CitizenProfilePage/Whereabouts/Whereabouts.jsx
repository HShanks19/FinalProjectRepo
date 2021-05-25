import {
  ComposableMap,
  Geographies,
  Geography,
  Marker,
} from 'react-simple-maps';
import {
  Button, Row, Col,
} from 'react-bootstrap';
import { useState, React } from 'react';
import axios from 'axios';
import { useParams, Link } from 'react-router-dom';

const geoUrl = 'https://raw.githubusercontent.com/zcreativelabs/react-simple-maps/master/topojson-maps/world-110m.json';

const markers = (longitude, latitude, name) => [

  { markerOffset: -15, name, coordinates: [longitude, latitude] },

];

const Whereabouts = () => {
  const [findWhereabouts, setFindWhereabouts] = useState([]);
  const { citizenId } = useParams();
  function findCitizenWhereabouts() {
    axios.post('http://52.211.82.10:5001/getWhereabouts/')
      .then((response) => {
        setFindWhereabouts(response.data);
      })
      .catch((err) => console.log(err));
  }
  return (
    <>
      <Row>
        <Col>
          <div>
            <Link to={{
              pathname: '/',
            }}
            >
              <Button type="button" variant="outline-danger" size="lg">
                <span>Home</span>
              </Button>
            </Link>
            <Link to={{
              pathname: `/Biography/${citizenId}`,
            }}
            >
              <Button type="button" variant="outline-danger" size="lg">
                <span>Biography</span>
              </Button>
            </Link>
            <Link to={{
              pathname: `/Associates/${citizenId}`,
            }}
            >
              <Button type="button" variant="outline-danger" size="lg">
                <span>Associates</span>
              </Button>
            </Link>
            <Link to={{
              pathname: `/FinanceHistory/${citizenId}`,
            }}
            >
              <Button type="button" variant="outline-danger" size="lg">
                <span>Financial History</span>
              </Button>
            </Link>
            <Link to={{
              pathname: `/Whereabouts/${citizenId}`,
            }}
            >
              <Button type="button" variant="outline-danger" size="lg">
                <span>Whereabouts</span>
              </Button>
            </Link>
          </div>
        </Col>
      </Row>
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
            .filter((d) => d.properties.REGION_UN === 'unitedKingdom')
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

import './Biography.css';
import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import {
  Button, Row, Col,
} from 'react-bootstrap';
import { ThreeDots } from '@agney/react-loading';
import BiographyRender from './BiographyRender';

const Biography = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const { citizenId } = useParams();
  console.log('citizenId ', citizenId);
  const makeRequest = () => {
    setLoading(true);
    axios.get(`http://54.74.11.52:5001/getBiographicalInfo/${citizenId}`)
      .then((response) => {
        setData(response.data);
        console.log(data);
        setLoading(false);
      }).catch((err) => console.log(err));
  };
  useEffect(() => { makeRequest(); }, []);
  const RenderInformation = data.map((d) => <BiographyRender data={d} />);
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
      {RenderInformation}
      { loading === true
        && (
          <ThreeDots className="loading-icon" />
        )}
    </>
  );
};

export default Biography;

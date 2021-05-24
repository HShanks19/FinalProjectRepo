import './Biography.css';
import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import {
  Button, Row, Col,
} from 'react-bootstrap';
import BiographyRender from './BiographyRender';

const Biography = () => {
  const [data, setData] = useState([]);
  const { citizenId } = useParams();
  console.log('citizenId ', citizenId);
  const makeRequest = () => {
    axios.get(`http://54.74.11.52:5001/getBiographicalInfo/${citizenId}`)
      .then((response) => {
        setData(response.data);
        console.log(data);
      }).catch((err) => console.log(err));
  };
  useEffect(() => { makeRequest(); }, []);
  const RenderInformation = data.map((d) => <BiographyRender data={d} />);
  return (
    <>
      <Row>
        <Col>
          <div>
            <Link to="/Biography">
              <Button type="button" variant="outline-danger" size="lg">
                <span>Biography</span>
              </Button>
            </Link>
            <Link to="/Associates">
              <Button type="button" variant="outline-danger" size="lg">
                <span>Associates</span>
              </Button>
            </Link>
            <Link to="/FinanceHistory">
              <Button type="button" variant="outline-danger" size="lg">
                <span>Financial History</span>
              </Button>
            </Link>
            <Link to="/Whereabouts">
              <Button type="button" variant="outline-danger" size="lg">
                <span>Whereabouts</span>
              </Button>
            </Link>
          </div>
        </Col>
      </Row>
      {RenderInformation}
    </>
  );
};

export default Biography;

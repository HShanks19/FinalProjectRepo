import { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, Link } from 'react-router-dom';
import {
  Button, Row, Col,
} from 'react-bootstrap';
import { ThreeDots } from '@agney/react-loading';
import AssociatesRender from './AssociatesRender';

const Associates = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const { citizenId } = useParams();
  console.log(citizenId);
  const postObject = { citizenID: `${citizenId}` };
  console.log(postObject);
  const makeRequest = () => {
    setLoading(true);
    axios.post('http://54.74.11.52:5001/getCitizensAssociates/', postObject)
      .then((response) => {
        setData(response.data);
        console.log(data);
        setLoading(false);
      }).catch((err) => console.log(err));
  };
  useEffect(() => { makeRequest(); }, []);
  const RenderAssociatesInformation = data.map((d) => <AssociatesRender data={d} />);

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
      {RenderAssociatesInformation}
      { loading === true
        && (
          <ThreeDots className="loading-icon" />
        )}
    </>
  );
};

export default Associates;

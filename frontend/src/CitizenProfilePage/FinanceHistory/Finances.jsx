import axios from 'axios';
import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import {
  Button, Row, Col,
} from 'react-bootstrap';
import FinancesRender from './FinancesRender';

const Finances = () => {
  const [financialHistory, setFinancialHistory] = useState([]);
  const { citizenId } = useParams();
  console.log('citizenId ', citizenId);
  const makeRequest = () => {
    axios.get(`http://54.74.11.52:5001/getBiographicalInfo/${citizenId}`)
      .then((response) => {
        console.log(response.data);
        axios.post('http://54.74.11.52:5001/getMatchingBankAccounts/', { forenames: `${response.data[0].forenames}`, surname: `${response.data[0].surname}`, dateOfBirth: `${response.data[0].dateOfBirth}` })
          .then((res) => {
            setFinancialHistory(res.data);
            console.log(financialHistory);
          })
          .catch((err) => console.log(err));
      }).catch((err) => console.log(err));
  };
  useEffect(() => { makeRequest(); }, []);

  const RenderFinancesInformation = financialHistory.map((d) => <FinancesRender data={d} />);
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
      {RenderFinancesInformation}
    </>
  );
};

export default Finances;

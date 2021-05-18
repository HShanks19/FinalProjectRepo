import {
  Button, Row, Col, Container,
} from 'react-bootstrap';
import Biography from './Biography/Biography';
import Finances from './FinanceHistory/Finances';
import Associates from './Associates/Associates';
import './CitizenProfile.css';
import Whereabouts from './Whereabouts/Whereabouts';

const CitizenPage = () => (
  <>
    <Row>
      <Col>
        <div className="d-grid d-md-block">
          <Button className="btn" type="button" id="button1" variant="outline-danger" size="lg">Biography</Button>
          <Button className="btn" type="button" id="button2" variant="outline-danger" size="lg">Associates</Button>
          <Button className="btn" type="button" id="button3" variant="outline-danger" size="lg">Financial History</Button>
          <Button className="btn" type="button" id="button4" variant="outline-danger" size="lg">Whereabouts</Button>
        </div>
      </Col>
    </Row>
    <Container>
      <Row>
        <Col>
          <Biography />
        </Col>
        <Col>
          <Associates />
        </Col>
        <Col>
          <Finances />
        </Col>
        <Col>
          <Whereabouts />
        </Col>
      </Row>
    </Container>
  </>
);

export default CitizenPage;

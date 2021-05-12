import {
  Button, Row, Col, Container,
} from 'react-bootstrap';
import Biography from './Biography/Biography';
import './CitizenProfile.css';

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
      </Row>
    </Container>
  </>
);

export default CitizenPage;

/* eslint-disable react/jsx-no-comment-textnodes */
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import {
  Button, Row, Col,
} from 'react-bootstrap';
import Search from './Search/Search';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import './Search/Search.css';
import './Footer/Footer.css';
import redsearchText from './redsearchText.svg';
import CitizenPage from './CitizenProfilePage/CitizenProfile';

function App() {
  return (
    <>
      <div className="App">
        <Router>
          <img src={redsearchText} alt="Logo" style={{ height: 60, margin: 50 }} />
          <Route exact path="/">
            <Search />
          </Route>
          <Row>
            <Col>
              <div className="d-grid d-md-block">
                <Button type="button" id="button1" size="lg" variant="danger" className="citizen-card-button"><Link to="/Biography">Biography</Link></Button>
                <Button type="button" id="button2" size="lg" variant="danger" className="citizen-card-button"><Link to="/Associates">Associates</Link></Button>
                <Button type="button" id="button3" size="lg" variant="danger" className="citizen-card-button"><Link to="/Finances">Financial History</Link></Button>
                <Button type="button" id="button4" size="lg" variant="danger" className="citizen-card-button"><Link to="/Whereabouts">Whereabouts</Link></Button>
              </div>
            </Col>
          </Row>
          <Route path="/Citizen">
            <CitizenPage />
          </Route>
        </Router>
      </div>
    </>
  );
}

export default App;

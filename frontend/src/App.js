/* eslint-disable max-len */
/* eslint-disable react/jsx-no-comment-textnodes */
import { BrowserRouter as Router, Link, Route } from 'react-router-dom';
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
import Biography from './CitizenProfilePage/Biography/Biography';

function App() {
  return (
    <>
      <div className="App">
        <Router>
          <img src={redsearchText} alt="Logo" style={{ height: 60, margin: 50 }} />
          <Route exact path="/">
            <Search />
          </Route>
          <Route path="/Citizen">
            <Row>
              <Col>
                <div>
                  <Button type="button" variant="outline-danger" size="lg" className="wide-button"><Link to="/Biography">Biography</Link></Button>
                  <Button type="button" variant="outline-danger" size="lg" className="wide-button"><Link to="/Associates">Associates</Link></Button>
                  <Button type="button" variant="outline-danger" size="lg" className="wide-button"><Link to="/Finances">Financial History</Link></Button>
                  <Button type="button" variant="outline-danger" size="lg" className="wide-button"><Link to="/Whereabouts">Whereabouts</Link></Button>
                </div>
              </Col>
            </Row>
            <CitizenPage />
          </Route>
          <Route path="/Biography">
            <Biography />
          </Route>
        </Router>
      </div>
    </>
  );
}

export default App;

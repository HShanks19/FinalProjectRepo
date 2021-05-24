import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import {
  Button, Row, Col,
} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Search from './Search/Search';
import './App.css';
import './Search/Search.css';
import './Footer/Footer.css';
import redsearchText from './redsearchText.svg';
import CitizenPage from './CitizenProfilePage/CitizenProfile';
import Biography from './CitizenProfilePage/Biography/Biography';
import Associates from './CitizenProfilePage/Associates/Associates';
import Finances from './CitizenProfilePage/FinanceHistory/Finances';
import Whereabouts from './CitizenProfilePage/Whereabouts/Whereabouts';

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
                  <Link to="/Citizen/Biography">
                    <Button type="button" variant="outline-danger" size="lg">
                      <span>Biography</span>
                    </Button>
                  </Link>
                  <Link to="/Citizen/Associates">
                    <Button type="button" variant="outline-danger" size="lg">
                      <span>Associates</span>
                    </Button>
                  </Link>
                  <Link to="/Citizen/FinanceHistory">
                    <Button type="button" variant="outline-danger" size="lg">
                      <span>Financial History</span>
                    </Button>
                  </Link>
                  <Link to="/Citizen/Whereabouts">
                    <Button type="button" variant="outline-danger" size="lg">
                      <span>Whereabouts</span>
                    </Button>
                  </Link>
                </div>
              </Col>
            </Row>
            <CitizenPage />
          </Route>
          <Route path="/Citizen/Biography">
            <Biography />
          </Route>
          <Route path="/Citizen/Associates">
            <Associates />
          </Route>
          <Route path="/Citizen/Finances">
            <Finances />
          </Route>
          <Route path="/Citizen/Whereabouts">
            <Whereabouts />
          </Route>
        </Router>
      </div>
    </>
  );
}

export default App;

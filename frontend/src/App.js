/* eslint-disable max-len */
/* eslint-disable react/jsx-no-comment-textnodes */
import {
  BrowserRouter as Router, Route, useRouteMatch,
} from 'react-router-dom';
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
import Associates from './CitizenProfilePage/Associates/Associates';
import Finances from './CitizenProfilePage/FinanceHistory/Finances';
import Whereabouts from './CitizenProfilePage/Whereabouts/Whereabouts';

function App() {
  const { path } = useRouteMatch();

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
                  <Button type="button" variant="outline-danger" size="lg" className="wide-button">Biography</Button>
                  <Button type="button" variant="outline-danger" size="lg" className="wide-button">Associates</Button>
                  <Button type="button" variant="outline-danger" size="lg" className="wide-button">Financial History</Button>
                  <Button type="button" variant="outline-danger" size="lg" className="wide-button">Whereabouts</Button>
                </div>
              </Col>
            </Row>
            <CitizenPage />
          </Route>
          <Route path={`${path}/Biography`}>
            <Biography />
          </Route>
          <Route path={`${path}/Associates`}>
            <Associates />
          </Route>
          <Route path={`${path}/Finances`}>
            <Finances />
          </Route>
          <Route path={`${path}/Whereabouts`}>
            <Whereabouts />
          </Route>
        </Router>
      </div>
    </>
  );
}

export default App;

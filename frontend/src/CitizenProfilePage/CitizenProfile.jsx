/* eslint no-template-curly-in-string: "error" */
import {
  BrowserRouter as Route, Switch, Link, useRouteMatch,
} from 'react-router-dom';
import {
  Button, Row, Col,
} from 'react-bootstrap';
import Biography from './Biography/Biography';
import Finances from './FinanceHistory/Finances';
import Associates from './Associates/Associates';
import './CitizenProfile.css';
import Whereabouts from './Whereabouts/Whereabouts';

const CitizenPage = () => {
  const { path } = useRouteMatch();
  return (
    <>
      <Row>
        <Col>
          <div className="d-grid d-md-block">
            <Button className="btn" type="button" id="button1" variant="outline-danger" size="lg"><Link to="/Biography">Biography</Link></Button>
            <Button className="btn" type="button" id="button2" variant="outline-danger" size="lg"><Link to="/Associates">Associates</Link></Button>
            <Button className="btn" type="button" id="button3" variant="outline-danger" size="lg"><Link to="/Finances">Financial History</Link></Button>
            <Button className="btn" type="button" id="button4" variant="outline-danger" size="lg"><Link to="/Whereabouts">Whereabouts</Link></Button>
          </div>
        </Col>
      </Row>
      <Switch>
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
      </Switch>
    </>
  );
};

export default CitizenPage;

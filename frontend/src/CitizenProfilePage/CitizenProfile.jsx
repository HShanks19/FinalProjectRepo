/* eslint no-template-curly-in-string: "error" */
import {
  BrowserRouter as Route, Switch,
} from 'react-router-dom';
import Biography from './Biography/Biography';
import Associates from './Associates/Associates';
import Finances from './FinanceHistory/Finances';
import Whereabouts from './Whereabouts/Whereabouts';
import './CitizenProfile.css';

const CitizenPage = () => (
  <>
    <Switch>
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
    </Switch>
  </>
);

export default CitizenPage;
